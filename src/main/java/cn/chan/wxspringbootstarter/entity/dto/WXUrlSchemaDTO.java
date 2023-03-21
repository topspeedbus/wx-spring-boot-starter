package cn.chan.wxspringbootstarter.entity.dto;


public class WXUrlSchemaDTO {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "错误码")
    private Integer errcode;

//    @ApiModelProperty(value = "错误信息")
    private String errmsg;

//    @ApiModelProperty(value = "urllink")
    private String openlink;


    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getOpenlink() {
        return openlink;
    }

    public void setOpenlink(String openlink) {
        this.openlink = openlink;
    }
}
