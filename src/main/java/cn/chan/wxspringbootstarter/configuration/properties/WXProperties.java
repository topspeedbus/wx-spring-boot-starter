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
    private String copPath;
    private String copQuery = "";

    private String cmsAppId;
    private String cmsSecret;
    private String cmsPath;
    private String cmsQuery = "";

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

    public String getCopPath() {
        return copPath;
    }

    public void setCopPath(String copPath) {
        this.copPath = copPath;
    }

    public String getCopQuery() {
        return copQuery;
    }

    public void setCopQuery(String copQuery) {
        this.copQuery = copQuery;
    }

    public String getCmsPath() {
        return cmsPath;
    }

    public void setCmsPath(String cmsPath) {
        this.cmsPath = cmsPath;
    }

    public String getCmsQuery() {
        return cmsQuery;
    }

    public void setCmsQuery(String cmsQuery) {
        this.cmsQuery = cmsQuery;
    }
}
