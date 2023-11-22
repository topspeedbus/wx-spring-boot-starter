package cn.chan.wxspringbootstarter.configuration.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/1/9 - 16:57
 * @description:
 **/

@ConfigurationProperties(prefix = "wx.qw")
@Data
public class QYWXProperties {

    private List<QWConfig> configs;

    @Data
    public static class QWConfig {
        private String corpID;
        private String appSecret;
        private String crmAgentId;
        private String crmAgentSecret;
        private String appName;
        private String nameCode;

    }
}
