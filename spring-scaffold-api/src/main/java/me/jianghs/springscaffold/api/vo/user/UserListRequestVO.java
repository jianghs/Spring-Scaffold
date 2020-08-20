package me.jianghs.springscaffold.api.vo.user;

import lombok.Data;

/**
 * @className: UserListRequestVO
 * @description:
 * @author: jianghs430
 * @createDate: 2020/8/20 10:15
 * @version: 1.0
 */
@Data
public class UserListRequestVO {
    private Integer pageNumber;

    private Integer pageSize;

    private String name;
}
