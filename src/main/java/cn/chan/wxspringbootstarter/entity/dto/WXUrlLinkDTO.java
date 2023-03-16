package cn.chan.wxspringbootstarter.entity.dto;


public class WXUrlLinkDTO {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "错误码")
    private Integer errcode;

//    @ApiModelProperty(value = "错误信息")
    private String errmsg;

//    @ApiModelProperty(value = "urllink")
    private String url_link;


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

    public String getUrl_link() {
        return url_link;
    }

    public void setUrl_link(String url_link) {
        this.url_link = url_link;
    }
}
