package cn.chan.wxspringbootstarter.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: piaoxue
 * @date: 2024/5/29 - 15:33
 * @description:
 **/
@Data
public class CustomerAcquisitionLinkDTO {
    @JsonProperty("link_id")
    private String linkId;

    @JsonProperty("link_name")
    private String linkName;

    @JsonProperty("url")
    private String url;

    @JsonProperty("create_time")
    private long createTime;
}
