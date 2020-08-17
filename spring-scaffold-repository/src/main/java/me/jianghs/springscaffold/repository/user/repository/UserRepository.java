package me.jianghs.springscaffold.repository.user.repository;

import me.jianghs.springscaffold.repository.user.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDO,Long> {
    UserDO findUserDOByUserCode(String userCode);
}
