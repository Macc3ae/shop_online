package com.wk.shop_online.controller;

import com.wk.shop_online.common.result.Result;
import com.wk.shop_online.entity.User;
import com.wk.shop_online.query.UserLoginQuery;
import com.wk.shop_online.service.UserService;
import com.wk.shop_online.vo.LoginResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.wk.shop_online.common.utils.ObtainUserIdUtils.getUserId;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wk
 * @since 2023-11-09
 */
@Tag(name = "用户模块")
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "微信登录")
    @PostMapping("login/wxMin")
    public Result<LoginResultVO> wxLogin(@RequestBody @Validated UserLoginQuery query) {
        LoginResultVO userVO = userService.login(query);
        return Result.ok(userVO);
    }

    @Operation(summary = "用户详情")
    @GetMapping("/profile")
    private Result<User> getUserInfo(HttpServletRequest request) {
        Integer userId = getUserId(request);
        User userInfo = userService.getUserInfo(userId);
        return Result.ok(userInfo);
    }

}