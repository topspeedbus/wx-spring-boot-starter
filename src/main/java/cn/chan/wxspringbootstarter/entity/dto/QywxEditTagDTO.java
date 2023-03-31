package cn.chan.wxspringbootstarter.entity.dto;

/**
 * @author: piaoxue
 * @date: 2023/3/31 - 17:37
 * @description:
 **/
public class QywxEditTagDTO {

    /**
     * access_token	是	调用接口凭证
     * id	是	标签或标签组的id
     * name	否	新的标签或标签组名称，最长为30个字符
     * order	否	标签/标签组的次序值。order值大的排序靠前。有效的值范围是[0, 2^32)
     * agentid	否	授权方安装的应用agentid。仅旧的第三方多应用套件需要填此参数
     */
    private String id;
    private String name;
    private int order;
    private long agentid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public long getAgentid() {
        return agentid;
    }

    public void setAgentid(long agentid) {
        this.agentid = agentid;
    }
}
