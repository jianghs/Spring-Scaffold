package me.jianghs.springscaffold.service.user.impl;

import me.jianghs.springscaffold.common.exception.BaseException;
import me.jianghs.springscaffold.repository.model.user.LoginDO;
import me.jianghs.springscaffold.repository.model.user.UserDO;
import me.jianghs.springscaffold.repository.dao.user.LoginRepository;
import me.jianghs.springscaffold.repository.dao.user.UserRepository;
import me.jianghs.springscaffold.service.bo.user.UserPageBO;
import me.jianghs.springscaffold.service.user.UserService;
import me.jianghs.springscaffold.service.bo.user.UserBO;
import me.jianghs.springscaffold.service.convert.user.UserConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Override
    public Page<UserDO> getUserPage(Integer page, Integer size, UserPageBO userPageBO) {
        Pageable pageable = PageRequest.of(page-1, size, Sort.by("id").descending());
        Specification<UserDO> specification = (Specification<UserDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if(StringUtils.isNotBlank(userPageBO.getName())){
                Predicate predicate = criteriaBuilder.equal(root.get("name").as(String.class), userPageBO.getName());
                list.add(predicate);
            }
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        };
        Page<UserDO> userDOPage = userRepository.findAll(specification, pageable);
        return userDOPage;
    }

    @Override
    public UserBO getUserInfo(Long id) {
        UserDO userDO = userRepository.findById(id).orElseThrow(() -> new BaseException("用户信息不存在"));
        LoginDO loginDO = loginRepository.findById(id).orElseThrow(() -> new BaseException("登录信息不存在"));
        return UserConverter.INSTANCE.convertBean(userDO, loginDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserBO userBO) {
        UserDO userDO = UserConverter.INSTANCE.toUserDO(userBO);
        userDO.setUserCode(UUID.randomUUID().toString());

        LoginDO loginDO = UserConverter.INSTANCE.toLoginDO(userBO);
        loginDO.setLoginCode(UUID.randomUUID().toString());
        loginDO.setLastLoginDate(new Date());
        userRepository.save(userDO);
        loginRepository.save(loginDO);
    }
}
