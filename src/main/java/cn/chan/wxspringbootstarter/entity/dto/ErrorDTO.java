package cn.chan.wxspringbootstarter.entity.dto;

import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: chan
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

    public void checkIfError() {
        if (!ObjectUtils.isEmpty(errcode)
                && !Objects.equals(errcode, 0)) {
            throw new RuntimeException("调用微信API报错, errorCode: " + errcode + ", errorMsg: " + errmsg);
        }
    }
}
