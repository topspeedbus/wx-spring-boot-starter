package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/11 - 18:29
 * @description:
 **/
public class QwDepartmentListDTO extends ErrorDTO {
    List<QwDepartmentDTO> department;

    public List<QwDepartmentDTO> getDepartment() {
        return department;
    }

    public void setDepartment(List<QwDepartmentDTO> department) {
        this.department = department;
    }
}
