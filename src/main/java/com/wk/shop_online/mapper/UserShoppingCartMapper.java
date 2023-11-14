package com.wk.shop_online.mapper;

import com.wk.shop_online.entity.UserShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.shop_online.vo.CartGoodsVO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface UserShoppingCartMapper extends BaseMapper<UserShoppingCart> {
    List<CartGoodsVO> getCartGoodsInfo(@Param("id") Integer id);
}
