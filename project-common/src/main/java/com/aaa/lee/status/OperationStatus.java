package com.aaa.lee.status;

/**
 * create by: lee
 * description:
 */
public enum OperationStatus {
    SUCCESS("1", "操作成功"),
    FAILED("2", "操作失败"),
    INSERT_SUCCESS("3","插入成功"),
    INSERT_FAILED("4","插入失败"),
    DELETE_SUCCESS("5","删除成功"),
    DELETE_FAILED("6","删除失败"),
    UPDATE_SUCCESS("7","更新成功"),
    UPDATE_FAILED("8","更新失败"),
    SELECT_SUCCESS("9","查询成功"),
    SELECT_FAILED("10","查询失败"),
    ZUUL_FILTER_SUCCESS("11", "路由过滤成功"),
    ZUUL_FILTER_FAILED("12", "路由过滤失败"),
    ZUUL_FILTER_TOKEN_SUCCESS("13", "token值存在"),
    ZUUL_FILTER_TOKEN_FAILED("14", "token值不存在"),
    REQUEST_IS_NULL("15", "request对象为null");

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
