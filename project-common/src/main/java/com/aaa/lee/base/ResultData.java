package com.aaa.lee.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 通过接口返回值
 * 也就是说把后端的controller的返回值统一了
 */
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {
    private String code;
    private String msg;
    private String detail;
    private T data;

}
