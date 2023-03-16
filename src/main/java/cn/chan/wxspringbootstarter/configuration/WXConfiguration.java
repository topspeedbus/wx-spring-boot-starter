package cn.chan.wxspringbootstarter.configuration;


import cn.chan.wxspringbootstarter.configuration.properties.WXProperties;
import cn.chan.wxspringbootstarter.service.WXService;
import cn.chan.wxspringbootstarter.service.impl.WXServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: piaoxue
 * @date: 2023/1/9 - 17:00
 * @description:
 **/
@Configuration
@EnableConfigurationProperties(WXProperties.class)
public class WXConfiguration {

    private final WXProperties wxProperties;

    public WXConfiguration(final WXProperties wxProperties) {
        this.wxProperties = wxProperties;
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean(name = "copWxService")
    @ConditionalOnProperty(
            value = {"wx.applet.configs.copAppId"}
    )
    public WXService copWxService() {
        return new WXServiceImpl(wxProperties.getCopAppId(), wxProperties.getCopSecret());
    }

    @Bean(name = "cmsWxService")
    @ConditionalOnProperty(
            value = {"wx.applet.configs.cmsAppId"}
    )
    public WXService cmsWxService() {
        return new WXServiceImpl(wxProperties.getCmsAppId(), wxProperties.getCmsSecret());
    }

    @Bean("wxServiceMap")
    @Lazy
    @ConditionalOnProperty(
            value = {"wx.applet.configs.copAppId"}
    )
    public Map<String, WXService> getWxServiceMap(@Qualifier("copWxService")WXService copWxService, @Qualifier("cmsWxService")WXService cmsWxService) {
        Map<String, WXService> map = new HashMap<>(2);
        map.put("官方商城", copWxService);
        map.put("POS门店", cmsWxService);
        return map;
    }

}
