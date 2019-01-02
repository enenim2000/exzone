package com.exzone.dto.response;

import com.exzone.shared.MetaData;
import com.exzone.util.RequestUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StringResponse {

    private String message;

    private String data;

    @JsonProperty("meta_data")
    private MetaData metaData = null;

    public StringResponse(Object data) {
        setMessage(RequestUtil.getMessage());
        setData((String) data);
        setMetaData(null);
    }
}