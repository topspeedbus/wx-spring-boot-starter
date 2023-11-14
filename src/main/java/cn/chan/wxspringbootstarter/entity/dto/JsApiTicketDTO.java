package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * @author: chan
 * @date: 2023/10/18 - 16:00
 * @description:
 **/
@Data
public class JsApiTicketDTO extends ErrorDTO{
    private String ticket;
    private Long expires_in;
}
