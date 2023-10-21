package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * @author: piaoxue
 * @date: 2023/10/19 - 16:36
 * @description:
 **/
@Data
public class FileUploadResp extends ErrorDTO {
    private String type;
    private String media_id;
    private Long created_at;
}
