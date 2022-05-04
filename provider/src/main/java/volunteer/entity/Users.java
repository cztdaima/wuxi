package volunteer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "users")
public class Users {
    @TableId("user_id")
    private Long userId;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("salt")
    private String salt;

    @TableField("identity")
    private String identity;

    @TableField("account_status")
    private String accountStatus;

    @TableField("head_portrait_id")
    private Long headPortraitId;

    @TableField("phone_no")
    private String phoneNo;

    @TableField("we_chat_id")
    private String weChatId;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
