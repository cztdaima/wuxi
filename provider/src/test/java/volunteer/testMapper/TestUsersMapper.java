package volunteer.testMapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import volunteer.entity.Users;
import volunteer.entity.VolunteerInfo;
import volunteer.mapper.UsersMapper;
import volunteer.utils.JacksonUtils;

@Slf4j
@MybatisPlusTest

public class TestUsersMapper {
    @Autowired
    private UsersMapper usersMapper;


    @Test
    void should_pass_when_save_users() {
        Users users = new Users();

        users.setAccountStatus("1");
        Assertions.assertEquals(1, usersMapper.insert(users));
        log.info("{}", usersMapper.selectList(null));
    }


}
