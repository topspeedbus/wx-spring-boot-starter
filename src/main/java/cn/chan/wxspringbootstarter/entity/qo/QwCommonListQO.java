package cn.chan.wxspringbootstarter.entity.qo;

/**
 * @author: piaoxue
 * @date: 2023/10/12 - 11:09
 * @description:
 **/
public class QwCommonListQO {
    private String cursor;

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

    private int limit;
}
