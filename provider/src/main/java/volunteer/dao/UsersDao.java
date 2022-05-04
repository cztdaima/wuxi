package volunteer.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volunteer.entity.Users;
import volunteer.mapper.UsersMapper;
import volunteer.param.request.LoginRequestDto;

import java.util.List;

@Service
public class UsersDao{

    @Autowired
    private UsersMapper usersMapper;

    public Users selectByWeChatId(String weChatId) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>();
        queryWrapper.eq("we_chat_id", weChatId);

        List<Users> usersList = usersMapper.selectList(queryWrapper);
        if(usersList.isEmpty())
            return null;
        return usersList.get(0);
    }

    public Users selectByWeChatIdAndPhone(String weChatId, String phoneNo) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>();
        queryWrapper.eq("we_chat_id", weChatId)
                .lt("phone_no", phoneNo);

        List<Users> usersList = usersMapper.selectList(queryWrapper);
        if(usersList.isEmpty())
            return null;
        return usersList.get(0);
    }
}
