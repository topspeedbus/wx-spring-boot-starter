package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/3/16 - 16:38
 * @description:
 **/
public class WXUserInfoOuterDTO extends ErrorDTO {
    private List<WxUserInfoDTO> user_info_list;


    public List<WxUserInfoDTO> getUser_info_list() {
        return user_info_list;
    }

    public void setUser_info_list(List<WxUserInfoDTO> user_info_list) {
        this.user_info_list = user_info_list;
    }
}
