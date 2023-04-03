package cn.chan.wxspringbootstarter.entity.dto;

/**
 * @author: piaoxue
 * @date: 2023/4/3 - 15:23
 * @description:
 **/
public class QwTagDTO {
    private String group_name;
    private String tag_name;
    private String tag_id;
    private int type;

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }


}
