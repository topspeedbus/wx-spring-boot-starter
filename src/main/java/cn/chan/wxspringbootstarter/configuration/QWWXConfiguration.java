package cn.chan.wxspringbootstarter.configuration;

import cn.chan.wxspringbootstarter.configuration.properties.QYWXProperties;
import cn.chan.wxspringbootstarter.service.QYWXService;
import cn.chan.wxspringbootstarter.service.impl.QYWXServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chan
 * @date: 2023/1/9 - 17:00
 * @description:
 **/
@Configuration
@EnableConfigurationProperties(QYWXProperties.class)
public class QWWXConfiguration {

    private final QYWXProperties qywxProperties;

    public QWWXConfiguration(final QYWXProperties qywxProperties) {
        this.qywxProperties = qywxProperties;
    }


    @Bean(name = "qywxService")
    @ConditionalOnProperty(
            value = {"wx.qw.config.appId"}
    )
    public QYWXService qywxService() {
        return new QYWXServiceImpl(qywxProperties.getAppId(), qywxProperties.getAppSecret(), qywxProperties.getCrmAgentId(), qywxProperties.getCrmAgentSecret());
    }
}
