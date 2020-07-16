package com.aaa.lee.annotation;

import java.lang.annotation.*;


/**
 * @Author: lee
 * @date : 2020/7/15 15:07
 * Description:
 *
**/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAnnotation {
    /**
     * @Author: lee
     * @date : 2020/7/15 15:09
     * Description: 要执行的操作
     *          eg:
     *          delete操作 update操作 insert操作
    **/
    String operationType();
    /**
     * @Author: lee
     * @date : 2020/7/15 15:09
     * Description: 所要执行的具体操作内容
     *          删除用户,删除菜单,删除部门
    **/
    String operationName();
}
