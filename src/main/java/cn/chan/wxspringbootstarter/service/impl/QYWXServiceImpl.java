package cn.chan.wxspringbootstarter.service.impl;

import cn.chan.wxspringbootstarter.entity.dto.*;
import cn.chan.wxspringbootstarter.entity.qo.QwBatchGetExternalUserInfoQO;
import cn.chan.wxspringbootstarter.entity.qo.QwEditUserMarkQO;
import cn.chan.wxspringbootstarter.service.QYWXService;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: piaoxue
 * @date: 2023/3/31 - 16:22
 * @description:
 **/
public class QYWXServiceImpl  implements QYWXService {

    private static final Logger log = LoggerFactory.getLogger(QYWXServiceImpl.class);

    public QYWXServiceImpl() {
    }

    public QYWXServiceImpl(String corpid, String corpsecret) {
        this.corpid = corpid;
        this.corpsecret = corpsecret;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    private String corpid;
    private String corpsecret;

    @Override
    public String getToken() {
        log.info("当前appid: {}, appkey: {}", corpid, corpsecret);
        //先获取redis中得token
        Object tokenRedis = redisTemplate.opsForValue().get(TOKEN_REDIS_KEY_PREFIX + corpid);
        if (!ObjectUtils.isEmpty(tokenRedis)) {
            return String.valueOf(tokenRedis);
        }

        ResponseEntity<WXTokenDTO> mapEntity = restTemplate.getForEntity(GET_TOKEN_URL, WXTokenDTO.class, corpid, corpsecret);
        WXTokenDTO token = mapEntity.getBody();
        log.info("返回token结果: {}", JSON.toJSON(token));
        if (ObjectUtils.isEmpty(token)) {
            log.error("获取微信token失败 :{}", mapEntity);
            throw new RuntimeException("获取微信token失败！");
        }

        //设置redis
        redisTemplate.opsForValue().set(TOKEN_REDIS_KEY_PREFIX + corpid, token.getAccess_token());
        redisTemplate.expire(TOKEN_REDIS_KEY_PREFIX + corpid, token.getExpires_in(), TimeUnit.SECONDS);

        return token.getAccess_token();
    }

    @Override
    public ExternalContractUserDTO getExternalContractUserList() {
        String token = getToken();
        return restTemplate.getForObject(GET_EXTERNAL_CONTRACT_USER_LIST + token, ExternalContractUserDTO.class);
    }

    @Override
    public ExternalContractDTO getExternalContractList(String userId) {
        String token = getToken();
        return restTemplate.getForObject(GET_EXTERNAL_CONTRACT_LIST, ExternalContractDTO.class, token, userId);
    }

    @Override
    public QwExternalUserDTO getExternalContractUserInfo(String externalUserId, String cursor) {
        String token = getToken();
        return restTemplate.getForObject(GET_EXTERNAL_CONTRACT_USER_INFO, QwExternalUserDTO.class, token, externalUserId, cursor);
    }

    @Override
    public QwExternalUserBatchDTO getExternalContractUserInfoBatch(QwBatchGetExternalUserInfoQO batchGetExternalUserInfoQO) {
        String token = getToken();
        return restTemplate.postForObject(GET_TAG_LIST + token, batchGetExternalUserInfoQO, QwExternalUserBatchDTO.class);
    }

    @Override
    public ErrorDTO mark(QwEditUserMarkQO userMarkQO) {
        String token = getToken();
        return restTemplate.postForObject(GET_TAG_LIST + token, userMarkQO, ErrorDTO.class);
    }

    @Override
    public QywxTagGroupOuterDTO createTag(QywxTagGroupDTO qywxTagOuterDTO) {
        String token = getToken();
        return restTemplate.postForObject(CREATE_TAG + token, qywxTagOuterDTO, QywxTagGroupOuterDTO.class);
    }

    @Override
    public QywxTagOuterDTO getCorpTagList() {
        String token = getToken();
        JSONObject jsonObject = new JSONObject();
        return restTemplate.postForObject(GET_TAG_LIST + token, jsonObject, QywxTagOuterDTO.class);
    }

    @Override
    public ErrorDTO editCorpTagList(QywxEditTagDTO qywxEditTagDTO) {
        String token = getToken();
        return restTemplate.postForObject(EDIT_TAG_LIST + token, qywxEditTagDTO, ErrorDTO.class);
    }

    @Override
    public ErrorDTO deleteCorpTagList(QywxDeleteTagDTO qywxDeleteTagDTO) {
        String token = getToken();
        return restTemplate.postForObject(DELETE_TAG_LIST + token, qywxDeleteTagDTO, ErrorDTO.class);
    }

    @Override
    public ErrorDTO editUserCorpTagList(QywxEditUserTagDTO qywxEditUserTagDTO) {
        String token = getToken();
        return restTemplate.postForObject(EDIT_USER_TAG_LIST + token, qywxEditUserTagDTO, ErrorDTO.class);
    }


}
