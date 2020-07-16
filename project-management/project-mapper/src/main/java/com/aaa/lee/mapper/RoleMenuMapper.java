package com.aaa.lee.mapper;

import com.aaa.lee.model.RoleMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMenuMapper extends Mapper<RoleMenu> {
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 18:45
     * Description: 在Role表中根据roleId删除
    **/
    int deleteRoleMenu(Long roleId);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 18:45
     * Description: 批量新增
    **/
    int batchInsertRoleMenu(List<RoleMenu> roleMenus);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 18:40
     * Description: 查询表里有没有roleId
    **/
    List<RoleMenu> selectByRoleId(Long roleId);
}