package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/3/31 - 17:52
 * @description:
 **/
public class QywxDeleteTagDTO {
    private List<String> tag_id;
    private List<String> group_id;
    private long agentid;

    public List<String> getTag_id() {
        return tag_id;
    }

    public void setTag_id(List<String> tag_id) {
        this.tag_id = tag_id;
    }

    public List<String> getGroup_id() {
        return group_id;
    }

    public void setGroup_id(List<String> group_id) {
        this.group_id = group_id;
    }

    public long getAgentid() {
        return agentid;
    }

    public void setAgentid(long agentid) {
        this.agentid = agentid;
    }
}
