package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * @author: chan
 * @date: 2023/10/18 - 20:27
 * @description:
 **/
@Data
public class MediaDTO extends ErrorDTO{
    private String type;
    private String media_id;
    private String created_at;
}
