package cn.chan.wxspringbootstarter.entity.qo;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/4/3 - 15:58
 * @description:
 **/
public class QwBatchGetExternalUserInfoQO {
    private List<String> userid_list;
    private String cursor;
    private int limit;

    public List<String> getUserid_list() {
        return userid_list;
    }

    public void setUserid_list(List<String> userid_list) {
        this.userid_list = userid_list;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
