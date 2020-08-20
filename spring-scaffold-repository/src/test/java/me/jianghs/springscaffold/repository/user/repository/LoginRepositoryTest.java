package me.jianghs.springscaffold.repository.user.repository;

import lombok.extern.slf4j.Slf4j;
import me.jianghs.springscaffold.repository.dao.user.LoginRepository;
import me.jianghs.springscaffold.repository.model.user.LoginDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
class LoginRepositoryTest {
    @Autowired
    LoginRepository loginRepository;

    @Test
    void add() {
        LoginDO loginDO = new LoginDO();
        loginDO.setLoginCode("A");
        loginDO.setLastLoginDate(new Date());
        loginDO = loginRepository.save(loginDO);
        Assertions.assertEquals("A", loginDO.getLoginCode());
    }

}