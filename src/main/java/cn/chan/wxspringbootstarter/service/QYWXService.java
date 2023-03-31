package cn.chan.wxspringbootstarter.service;


import cn.chan.wxspringbootstarter.entity.dto.*;

/**
 * @author: piaoxue
 * @date: 2023/3/13 - 18:08
 * @description:
 **/
public interface QYWXService {

    String WX_API_DOMAIN = "https://qyapi.weixin.qq.com";
    /**
     * 获取token
     */
    String GET_TOKEN_URL = WX_API_DOMAIN + "/cgi-bin/gettoken?corpid={corpid}&corpsecret={corpsecret}";
    String getToken();

    /**
     * token redis key
     */
    String TOKEN_REDIS_KEY_PREFIX = "qywx_token:";
//
//    /**
//     * 获取schema
//     */
//    String GEN_URL_SCHEMA = WX_API_DOMAIN + "/wxa/generatescheme?access_token=";
//    WXUrlSchemaDTO genUrlSchema(WxUrlSchemaOuterQO urlSchemaOuterQO);
//
//    /**
//     * 获取小程序码
//     */
//    String GET_NO_LIMIT_CODE = WX_API_DOMAIN + "/wxa/getwxacodeunlimit?access_token=";
//    byte[] getNoLimitCode(WxCodeQO wxCodeQO);
//
//    /**
//     * 获取URLLink
//     */
//    String urlLink(WxUrlLinkQO wxUrlLinkQO);
//
//
//    /**
//     * 66_CGGvh7btx-parJI9LuCA_c-JIpFtbZEFw10gWd9KznbpI4RCIPgpzLJdO10gi6Ukjvnts30eLhKiS0fDABGCu-_fgEJtHDvOdeWTvP-HCN7jefDwsWQwPT-EffgNPPaABABDD
//     * 获取用户列表
//     * @param nextOpenId 下一个openid
//     */
//    String USER_LIST_URL = WX_API_DOMAIN + "/cgi-bin/user/get?access_token={token}&next_openid={nextOpenId}";
//
//    WxMpUserList getUserList(String nextOpenId);
//
//
//    /**
//     * 批量获取用户信息
//     */
//    String USER_INFO = WX_API_DOMAIN + "/cgi-bin/user/info?access_token=";
//    WxUserInfoDTO getUserInfo(String openId);
//
//    /**
//     * 批量获取用户信息
//     */
//    String BATCH_USER_INFO = WX_API_DOMAIN + "/cgi-bin/user/info/batchget?access_token=";
//    WXUserInfoOuterDTO batchGetUserInfo(List<String> openIds);


    /************************************************标签管理*****************************************************************/


    /**
     * 创建标签
     *
     errcode	返回码
     errmsg	对返回码的文本描述内容
     tag_group	标签组列表
     tag_group.group_id	标签组id
     tag_group.group_name	标签组名称
     tag_group.create_time	标签组创建时间
     tag_group.order	标签组排序的次序值，order值大的排序靠前。有效的值范围是[0, 2^32)
     tag_group.deleted	标签组是否已经被删除，只在指定tag_id进行查询时返回
     tag_group.tag	标签组内的标签列表
     tag_group.tag.id	标签id
     tag_group.tag.name	标签名称
     tag_group.tag.create_time	标签创建时间
     tag_group.tag.order	标签排序的次序值，order值大的排序靠前。有效的值范围是[0, 2^32)
     tag_group.tag.deleted	标签是否已经被删除，只在指定tag_id/group_id进行查询时返回
     *
     */
    String CREATE_TAG = WX_API_DOMAIN + "cgi-bin/externalcontact/add_corp_tag?access_token=ACCESS_TOKEN";
    QywxTagOuterDTO createTag(QywxTagOuterDTO qywxTagOuterDTO);

    /**
     * 获取标签列表
     *
     */
    String GET_TAG_LIST = WX_API_DOMAIN + "cgi-bin/externalcontact/get_corp_tag_list?access_token=ACCESS_TOKEN";
    QywxTagOuterDTO getCorpTagList();

    /**
     * 编辑标签列表
     *
     */
    String EDIT_TAG_LIST = WX_API_DOMAIN + "cgi-bin/externalcontact/edit_corp_tag_list?access_token=ACCESS_TOKEN";
    ErrorDTO editCorpTagList(QywxEditTagDTO qywxEditTagDTO);

    /**
     * 删除标签列表
     *
     * tag_id	否	标签的id列表
     * group_id	否	标签组的id列表
     * agentid	否	授权方安装的应用agentid。仅旧的第三方多应用套件需要填此参数
     * tag_id和group_id不可同时为空。
     * 如果一个标签组下所有的标签均被删除，则标签组会被自动删除。
     *
     */
    String DELETE_TAG_LIST = WX_API_DOMAIN + "cgi-bin/externalcontact/del_corp_tag_list?access_token=ACCESS_TOKEN";
    ErrorDTO deleteCorpTagList(QywxDeleteTagDTO qywxDeleteTagDTO);


    String EDIT_USER_TAG_LIST = WX_API_DOMAIN + "cgi-bin/externalcontact/mark_tag?access_token=ACCESS_TOKEN";
    ErrorDTO editUserCorpTagList(QywxEditUserTagDTO qywxEditUserTagDTO);




    /************************************************标签管理*****************************************************************/

}