package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/3/31 - 17:12
 * @description:
 **/
public class QywxTagGroupDTO extends ErrorDTO {
    private String group_id;
    private String group_name;
    private int order;
    private List<QywxTagDTO> tag;
    private Long create_time;
    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<QywxTagDTO> getTag() {
        return tag;
    }

    public void setTag(List<QywxTagDTO> tag) {
        this.tag = tag;
    }

    public long getAgentid() {
        return agentid;
    }

    public void setAgentid(long agentid) {
        this.agentid = agentid;
    }

    private long agentid;

}
