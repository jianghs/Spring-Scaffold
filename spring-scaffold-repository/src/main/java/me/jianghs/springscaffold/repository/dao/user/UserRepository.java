package me.jianghs.springscaffold.repository.dao.user;

import me.jianghs.springscaffold.repository.model.user.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author jianghs430
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO,Long>, JpaSpecificationExecutor<UserDO> {
    /**
     * 根据 userCode 查询用户信息
     * @param userCode
     * @return
     */
    UserDO findUserDOByUserCode(String userCode);

}
