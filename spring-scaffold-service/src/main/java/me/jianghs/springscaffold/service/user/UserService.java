package me.jianghs.springscaffold.service.user;
import me.jianghs.springscaffold.service.user.bo.UserBO;

import java.util.List;

/**
 * @className: UserService
 * @description: 用户服务
 * @author: jianghs430
 * @createDate: 2020/8/17 14:02
 * @version: 1.0
 */
public interface UserService {
    /**
     * 查询用户信息列表
     * @return
     */
    List<UserBO> getUserList();

    /**
     * 查询某个用户
     * @author: jianghs430
     * @date: 2020/8/17 14:26
     * @param id:
     * @return: me.jianghs.springscaffold.service.user.bo.UserBO
     **/
    UserBO getUserInfo(Long id);
    /**
     * 新增一个用户
     * @param userBO
     * @return
     */
    void save(UserBO userBO);
}
