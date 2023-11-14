package cn.chan.wxspringbootstarter.entity.qo;

import cn.chan.wxspringbootstarter.entity.dto.AttachmentsDTO;
import cn.chan.wxspringbootstarter.entity.dto.ContentDTO;
import lombok.Data;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/23 - 10:51
 * @description:
 **/
@Data
public class WelcomeMsgQO {
    private String welcome_code;
    private ContentDTO text;
    private List<AttachmentsDTO> attachments;
}
