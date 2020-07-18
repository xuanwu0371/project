package com.aaa.lee.status;

/**
 * create by: lee
 * description:
 */
public enum OperationStatus {
    OPERATION_SUCCESS("1", "操作成功"),
    OPERATION_FAILED("2", "操作失败"),
    ZUUL_FILTER_SUCCESS("3", "路由过滤成功"),
    ZUUL_FILTER_FAILED("4", "路由过滤失败"),
    ZUUL_FILTER_TOKEN_SUCCESS("5", "token值存在"),
    ZUUL_FILTER_TOKEN_FAILED("6", "token值不存在"),
    REQUEST_IS_NULL("7", "request对象为null");

    OperationStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
