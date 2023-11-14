package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/4/3 - 14:51
 * @description:
 **/
public class ExternalContractUserDTO extends ErrorDTO{
    /**
     * errcode	返回码
     * errmsg	对返回码的文本描述内容
     * follow_user	配置了客户联系功能的成员userid列表
     */
    private List<String> follow_user;

    public List<String> getFollow_user() {
        return follow_user;
    }

    public void setFollow_user(List<String> follow_user) {
        this.follow_user = follow_user;
    }
}
