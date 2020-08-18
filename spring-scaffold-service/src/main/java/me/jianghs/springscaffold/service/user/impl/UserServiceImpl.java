package me.jianghs.springscaffold.service.user.impl;

import me.jianghs.springscaffold.common.exception.BaseException;
import me.jianghs.springscaffold.repository.user.model.LoginDO;
import me.jianghs.springscaffold.repository.user.model.UserDO;
import me.jianghs.springscaffold.repository.user.repository.LoginRepository;
import me.jianghs.springscaffold.repository.user.repository.UserRepository;
import me.jianghs.springscaffold.service.user.UserService;
import me.jianghs.springscaffold.service.user.bo.UserBO;
import me.jianghs.springscaffold.service.user.convert.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @className: UserServiceImpl
 * @description:
 * @author: jianghs430
 * @createDate: 2020/8/17 14:06
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserConverter userConverter;
    
    @Override
    public List<UserBO> getUserList() {
        List<UserDO> userDOList = userRepository.findAll();
        return userConverter.convertList(userDOList);
    }

    @Override
    public UserBO getUserInfo(Long id) {
        UserDO userDO = userRepository.findById(id).orElseThrow(() -> new BaseException("用户信息不存在"));
        LoginDO loginDO = loginRepository.findById(id).orElseThrow(() -> new BaseException("登录信息不存在"));
        return userConverter.convertBean(userDO, loginDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserBO userBO) {
        UserDO userDO = userConverter.toUserDO(userBO);
        userDO.setUserCode(UUID.randomUUID().toString());

        LoginDO loginDO = userConverter.toLoginDO(userBO);
        loginDO.setLoginCode(UUID.randomUUID().toString());
        loginDO.setLastLoginDate(new Date());
        userRepository.save(userDO);
        loginRepository.save(loginDO);
    }
}
