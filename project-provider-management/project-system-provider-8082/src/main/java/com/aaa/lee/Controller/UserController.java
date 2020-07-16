package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.User;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.aaa.lee.status.OperationStatus.INSERT_OPERATION_SUCCESS;

/**
 * create by: lee
 * description:
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController extends CommonController<User> {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:17
     * Description: 用户管理中的新增用户
    **/

    @PostMapping("/addUser")
    ResultData addUser(@RequestBody User user){
        Map<String,Object> addResult  = userService.addUser(user);
        if (INSERT_OPERATION_SUCCESS.getCode().equals(addResult.get("code"))){
            return
        }
    }
















    @Override
    public BaseService getBaseService() {
        return null;
    }
}
