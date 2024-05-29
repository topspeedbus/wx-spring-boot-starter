package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/18 - 16:29
 * @description:
 **/
@Data
public class GroupSendMsgListDTO extends ErrorDTO {
    private String next_cursor;
    private List<GroupMsg> group_msg_list;

    @Data
    public static class GroupMsg {
        private String msgid;
        private String creator;
        private Integer create_time;
        private Integer create_type;

        private MSGText text;

        private List<AttachmentsDTO> attachments;
    }

    @Data
    private static class MSGText {
        String content;
    }


}

