package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/12 - 11:12
 * @description:
 **/
public class QwUserDTO extends ErrorDTO {
        private String userid;
        private String name;
        private List<Integer> department;
        private List<Integer> order;
        private String position;
        private String mobile;
        private String gender;
        private String email;
        private String biz_mail;
        private List<Integer> is_leader_in_dept;
        private List<String> direct_leader;
        private String avatar;
        private String thumb_avatar;
        private String telephone;
        private String alias;
        private String address;
        private String open_userid;
        private int main_department;
        private int status;
        private String qr_code;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

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

    public List<Integer> getOrder() {
        return order;
    }

    public void setOrder(List<Integer> order) {
        this.order = order;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBiz_mail() {
        return biz_mail;
    }

    public void setBiz_mail(String biz_mail) {
        this.biz_mail = biz_mail;
    }

    public List<Integer> getIs_leader_in_dept() {
        return is_leader_in_dept;
    }

    public void setIs_leader_in_dept(List<Integer> is_leader_in_dept) {
        this.is_leader_in_dept = is_leader_in_dept;
    }

    public List<String> getDirect_leader() {
        return direct_leader;
    }

    public void setDirect_leader(List<String> direct_leader) {
        this.direct_leader = direct_leader;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getThumb_avatar() {
        return thumb_avatar;
    }

    public void setThumb_avatar(String thumb_avatar) {
        this.thumb_avatar = thumb_avatar;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpen_userid() {
        return open_userid;
    }

    public void setOpen_userid(String open_userid) {
        this.open_userid = open_userid;
    }

    public int getMain_department() {
        return main_department;
    }

    public void setMain_department(int main_department) {
        this.main_department = main_department;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getExternal_position() {
        return external_position;
    }

    public void setExternal_position(String external_position) {
        this.external_position = external_position;
    }

    private String external_position;

}
