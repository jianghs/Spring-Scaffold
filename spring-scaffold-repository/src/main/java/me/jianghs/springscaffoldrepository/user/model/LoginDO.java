package me.jianghs.springscaffoldrepository.user.model;

import lombok.Data;

import java.util.Date;

/**
 * @className: LoginDO
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/14 17:32
 * @version: 1.0
 */
@Data
public class LoginDO {
    private Long id;

    private Long userId;

    private Date lastLoginDate;
}
