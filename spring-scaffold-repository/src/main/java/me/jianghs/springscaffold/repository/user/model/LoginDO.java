package me.jianghs.springscaffold.repository.user.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @className: LoginDO
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/14 17:32
 * @version: 1.0
 */
@Data
@Entity
@Table(name = "login")
public class LoginDO {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "login_code", nullable = false)
    private String loginCode;

    @Column(name = "last_login_date", nullable = false)
    private Date lastLoginDate;
}
