package com.wk.shop_online.service.impl;

import com.wk.shop_online.entity.Category;
import com.wk.shop_online.mapper.CategoryMapper;
import com.wk.shop_online.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}