package me.jianghs.springscaffold.web.user;

import me.jianghs.springscaffold.service.user.UserService;
import me.jianghs.springscaffold.service.user.bo.UserBO;
import me.jianghs.springscaffold.web.user.convert.WebUserConverter;
import me.jianghs.springscaffold.web.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @className: UserController
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/17 15:21
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    WebUserConverter webUserConverter;

    @GetMapping("/{id}")
    public UserVO getUserInfo(@PathVariable("id") long id) {
        UserBO userBO = userService.getUserInfo(id);
        return webUserConverter.fromUserBO(userBO);
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody UserVO userVO) {
        userService.save(webUserConverter.toUserBO(userVO));
        return true;
    }
}
