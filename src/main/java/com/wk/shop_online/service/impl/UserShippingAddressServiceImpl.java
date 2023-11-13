package com.wk.shop_online.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wk.shop_online.Enums.AddressDefaultEnum;
import com.wk.shop_online.common.exception.ServerException;
import com.wk.shop_online.common.result.Result;
import com.wk.shop_online.convert.AddressConvert;
import com.wk.shop_online.entity.UserShippingAddress;
import com.wk.shop_online.mapper.UserShippingAddressMapper;
import com.wk.shop_online.service.UserShippingAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.shop_online.vo.AddressVO;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
@Service
public class UserShippingAddressServiceImpl extends ServiceImpl<UserShippingAddressMapper, UserShippingAddress> implements UserShippingAddressService {

    @Override
    public Integer saveShippingAddress(AddressVO addressVO) {
        UserShippingAddress convert = AddressConvert.INSTANCE.convert(addressVO);
        if(addressVO.getIsDefault() == AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
            List<UserShippingAddress> list = baseMapper.selectList(new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getIsDefault,AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
            if(list.size() > 0){
                throw new ServerException("已经存在默认地址，请勿重复操作");
            }
        }
        save(convert);
        return convert.getId();
    }

    @Override
    public Integer editShippingAddress(AddressVO addressVO) {
        UserShippingAddress userShippingAddress = baseMapper.selectById(addressVO.getId());
        if(userShippingAddress == null){
            throw new ServerException("地址不存在");
        }
        if(addressVO.getIsDefault() == AddressDefaultEnum.DEFAULT_ADDRESS.getValue()){
            UserShippingAddress address = baseMapper.selectOne(new LambdaQueryWrapper<UserShippingAddress>().eq(UserShippingAddress::getUserId,addressVO.getUserId()).eq(UserShippingAddress::getUserId,addressVO.getUserId()).eq(UserShippingAddress::getIsDefault,AddressDefaultEnum.DEFAULT_ADDRESS.getValue()));
            if (address != null){
                address.setIsDefault(AddressDefaultEnum.NOT_DEFAULT_ADDRESS.getValue());
                updateById(address);
            }
        }
        UserShippingAddress address = AddressConvert.INSTANCE.convert(addressVO);
        updateById(address);
        return address.getId();
    }

    @Override
    public List<AddressVO> getList(Integer userId) {
        LambdaQueryWrapper<UserShippingAddress> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserShippingAddress::getUserId,userId);
        wrapper.orderByDesc(UserShippingAddress::getIsDefault);
        wrapper.orderByDesc(UserShippingAddress::getCreateTime);
        List<UserShippingAddress> list = baseMapper.selectList(wrapper);
        List<AddressVO> result = AddressConvert.INSTANCE.convertToAddressVOList(list);
        return result;
    }

    @Override
    public AddressVO getAddressDetail(Integer id) {
        UserShippingAddress userShippingAddress = baseMapper.selectById(id);
        if(userShippingAddress == null){
            throw new ServerException("地址不存在");
        }
        AddressVO addressVO = AddressConvert.INSTANCE.convertToAddressVO(userShippingAddress);
        return addressVO;
    }

    @Override
    public void deleteAddress(Integer id) {
        removeById(id);
    }
}
