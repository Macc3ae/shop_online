package com.wk.shop_online.service;

import com.wk.shop_online.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.query.UserLoginQuery;
import com.wk.shop_online.vo.LoginResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface UserService extends IService<User> {
    LoginResultVO login(UserLoginQuery query);

    User getUserInfo(Integer userId);
}
