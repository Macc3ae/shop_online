package com.wk.shop_online.service;

import com.wk.shop_online.common.result.PageResult;
import com.wk.shop_online.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.query.CancelGoodsQuery;
import com.wk.shop_online.query.OrderPreQuery;
import com.wk.shop_online.query.OrderQuery;
import com.wk.shop_online.vo.OrderDetailVO;
import com.wk.shop_online.vo.SubmitOrderVO;
import com.wk.shop_online.vo.UserAddressVO;
import com.wk.shop_online.vo.UserOrderVO;

import java.util.List;

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

    SubmitOrderVO getPreOrderDetail(Integer userId);

    List<UserAddressVO> getAddressListByUserId(Integer userId,Integer addressId);

    SubmitOrderVO getPreNowOrderDetail(OrderPreQuery query);

    SubmitOrderVO getRepurchaseOrderDetail(Integer id);

    PageResult<OrderDetailVO> getOrderList(OrderQuery query);

    OrderDetailVO cancelOrder(CancelGoodsQuery query);

    void deleteOrder(List<Integer> ids,Integer userId);

    void payOrder(Integer id);

    void consignOrder(Integer id);

    OrderDetailVO receiptOrder(Integer id);
}
