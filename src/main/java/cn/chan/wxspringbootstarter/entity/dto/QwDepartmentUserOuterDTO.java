package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/10/12 - 10:42
 * @description:
 **/
public class QwDepartmentUserOuterDTO extends ErrorDTO{
    public List<QwUserDTO> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<QwUserDTO> userlist) {
        this.userlist = userlist;
    }

    private List<QwUserDTO> userlist;
}
