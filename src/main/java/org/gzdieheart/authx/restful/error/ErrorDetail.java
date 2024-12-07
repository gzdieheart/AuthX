package org.gzdieheart.authx.restful.error;

import lombok.Data;

/**
 * @author hyj
 * @version 1.0
 * @date 2024/12/05
 * 定义错误代码细节
 */

@Data
public class ErrorDetail {
    /**
     * 响应是否成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 错误描述
     */
    private String details;
    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 接口请求时间戳
     */
    private String timestamp;
}
