package com.wk.shop_online.convert;

import com.wk.shop_online.entity.User;
import com.wk.shop_online.vo.LoginResultVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);


    LoginResultVO convertToLoginResultVO(User user);
}