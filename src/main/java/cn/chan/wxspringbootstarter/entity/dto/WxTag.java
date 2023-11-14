package cn.chan.wxspringbootstarter.entity.dto;

/**
 * @author: chan
 * @date: 2023/3/16 - 17:24
 * @description:
 **/
public class WxTag extends ErrorDTO{
    private Integer id;

    private String name;

    /**
     * 粉丝数
     */
    private Long count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
