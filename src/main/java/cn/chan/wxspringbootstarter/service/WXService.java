package cn.chan.wxspringbootstarter.service;


import cn.chan.wxspringbootstarter.entity.dto.*;
import cn.chan.wxspringbootstarter.entity.qo.WxTagBatchTaggingQO;
import cn.chan.wxspringbootstarter.entity.qo.WxUrlLinkQO;
import cn.chan.wxspringbootstarter.entity.qo.WxUrlSchemaOuterQO;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2023/3/13 - 18:08
 * @description:
 **/
public interface WXService {

    String WX_API_DOMAIN = "https://api.weixin.qq.com";
    /**
     * 获取token
     */
    String GET_TOKEN_URL = WX_API_DOMAIN + "/cgi-bin/token?grant_type=client_credential&appid={appId}&secret={appSecret}";


    /**
     * 获取外链接
     */
    String GENERATE_URLLINK_URL = WX_API_DOMAIN + "/wxa/generate_urllink?access_token=";


    /**
     * token redis key
     */
    String TOKEN_REDIS_KEY_PREFIX = "wx_token:";


    /**
     * 获取token
     *
     * @return
     */
    String getToken();

    /**
     * 公众号根据code获取token信息
     */
    String GET_TOKEN_BY_CODE = WX_API_DOMAIN + "/sns/oauth2/access_token?grant_type=authorization_code&appid={appId}&secret={appSecret}&code={code}";
    WXTokenDTO getTokenByCode(String code);

    /**
     * 公众号根据code获取token信息
     */
    String GEN_URL_SCHEMA = WX_API_DOMAIN + "/wxa/generatescheme?access_token=";
    WXUrlSchemaDTO genUrlSchema(WxUrlSchemaOuterQO urlSchemaOuterQO);

    /**
     * 获取URLLink
     */
    String urlLink(WxUrlLinkQO wxUrlLinkQO);


    /**
     * 66_CGGvh7btx-parJI9LuCA_c-JIpFtbZEFw10gWd9KznbpI4RCIPgpzLJdO10gi6Ukjvnts30eLhKiS0fDABGCu-_fgEJtHDvOdeWTvP-HCN7jefDwsWQwPT-EffgNPPaABABDD
     * 获取用户列表
     * @param nextOpenId 下一个openid
     */
    String USER_LIST_URL = WX_API_DOMAIN + "/cgi-bin/user/get?access_token={token}&next_openid={nextOpenId}";

    WxMpUserList getUserList(String nextOpenId);


    /**
     * 批量获取用户信息
     */
    String USER_INFO = WX_API_DOMAIN + "/cgi-bin/user/info?access_token=";
    WxUserInfoDTO getUserInfo(String openId);

    /**
     * 批量获取用户信息
     */
    String BATCH_USER_INFO = WX_API_DOMAIN + "/cgi-bin/user/info/batchget?access_token=";
    WXUserInfoOuterDTO batchGetUserInfo(List<String> openIds);


    /************************************************标签管理*****************************************************************/


    /**
     * 创建标签
     *
     * 错误码	说明
     * -1	系统繁忙
     * 45157	标签名非法，请注意不能和其他标签重名
     * 45158	标签名长度超过30个字节
     * 45056	创建的标签数过多，请注意不能超过100个
     *
     */
    String CREATE_TAG = WX_API_DOMAIN + "/cgi-bin/tags/create?access_token=";
    WxTagOuterDTO createTag(WxTag tag);

    /**
     *获取公众号已创建的标签
     */
    String GET_CREATED_TAGS = WX_API_DOMAIN + "/cgi-bin/tags/get?access_token={token}";
    WxTagsOuterDTO getCreatedTags();

    /**
     *编辑标签
     *
     * -1	系统繁忙
     * 45157	标签名非法，请注意不能和其他标签重名
     * 45158	标签名长度超过30个字节
     * 45058	不能修改0/1/2这三个系统默认保留的标签
     */
    String EDIT_TAG = WX_API_DOMAIN + "/cgi-bin/tags/update?access_token=";
    ErrorDTO editTag(WxTagOuterDTO tagOuterDTO);

    /**
     *删除标签
     *
     * -1	系统繁忙
     * 45157	标签名非法，请注意不能和其他标签重名
     * 45158	标签名长度超过30个字节
     * 45058	不能修改0/1/2这三个系统默认保留的标签
     */
    String DELETE_TAG = WX_API_DOMAIN + "/cgi-bin/tags/delete?access_token=";
    ErrorDTO deleteTag(WxTagOuterDTO tagOuterDTO);

    /**
     *标签功能目前支持公众号为用户打上最多20个标签。
     *
     错误码	说明
     -1	系统繁忙
     40032	每次传入的openid列表个数不能超过50个
     45159	非法的标签
     45059	有粉丝身上的标签数已经超过限制，即超过20个
     40003	传入非法的openid
     49003	传入的openid不属于此AppID
     */
    String BATCH_TAGGING = WX_API_DOMAIN + "/cgi-bin/tags/members/batchtagging?access_token=";
    ErrorDTO batchTagging(WxTagBatchTaggingQO batchTaggingQO);

    /**
     *标签功能目前支持公众号为用户打上最多20个标签。
     *
     错误码	说明
     -1	系统繁忙
     40032	每次传入的openid列表个数不能超过50个
     45159	非法的标签
     45059	有粉丝身上的标签数已经超过限制，即超过20个
     40003	传入非法的openid
     49003	传入的openid不属于此AppID
     */
    String BATCH_UNTAGGING = WX_API_DOMAIN + "/cgi-bin/tags/members/batchuntagging?access_token=";
    ErrorDTO batchUnTagging(WxTagBatchTaggingQO batchTaggingQO);

    /************************************************标签管理*****************************************************************/

}