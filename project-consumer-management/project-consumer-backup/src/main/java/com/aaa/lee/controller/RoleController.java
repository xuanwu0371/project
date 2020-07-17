package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.service.IProjectService;
import com.aaa.lee.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * create by: LiShiHao
 * create Time:  2020/7/17 9:14
 * description:
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:23
     * Description: 查询所有的角色
     **/
    @PostMapping("/allRoles")
    public ResultData selectAllRole() {
        return iProjectService.selectAllRole();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:27
     * Description: 简单的分页查询
     **/
    @PostMapping("/pageRoles")
    public ResultData selectAllRoleByPage(@RequestBody RoleVo roleVo) {
        return iProjectService.selectAllRoleByPage(roleVo);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:31
     * Description: 删除角色
     **/
    @PostMapping("/deleteRole")
    public ResultData deleteRole(@RequestParam("roleId") Long roleId) {
        return iProjectService.deleteRole(roleId);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:35
     * Description: 新增角色以及批量新增权限
     **/
    @PostMapping("/insertRole")
    public ResultData insertRole(@RequestBody RoleVo roleVo) {
        return iProjectService.insertRole(roleVo);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:38
     * Description: 修改角色及权限
     **/
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleVo roleVo) {
        return iProjectService.updateRole(roleVo);
    }
}
