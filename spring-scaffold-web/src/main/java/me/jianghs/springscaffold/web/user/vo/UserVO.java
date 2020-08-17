package me.jianghs.springscaffold.web.user.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @className: UserVO
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/17 15:20
 * @version: 1.0
 */
@Data
public class UserVO implements Serializable {

    @NotBlank(message = "姓名不得为空")
    private String name;

    @NotNull(message = "手机号不得为空")
    @Length(min = 11, max = 11, message = "手机号必须11位")
    private String mobile;

    @NotNull(message = "性别不得为空")
    @Pattern(regexp = "[FM]", message = "性别只能为M-男或者F-女")
    private String sex;

    @NotNull(message = "邮箱不得为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotNull(message = "出生日期不得为空")
    private String date;
}
