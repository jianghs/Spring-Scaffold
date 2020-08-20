package me.jianghs.springscaffold.repository.dao.user;

import me.jianghs.springscaffold.repository.model.user.LoginDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginDO,Long> {
    LoginDO findLoginDOByLoginCode(String loginCode);
}
