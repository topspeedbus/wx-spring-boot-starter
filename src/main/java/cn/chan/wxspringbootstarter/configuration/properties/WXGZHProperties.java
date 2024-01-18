package cn.chan.wxspringbootstarter.configuration.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: chan
 * @date: 2023/1/9 - 16:57
 * @description:
 **/
@ConfigurationProperties(prefix = "wx.gzh.config")
@Data
public class WXGZHProperties {
    private String appId;
    private String appSecret;
    private String appName;
    private String appCode;
}
