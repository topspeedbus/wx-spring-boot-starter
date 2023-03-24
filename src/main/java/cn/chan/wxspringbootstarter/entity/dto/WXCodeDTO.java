package cn.chan.wxspringbootstarter.entity.dto;


public class WXCodeDTO {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "错误码")
    private Integer errcode;

//    @ApiModelProperty(value = "错误信息")
    private String errmsg;

//    @ApiModelProperty(value = "urllink")
    private String contentType;
    private byte[] buffer;

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }
}
