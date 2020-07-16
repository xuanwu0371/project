package com.aaa.lee.controller;

import com.aaa.lee.annotation.LoginAnnotation;
import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.User;
import com.aaa.lee.service.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: lee
 * description:
 */
@RestController
public class LoginController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @Author: lee
     * @date : 2020/7/15 15:29
     * Description: 执行登录操作
     **/
    @PostMapping("/doLogin")
    @LoginAnnotation(operationType = "登录操作", operationName = "管理员登录")
    public ResultData doLogin(User user) {
        return iProjectService.doLogin(user);
    }
}
