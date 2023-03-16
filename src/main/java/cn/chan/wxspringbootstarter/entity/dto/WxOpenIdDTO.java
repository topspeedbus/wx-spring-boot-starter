package cn.chan.wxspringbootstarter.entity.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/3/16 - 15:56
 * @description:
 **/
public class WxOpenIdDTO {
    private List<String> openid = new ArrayList<>();

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
}
