package com.exzone.model.cache;

import com.exzone.constant.ModelFieldConstant;
import com.exzone.enums.EnabledStatus;
import com.exzone.enums.LoggedIn;
import com.exzone.enums.LoginStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Data
public class LoginCache {
    private Long id;

    private String username;

    @JsonProperty("user_type")
    @SerializedName("user_type")
    private String userType;

    @JsonProperty("user")
    @SerializedName("user")
    private Object user;

    @JsonProperty("user_id")
    @SerializedName("user_id")
    private Long userId;

    @JsonProperty("login_status")
    @SerializedName("login_status")
    private LoginStatus loginStatus;

    @NotNull
    @JsonProperty("logged_in")
    @SerializedName("logged_in")
    private LoggedIn loggedIn = LoggedIn.USER_LOGGED_IN;

    @JsonProperty("last_logged_in")
    @SerializedName("last_logged_in")
    private Date lastLoggedIn;

    @JsonProperty("status")
    @SerializedName("status")
    private EnabledStatus enabled;

    @JsonProperty("global_settings")
    @SerializedName("global_settings")
    private HashMap<String, Object> globalSettings = new HashMap<>();

    @JsonProperty(ModelFieldConstant.CREATED_AT)
    @SerializedName(ModelFieldConstant.CREATED_AT)
    private Date createdAt;

    @JsonProperty(ModelFieldConstant.UPDATED_AT)
    @SerializedName(ModelFieldConstant.UPDATED_AT)
    private Date updatedAt;

    public boolean hasExpired(long idleTimeout) {
        if(getUpdatedAt() == null){
            return true;
        }
        LocalDateTime localDateTime = getUpdatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusMinutes(idleTimeout);
        return  Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()).before(new Date());
    }
}
