package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.User;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

/**
 * @author luyu
 * @date 2020/7/16 18:36
 * Description
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @author luyu
     * @date 2020/7/16 20:30
     * Description
     * 用户管理中新增用户
     */
    @PostMapping("/addUser")
    public ResultData addUser(@RequestBody User user) {
        return iProjectService.addUser(user);

    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:10
     * Description: 根据id批量删除用户
    **/
    public ResultData delUserByIds(@RequestBody List<Integer> ids){
        return iProjectService.delUserByIds(ids);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:10
     * Description: 根据id修改用户
    **/
    @PostMapping("/updateUserById")
    public ResultData updateUserById(User user){
        return iProjectService.updateUserById(user);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:11
     * Description: 查询全部用户
    **/
    @PostMapping("/selUser")
    public ResultData selUser(User user){
        return iProjectService.selUser(user);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:12
     * Description: 根据id查询用户
    **/
    @PostMapping("/selUserById")
    public ResultData selUserById(@RequestBody User id){
        return iProjectService.selUserById(id);

    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:12
     * Description: 查询用户并分页
    **/
    @PostMapping("/selUserByPage")
    public ResultData selUserByPage(User user, Integer pageNumber, Integer pageSize){
        return iProjectService.selUserByPage(user, pageNumber, pageSize);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:13
     * Description: 根据字段查询用户信息并分页

    **/
    @PostMapping("/SelUserByPageFiled")
    public ResultData selUserByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        return iProjectService.selUserByPageFiled(number, pageSize, where, orderFiled, fileds);
    }


}
