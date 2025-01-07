package org.gzdieheart.authx.restful.error;

/**
 * @author hyj
 * @version 1.0
 * @date 2023/5/9 20:14
 * 定义业务错误代码常量
 */

public interface BusinessErrorConstant {
    /**
     * 公共错误码定义
     */
    public static final String SignError = "500101";
    public static final String ApiERROR = "500102";
    public static final String WechatAuthenticateERROR = "500103";
    public static final String GenerateUsernameError = "500104";
}
