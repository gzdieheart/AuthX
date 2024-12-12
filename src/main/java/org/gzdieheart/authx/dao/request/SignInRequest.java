package org.gzdieheart.authx.dao.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 登录请求头
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
    @Email(message = "email格式不正确")
    @NotBlank(message = "email不能为空")
    @Size(max = 50, message = "email长度不能超过50个字符")
    private String email;
    @NotBlank(message = "password不能为空")
    @Size(min = 8, max = 100, message = "password长度必须在8到100个字符之间")
    private String password;
}
