package org.gzdieheart.authx.restful.error;

import org.gzdieheart.authx.restful.resp.ResultCode;

/**
 * @author hyj
 * @version 1.0
 * @date 2024/12/05
 * 定义业务错误代码
 */

public enum BusinessErrorCode implements ResultCode {

    Sign_Error(false, BusinessErrorConstant.SignError, "接口签名认证无效"),
    Api_Error(false, BusinessErrorConstant.ApiERROR, "应用程序接口调用无效"),
    Wechat_Authenticate_Error(false, BusinessErrorConstant.WechatAuthenticateERROR, "微信认证无效");

    BusinessErrorCode(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;

    }

    /**
     * 响应是否成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private String code;
    /**
     * 响应信息
     */
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean getSuccess() {
        return success;
    }


}
