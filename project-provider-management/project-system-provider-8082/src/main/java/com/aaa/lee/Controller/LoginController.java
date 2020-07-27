package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.User;
import com.aaa.lee.service.LoginService;
import com.aaa.lee.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.lee.status.LoginStatus.*;

/**
 * create by: lee
 * description:
 */
@RestController
public class LoginController extends CommonController {
    @Autowired
    private LoginService loginService;

    @Override
    public BaseService getBaseService() {
        return loginService;
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 15:59
     * Description: 执行登录操作
     **/


    @PostMapping("/doLogin")
    public ResultData doLogin(User user) {
        TokenVo tokenVo = loginService.dologin(user);
        if (tokenVo.getIfSuccess()) {
            return super.loginSuccess(tokenVo.getToken());
        } else if (tokenVo.getType() == 1) {
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        } else if (tokenVo.getType() == 2) {
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        } else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }
    }
}
