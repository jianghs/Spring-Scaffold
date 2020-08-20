package me.jianghs.springscaffold.api.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.jianghs.springscaffold.api.convert.user.UserConverter;
import me.jianghs.springscaffold.api.vo.user.UserListRequestVO;
import me.jianghs.springscaffold.api.vo.user.UserVO;
import me.jianghs.springscaffold.repository.model.user.UserDO;
import me.jianghs.springscaffold.service.user.UserService;
import me.jianghs.springscaffold.service.bo.user.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @className: UserController
 * @description:
 * @author: jianghs430
 * @createDate: 2020/8/17 15:21
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/user/v1")
@Api(value = "/user", tags = "用户接口")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    @ApiOperation(value = "查询用户列表接口", notes = "查询用户列表")
    public Page<UserDO> getUserList(@RequestBody UserListRequestVO userListRequestVO) {
        Page<UserDO> userBOList = userService.getUserPage(userListRequestVO.getPageNumber(), userListRequestVO.getPageSize(), UserConverter.INSTANCE.convert(userListRequestVO));
        return userBOList;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询用户信息接口", notes = "根据id查询用户信息")
    public UserVO getUserInfo(@NotBlank(message = "id不得为空") @PathVariable("id") long id) {
        UserBO userBO = userService.getUserInfo(id);
        return UserConverter.INSTANCE.fromUserBO(userBO);
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增用户接口", notes = "新增用户信息及登录信息")
    public void save(@Valid @RequestBody UserVO userVO) {
        userService.save(UserConverter.INSTANCE.toUserBO(userVO));
    }
}
