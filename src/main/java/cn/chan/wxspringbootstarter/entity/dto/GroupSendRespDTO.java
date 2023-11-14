package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/18 - 16:06
 * @description:
 **/
@Data
public class GroupSendRespDTO extends ErrorDTO{
    List<String> fail_list;
    String msgid;
}
