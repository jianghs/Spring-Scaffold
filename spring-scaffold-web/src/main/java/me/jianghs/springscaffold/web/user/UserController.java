package me.jianghs.springscaffold.web.user;

import me.jianghs.springscaffold.common.entity.Result;
import me.jianghs.springscaffold.service.user.UserService;
import me.jianghs.springscaffold.service.user.bo.UserBO;
import me.jianghs.springscaffold.web.user.convert.WebUserConverter;
import me.jianghs.springscaffold.web.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
    public UserVO getUserInfo(@NotBlank(message = "id不得为空") @PathVariable("id") long id) {
        UserBO userBO = userService.getUserInfo(id);
        return webUserConverter.fromUserBO(userBO);
    }

    @PostMapping("/save")
    public void save(@Valid @RequestBody UserVO userVO) {
        userService.save(webUserConverter.toUserBO(userVO));
    }
}
