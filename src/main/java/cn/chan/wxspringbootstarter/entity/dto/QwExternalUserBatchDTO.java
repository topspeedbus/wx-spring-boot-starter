package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/4/3 - 15:59
 * @description:
 **/
@Data
public class QwExternalUserBatchDTO extends ErrorDTO {
    List<QwExternalUserListDTO> external_contact_list;
    String next_cursor;
}
