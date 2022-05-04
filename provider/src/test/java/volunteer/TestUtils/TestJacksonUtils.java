package volunteer.TestUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import volunteer.entity.Users;
import volunteer.entity.VolunteerInfo;
import volunteer.mapper.UsersMapper;
import volunteer.utils.JacksonUtils;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestJacksonUtils {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private JacksonUtils jacksonUtils;

    @Test
    void should_error_when_page_to_json() throws Exception {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>();
        queryWrapper.eq("account_status", "2");
        Page<Users> page = new Page<>(1, 10);
        Page<Users> usersPage = usersMapper.selectPage(page, queryWrapper);

        Assertions.assertEquals("he00", jacksonUtils.objectToString(usersPage.getRecords()));
    }
}
