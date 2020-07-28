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
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

import static com.aaa.lee.status.OperationStatus.*;

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
        return roleService;
    }

    /**
     * @Author: Li ShiHao
     * @Date: 2020/7/28 8:55
     * @Description: 新增角色以及批量新增权限
     */
    @PostMapping("/insertRole")
    public ResultData insertRole(RoleVo roleVo) {
        Boolean insertRole = roleService.insertRole(roleVo);
        return (insertRole)
                ? super.insertOperationSuccess()
                : super.insertOperationFailed();
    }

    /**
     * @Author: Li ShiHao
     * @Date: 2020/7/28 9:00
     * @Description: 删除角色
     */
    @PostMapping("/deleteRole")
    public ResultData deleteRole(Long roleId) {
        Boolean aBoolean = roleService.deleteRole(roleId);
        return (aBoolean)
                ? super.deleteOperationSuccess()
                : super.deleteOperationFailed();
    }

    /**
     * @Author: Li ShiHao
     * @Date: 2020/7/28 9:02
     * @Description: 修改角色及权限
     */

    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleVo roleVo) {
        Boolean aBoolean = roleService.updateRole(roleVo);
        return (aBoolean)
                ? super.updateOperationSuccess()
                : super.insertOperationFailed();
    }

    /**
     * @Author: Li ShiHao
     * @Date: 2020/7/28 9:05
     * @Description: 查询所有的角色
     */
    @GetMapping("/allRoles")
    public ResultData selectAllRole() {
        ResultData resultData = roleService.selectAllRole();
        return resultData.getCode().equals(SELECT_SUCCESS.getCode())
                ? resultData : super.selectOperationFailed();
    }

    /**
     * @Author: Li ShiHao
     * @Date: 2020/7/28 9:10
     * @Description: 通过userId获取对应的角色
     */
    @GetMapping("/selectRoleIdByUserId")
    public List<Role> selectRoleIdByUserId(Long userId) {
        return roleService.selectRoleIdByUserId(userId);
    }

    /**
     * @Author: Li ShiHao
     * @Date: 2020/7/28 9:11
     * @Description: 分页查询
     */
    @PostMapping("/selectAllRoleByPage")
    public ResultData selectAllRoleByPage(RoleVo roleVo) {
        ResultData resultData = roleService.selectAllRoleByPage(roleVo);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode())
                ? resultData : super.selectOperationFailed();
    }

}
