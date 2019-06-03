package com.exzone.service;

import com.exzone.shared.AuthToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Service
public class AuthTokenService {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 7; // 7 days

    @Value("${app.private-key}")
    private String secret;

    private final RedisTemplate<String, AuthToken> redisTemplate;

    private ValueOperations<String, AuthToken> valueOps;

    @Autowired
    public AuthTokenService(@Qualifier("redisAuthTemplate") RedisTemplate<String, AuthToken> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void setup() {
        valueOps = redisTemplate.opsForValue();
    }

    public AuthToken getAuthToken(String sessionId){
        return valueOps.get(sessionId);
    }

    public void saveAuthToken(AuthToken authToken){
        valueOps.set(authToken.getSessionId(), authToken);
    }

    @Async
    public void deleteAuthToken(String sessionId){
        redisTemplate.execute((RedisCallback<String>) redisConnection -> {
            redisConnection.del(redisTemplate.getStringSerializer().serialize(sessionId));
            return null;
        });
    }

    @Async
    public void refreshAuthToken(String sessionId){
        AuthToken authToken = getAuthToken(sessionId);
        authToken.setUpdatedAt(new Date());
        saveAuthToken(authToken);
    }

    public String encodeToken(AuthToken authToken) {
        return Jwts.builder()
                .setClaims( new ObjectMapper().convertValue(authToken, Map.class) )
                .setSubject(authToken.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getKey())
                .compact();
    }

    public AuthToken decodeToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token).getBody();
        return new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false).convertValue(claims, AuthToken.class);
    }

    private PrivateKey getKey(){
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(secret.getBytes()));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            if (keyFactory != null) {
                privateKey = keyFactory.generatePrivate(keySpec);
            }
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }
}
