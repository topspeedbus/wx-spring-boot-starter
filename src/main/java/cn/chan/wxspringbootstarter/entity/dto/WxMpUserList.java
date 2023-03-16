package cn.chan.wxspringbootstarter.entity.dto;

import lombok.Data;

/**
 * 关注者列表
 *
 * @author chanjarster
 */
@Data
public class WxMpUserList extends ErrorDTO {

  protected long total = -1;
  protected int count = -1;
//  protected List<String> openids = new ArrayList<>();
  private WxOpenIdDTO data;
  protected String next_openid;

}
