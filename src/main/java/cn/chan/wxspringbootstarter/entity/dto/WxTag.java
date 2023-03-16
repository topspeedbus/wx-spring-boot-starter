package cn.chan.wxspringbootstarter.entity.dto;

/**
 * @author: piaoxue
 * @date: 2023/3/16 - 17:24
 * @description:
 **/
public class WxTag extends ErrorDTO{
    private Integer id;

    private String name;

    /**
     * 粉丝数
     */
    private Long count;
}
