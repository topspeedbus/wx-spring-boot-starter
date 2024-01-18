package cn.chan.wxspringbootstarter.configuration;

import cn.chan.wxspringbootstarter.configuration.properties.WXGZHProperties;
import cn.chan.wxspringbootstarter.service.WXService;
import cn.chan.wxspringbootstarter.service.impl.WXServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @author: chan
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

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean(name = "wXGZHService")
    @ConditionalOnProperty(
            value = {"wx.gzh.config.appId"}
    )
    public WXService gzhWxService() {
        return new WXServiceImpl(wxgzhProperties.getAppId(), wxgzhProperties.getAppSecret(), wxgzhProperties.getAppName(), wxgzhProperties.getAppCode(), restTemplate, redisTemplate);
    }
}
