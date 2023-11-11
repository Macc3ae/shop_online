package com.wk.shop_online.service;

import com.wk.shop_online.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.shop_online.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
public interface CategoryService extends IService<Category> {

    List<Category> getIndexCategoryList();

    List<CategoryVO> getCategoryList();
}
