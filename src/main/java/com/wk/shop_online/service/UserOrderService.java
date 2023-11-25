package com.wk.shop_online.service;

import com.wk.shop_online.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.vo.OrderDetailVO;
import com.wk.shop_online.vo.UserOrderVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface UserOrderService extends IService<UserOrder> {
    Integer addGoodsOrder(UserOrderVO orderVO);

    OrderDetailVO getOrderDetail(Integer id);
}
