package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.User;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @author luyu
     * @date 2020/7/16 20:34
     * Description
     * 删除用户
     */
    @DeleteMapping("/delUser")
    public ResultData delUser(@RequestBody List<Long> ids) {
        return iProjectService.delUser(ids);
    }

    /**
     * @author luyu
     * @date 2020/7/16 20:35
     * Description
     * 修改用户信息
     */
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestBody User user) {
        return iProjectService.updateUser(user);
    }


    //TODO 导出用户信息的功能，待撰写

    /**
     * @author luyu
     * @date 2020/7/16 20:52
     * Description
     * 带条件查询用户
     */
    @PostMapping("/selectUser")
    ResultData selectUserAll(@RequestBody HashMap map) {
        return iProjectService.selectUserAll(map);
    }


}
