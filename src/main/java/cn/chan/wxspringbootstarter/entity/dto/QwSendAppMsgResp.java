package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * @author: piaoxue
 * @date: 2023/11/30 - 10:50
 * @description:
 **/
@Data
public class QwSendAppMsgResp extends ErrorDTO {
    /**
     * invaliduser	不合法的userid，不区分大小写，统一转为小写
     * invalidparty	不合法的partyid
     * invalidtag	不合法的标签id
     * unlicenseduser	没有基础接口许可(包含已过期)的userid
     * msgid	消息id，用于撤回应用消息
     * response_code	仅消息类型为“按钮交互型”，“投票选择型”和“多项选择型”的模板卡片消息返回，应用可使用response_code调用更新模版卡片消息接口，72小时内有效，且只能使用一次
     */

    private String invaliduser;
    private String invalidparty;
    private String invalidtag;
    private String unlicenseduser;
    private String msgid;
    private String response_code;
}
