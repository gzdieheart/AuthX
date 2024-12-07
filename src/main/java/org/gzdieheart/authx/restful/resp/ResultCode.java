package org.gzdieheart.authx.restful.resp;

/**
 * @author hyj
 * @version 1.0
 * @date 2024/12/05
 * 响应码接口，凡各模块错误码枚举类，皆须为此接口的子类型
 */

public interface ResultCode {
    String getCode();

    String getMessage();

    boolean getSuccess();
}
