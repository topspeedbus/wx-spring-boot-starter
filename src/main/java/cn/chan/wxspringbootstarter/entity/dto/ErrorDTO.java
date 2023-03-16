package cn.chan.wxspringbootstarter.entity.dto;

import java.io.Serializable;

/**
 * @author: piaoxue
 * @date: 2023/3/16 - 15:43
 * @description:
 **/
public class ErrorDTO implements Serializable {
    private static final long serialVersionUID = 1389073042674901032L;

    private Integer errcode;
    private String errmsg;

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
}
