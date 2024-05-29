package cn.chan.wxspringbootstarter.entity.qo;

import lombok.Data;

/**
 * @author: chan
 * @date: 2023/10/18 - 16:27
 * @description:
 **/
@Data
public class GroupSendMsgListQO {
/**
 *    "chat_type":"single",
 *    "start_time":1605171726,
 *    "end_time":1605172726,
 *    "creator":"zhangshan",
 *    "filter_type":1,
 *    "limit":50,
 *    "cursor":"CURSOR"
 */

    private String chat_type = "single";
    private String creator;
    private String cursor;
    private Integer start_time;
    private Integer end_time;
    private Integer limit;
    private Integer filter_type;
}
