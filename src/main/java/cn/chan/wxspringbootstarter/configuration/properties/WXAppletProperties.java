package cn.chan.wxspringbootstarter.configuration.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/1/9 - 16:57
 * @description:
 **/

@ConfigurationProperties(prefix = "wx.applet")
@Data
public class WXAppletProperties {

    private List<AppletConfig> appConfigs;

    @Data
    public static class AppletConfig {
        private String appId;
        private String secret;
        private String name;
        private String code;
        private String path;
        private String query = "";
    }
}
