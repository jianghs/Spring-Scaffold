package me.jianghs.springscaffoldservice.user.bo;

import lombok.extern.slf4j.Slf4j;
import me.jianghs.springscaffoldrepository.user.model.LoginDO;
import me.jianghs.springscaffoldrepository.user.model.UserDO;
import me.jianghs.springscaffoldservice.user.convert.UserConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
class UserBOTest {
    @Autowired
    UserConverter userConverter;

    @Test
    public void test() {
        List<UserDO> userDOS = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserDO userDO = new UserDO();
            userDO.setId((long)i);
            userDO.setUserCode(String.valueOf(i));
            userDO.setName("张三");
            userDO.setSex("M");
            userDO.setEmail("xx@xx.com");
            userDO.setMobile("110");
            userDO.setBirthday(new Date());

            LoginDO loginDO = new LoginDO();
            loginDO.setId((long)i);
            loginDO.setLoginCode(String.valueOf(i));
            loginDO.setLastLoginDate(new Date());

            userDOS.add(userDO);
            log.info("第{}个输出：{}", i, userDO.toString());
            UserBO userBO = userConverter.convertBean(userDO, loginDO);
            log.info("第{}个输出：{}", i, userBO.toString());
        }
        log.info("list输出：{}", userDOS.toString());

    }

}