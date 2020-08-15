package me.jianghs.springscaffoldrepository.user.repository;

import me.jianghs.springscaffoldrepository.user.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDO,Long> {
    UserDO findUserDOByUserCode(String userCode);
}
