//package cn.chan.wxspringbootstarter.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//import javax.annotation.Resource;
//import javax.net.ssl.*;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.security.SecureRandom;
//import java.security.cert.X509Certificate;
//
///**
// * @author: piaoxue
// * @date: 2023/3/14 - 10:29
// * @description:
// **/
////@Configuration
//public class RestConfig {
//
//    @Bean
//    @Resource(name="simpleClientHttpRequestFactory") // 在多ClientHttpRequestFactory的时候指定用哪个
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        return new RestTemplate(factory);
//    }
//
//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
//        SSL factory = new SSL();
//        factory.setReadTimeout(60000);
//        factory.setConnectTimeout(30000);//单位为ms
//        return factory;
//    }
//
//}
//
//class SSL extends SimpleClientHttpRequestFactory {
//
//    @Override
//    protected void prepareConnection(HttpURLConnection connection, String httpMethod)
//            throws IOException {
//        if (connection instanceof HttpsURLConnection) {
//            prepareHttpsConnection((HttpsURLConnection) connection);
//        }
//        super.prepareConnection(connection, httpMethod);
//    }
//
//    private void prepareHttpsConnection(HttpsURLConnection connection) {
//        connection.setHostnameVerifier(new SkipHostnameVerifier());
//        try {
//            connection.setSSLSocketFactory(createSslSocketFactory());
//        }
//        catch (Exception ex) {
//            // Ignore
//        }
//    }
//
//    private SSLSocketFactory createSslSocketFactory() throws Exception {
//        SSLContext context = SSLContext.getInstance("TLS");
//        context.init(null, new TrustManager[] { new SkipX509TrustManager() },
//                new SecureRandom());
//        return context.getSocketFactory();
//    }
//
//    private class SkipHostnameVerifier implements HostnameVerifier {
//
//        @Override
//        public boolean verify(String s, SSLSession sslSession) {
//            return true;
//        }
//
//    }
//
//    private static class SkipX509TrustManager implements X509TrustManager {
//
//        @Override
//        public X509Certificate[] getAcceptedIssuers() {
//            return new X509Certificate[0];
//        }
//
//        @Override
//        public void checkClientTrusted(X509Certificate[] chain, String authType) {
//        }
//
//        @Override
//        public void checkServerTrusted(X509Certificate[] chain, String authType) {
//        }
//
//    }
//
//}
