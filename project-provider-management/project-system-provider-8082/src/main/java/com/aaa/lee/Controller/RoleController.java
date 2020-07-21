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
        return null;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:35
     * Description: 新增角色以及批量新增权限
     **/
    @PostMapping("/insertRole")
    public ResultData insertRole( RoleVo roleVo) {
        ResultData resultData = roleService.insertRole(roleVo);
        return resultData.getCode().equals(INSERT_SUCCESS.getCode()) ?
                resultData : super.insertOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:31
     * Description: 删除角色
     **/
    @PostMapping("/deleteRole")
    public ResultData deleteRole( Long roleId) {
        ResultData resultData = roleService.deleteRole(roleId);
        return resultData.getCode().equals(DELETE_SUCCESS.getCode()) ?
                resultData : super.deleteOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:38
     * Description: 修改角色及权限
     **/
    @PostMapping("/updateRole")
    public ResultData updateRole( RoleVo roleVo) {
        ResultData resultData = roleService.updateRole(roleVo);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:23
     * Description: 查询所有的角色,分页
     **/
    @PostMapping("/selRoleByPage")
    public ResultData selRoleByPage(Role role, Integer pageNumber, Integer pageSize) {
        ResultData resultData = roleService.selRoleByPage(role, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:27
     * Description: 简单的分页查询
     **/
    @PostMapping("/selRoleByPageByFiled")
    public ResultData selRoleByPageByFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        ResultData resultData = roleService.selRoleByPageByFiled(pageNo, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();

    }
}
