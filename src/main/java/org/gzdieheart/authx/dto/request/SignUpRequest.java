package org.gzdieheart.authx.dto.request;

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
 * 注册请求头
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @Email(message = "email格式不正确")
    @NotBlank(message = "email不能为空")
    @Size(max = 50, message = "email长度不能超过50个字符")
    private String email;
    @NotBlank(message = "password不能为空")
    @Size(min = 8, max = 100, message = "password长度必须在8到100个字符之间")
    private String password;
    @NotBlank(message = "firstname不能为空")
    @Size(max = 50, message = "firsname长度不能超过50个字符")
    private String firstname;
    @NotBlank(message = "lastname不能为空")
    @Size(max = 50, message = "lastname长度不能超过50个字符")
    private String lastname;
}
