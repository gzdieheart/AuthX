package org.gzdieheart.authx.restful.resp;

import org.gzdieheart.authx.restful.error.CommonErrorConstant;

/**
 * @author hyj
 * @version 1.0
 * @date 2024/12/05
 * 响应结果枚举
 */

public enum ResultSuccess implements ResultCode {

    SUCCESS(true, CommonErrorConstant.OK, "成功"),
    FAIL(false, CommonErrorConstant.FAIL, "请求失败");

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

    ResultSuccess(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
