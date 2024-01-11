package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * @author: chan
 * @date: 2023/4/3 - 15:31
 * @description:
 **/
@Data
public class QwExternalUserListDTO {
    private QwExternalContractDTO external_contact;
    private FollowUserDTO follow_info;
}

