package cn.chan.wxspringbootstarter.entity.qo;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/4/3 - 17:00
 * @description:
 **/
public class QwEditUserMarkQO {
    private String userid;
    private String external_userid;
    private String remark;
    private String description;
    private String remark_company;
    private List<String> remark_mobiles;
    private String remark_pic_mediaid;

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setExternal_userid(String external_userid) {
        this.external_userid = external_userid;
    }

    public String getExternal_userid() {
        return external_userid;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setRemark_company(String remark_company) {
        this.remark_company = remark_company;
    }

    public String getRemark_company() {
        return remark_company;
    }

    public void setRemark_mobiles(List<String> remark_mobiles) {
        this.remark_mobiles = remark_mobiles;
    }

    public List<String> getRemark_mobiles() {
        return remark_mobiles;
    }

    public void setRemark_pic_mediaid(String remark_pic_mediaid) {
        this.remark_pic_mediaid = remark_pic_mediaid;
    }

    public String getRemark_pic_mediaid() {
        return remark_pic_mediaid;
    }


}
