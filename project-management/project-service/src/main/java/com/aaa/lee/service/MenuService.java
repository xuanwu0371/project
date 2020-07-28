package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.MenuMapper;
import com.aaa.lee.mapper.RoleMenuMapper;
import com.aaa.lee.model.Menu;
import com.aaa.lee.model.Role;
import com.aaa.lee.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.aaa.lee.status.OperationStatus.*;


/**
 * create by: Lee ShiHao
 * create Time:  2020/7/16 10:18
 * description:
 */
@Service
public class MenuService extends BaseService<Menu> {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    private ResultData resultData = new ResultData();

    /**
     * @Description: 获取菜单信息
     * @Author: sgz
     * @Date: 2020/6/3 18:43
     * @Param: []
     * @return: java.util.List<com.aaa.qy108.model.Menu>
     */
    public List<Menu> selectAllMenus() {
        //菜单树
        List<Menu> menusList = new ArrayList<Menu>();
        //菜单的全部信息
        List<Menu> allMenusList = menuMapper.selectAll();
        if (null != allMenusList && allMenusList.size() > 0) {
            //拿到一级菜单信息
            for (int i = 0; i < allMenusList.size(); i++) {
                Menu menu = allMenusList.get(i);
                if (menu.getParentId() == 0) {
                    //说明是一级菜单
                    menusList.add(menu);
                }
            }
            //为一级菜单设置子菜单
            for (Menu menu : menusList) {
                menu.setSubMenu(getSubMenu(menu.getMenuId(), allMenusList));
            }
        }
        return menusList;
    }

    /**
     * @Author: Sgz
     * @Time: 11:00 2020/7/23
     * @Params: [userId, roleService]
     * @Return: java.util.List
     * @Throws:
     * @Description: 通过userId 先拿到roleId  在通过循环roleId拿到menuId 从而拿到menuName
     */

    public List selectAllMenusByUserId(String id, RoleService roleService) {
        RoleMenu roleMenu = new RoleMenu();
        Menu menu = new Menu();
        // 第一步 判断userId是否存在
        if ("".equals(id) || id == null) {
            return null;
        } else {
            Long userId = Long.valueOf(id);
            List<Role> roleList = roleService.selectRoleIdByUserId(userId);
            // 第二步判断roleList是否含有数据 也就是说该用户是否有角色
            if (roleList != null && roleList.size() > 0) {
                // 第三步 当roleList 含有数据的时候 说明有角色 通过循环拿到roleIDD
                for (Role role : roleList) {
                    Long roleId = role.getRoleId();
                    // 把roleId 存放到roleMenu之中
                    roleMenu.setRoleId(roleId);
                    // 拿到roleMenu的数据
                    List<RoleMenu> roleMenus = roleMenuMapper.select(roleMenu);
                    // 判断roleMenu是是否有数据
                    if (roleMenus.size() > 0) {
                        // 当roleMenus有数据的时候 通过循环拿到menuId
                        for (RoleMenu roleMenu1 : roleMenus) {
                            roleMenu1.getMenuId();
                            List<Menu> menuList = menuMapper.select(menu);
                            if (menuList.size() > 0) {
                                return menuList;
                            }

                        }
                    }

                }
            }
        }
        return null;

    }

    /**
     * @Description: 获取上一级菜单的子菜单
     * @Author: sgz
     * @Date: 2020/6/3 18:43
     * @Param: [menuId, allMenus]
     * @return: java.util.List<com.aaa.qy108.model.Menu>
     */
    private List<Menu> getSubMenu(Long menuId, List<Menu> allMenus) {
        //子菜单
        List<Menu> subMenus = new ArrayList<Menu>();
        for (Menu menu :
                allMenus) {
            if (menu.getParentId().equals(menuId)) {
                subMenus.add(menu);
            }
        }
        //子菜单的下一级
        //疑问：当递归进入，查找子菜单的子菜单，那么子菜单的数据现在在哪，是在下面循环代码中的subMenus中
        for (Menu menu :
                subMenus) {
            menu.setSubMenu(getSubMenu(menu.getMenuId(), allMenus));
        }
        if (subMenus.size() == 0) {
            return null;
        }
        return subMenus;
    }

    /**
     * @Description: 新增菜单或者按钮
     * @Author: sgz
     * @Date: 2020/6/3 18:43
     * @Param: [menu]
     * @return: java.lang.Boolean
     */
    public Boolean insertMenuOrButton(Menu menu) {

        menu.setCreateTime(new Date());
        try {
            Integer add = super.add(menu);
            if (add > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @Description: 根据主键修改菜单或者按钮的信息
     * @Author: sgz
     * @Date: 2020/6/3 18:42
     * @Param: [menu]
     * @return: java.lang.Boolean
     */
    public Boolean updateMenuOrButton(Menu menu) {

        menu.setModifyTime(new Date());
        try {
            Integer update = super.update(menu);
            if (update > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * @Description: 通过主键id删除菜单或者按钮
     * @Author: sgz
     * @Date: 2020/6/3 18:42
     * @Param: [menuId]
     * @return: java.lang.Boolean
     */
    public Boolean deleteMenuOrButton(Long menuId) {
        int i = menuMapper.deleteByPrimaryKey(menuId);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }


}

