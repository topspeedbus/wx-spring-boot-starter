package cn.chan.wxspringbootstarter.entity.qo;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/3/16 - 18:06
 * @description:
 **/
public class WxTagBatchTaggingQO {
    /**
     * {
     *     "openid_list" : [//粉丝列表
     *     "ocYxcuAEy30bX0NXmGn4ypqx3tI0",
     *     "ocYxcuBt0mRugKZ7tGAHPnUaOW7Y"   ],
     *     "tagid" : 134
     *  }
     */

    private List<String> openid_list;

    private Integer tagid;

    public List<String> getOpenid_list() {
        return openid_list;
    }

    public void setOpenid_list(List<String> openid_list) {
        this.openid_list = openid_list;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }
}
