package volunteer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName(value = "volunteer_application")
@Data
public class VolunteerApplication {

    @TableId("volunteer_application_id")
    private Long volunteerApplicationId;

    @TableField("volunteer_info_id")
    private Long volunteerInfoId;

    @TableField("application_status")
    private String applicationStatus;

    @TableField("claimer_id")
    private Long claimerId;


    @TableField("create_time")
    private Date createTime;

    @TableField("create_time")
    private Date updateTime;

}
