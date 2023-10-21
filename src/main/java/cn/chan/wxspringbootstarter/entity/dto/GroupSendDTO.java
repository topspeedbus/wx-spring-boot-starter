package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/10/18 - 15:49
 * @description:
 **/
@Data
public class GroupSendDTO {
    private String chat_type;
    private List<String> external_userid;
    private List<String> chat_id_list;
    private TagFilterDTO tag_filter;
    private String sender;
    private boolean allow_select;
    private ContentDTO text;
    private List<AttachmentsDTO> attachments;
}
