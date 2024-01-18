package cn.chan.wxspringbootstarter.configuration;

import cn.chan.wxspringbootstarter.configuration.properties.GZHProperties;
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
 * @author: chan
 * @date: 2023/1/9 - 17:00
 * @description:
 **/
@Configuration
@EnableConfigurationProperties(GZHProperties.class)
public class WXGZHMultipleConfiguration {

    private final GZHProperties wxgzhProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public WXGZHMultipleConfiguration(final GZHProperties wxgzhProperties) {
        this.wxgzhProperties = wxgzhProperties;
    }


    @Bean("wxGZHServiceMap")
    @Lazy
    public Map<String, WXService> getWxGZHServiceMap() {
        Map<String, WXService> map = new HashMap<>();
        wxgzhProperties.getConfigs().forEach(config -> {
            WXServiceImpl wxService = new WXServiceImpl(config.getAppId(), config.getAppSecret(), config.getAppName(), config.getAppCode(), restTemplate, redisTemplate);
            map.put(config.getAppCode(), wxService);
        });
        return map;
    }
}
