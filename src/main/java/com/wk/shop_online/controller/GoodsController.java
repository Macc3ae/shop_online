package com.wk.shop_online.controller;

import com.wk.shop_online.common.result.Result;
import com.wk.shop_online.query.RecommendByTabGoodsQuery;
import com.wk.shop_online.service.GoodsService;
import com.wk.shop_online.vo.GoodsVO;
import com.wk.shop_online.vo.IndexTabRecommendVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
@Tag(name = "商品模块")
@RestController
@RequestMapping("goods")
@AllArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @Operation(summary = "首页-热门推荐商品列表")
    @PostMapping("preference")
    public Result<IndexTabRecommendVO> getTabRecommendGoodsByTabId(@RequestBody @Validated RecommendByTabGoodsQuery query) {
        IndexTabRecommendVO result = goodsService.getTabRecommendGoodsByTabId(query);
        return Result.ok(result);
    }

    @Operation(summary = "首页-商品详情")
    @GetMapping("detail")
    public Result<GoodsVO> getGoodsDetail(@RequestParam Integer id) {
        GoodsVO goodsDetail = goodsService.getGoodsDetail(id);
        return Result.ok(goodsDetail);
    }
}
