package me.jianghs.springscaffold.service.user.impl;

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

import java.util.List;

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
        UserDO userDO = userRepository.findById(id).get();
        LoginDO loginDO = loginRepository.findById(id).get();
        return userConverter.convertBean(userDO, loginDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserBO userBO) {
        UserDO userDO = userConverter.toUserDO(userBO);
        LoginDO loginDO = userConverter.toLoginDO(userBO);
        userRepository.save(userDO);
        loginRepository.save(loginDO);
    }
}
