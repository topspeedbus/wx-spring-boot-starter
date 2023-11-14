package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/4/4 - 18:07
 * @description:
 **/
public class QywxTagOuterDTO extends ErrorDTO{
    private List<QywxTagGroupDTO> tag_group;

    public List<QywxTagGroupDTO> getTag_group() {
        return tag_group;
    }

    public void setTag_group(List<QywxTagGroupDTO> tag_group) {
        this.tag_group = tag_group;
    }
}
