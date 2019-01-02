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
public class BooleanResponse{

    private String message;

    private Boolean data;

    @JsonProperty("meta_data")
    private MetaData metaData = null;

    public BooleanResponse(Object data) {
        setMessage(RequestUtil.getMessage());
        setData((Boolean) data);
        setMetaData(null);
    }
}