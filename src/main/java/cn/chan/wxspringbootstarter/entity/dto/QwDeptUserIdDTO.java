package cn.chan.wxspringbootstarter.entity.dto;

/**
 * @author: piaoxue
 * @date: 2023/10/12 - 11:02
 * @description:
 **/
public class QwDeptUserIdDTO {
    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    private Integer department;
}
