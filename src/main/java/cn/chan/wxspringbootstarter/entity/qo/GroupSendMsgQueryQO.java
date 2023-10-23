package cn.chan.wxspringbootstarter.entity.qo;

import lombok.Data;

/**
 * @author: piaoxue
 * @date: 2023/10/18 - 16:27
 * @description:
 **/
@Data
public class GroupSendMsgQueryQO {
    private String msgid;
    private String userid;
    private Integer limit;
    private String cursor;
}
