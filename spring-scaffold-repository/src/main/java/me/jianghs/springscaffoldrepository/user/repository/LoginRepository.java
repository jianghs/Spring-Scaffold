package me.jianghs.springscaffoldrepository.user.repository;

import me.jianghs.springscaffoldrepository.user.model.LoginDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginDO,Long> {
    LoginDO findLoginDOByLoginCode(String loginCode);
}
