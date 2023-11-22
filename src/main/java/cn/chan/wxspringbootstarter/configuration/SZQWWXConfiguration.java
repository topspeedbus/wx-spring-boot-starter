//package cn.chan.wxspringbootstarter.configuration;
//
//import cn.chan.wxspringbootstarter.configuration.properties.SZQYWXProperties;
//import cn.chan.wxspringbootstarter.service.QYWXService;
//import cn.chan.wxspringbootstarter.service.impl.QYWXServiceImpl;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author: chan
// * @date: 2023/1/9 - 17:00
// * @description:
// **/
//@Configuration
//@EnableConfigurationProperties(SZQYWXProperties.class)
//public class SZQWWXConfiguration {
//
//    private final SZQYWXProperties qywxProperties;
//
//    public SZQWWXConfiguration(final SZQYWXProperties qywxProperties) {
//        this.qywxProperties = qywxProperties;
//    }
//
//
//    @Bean(name = "szQywxService")
//    @ConditionalOnProperty(
//            value = {"wx.szqw.config.appId"}
//    )
//    public QYWXService szQywxService() {
//        return new QYWXServiceImpl(qywxProperties.getAppId(), qywxProperties.getAppSecret(), qywxProperties.getCrmAgentId(), qywxProperties.getCrmAgentSecret());
//    }
//}
