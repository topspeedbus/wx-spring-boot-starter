package cn.chan.wxspringbootstarter.entity.qo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: piaoxue
 * @date: 2024/5/29 - 15:22
 * @description:
 **/
@Data
public class CustomerAcquisitionQO {
    @ApiModelProperty(value = "链接名称", required = true)
    @JsonProperty("link_name")
    private String linkName;

    @ApiModelProperty(value = "此获客链接关联的userid列表，最多500人", required = false)
    @JsonProperty("user_list")
    private List<String> userList;

    @ApiModelProperty(value = "此获客链接关联的部门id列表，部门覆盖总人数最多500个", required = false)
    @JsonProperty("department_list")
    private List<Integer> departmentList;

    @ApiModelProperty(value = "是否无需验证，默认为true", required = false)
    @JsonProperty("skip_verify")
    private Boolean skipVerify = true; // 设置为默认值

    @ApiModelProperty(value = "优先分配选项", required = false)
    @JsonProperty("priority_option")
    private PriorityOption priorityOption;

    @ApiModel(value = "PriorityOption", description = "优先分配选项")
    @Data
    public static class PriorityOption {

        @ApiModelProperty(value = "客户与成员关系绑定，1-全企业范围内优先分配给有好友关系的成员；2-指定范围内优先分配有好友关系的成员", required = false)
        @JsonProperty("priority_type")
        private Integer priorityType;

        @ApiModelProperty(value = "指定成员列表，priority_type为2时必填，最多1000个", required = false)
        @JsonProperty("priority_userid_list")
        private List<String> priorityUserIdList;

    }
}
