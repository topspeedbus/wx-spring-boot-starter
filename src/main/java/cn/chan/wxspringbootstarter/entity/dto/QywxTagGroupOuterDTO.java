package cn.chan.wxspringbootstarter.entity.dto;

/**
 * @author: chan
 * @date: 2023/3/31 - 17:12
 * @description:
 **/
public class QywxTagGroupOuterDTO extends ErrorDTO {
    private QywxTagGroupDTO tag_group;

    public QywxTagGroupDTO getTag_group() {
        return tag_group;
    }

    public void setTag_group(QywxTagGroupDTO tag_group) {
        this.tag_group = tag_group;
    }
}
