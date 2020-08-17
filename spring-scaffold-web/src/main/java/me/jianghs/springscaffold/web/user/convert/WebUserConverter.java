package me.jianghs.springscaffold.web.user.convert;

import me.jianghs.springscaffold.service.user.bo.UserBO;
import me.jianghs.springscaffold.web.user.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @className: UserConverter
 * @description:
 * @author: jianghs430
 * @createDate: 2020/8/17 15:23
 * @version: 1.0
 */
@Mapper(componentModel="spring")
public interface WebUserConverter {
    /**
     * BO 转换成 VO
     * @param userBO
     * @return
     */
    @Mapping(source = "userBO.date", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVO fromUserBO(UserBO userBO);

    /**
     * VO -> BO
     * @param userVO
     * @return
     */
    @Mapping(source = "userVO.date", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserBO toUserBO(UserVO userVO);

}
