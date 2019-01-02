package com.exzone.dto.response;

import com.exzone.shared.MetaData;
import com.exzone.util.RequestUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@ToString
public class PageResponse<T> {

    private String message;

    private List<T> data;

    @JsonProperty("meta_data")
    private MetaData metaData;

    public PageResponse(Page<T> result) {
        setMessage(RequestUtil.getMessage());
        setData(result.getContent());
        setMetaData(new MetaData<>(result));
    }
}