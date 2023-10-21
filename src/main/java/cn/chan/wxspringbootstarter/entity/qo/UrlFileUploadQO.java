package cn.chan.wxspringbootstarter.entity.qo;

import lombok.Data;

/**
 * @author: piaoxue
 * @date: 2023/10/19 - 16:34
 * @description:
 **/
@Data
public class UrlFileUploadQO {
    private String url;
    private String fileName;
    private String type;
}
