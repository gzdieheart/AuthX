package org.gzdieheart.authx.restful.error;

import org.gzdieheart.authx.restful.resp.ResultCode;

/**
 * @author hyj
 * @version 1.0
 * @date 2024/12/05
 * 定义通用错误代码
 */

public enum CommonErrorCode implements ResultCode {

    /**
     * 鉴权验证错误
     */
    UNAUTHORIZED(false, CommonErrorConstant.UNAUTHORIZED, "Authorization failed"),
    /**
     * 未找到资源
     */
    NOT_FOUND(false, CommonErrorConstant.NotFound, "Resource  not found."),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(false, CommonErrorConstant.UnknownError, "Unknown server internal error."),
    /**
     * 错误请求
     */
    INVALID_REQUEST(false, CommonErrorConstant.InvalidRequest, "Invalid request, for reason: "),
    /**
     * 参数验证错误
     */
    INVALID_ARGUMENT(false, CommonErrorConstant.InvalidArgument, "Validation failed for argument "),
    /**
     * 参数验证错误
     */
    INVALID_ALGORITHM(false, CommonErrorConstant.InvalidAlgorithm, "Invalid algorithm "),;

    CommonErrorCode(Boolean success, String code, String message) {
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
