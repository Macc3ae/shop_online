package com.wk.shop_online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wk.shop_online.common.exception.ServerException;
import com.wk.shop_online.convert.GoodsConvert;
import com.wk.shop_online.entity.Goods;
import com.wk.shop_online.entity.UserShoppingCart;
import com.wk.shop_online.mapper.GoodsMapper;
import com.wk.shop_online.mapper.UserShoppingCartMapper;
import com.wk.shop_online.query.CartQuery;
import com.wk.shop_online.query.EditCartQuery;
import com.wk.shop_online.service.UserShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.shop_online.vo.CartGoodsVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
@Service
@AllArgsConstructor
public class UserShoppingCartServiceImpl extends ServiceImpl<UserShoppingCartMapper, UserShoppingCart> implements UserShoppingCartService {
    private final GoodsMapper goodsMapper;
    @Override
    public CartGoodsVO addShopCart(CartQuery query) {
        Goods goods = goodsMapper.selectById(query.getId());
        if (goods == null){
            throw new ServerException("商品不存在");
        }
        if (query.getCount() > goods.getInventory()){
            throw new ServerException("商品库存不足");
        }
        UserShoppingCart userShoppingCart = new UserShoppingCart();
        userShoppingCart.setUserId(query.getUserId());
        userShoppingCart.setGoodsId(goods.getId());
        userShoppingCart.setPrice(goods.getPrice());
        userShoppingCart.setCount(query.getCount());
        userShoppingCart.setAttrsText(query.getAttrsText());
        userShoppingCart.setSelected(false);
        baseMapper.insert(userShoppingCart);

        CartGoodsVO goodsVO = new CartGoodsVO();
        goodsVO.setId(userShoppingCart.getId());
        goodsVO.setName(goods.getName());
        goodsVO.setAttrsText(query.getAttrsText());
        goodsVO.setPrice(userShoppingCart.getPrice());
        goodsVO.setNowPrice(goods.getPrice());
        goodsVO.setSelected(userShoppingCart.getSelected());
        goodsVO.setStock(goods.getInventory());
        goodsVO.setCount(query.getCount());
        goodsVO.setPicture(goods.getCover());
        goodsVO.setDiscount(goods.getDiscount());
        return goodsVO;
    }

    @Override
    public List<CartGoodsVO> shopCartList(Integer userId) {
        List<CartGoodsVO> list = baseMapper.getCartGoodsInfo(userId);
        return list;
    }

    @Override
    public CartGoodsVO editCart(EditCartQuery query) {
        UserShoppingCart userShoppingCart = baseMapper.selectById(query.getId());
        if (userShoppingCart == null){
            throw new ServerException("购物车信息不存在");
        }

        userShoppingCart.setCount(query.getCount());
        userShoppingCart.setSelected(query.getSelected());
        baseMapper.updateById(userShoppingCart);

        Goods goods = goodsMapper.selectById(userShoppingCart.getGoodsId());
        if(query.getCount() > goods.getInventory()){
            throw new ServerException(goods.getName() + "商品数量不足");
        }
        CartGoodsVO goodsVO = new CartGoodsVO();
        goodsVO.setId(userShoppingCart.getId());
        goodsVO.setAttrsText(userShoppingCart.getAttrsText());
        goodsVO.setPrice(userShoppingCart.getPrice());
        goodsVO.setNowPrice(goods.getPrice());
        goodsVO.setSelected(userShoppingCart.getSelected());
        goodsVO.setStock(goods.getInventory());
        goodsVO.setCount(query.getCount());
        goodsVO.setPicture(goods.getCover());
        goodsVO.setDiscount(goods.getDiscount());
        return goodsVO;
    }

    @Override
    public void removeCartGoods(Integer userId, List<Integer> ids) {
        List<UserShoppingCart> cartList = baseMapper.selectList(new LambdaQueryWrapper<UserShoppingCart>().eq(UserShoppingCart::getUserId,userId));
        if(cartList.size() == 0){
            return;
        }
        List<UserShoppingCart> deleteCartList = cartList.stream().filter(item -> ids.contains(item.getId())).collect(Collectors.toList());
        removeBatchByIds(deleteCartList);
    }
}
