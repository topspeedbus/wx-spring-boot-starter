package cn.chan.wxspringbootstarter.service.impl;

import cn.chan.wxspringbootstarter.entity.dto.*;
import cn.chan.wxspringbootstarter.entity.qo.*;
import cn.chan.wxspringbootstarter.service.QYWXService;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author: chan
 * @date: 2023/3/31 - 16:22
 * @description:
 **/
public class QYWXServiceImpl implements QYWXService {

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
    public Code2SessionDTO code2Session(String code) {
        String token = getToken();
        return restTemplate.getForObject(CODE_TO_SESSION_URL, Code2SessionDTO.class, token, code);
    }

    @Override
    public JsApiTicketDTO jsapiTicket() {
        String token = getToken();
        return restTemplate.getForObject(JSAPI_TICKET, JsApiTicketDTO.class, token);
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
        return restTemplate.postForObject(EXTERNAL_CONTRACT_MARK + token, userMarkQO, ErrorDTO.class);
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

    @Override
    public QwDepartmentListDTO getDepartmentList() {
        String token = getToken();
        return restTemplate.getForObject(DEPARTMENT_LIST + token, QwDepartmentListDTO.class);
    }

    @Override
    public QwDepartmentDetailDTO getDepartmentDetail(Integer departmentId) {
        String token = getToken();
        return restTemplate.getForObject(DEPARTMENT_DETAIL, QwDepartmentDetailDTO.class, token, departmentId);
    }

    @Override
    public QwDeptUserIdOuterDTO getDepartmentIdUserIdList() {
        QwCommonListQO commonListQO = new QwCommonListQO();
        String token = getToken();
        return restTemplate.postForObject(DEPARTMENT_USERID_LIST + token, commonListQO, QwDeptUserIdOuterDTO.class);
    }

    @Override
    public QwUserDTO getUserInfo(String userId) {
        String token = getToken();
        return restTemplate.getForObject(USER_INFO, QwUserDTO.class, token, userId);
    }

    @Override
    public QwDepartmentUserOuterDTO getDepartmentUserInfo(Integer departmentId) {
        String token = getToken();
        return restTemplate.getForObject(DEPARTMENT_USER_INFO, QwDepartmentUserOuterDTO.class, token, departmentId);
    }

    @Override
    public GroupSendRespDTO groupSend(GroupSendDTO groupSendDTO) {
        String token = getToken();
        return restTemplate.postForObject(GROUP_SEND + token, groupSendDTO, GroupSendRespDTO.class);
    }

    @Override
    public ErrorDTO remindGroupMsgSend(QWMentionUserSendQO mentionUserSendQO) {
        String token = getToken();
        return restTemplate.postForObject(REMIND_GROUP_MSG_SEND + token, mentionUserSendQO, ErrorDTO.class);
    }

    @Override
    public ErrorDTO cancelGroupMsgSend(QWMentionUserSendQO mentionUserSendQO) {
        String token = getToken();
        return restTemplate.postForObject(CANCEL_GROUP_MSG_SEND + token, mentionUserSendQO, ErrorDTO.class);
    }

    @Override
    public groupSendMsgQueryDTO getGroupMsgTask(GroupSendMsgQueryQO groupSendMsgQueryQO) {
        String token = getToken();
        return restTemplate.postForObject(GET_GROUP_MSG_TASK + token, groupSendMsgQueryQO, groupSendMsgQueryDTO.class);
    }

    @Override
    public groupSendMsgQueryDTO getGroupMsgResult(GroupSendMsgQueryQO groupSendMsgQueryQO) {
        String token = getToken();
        return restTemplate.postForObject(GET_GROUP_MSG_RESULT + token, groupSendMsgQueryQO, groupSendMsgQueryDTO.class);
    }

    @Override
    public ErrorDTO sendWelcomeMsg(WelcomeMsgQO welcomeMsgQO) {
        String token = getToken();
        return restTemplate.postForObject(SEND_WELCOME_MSG + token, welcomeMsgQO, ErrorDTO.class);
    }

    @Override
    public FileUploadResp mediaUpload(UrlFileUploadQO urlFileUploadQO) {
        //读取网络图片
        ResponseEntity<byte[]> rsp = restTemplate.getForEntity(urlFileUploadQO.getUrl(), byte[].class);
        HttpHeaders responseHeader = rsp.getHeaders();
        byte[] body = rsp.getBody();
        MultipartFile file = new MockMultipartFile(urlFileUploadQO.getFileName().split("\\.")[0], urlFileUploadQO.getFileName(), responseHeader.getContentType().toString(), body);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setContentLength(file.getSize());
        headers.setContentDispositionFormData("media", file.getName());
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

        param.add("file", file.getResource());
        HttpEntity<MultiValueMap<String, Object>> formEntity = new HttpEntity<>(param, headers);

        String token = getToken();
        String url = MEDIA_UPLOAD.replace("param1", urlFileUploadQO.getType());
        return restTemplate.postForObject(url + token, formEntity, FileUploadResp.class);
    }

    private File toFile(MultipartFile multipartFile) {
        //文件上传前的名称
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(fileName);
        OutputStream out = null;
        try {
            //获取文件流，以文件流的方式输出到新文件
            out = new FileOutputStream(file);
            byte[] ss = multipartFile.getBytes();
            for (int i = 0; i < ss.length; i++) {
                out.write(ss[i]);
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
