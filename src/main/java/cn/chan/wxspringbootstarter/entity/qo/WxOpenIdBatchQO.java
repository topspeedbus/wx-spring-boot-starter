package cn.chan.wxspringbootstarter.entity.qo;

/**
 * @author: piaoxue
 * @date: 2023/3/16 - 15:56
 * @description:
 **/
public class WxOpenIdBatchQO {
    private String openid;
    private String lang = "zh_CN";

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
