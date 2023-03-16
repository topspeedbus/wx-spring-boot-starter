package cn.chan.wxspringbootstarter.configuration;

import cn.chan.wxspringbootstarter.configuration.properties.WXGZHProperties;
import cn.chan.wxspringbootstarter.service.WXService;
import cn.chan.wxspringbootstarter.service.impl.WXServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: piaoxue
 * @date: 2023/1/9 - 17:00
 * @description:
 **/
@Configuration
@EnableConfigurationProperties(WXGZHProperties.class)
public class WXGZHConfiguration {

    private final WXGZHProperties wxgzhProperties;

    public WXGZHConfiguration(final WXGZHProperties wxgzhProperties) {
        this.wxgzhProperties = wxgzhProperties;
    }


    @Bean(name = "wXGZHService")
    @ConditionalOnProperty(
            value = {"wx.gzh.config.appId"}
    )
    public WXService gzhWxService() {
        return new WXServiceImpl(wxgzhProperties.getAppId(), wxgzhProperties.getAppSecret());
    }
}
