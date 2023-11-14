package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * @author: chan
 * @date: 2023/10/18 - 16:01
 * @description:
 **/
@Data
public class AttachmentsDTO {
    /**
     * 附件类型，可选image、link、miniprogram或者video
     */
    private String msgtype;
    private ImageDTO image;
    private LinkDTO link;
    private MiniProgramDTO miniprogram;
    private MediaDTO video;
    private MediaDTO file;

    @Data
    public static class LinkDTO {
        private String title;
        private String picurl;
        private String desc;
        private String url;
    }

    @Data
    public static class MiniProgramDTO {
        private String title;
        private String pic_media_id;
        private String appid;
        private String page;
    }

    @Data
    public static class MediaDTO {
        private String media_id;
    }
}
