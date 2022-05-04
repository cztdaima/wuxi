package volunteer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "volunteer_info")
public class VolunteerInfo {

    @TableId("user_id")
    private Long volunteerInfoId;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("picture_id")
    private Long pictureId;

    @TableField("promulgator_id")
    private String promulgatorId;

    @TableField("number_of_need")
    private String numberOfNeed;

    @TableField("address")
    private String address;

    @TableField("time")
    private Date time;

    @TableField("status")
    private String status;

    @TableField("award")
    private String award;

    @TableField("create_time")
    private Date createTime;

    @TableField("create_time")
    private Date updateTime;

}
