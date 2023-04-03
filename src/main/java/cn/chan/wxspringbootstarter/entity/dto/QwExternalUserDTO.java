package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/4/3 - 15:31
 * @description:
 **/
public class QwExternalUserDTO extends ErrorDTO {


    private QwExternalContractDTO external_contact;
    private List<FollowUserDTO> follow_user;
    private String next_cursor;

    public QwExternalContractDTO getExternal_contact() {
        return external_contact;
    }

    public void setExternal_contact(QwExternalContractDTO external_contact) {
        this.external_contact = external_contact;
    }

    public List<FollowUserDTO> getFollow_user() {
        return follow_user;
    }

    public void setFollow_user(List<FollowUserDTO> follow_user) {
        this.follow_user = follow_user;
    }

    public String getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(String next_cursor) {
        this.next_cursor = next_cursor;
    }
}

