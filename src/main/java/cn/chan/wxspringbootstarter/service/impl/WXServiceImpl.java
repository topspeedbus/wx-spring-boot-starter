package cn.chan.wxspringbootstarter.service.impl;


import cn.chan.wxspringbootstarter.entity.dto.*;
import cn.chan.wxspringbootstarter.entity.qo.*;
import cn.chan.wxspringbootstarter.service.WXService;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author: chan
 * @date: 2023/3/13 - 18:12
 * @description:
 **/
public class WXServiceImpl implements WXService {

    private static final Logger log = LoggerFactory.getLogger(WXServiceImpl.class);


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private String appId;
    private String appSecret;
    private String appName;
    private String appCode;
    private String path;
    private String query;

    @Override
    public String getAppId() {
        return this.appId;
    }

    @Override
    public String getAppName() {
        return this.appName;
    }

//    public WXServiceImpl(String appId, String appSecret, String path, String query, RestTemplate restTemplate, RedisTemplate redisTemplate) {
//        this.appId = appId;
//        this.appSecret = appSecret;
//        this.path = path;
//        this.query = query;
//        this.restTemplate = restTemplate;
//        this.redisTemplate = redisTemplate;
//    }

    public WXServiceImpl(String appId, String appSecret, String appName, String appCode, RestTemplate restTemplate, RedisTemplate redisTemplate) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.appName = appName;
        this.appCode = appCode;
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
        this.path = "";
        this.query = "";
    }

    @Override
    public String getToken() {

        log.info("当前appid: {}, appkey: {}", appId, appSecret);
        //先获取redis中得token
        Object tokenRedis = redisTemplate.opsForValue().get(TOKEN_REDIS_KEY_PREFIX + appId);
        if (!ObjectUtils.isEmpty(tokenRedis)) {
            return String.valueOf(tokenRedis);
        }

        ResponseEntity<WXTokenDTO> mapEntity = restTemplate.getForEntity(GET_TOKEN_URL, WXTokenDTO.class, appId, appSecret);
        WXTokenDTO token = mapEntity.getBody();
        log.info("返回token结果: {}", JSON.toJSON(token));
        if (ObjectUtils.isEmpty(token)) {
            log.error("获取微信token失败 :{}", mapEntity);
            throw new RuntimeException("获取微信token失败！");
        }

        //设置redis
        redisTemplate.opsForValue().set(TOKEN_REDIS_KEY_PREFIX + appId, token.getAccess_token());
        redisTemplate.expire(TOKEN_REDIS_KEY_PREFIX + appId, token.getExpires_in(), TimeUnit.SECONDS);

        return token.getAccess_token();
    }

    @Override
    public String getToken1() {

        log.info("当前appid: {}, appkey: {}", appId, appSecret);

        ResponseEntity<WXTokenDTO> mapEntity = restTemplate.getForEntity(GET_TOKEN_URL, WXTokenDTO.class, appId, appSecret);
        WXTokenDTO token = mapEntity.getBody();
        log.info("返回token结果: {}", JSON.toJSON(token));
        if (ObjectUtils.isEmpty(token)) {
            log.error("获取微信token失败 :{}", mapEntity);
            throw new RuntimeException("获取微信token失败！");
        }

        return token.getAccess_token();
    }

    @Override
    public WXTokenDTO getTokenByCode(String code) {
        ResponseEntity<String> mapEntity = restTemplate.getForEntity(GET_TOKEN_BY_CODE, String.class, appId, appSecret, code);

        String body = mapEntity.getBody();

        WXTokenDTO wxTokenDTO = JSONObject.parseObject(body, WXTokenDTO.class);
        return wxTokenDTO;
    }

    @Override
    public WXUrlSchemaDTO genUrlSchema(WxUrlSchemaOuterQO urlSchemaOuterQO) {
        String token = getToken1();
        WxUrlSchemaQO jump_wxa = urlSchemaOuterQO.getJump_wxa();
        jump_wxa.setPath(path);
        jump_wxa.setQuery(query);
        ResponseEntity<WXUrlSchemaDTO> entity = restTemplate.postForEntity(GEN_URL_SCHEMA + token, urlSchemaOuterQO, WXUrlSchemaDTO.class);

        return entity.getBody();
    }

    /**
     * WxCodeQO wxCodeQO = new WxCodeQO();
     * wxCodeQO.setPage(copPath);
     * wxCodeQO.setScene(copQuery);
     * byte[] resource = wxService.getNoLimitCode(wxCodeQO);
     * <p>
     * try (InputStream bis = new ByteArrayInputStream(resource)) {
     * IOssService ossService = appContext.getBean("ossService", IOssService.class);
     * String chan = ossService.UpToOss(bis, ".png");
     * return chan;
     * } catch (IOException e) {
     * throw new CustomException("获取微信小程序码报错");
     * }
     *
     * @param wxCodeQO
     * @return
     */
    @Override
    public byte[] getNoLimitCode(WxCodeQO wxCodeQO) {
        String token = getToken();
        wxCodeQO.setPage(path);
        wxCodeQO.setScene(query);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        HttpEntity requestEntity = new HttpEntity(wxCodeQO, headers);
        ResponseEntity<byte[]> entity = restTemplate.exchange(GET_NO_LIMIT_CODE + token, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
        byte[] body = entity.getBody();
        return body;
    }

    @Override
    public String urlLink(WxUrlLinkQO wxUrlLinkQO) {
        String token = getToken1();

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("query", "");
        ResponseEntity<WXUrlLinkDTO> entity = restTemplate.postForEntity(GENERATE_URLLINK_URL + token, wxUrlLinkQO, WXUrlLinkDTO.class);
        WXUrlLinkDTO urlLinkDTO = entity.getBody();
        if (ObjectUtils.isEmpty(urlLinkDTO) || !urlLinkDTO.getErrcode().equals(0)) {
            log.error("url link error :{}", entity);
            throw new RuntimeException("获取小程序外连接报错！");
        }

        return urlLinkDTO.getUrl_link();
    }

    @Override
    public WxMpUserList getUserList(String nextOpenId) {
        String token = getToken();

        ResponseEntity<WxMpUserList> entity = restTemplate.getForEntity(USER_LIST_URL, WxMpUserList.class, token, nextOpenId);
        WxMpUserList wxMpUserList = entity.getBody();

        if (ObjectUtils.isEmpty(wxMpUserList)) {
            log.error("getUserList error :{}", entity);
            throw new RuntimeException("获取小程序外连接报错！" + entity.getBody().toString());
        }

//        WxOpenIdDTO data = wxMpUserList.getData();
        return wxMpUserList;
    }

    @Override
    public WxUserInfoDTO getUserInfo(String openId) {
        String token = getToken();
        ResponseEntity<WxUserInfoDTO> entity = restTemplate.getForEntity(USER_INFO, WxUserInfoDTO.class, token, openId);
        return entity.getBody();
    }

    @Override
    public WXUserInfoOuterDTO batchGetUserInfo(List<String> openIds) {
        String token = getToken();

        //根据openid封装请求对象
        List<WxOpenIdBatchQO> batchQOS = openIds.stream().map(openid -> {
            WxOpenIdBatchQO openIdBatchQO = new WxOpenIdBatchQO();
            openIdBatchQO.setOpenid(openid);
            return openIdBatchQO;
        }).collect(Collectors.toList());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_list", batchQOS);

        ResponseEntity<WXUserInfoOuterDTO> entity = restTemplate.postForEntity(BATCH_USER_INFO + token, jsonObject, WXUserInfoOuterDTO.class);

        return entity.getBody();
    }

    @Override
    public WxTagOuterDTO createTag(WxTag tag) {
        String token = getToken();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag", tag);
        ResponseEntity<WxTagOuterDTO> entity = restTemplate.postForEntity(CREATE_TAG + token, jsonObject, WxTagOuterDTO.class);

        return entity.getBody();
    }

    @Override
    public WxTagsOuterDTO getCreatedTags() {
        String token = getToken();

        ResponseEntity<WxTagsOuterDTO> entity = restTemplate.getForEntity(GET_CREATED_TAGS, WxTagsOuterDTO.class, token);

        return entity.getBody();
    }

    @Override
    public ErrorDTO editTag(WxTagOuterDTO tagOuterDTO) {
        String token = getToken();
        ResponseEntity<ErrorDTO> entity = restTemplate.postForEntity(CREATE_TAG + token, tagOuterDTO, ErrorDTO.class);
        return entity.getBody();
    }

    @Override
    public ErrorDTO deleteTag(WxTagOuterDTO tagOuterDTO) {
        String token = getToken();
        ResponseEntity<ErrorDTO> entity = restTemplate.postForEntity(DELETE_TAG + token, tagOuterDTO, ErrorDTO.class);
        return entity.getBody();
    }

    @Override
    public ErrorDTO batchTagging(WxTagBatchTaggingQO batchTaggingQO) {
        String token = getToken();
        ResponseEntity<ErrorDTO> entity = restTemplate.postForEntity(BATCH_TAGGING + token, batchTaggingQO, ErrorDTO.class);
        return entity.getBody();
    }

    @Override
    public ErrorDTO batchUnTagging(WxTagBatchTaggingQO batchTaggingQO) {
        String token = getToken();
        ResponseEntity<ErrorDTO> entity = restTemplate.postForEntity(BATCH_UNTAGGING + token, batchTaggingQO, ErrorDTO.class);
        return entity.getBody();
    }

    @Override
    public ErrorDTO sendSubscribeMsg(SubscribeMsgSendQO subscribeMsgSendQO) {
        String token = getToken();
        ResponseEntity<ErrorDTO> entity = restTemplate.postForEntity(SEND_SUBSCRIBE_MSG + token, subscribeMsgSendQO, ErrorDTO.class);
        return entity.getBody();
    }

}
