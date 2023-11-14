package cn.chan.wxspringbootstarter.entity.dto;

import java.util.List;

/**
 * @author: chan
 * @date: 2023/4/3 - 15:21
 * @description:
 **/
public class FollowUserDTO {


        private String userid;
        private String remark;
        private String description;
        private long createtime;
        private List<QwTagDTO> tags;
        private String remark_corp_name;
        private List<String> remark_mobiles;
        private String oper_userid;
        private int add_way;
        private QwWechatChannelDTO wechat_channels;

        public String getUserid() {
                return userid;
        }

        public void setUserid(String userid) {
                this.userid = userid;
        }

        public String getRemark() {
                return remark;
        }

        public void setRemark(String remark) {
                this.remark = remark;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public long getCreatetime() {
                return createtime;
        }

        public void setCreatetime(long createtime) {
                this.createtime = createtime;
        }

        public List<QwTagDTO> getTags() {
                return tags;
        }

        public void setTags(List<QwTagDTO> tags) {
                this.tags = tags;
        }

        public String getRemark_corp_name() {
                return remark_corp_name;
        }

        public void setRemark_corp_name(String remark_corp_name) {
                this.remark_corp_name = remark_corp_name;
        }

        public List<String> getRemark_mobiles() {
                return remark_mobiles;
        }

        public void setRemark_mobiles(List<String> remark_mobiles) {
                this.remark_mobiles = remark_mobiles;
        }

        public String getOper_userid() {
                return oper_userid;
        }

        public void setOper_userid(String oper_userid) {
                this.oper_userid = oper_userid;
        }

        public int getAdd_way() {
                return add_way;
        }

        public void setAdd_way(int add_way) {
                this.add_way = add_way;
        }

        public QwWechatChannelDTO getWechat_channels() {
                return wechat_channels;
        }

        public void setWechat_channels(QwWechatChannelDTO wechat_channels) {
                this.wechat_channels = wechat_channels;
        }
}
