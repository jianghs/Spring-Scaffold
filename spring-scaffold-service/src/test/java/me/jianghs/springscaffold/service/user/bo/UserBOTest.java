package me.jianghs.springscaffold.service.user.bo;

import lombok.extern.slf4j.Slf4j;
import me.jianghs.springscaffold.repository.user.model.LoginDO;
import me.jianghs.springscaffold.repository.user.model.UserDO;
import me.jianghs.springscaffold.repository.user.repository.LoginRepository;
import me.jianghs.springscaffold.repository.user.repository.UserRepository;
import me.jianghs.springscaffold.service.user.convert.UserConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@Slf4j
@SpringBootTest
class UserBOTest {
    @Autowired
    UserConverter userConverter;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoginRepository loginRepository;

    @Test
    void test() {
        List<UserDO> userDOS = userRepository.findAll();
        for (int i = 0; i < userDOS.size(); i++) {
            UserDO userDO = userDOS.get(i);
            LoginDO loginDO = loginRepository.findById(userDO.getId()).get();
            UserBO userBO = userConverter.convertBean(userDO, loginDO);
            Assertions.assertEquals(userDO.getName(), userBO.getName());
            Assertions.assertEquals(loginDO.getLastLoginDate(), userBO.getLoginDate());
        }
    }

}