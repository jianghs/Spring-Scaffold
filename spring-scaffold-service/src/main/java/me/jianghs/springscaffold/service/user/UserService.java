package me.jianghs.springscaffold.service.user;
import me.jianghs.springscaffold.repository.model.user.UserDO;
import me.jianghs.springscaffold.service.bo.user.UserBO;
import me.jianghs.springscaffold.service.bo.user.UserPageBO;
import org.springframework.data.domain.Page;

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
    Page<UserDO> getUserPage(Integer page, Integer size, UserPageBO userPageBO);

    /**
     * 查询某个用户
     * @author: jianghs430
     * @date: 2020/8/17 14:26
     * @param id:
     * @return: me.jianghs.springscaffold.service.bo.user.UserBO
     **/
    UserBO getUserInfo(Long id);
    /**
     * 新增一个用户
     * @param userBO
     * @return
     */
    void save(UserBO userBO);
}
