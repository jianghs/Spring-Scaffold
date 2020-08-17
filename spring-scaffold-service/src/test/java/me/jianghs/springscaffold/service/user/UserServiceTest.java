package me.jianghs.springscaffold.service.user;

import lombok.extern.slf4j.Slf4j;
import me.jianghs.springscaffold.repository.user.model.LoginDO;
import me.jianghs.springscaffold.repository.user.model.UserDO;
import me.jianghs.springscaffold.repository.user.repository.LoginRepository;
import me.jianghs.springscaffold.repository.user.repository.UserRepository;
import me.jianghs.springscaffold.service.user.bo.UserBO;
import me.jianghs.springscaffold.service.user.convert.UserConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoginRepository loginRepository;

    @Test
    void getUserList() {
        List<UserDO> userDOList = userRepository.findAll();
        List<UserBO> userBOList = userConverter.convertList(userDOList);
        Assertions.assertNull(userBOList.get(0).getLoginCode());
    }

    @Test
    void getUserInfo() {
        UserDO userDO = userRepository.findById(1L).get();
        LoginDO loginDO = loginRepository.findById(1L).get();
        UserBO userBO = userConverter.convertBean(userDO, loginDO);
        Assertions.assertNotNull(userBO.getLoginCode());
        Assertions.assertNotNull(userBO.getMobile());
    }

    @Test
    @Transactional
    void save() {
        Date today = new Date();
        UserBO userBO = new UserBO();
        userBO.setUserCode(UUID.randomUUID().toString());
        userBO.setName("马波mabo");
        userBO.setSex("F");
        userBO.setEmail("bobo@163.com");
        userBO.setDate(today);
        userBO.setMobile("110119");
        userBO.setLoginCode(UUID.randomUUID().toString());
        userBO.setLoginDate(today);

        LoginDO loginDO = userConverter.toLoginDO(userBO);
        loginDO = loginRepository.save(loginDO);

        UserDO userDO = userConverter.toUserDO(userBO);
        userDO = userRepository.save(userDO);

        Assertions.assertEquals("马波mabo", userDO.getName());
        Assertions.assertEquals(today, loginDO.getLastLoginDate());
    }
}