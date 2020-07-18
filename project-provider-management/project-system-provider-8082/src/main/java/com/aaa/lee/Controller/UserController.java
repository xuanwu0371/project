package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;

import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.User;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

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

    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:17
     * Description: 新增用户
     **/
    @PostMapping("/addUser")
    public ResultData addUser(@RequestBody User user) {
        ResultData resultData = userService.addUser(user);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:37
     * Description: 根据主键删除用户
     **/
    @PostMapping("/delUserByKey")
    public ResultData delUserByKey(@RequestBody User user) {
        ResultData resultData = userService.delUserByKey(user);
        return (resultData.getCode().equals(DELETE_SUCCESS.getCode()))
                ? resultData : super.deleteOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:44
     * Description: 根据id批量删除用户
     **/
    @PostMapping("/delUserByIds")
    public ResultData delUserByIds(@RequestBody Integer[] ids) {
        ResultData resultData = super.batchDelete(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();

    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 21:03
     * Description: 查询所有用户
     **/
    @PostMapping("/selUser")
    public ResultData selUser(User user) {
        ResultData resultData = userService.selUser(user);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 15:50
     * Description: 查询一条数据
     **/
    @PostMapping("/selUserById")
    public ResultData selUserById(@RequestBody User id) {
        ResultData resultData = userService.selUserById(id);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }


}
