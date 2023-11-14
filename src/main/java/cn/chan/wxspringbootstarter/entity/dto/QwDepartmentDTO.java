package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/11 - 17:22
 * @description:
 **/
public class QwDepartmentDTO {

    private int id;
    private String name;
    private String name_en;
    private List<String> department_leader;
    private int parentid;
    private int order;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_en() {
        return name_en;
    }

    public void setDepartment_leader(List<String> department_leader) {
        this.department_leader = department_leader;
    }

    public List<String> getDepartment_leader() {
        return department_leader;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getParentid() {
        return parentid;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

}
