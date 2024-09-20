package cn.chan.wxspringbootstarter.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: piaoxue
 * @date: 2024/6/26 - 16:43
 * @description:
 **/
@Data
public class QWAddContractLinkResp extends ErrorDTO {
    @JsonProperty("config_id")
    private String configId;

    @JsonProperty("qr_code")
    private String qrCode;
}
