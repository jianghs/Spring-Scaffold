package me.jianghs.springscaffold.common.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @className: MapStructUtil
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/8/19 16:42
 * @version: 1.0
 */
@Mapper
public class MapStructUtil<S, T> {

    MapStructUtil INSTANCE = Mappers.getMapper(MapStructUtil.class);

}
