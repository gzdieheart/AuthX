package org.gzdieheart.authx.controller;

import org.gzdieheart.authx.restful.resp.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.gzdieheart.authx.dao.request.SignUpRequest;
import org.gzdieheart.authx.dao.request.SignInRequest;
import org.gzdieheart.authx.service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 鉴权控制器
 */

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "鉴权管理", description = "提供鉴权注册及登录接口")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    @Operation(summary = "注册接口", description = "根据用户邮箱及密码生成注册信息")
    public R signup(@Valid @RequestBody SignUpRequest request) {
        return R.success().data("token", authenticationService.signup(request));
    }

    @PostMapping("/signin")
    @Operation(summary = "登录接口", description = "根据用户邮箱及密码获取token")
    public R signin(@Valid @RequestBody SignInRequest request) {
        return R.success().data("token", authenticationService.signin(request));
    }
}
