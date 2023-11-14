package com.wk.shop_online.service;

import com.wk.shop_online.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.query.CartQuery;
import com.wk.shop_online.vo.CartGoodsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface UserShoppingCartService extends IService<UserShoppingCart> {

    CartGoodsVO addShopCart(CartQuery query);
}
