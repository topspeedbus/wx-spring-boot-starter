package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/18 - 16:29
 * @description:
 **/
@Data
public class groupSendMsgQueryDTO extends ErrorDTO{
    private String next_cursor;
    private List<SendList> send_list;
    private List<TaskList> task_list;

    @Data
    public static class SendList {
        private String external_userid;
        private String chat_id;
        private String userid;
        private int status;
        private long send_time;
    }

    @Data
    public static class TaskList {
        private String userid;
        private int status;
        private long send_time;
    }
}

