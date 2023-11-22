package cn.chan.wxspringbootstarter.configuration;


import cn.chan.wxspringbootstarter.configuration.properties.QYWXProperties;
import cn.chan.wxspringbootstarter.service.QYWXService;
import cn.chan.wxspringbootstarter.service.impl.QYWXServiceImpl;
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
@EnableConfigurationProperties(QYWXProperties.class)
public class QYWXConfiguration {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private final QYWXProperties qywxProperties;

    public QYWXConfiguration(final QYWXProperties qywxProperties) {
        this.qywxProperties = qywxProperties;
    }

    @Bean("qywxServiceMap")
//    @ConditionalOnProperty(
//            value = {"wx.applet.appConfigs"}
//    )
//    @ConditionalOnProperty(prefix = "wx.qw.configs", matchIfMissing = false)
    @Lazy
    public Map<String, QYWXService> getQYWXServiceMap() {
        Map<String, QYWXService> map = new HashMap<>();
        qywxProperties.getConfigs().forEach(config -> {
            QYWXService wxService = new QYWXServiceImpl(
                    config.getCorpID(),
                    config.getAppSecret(),
                    config.getCrmAgentId(),
                    config.getCrmAgentSecret(),
                    config.getAppName(),
                    config.getNameCode(),
                    restTemplate,
                    redisTemplate
            );
            map.put(config.getNameCode(), wxService);
        });
        return map;
    }
}
