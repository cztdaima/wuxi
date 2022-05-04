package volunteer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "picture")
public class Picture {

    @TableId("picture_id")
    private Long pictureId;

    @TableField("picture_url_address")
    private String pictureUrlAddress;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

}
