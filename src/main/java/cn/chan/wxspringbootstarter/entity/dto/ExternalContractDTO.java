package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/4/3 - 14:51
 * @description:
 **/
public class ExternalContractDTO extends ErrorDTO{
    /**
     * errcode	返回码
     * errmsg	对返回码的文本描述内容
     * external_userid	外部联系人的userid列表
     */
    private List<String> external_userid;

    public List<String> getExternal_userid() {
        return external_userid;
    }

    public void setExternal_userid(List<String> external_userid) {
        this.external_userid = external_userid;
    }
}
