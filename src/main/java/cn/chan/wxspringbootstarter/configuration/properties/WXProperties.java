package cn.chan.wxspringbootstarter.configuration.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: piaoxue
 * @date: 2023/1/9 - 16:57
 * @description:
 **/

@ConfigurationProperties(prefix = "wx.applet.configs")
public class WXProperties {

    private String copAppId;
    private String copSecret;

    private String cmsAppId;
    private String cmsSecret;

    public String getCopAppId() {
        return copAppId;
    }

    public void setCopAppId(String copAppId) {
        this.copAppId = copAppId;
    }

    public String getCopSecret() {
        return copSecret;
    }

    public void setCopSecret(String copSecret) {
        this.copSecret = copSecret;
    }

    public String getCmsAppId() {
        return cmsAppId;
    }

    public void setCmsAppId(String cmsAppId) {
        this.cmsAppId = cmsAppId;
    }

    public String getCmsSecret() {
        return cmsSecret;
    }

    public void setCmsSecret(String cmsSecret) {
        this.cmsSecret = cmsSecret;
    }
}
