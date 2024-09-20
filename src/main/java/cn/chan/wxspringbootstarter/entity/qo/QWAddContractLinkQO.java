package cn.chan.wxspringbootstarter.entity.qo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2024/6/26 - 16:39
 * @description:
 **/
@Data
public class QWAddContractLinkQO {
    @ApiModelProperty(value = "联系方式类型, 1-单人, 2-多人", required = true)
    private Integer type;

    @ApiModelProperty(value = "场景，1-在小程序中联系，2-通过二维码联系", required = true)
    private Integer scene;

    @ApiModelProperty(value = "在小程序中联系时使用的控件样式，详见附表", required = false)
    private Integer style;

    @ApiModelProperty(value = "联系方式的备注信息，用于助记，不超过30个字符", required = false)
    private String remark;

    @ApiModelProperty(value = "外部客户添加时是否无需验证，默认为true", required = false)
    @JsonProperty("skip_verify")
    private Boolean skipVerify = true; // 默认为true

    @ApiModelProperty(value = "企业自定义的state参数，用于区分不同的添加渠道，在调用“获取外部联系人详情”时会返回该参数值，不超过30个字符", required = false)
    private String state;

    @ApiModelProperty(value = "使用该联系方式的用户userID列表，在type为1时为必填，且只能有一个", required = false)
    private List<String> user; // 注意这里使用了userIds，因为通常我们不会直接使用user作为列表的字段名

    @ApiModelProperty(value = "使用该联系方式的部门id列表，只在type为2时有效", required = false)
    private List<Integer> partyIds; // 同样，这里使用了partyIds作为列表的字段名

    @ApiModelProperty(value = "是否临时会话模式，true表示使用临时会话模式，默认为false", required = false)
    @JsonProperty("is_temp")
    private Boolean isTemp = false; // 默认为false

    @ApiModelProperty(value = "临时会话二维码有效期，以秒为单位。该参数仅在isTemp为true时有效，默认7天，最多为14天", required = false)
    @JsonProperty("expires_in")
    private Integer expiresIn;

    @ApiModelProperty(value = "临时会话有效期，以秒为单位。该参数仅在isTemp为true时有效，默认为添加好友后24小时，最多为14天", required = false)
    @JsonProperty("chat_expires_in")
    private Integer chatExpiresIn;

    @ApiModelProperty(value = "可进行临时会话的客户unionid，该参数仅在isTemp为true时有效，如不指定则不进行限制", required = false)
    private String unionId; // 注意这里使用了unionId而不是unionid，因为Java命名通常使用驼峰命名法

    @ApiModelProperty(value = "是否开启同一外部企业客户只能添加同一个员工，默认为否，开启后，同一个企业的客户会优先添加到同一个跟进人", required = false)
    @JsonProperty("is_exclusive")
    private Boolean isExclusive = false; // 默认为false

//    @ApiModelProperty(value = "结束语，会话结束时自动发送给客户，可参考“结束语定义”，仅在isTemp为true时有效", required = false)
//    private String conclusions;

}
