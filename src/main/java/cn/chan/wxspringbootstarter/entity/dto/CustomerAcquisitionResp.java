package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * @author: piaoxue
 * @date: 2024/5/29 - 15:32
 * @description:
 **/
@Data
public class CustomerAcquisitionResp extends ErrorDTO {

    private CustomerAcquisitionLinkDTO link;
}
