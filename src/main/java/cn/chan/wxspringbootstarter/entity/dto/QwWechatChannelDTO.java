package cn.chan.wxspringbootstarter.entity.dto;

/**
 * @author: piaoxue
 * @date: 2023/4/3 - 15:30
 * @description:
 **/
public class QwWechatChannelDTO {
    private String nickname;
    private int source;
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setSource(int source) {
        this.source = source;
    }
    public int getSource() {
        return source;
    }
}
