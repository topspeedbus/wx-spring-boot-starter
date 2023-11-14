package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/3/31 - 18:12
 * @description:
 **/
public class QywxEditUserTagDTO {

    /**
     * userid	是	添加外部联系人的userid
     * external_userid	是	外部联系人userid
     * add_tag	否	要标记的标签列表
     * remove_tag	否	要移除的标签列表
     * 请确保external_userid是userid的外部联系人。
     * add_tag和remove_tag不可同时为空。
     * 同一个标签组下现已支持多个标签
     */
    private String userid;
    private String external_userid;
    private List<String> add_tag;
    private List<String> remove_tag;

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

    public void setAdd_tag(List<String> add_tag) {
        this.add_tag = add_tag;
    }

    public List<String> getAdd_tag() {
        return add_tag;
    }

    public void setRemove_tag(List<String> remove_tag) {
        this.remove_tag = remove_tag;
    }

    public List<String> getRemove_tag() {
        return remove_tag;
    }


}
