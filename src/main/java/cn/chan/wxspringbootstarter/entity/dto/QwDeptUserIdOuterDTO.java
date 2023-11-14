package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/12 - 11:03
 * @description:
 **/
public class QwDeptUserIdOuterDTO extends ErrorDTO {
    public String getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(String next_cursor) {
        this.next_cursor = next_cursor;
    }

    public List<QwDeptUserIdDTO> getDept_user() {
        return dept_user;
    }

    public void setDept_user(List<QwDeptUserIdDTO> dept_user) {
        this.dept_user = dept_user;
    }

    private String next_cursor;
    private List<QwDeptUserIdDTO> dept_user;
}
