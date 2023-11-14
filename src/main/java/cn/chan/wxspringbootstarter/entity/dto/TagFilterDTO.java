package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/10/18 - 15:57
 * @description:
 **/
@Data
public class TagFilterDTO {
    private List<TagGroupDTO> group_list;
}
