package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/3/16 - 17:24
 * @description:
 **/
public class WxTagsOuterDTO extends ErrorDTO {
    private List<WxTag> tags;

    public List<WxTag> getTags() {
        return tags;
    }

    public void setTags(List<WxTag> tags) {
        this.tags = tags;
    }
}
