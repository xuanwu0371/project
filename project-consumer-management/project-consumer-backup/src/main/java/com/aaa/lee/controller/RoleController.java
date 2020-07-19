package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Role;
import com.aaa.lee.service.IProjectService;
import com.aaa.lee.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

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
     * @date : 2020/7/19 15:24
     * Description: 增加角色
     **/
    @PostMapping("/insertRole")
    public ResultData insertRole(RoleVo roleVo) {
        return iProjectService.insertRole(roleVo);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:24
     * Description: 删除角色
     **/
    @PostMapping("/deleteRole")
    public ResultData deleteRole(@RequestParam("roleId") Long roleId) {
        return iProjectService.deleteRole(roleId);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:25
     * Description: 更新角色
     **/
    @PostMapping("/updateRole")
    public ResultData updateRole(@RequestBody RoleVo roleVo) {
        return iProjectService.updateRole(roleVo);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:26
     * Description: 查询角色 分页
     **/
    @PostMapping("/selRoleByPage")
    public ResultData selRoleByPage(Role role, Integer pageNumber, Integer pageSize) {
        return iProjectService.selRoleByPage(role, pageNumber, pageSize);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:26
     * Description: 查询角色分页,根据字段
     **/
    @PostMapping("/selRoleByPageByFiled")
    public ResultData selRoleByPageByFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return iProjectService.selRoleByPageByFiled(pageNo, pageSize, where, orderFiled, fileds);
    }

}
