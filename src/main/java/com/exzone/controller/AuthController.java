package com.exzone.controller;

import com.exzone.annotation.Get;
import com.exzone.annotation.Post;
import com.exzone.dto.request.LoginRequest;
import com.exzone.dto.response.BooleanResponse;
import com.exzone.dto.response.Response;
import com.exzone.dto.response.StringResponse;
import com.exzone.enums.LoginStatus;
import com.exzone.enums.VerifyStatus;
import com.exzone.exception.AppException;
import com.exzone.exception.UnAuthorizedException;
import com.exzone.model.dao.Login;
import com.exzone.service.AuthTokenService;
import com.exzone.service.dao.LoginService;
import com.exzone.shared.AuthToken;
import com.exzone.util.PasswordEncoder;
import com.exzone.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/auth/v1")
public class AuthController {

	private final LoginService loginService;
	private final AuthTokenService authTokenService;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AuthController(LoginService loginService, AuthTokenService authTokenService, PasswordEncoder passwordEncoder) {
		this.loginService = loginService;
		this.authTokenService = authTokenService;
		this.passwordEncoder = passwordEncoder;
	}


	@Post("/sign-in")
	public Response<StringResponse> signIn(@Valid @RequestBody LoginRequest request) {
		Login login = loginService.getLoginByUsername(request.getUsername());

		if (!StringUtils.isEmpty(login) && passwordEncoder.matches(request.getPassword(), login.getPassword())) {

			if (login.getVerifyStatus() == VerifyStatus.NOT_VERIFIED) {
				throw new AppException("account not verified");
			} else if (login.getStatus() == LoginStatus.DISABLED) {
				throw new AppException("account disabled");
			} else if (login.getStatus() == LoginStatus.LOCKED) {
				throw new AppException("account blocked");
			}else if (login.getStatus() == LoginStatus.DORMANT) {
				throw new AppException("account dormant");
			} else {

				AuthToken authToken = AuthToken.builder()
						.userId(login.getUserId())
						.userType(login.getUserType())
						.userName(login.getUsername())
						.permissions(new ArrayList<>())
						.sessionId(RandomUtil.getSessionId())
						.createdAt(new Date())
						.updatedAt(new Date())
						.build();

				String token = authTokenService.encodeToken(authToken);
				authTokenService.saveAuthToken(authToken);

				StringResponse response = new StringResponse(token);
				response.setMessage("successful logged in");
				return new Response<>(response);

			}

		}

		throw new UnAuthorizedException("invalid login");
	}

	@Get("/sign-out")
	public Response<BooleanResponse> signOut() {
		authTokenService.signOut();
		return new Response<>(new BooleanResponse(true));
	}
}