package me.jianghs.springscaffold.api.convert.user;

import me.jianghs.springscaffold.api.vo.user.UserListRequestVO;
import me.jianghs.springscaffold.api.vo.user.UserVO;
import me.jianghs.springscaffold.service.bo.user.UserBO;
import me.jianghs.springscaffold.service.bo.user.UserPageBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @className: UserConverter
 * @description:
 * @author: jianghs430
 * @createDate: 2020/8/17 15:23
 * @version: 1.0
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    /**
     * BO 转换成 VO
     * @param userBO
     * @return
     */
    @Mapping(source = "userBO.date", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVO fromUserBO(UserBO userBO);

    /**
     * BO 转换成 VO
     * @param userBOList
     * @return
     */
    List<UserVO> fromUserBOList(List<UserBO> userBOList);

    /**
     * VO -> BO
     * @param userVO
     * @return
     */
    @Mapping(source = "userVO.date", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserBO toUserBO(UserVO userVO);

    UserPageBO convert(UserListRequestVO userListRequestVO);

}
