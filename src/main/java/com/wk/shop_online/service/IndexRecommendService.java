package com.wk.shop_online.service;

import com.wk.shop_online.entity.IndexRecommend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.vo.IndexRecommendVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface IndexRecommendService extends IService<IndexRecommend> {
    List<IndexRecommendVO> getList();
}
