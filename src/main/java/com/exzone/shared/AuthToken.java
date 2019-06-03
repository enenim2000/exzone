package com.exzone.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_role")
    private String userRole;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("permissions")
    private List<String> permissions;

    public boolean hasExpired(long idleTimeout) {
        if(getUpdatedAt() == null){
            return true;
        }
        LocalDateTime localDateTime = getUpdatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusMinutes(idleTimeout);
        return  Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()).before(new Date());
    }

}