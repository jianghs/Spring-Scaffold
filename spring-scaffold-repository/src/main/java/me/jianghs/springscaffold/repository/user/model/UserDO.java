package me.jianghs.springscaffold.repository.user.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @className: User
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/14 16:15
 * @version: 1.0
 */
@Data
@Entity
@Table(name = "user")
public class UserDO {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "user_code", nullable = false)
    private String userCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthday", nullable = false)
    private Date birthday;
}
