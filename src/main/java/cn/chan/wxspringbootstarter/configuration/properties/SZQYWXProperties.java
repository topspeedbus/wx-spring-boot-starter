package cn.chan.wxspringbootstarter.configuration.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: chan
 * @date: 2023/1/9 - 16:57
 * @description:
 **/
@ConfigurationProperties(prefix = "wx.szqw.config")
public class SZQYWXProperties {
    private String appId;
    private String appSecret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
