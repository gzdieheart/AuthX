package org.gzdieheart.authx.restful.error;

import org.gzdieheart.authx.restful.resp.ResultCode;
import lombok.Data;

/**
 * @author hyj
 * @version 1.0
 * @date 2024/12/06
 * 通用业务异常封装
 */

@Data
public class BusinessException extends RuntimeException {
    /**
     * 自定义异常编码
     */
    private String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResultCode resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    public BusinessException(ResultCode resultCodeEnum, String msg) {
        super(resultCodeEnum.getMessage() + " " + msg);
        this.code = resultCodeEnum.getCode();
    }
}
