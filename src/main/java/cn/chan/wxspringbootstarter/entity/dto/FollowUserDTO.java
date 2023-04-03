package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/4/3 - 15:21
 * @description:
 **/
public class FollowUserDTO {


        private String userid;
        private String remark;
        private String description;
        private long createtime;
        private List<QwTagDTO> tags;
        private String remark_corp_name;
        private List<String> remark_mobiles;
        private String oper_userid;
        private int add_way;
        private QwWechatChannelDTO wechat_channels;


}
