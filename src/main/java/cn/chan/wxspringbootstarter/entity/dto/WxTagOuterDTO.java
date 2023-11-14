package cn.chan.wxspringbootstarter.entity.dto;

/**
 * @author: chan
 * @date: 2023/3/16 - 17:24
 * @description:
 **/
public class WxTagOuterDTO extends ErrorDTO {
    public WxTag getTagDTO() {
        return tagDTO;
    }

    public void setTagDTO(WxTag tagDTO) {
        this.tagDTO = tagDTO;
    }

    private WxTag tagDTO;
}
