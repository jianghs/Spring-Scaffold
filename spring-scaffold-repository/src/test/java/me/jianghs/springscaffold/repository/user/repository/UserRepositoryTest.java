package me.jianghs.springscaffold.repository.user.repository;

import lombok.extern.slf4j.Slf4j;
import me.jianghs.springscaffold.repository.dao.user.UserRepository;
import me.jianghs.springscaffold.repository.model.user.UserDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;


@Slf4j
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void add() {
        UserDO userDO = new UserDO();
        userDO.setUserCode(UUID.randomUUID().toString());
        userDO.setBirthday(new Date());
        userDO.setEmail("json@gmail.com");
        userDO.setMobile("110");
        userDO.setName("里斯");
        userDO.setSex("M");
        userDO = userRepository.save(userDO);
        Assertions.assertEquals("里斯", userDO.getName());
    }

}