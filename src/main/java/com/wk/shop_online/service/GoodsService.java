package com.wk.shop_online.service;

import com.wk.shop_online.common.result.PageResult;
import com.wk.shop_online.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.query.Query;
import com.wk.shop_online.query.RecommendByTabGoodsQuery;
import com.wk.shop_online.vo.GoodsVO;
import com.wk.shop_online.vo.IndexTabRecommendVO;
import com.wk.shop_online.vo.RecommendGoodsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface GoodsService extends IService<Goods> {
    IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query);
    PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query);

    GoodsVO getGoodsDetail(Integer id);
}
