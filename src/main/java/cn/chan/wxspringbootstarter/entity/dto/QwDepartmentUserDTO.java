package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/12 - 10:41
 * @description:
 **/
public class QwDepartmentUserDTO {
        private String name;
        private List<Integer> department;
        private String position;
        private int status;
        private int enable;
        private int isleader;
        private int hide_mobile;
        private String telephone;
        private List<Integer> order;
        private int main_department;
        private String alias;
        private List<Integer> is_leader_in_dept;
        private String userid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDepartment() {
        return department;
    }

    public void setDepartment(List<Integer> department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getIsleader() {
        return isleader;
    }

    public void setIsleader(int isleader) {
        this.isleader = isleader;
    }

    public int getHide_mobile() {
        return hide_mobile;
    }

    public void setHide_mobile(int hide_mobile) {
        this.hide_mobile = hide_mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Integer> getOrder() {
        return order;
    }

    public void setOrder(List<Integer> order) {
        this.order = order;
    }

    public int getMain_department() {
        return main_department;
    }

    public void setMain_department(int main_department) {
        this.main_department = main_department;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Integer> getIs_leader_in_dept() {
        return is_leader_in_dept;
    }

    public void setIs_leader_in_dept(List<Integer> is_leader_in_dept) {
        this.is_leader_in_dept = is_leader_in_dept;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<String> getDirect_leader() {
        return direct_leader;
    }

    public void setDirect_leader(List<String> direct_leader) {
        this.direct_leader = direct_leader;
    }

    private List<String> direct_leader;
}
