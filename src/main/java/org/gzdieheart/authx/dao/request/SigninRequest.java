package org.gzdieheart.authx.dao.request;

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
public class SigninRequest {
    private String email;
    private String password;
}
