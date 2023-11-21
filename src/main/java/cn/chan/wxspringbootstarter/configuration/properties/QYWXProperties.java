package cn.chan.wxspringbootstarter.configuration.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: chan
 * @date: 2023/1/9 - 16:57
 * @description:
 **/
@Data
@ConfigurationProperties(prefix = "wx.qw.config")
public class QYWXProperties {
    private String appId;
    private String appSecret;
    private String crmAgentId;
    private String crmAgentSecret;
}
