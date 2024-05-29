package cn.chan.wxspringbootstarter.entity.qo;

import lombok.Data;

import java.util.Map;

/**
 * @author: piaoxue
 * @date: 2024/1/18 - 15:48
 * @description:
 **/
@Data
public class SubscribeMsgSendQO {
    private String touser;
    private String template_id;
    private String page;
    private AppDetailQO miniprogram;

    private Map<String, SimpleValueKeyQO> data;
}
