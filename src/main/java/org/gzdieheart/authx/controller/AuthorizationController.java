package org.gzdieheart.authx.controller;

import org.gzdieheart.authx.restful.resp.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 资源控制器
 */

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {
    @GetMapping
    public R sayHello() {
        return R.success().message("Here is your resource");
    }
}
