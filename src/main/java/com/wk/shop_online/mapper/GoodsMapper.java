package com.wk.shop_online.mapper;

import com.wk.shop_online.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.shop_online.entity.UserOrderGoods;
import com.wk.shop_online.vo.UserOrderGoodsVO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    List<UserOrderGoodsVO> getGoodsListByOrderId(@Param("id") Integer id);

}
