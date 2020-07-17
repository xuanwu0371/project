package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Role;
import com.aaa.lee.service.RoleService;
import com.aaa.lee.vo.RoleVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * create by: LiShiHao
 * create Time:  2020/7/16 19:20
 * description:
 */
@RestController
@RequestMapping("/role")
public class RoleController extends CommonController<Role> {
    @Autowired
    private RoleService roleService;

    @Override
    public BaseService getBaseService() {
        return null;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:35
     * Description: 新增角色以及批量新增权限
     **/
    @PostMapping("/insertRole")
    public ResultData insertRole(@RequestBody RoleVo roleVo) {
        Boolean insertRole = roleService.insertRole(roleVo);
        if (insertRole) {
            return super.insertOperationSuccess("新增角色及权限成功");
        }else {
            return super.insertOperationFailed("新增角色及权限失败");
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:31
     * Description: 删除角色
     **/
    @PostMapping("/deleteRole")
    public ResultData deleteRole(@RequestParam("roleId") Long roleId) {
        Boolean role = roleService.deleteRole(roleId);
        if (role) {
            return super.deleteOperationSuccess("删除角色成功");
        } else {
            return super.deleteOperationFailed("删除角色失败");
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:38
     * Description: 修改角色及权限
     **/
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleVo roleVo){
        Boolean updateRole = roleService.updateRole(roleVo);
        if (updateRole){
            return super.updateOperationSuccess("修改角色及权限成功");
        }else {
            return super.updateOperationFailed("修改角色及权限失败");
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:23
     * Description: 查询所有的角色
     **/
    @GetMapping("/allRoles")
    public ResultData selectAllRole() {
        ResultData resultData = roleService.selectAllRole();
        if (resultData.getMsg().equals("查询成功")) {
            return selectOperationSuccess(resultData.getCode());
        } else {
            return selectOperationFailed();
        }
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:27
     * Description: 简单的分页查询
     **/
    @PostMapping("/pageRoles")
    public ResultData selectAllRoleByPage(@RequestBody RoleVo roleVo) {
        ResultData<PageInfo<Role>> resultData = roleService.selectAllRoleByPage(roleVo);
        if (resultData.getCode().equals("1")) {
            return selectOperationSuccess(resultData.getCode());
        } else {
            return selectOperationFailed();
        }
    }
}
