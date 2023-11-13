package com.wk.shop_online.service;

import com.wk.shop_online.entity.UserShippingAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.vo.AddressVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface UserShippingAddressService extends IService<UserShippingAddress> {
    Integer saveShippingAddress(AddressVO addressVO);

    Integer editShippingAddress(AddressVO addressVO);

    List<AddressVO> getList(Integer userId);

    AddressVO getAddressDetail(Integer id);

    void deleteAddress(Integer id);
}
