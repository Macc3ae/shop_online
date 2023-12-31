package com.wk.shop_online.service;

import com.wk.shop_online.entity.IndexCarousel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface IndexCarouselService extends IService<IndexCarousel> {

    List<IndexCarousel> getList(Integer distributionSite);
}
