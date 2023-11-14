package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * @author: chan
 * @date: 2023/10/18 - 16:00
 * @description:
 **/
@Data
public class Code2SessionDTO extends ErrorDTO{
    private String corpid;
    private String userid;
    private String session_key;
}
