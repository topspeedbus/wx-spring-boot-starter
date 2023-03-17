package cn.chan.wxspringbootstarter.entity.dto;


/**
 * @program： CRM(会员中心)
 * @description: 基础数据-渠道业务对象
 * @author: 飘雪
 * @date: 2023-03-10
 * @company: 深圳减字科技有限公司
 */
//@Data
//@Accessors(chain = true)
//@ApiModel("微信token")
public class WXTokenDTO extends ErrorDTO {

    //    @ApiModelProperty(value = "微信token")
    private String access_token;

    private String refresh_token;

    private String openid;

    //    @ApiModelProperty(value = "过期时间")
    private Long expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
