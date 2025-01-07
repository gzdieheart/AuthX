package org.gzdieheart.authx.restful.error;

/**
 * @author hyj
 * @version 1.0
 * @date 2024/12/05
 * 定义错误常量 代替错误码,避免业务复杂错误码分配重复等问题
 */

public interface CommonErrorConstant {
    /**
     * 公共错误码定义
     */
    public static final String OK = "200";
    public static final String UNAUTHORIZED = "401";
    public static final String NotFound = "404";
    public static final String FAIL = "500";
    public static final String UnknownError = "500000";
    public static final String InvalidRequest = "500001";
    public static final String InvalidArgument = "500002";
    public static final String InvalidAlgorithm = "500003";
}
