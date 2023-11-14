package com.wk.shop_online.service;

import com.wk.shop_online.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.query.CartQuery;
import com.wk.shop_online.query.EditCartQuery;
import com.wk.shop_online.vo.CartGoodsVO;

import java.util.List;

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

    List<CartGoodsVO> shopCartList(Integer userId);

    CartGoodsVO editCart(EditCartQuery query);

    void removeCartGoods(Integer userId,List<Integer> ids);


}
