package cn.chan.wxspringbootstarter.configuration;


import cn.chan.wxspringbootstarter.configuration.properties.WXAppletProperties;
import cn.chan.wxspringbootstarter.service.WXService;
import cn.chan.wxspringbootstarter.service.impl.WXServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: piaoxue
 * @date: 2023/1/9 - 17:00
 * @description:
 **/
@Configuration
@EnableConfigurationProperties(WXAppletProperties.class)
public class WXAppletConfiguration {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private final WXAppletProperties wxAppletProperties;

    public WXAppletConfiguration(final WXAppletProperties wxAppletProperties) {
        this.wxAppletProperties = wxAppletProperties;
    }

    @Bean("wxServiceMap")
//    @ConditionalOnProperty(
//            value = {"wx.applet.appConfigs"}
//    )
    @Lazy
    public Map<String, WXService> getWxServiceMap() {
        Map<String, WXService> map = new HashMap<>();
        wxAppletProperties.getAppConfigs().forEach(config -> {
            WXServiceImpl wxService = new WXServiceImpl(config.getAppId(), config.getSecret(), config.getPath(), config.getQuery(), restTemplate, redisTemplate);
            map.put(config.getCode(), wxService);
        });
        return map;
    }
}
