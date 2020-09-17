package me.jianghs.springscaffold.common.enums;

import lombok.Getter;

/**
 * @className: SexCode
 * @description: 性别枚举
 * @author: jianghs430
 * @createDate: 2020/9/17 22:26
 * @version: 1.0
 */
@Getter
public enum SexCode {
    MALE("M", "男"),
    FEMALE("F", "女"),
    OTHER("Other", "其他");

    private String code;
    private String msg;

    SexCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
