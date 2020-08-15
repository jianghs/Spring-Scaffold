package me.jianghs.springscaffoldservice.user.convert;

import me.jianghs.springscaffoldrepository.user.model.LoginDO;
import me.jianghs.springscaffoldrepository.user.model.UserDO;
import me.jianghs.springscaffoldservice.user.bo.UserBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @className: UserConvert
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/14 16:19
 * @version: 1.0
 */
@Mapper(componentModel="spring")
public interface UserConverter {

//    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    /**
     * DO 转换成 BO
     * @param userDO
     * @param loginDO
     * @return
     */
    @Mappings({
            @Mapping(source = "userDO.id", target = "id", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "userDO.birthday", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "loginDO.lastLoginDate", target = "loginDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    UserBO convertBean(UserDO userDO, LoginDO loginDO);

    /**
     * DO LIST 转换成 BO LIST
     * @param userDOList
     * @return
     */
    List<UserBO> convertList(List<UserDO> userDOList);

}