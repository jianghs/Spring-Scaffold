package me.jianghs.springscaffold.repository.user.repository;

import me.jianghs.springscaffold.repository.user.model.LoginDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginDO,Long> {
    LoginDO findLoginDOByLoginCode(String loginCode);
}
