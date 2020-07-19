package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.RoleMapper;
import com.aaa.lee.mapper.RoleMenuMapper;
import com.aaa.lee.model.Role;
import com.aaa.lee.model.RoleMenu;
import com.aaa.lee.vo.RoleVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.*;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * create by: LiShiHao
 * create Time:  2020/7/16 18:16
 * description:角色权限
 */
@Service
public class RoleService extends BaseService<Role> {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    private ResultData resultData =new ResultData();
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 18:46
     * Description: 新增角色以及批量新增权限
     **/
    public ResultData insertRole(RoleVo roleVo) {
        Date date = new Date();
        roleVo.getRole().setCreateTime(date);
        int insert = roleMapper.insert(roleVo.getRole());
        if (insert > 0) {
            //说明新增成功了
            //那就开始加roleMenu
            //如果传过来的menuId是null 说明不添加了
            //如果传过来的不是空,说明需要添加roleMenu
            if (null != roleVo.getMenuId()) {
                //说明需要添加新的菜单权限
                List<RoleMenu> list = new ArrayList<RoleMenu>();
                for (long menuId : roleVo.getMenuId()) {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setMenuId(menuId);
                    roleMenu.setRoleId(roleVo.getRole().getRoleId());
                    list.add(roleMenu);
                }
                int i = roleMenuMapper.batchInsertRoleMenu(list);
                if (i > 0) {
                    //说明批量新增成功返回
                    return resultData.setCode(INSERT_SUCCESS.getCode())
                            .setMsg(INSERT_SUCCESS.getMsg());
                } else {
                    return resultData.setCode(INSERT_FAILED.getCode())
                            .setMsg(INSERT_FAILED.getMsg());
                }
            } else {
                //说明不添加权限,只是加一个角色 返回true
                return resultData.setCode(INSERT_SUCCESS.getCode())
                        .setMsg(INSERT_SUCCESS.getMsg());
            }

        }
        //新增失败直接false
        return resultData.setCode(INSERT_FAILED.getCode())
                .setMsg(INSERT_FAILED.getMsg());
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 18:37
     * Description: 删除角色
     **/
    public ResultData deleteRole(Long roleId) {
        int i = roleMapper.deleteByPrimaryKey(roleId);
        if (i > 0) {
            //说明删除成功
            //接下来要去把role_menu表中对应的数据删掉
            //先去查看有没有权限,没权限就全部删掉 没有就结束
            List<RoleMenu> list = roleMenuMapper.selectByRoleId(roleId);
            if (list.size() > 0) {
                //说明权限不是空的,需要删除
                int i1 = roleMenuMapper.deleteRoleMenu(roleId);
                if (list.size() > 0) {
                    //说明删除成功
                    return resultData.setCode(DELETE_SUCCESS.getCode())
                            .setMsg(DELETE_SUCCESS.getMsg());
                } else {
                    //删除失败
                    return resultData.setCode(DELETE_FAILED.getCode())
                            .setMsg(DELETE_FAILED.getMsg());
                }
            } else {
                //说明权限是空的,不要删除
                return resultData.setCode(DELETE_SUCCESS.getCode())
                        .setMsg(DELETE_SUCCESS.getMsg());
            }
        } else {
            //删除失败 直接false
            return resultData.setCode(DELETE_FAILED.getCode())
                    .setMsg(DELETE_FAILED.getMsg());
        }
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:01
     * Description: 修改角色及其权限
     **/
    public ResultData updateRole(RoleVo roleVo) {
        Date date = new Date();
        roleVo.getRole().setModifyTime(date);
        //1.去修改role表
        int i = roleMapper.updateByPrimaryKeySelective(roleVo.getRole());
        if (i > 0) {
            //1.说明role表修改成功
            //2.要继续去修改Role的Menu
            //3.如果没有修改权限表,不执行以下流程
            //4.修改就是先删除老的,再添加新的,不管是换新的权限还是去哪先全部取消,都先删除,(判断传过来的menuId是不是null)
            //5.如果之前没有权限就不能去删除权限, 直接新增就行
            //6.如果之前有权限,要撤销他的权限,就直接删除即可
            List<RoleMenu> list = roleMenuMapper.selectByRoleId(roleVo.getRole().getRoleId());
            boolean equals = list.equals(roleVo.getMenuId());
            if (equals) {
                //说明没有改动权限表,直接返回true
                return resultData.setCode(UPDATE_SUCCESS.getCode())
                        .setMsg(UPDATE_SUCCESS.getMsg());
            } else {
                //说明要改动权限表 先查他之前是否有权限
                List<RoleMenu> menus = roleMenuMapper.selectByRoleId(roleVo.getRole().getRoleId());
                if (menus.size() > 0) {
                    //说明以前是有权限的, 无论是要给他撤销全部的权限 还是要更改他的权限 都要全部删除
                    int i1 = roleMenuMapper.deleteRoleMenu(roleVo.getRole().getRoleId());
                    if (i1 > 0) {
                        //说明权限已经全部删除了 接下来判断是否要给他换上新的权限
                        //如果传进来了权限
                        if (roleVo.getMenuId().size() > 0) {
                            List<RoleMenu> arr = new ArrayList<RoleMenu>();
                            for (long mid : roleVo.getMenuId()) {
                                RoleMenu rm = new RoleMenu();
                                rm.setMenuId(mid);
                                rm.setRoleId(roleVo.getRole().getRoleId());
                                arr.add(rm);
                            }
                            int i2 = roleMenuMapper.batchInsertRoleMenu(arr);
                            if (i2 > 0) {
                                //说明修改彻底结束
                                return resultData.setCode(UPDATE_SUCCESS.getCode())
                                        .setMsg(UPDATE_SUCCESS.getMsg());
                            }
                        }
                    }
                    return resultData.setCode(UPDATE_FAILED.getCode())
                            .setMsg(UPDATE_FAILED.getMsg());
                }
            }
        }
        return resultData.setCode(UPDATE_FAILED.getCode())
                .setMsg(UPDATE_FAILED.getMsg());
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 18:28
     * Description: 查询所有角色,分页
     **/
    public ResultData selRoleByPage(Role role, Integer pageNumber, Integer pageSize) {
        PageInfo<Role> rolePageInfo = super.selectListByPage(role, pageNumber, pageSize);
        if (!rolePageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(rolePageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 11:12
     * Description: 条件查询分页
    **/
    public ResultData selRoleByPageByFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        PageInfo<Role> rolePageInfo = super.selectListByPageAndFiled(pageNo, pageSize, where, orderFiled, fileds);

        if (!rolePageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(rolePageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }





}








