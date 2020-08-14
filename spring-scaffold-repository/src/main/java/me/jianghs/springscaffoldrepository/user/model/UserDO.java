package me.jianghs.springscaffoldrepository.user.model;

import lombok.Data;

import java.util.Date;

/**
 * @className: User
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/14 16:15
 * @version: 1.0
 */
@Data
public class UserDO {
    private Long id;

    private String name;

    private String mobile;

    private String sex;

    private String email;

    private Date birthday;
}
