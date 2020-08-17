package me.jianghs.springscaffold.web.user;

import me.jianghs.springscaffold.service.user.UserService;
import me.jianghs.springscaffold.service.user.bo.UserBO;
import me.jianghs.springscaffold.web.user.convert.UserConverter;
import me.jianghs.springscaffold.web.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: UserController
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/17 15:21
 * @version: 1.0
 */
@RestController("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    @GetMapping("/{id}")
    public UserVO getUserInfo(@PathVariable("id") long id) {
        UserBO userBO = userService.getUserInfo(id);
        return userConverter.fromUserBO(userBO);
    }
}