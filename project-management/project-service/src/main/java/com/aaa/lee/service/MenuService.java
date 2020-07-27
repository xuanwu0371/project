package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.MenuMapper;
import com.aaa.lee.model.Menu;
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
    private ResultData resultData = new ResultData();

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 10:34
     * Description: 新增菜单或者按钮
     **/
    public ResultData insertMenuOrButton(Menu menu) {

        Date createTime = new Date();
        menu.setCreateTime(createTime);
        try {
            Integer add = super.add(menu);
            if (add > 0) {
                resultData.setCode(INSERT_SUCCESS.getCode())
                        .setMsg(INSERT_SUCCESS.getMsg());
            } else {
                resultData.setCode(INSERT_FAILED.getCode())
                        .setMsg(INSERT_FAILED.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 10:42
     * Description: 根据主键id删除菜单或者按钮
     **/
    public ResultData deleteMenuOrButton(Long menuId) {

        int Result = menuMapper.deleteByPrimaryKey(menuId);
        if (Result > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode())
                    .setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode())
                    .setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 10:39
     * Description: 根据主键修改菜单或者按钮的信息
     **/
    public ResultData updateMenuOrButton(Menu menu) {
        Date date = new Date();
        menu.setModifyTime(date);
        try {
            Integer update = super.update(menu);
            if (update > 0) {
                resultData.setCode(UPDATE_SUCCESS.getCode())
                        .setMsg(UPDATE_SUCCESS.getMsg());


            } else {
                resultData.setCode(UPDATE_FAILED.getCode())
                        .setMsg(UPDATE_FAILED.getMsg());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultData;
    }

    /**
     * @Author: LiShiHao
     * @date : 2020/7/16 10:19
     * Description: 获取菜单信息
     **/
    public ResultData selectAllMenus() {
        //菜单树
        List<Menu> menuList = new ArrayList<>();
        //菜单的全部信息
        List<Menu> menuListAll = menuMapper.selectAll();
        if (null != menuListAll && menuListAll.size() > 0) {
            //拿到一级菜单信息
            for (int i = 0; i < menuListAll.size(); i++) {
                Menu menu = menuListAll.get(i);
                if (menu.getParentId() == 0) {
                    //说明是一级菜单
                    menuList.add(menu);
                }
            }
            //为一级菜单设置子菜单
            for (Menu menu : menuList) {
                menu.setSubMenu(getSubMenu(menu.getMenuId(), menuListAll));
            }
            resultData.setData(menuList);
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 10:29
     * Description: 获取上一级菜单的子菜单
     **/
    private List<Menu> getSubMenu(Long menuId, List<Menu> allMenus) {
        //子菜单
        List<Menu> subMenus = new ArrayList<Menu>();
        for (Menu menu : allMenus) {
            if (menu.getParentId().equals(menuId)) {
                subMenus.add(menu);
            }
        }
        //子菜单的下一级
        //当递归进入,查找子菜单的子菜单,那么子菜单的数据在哪儿?
        for (Menu menu : subMenus) {
            menu.setSubMenu(getSubMenu(menu.getMenuId(), allMenus));
        }
        if (subMenus.size() > 0) {
            return null;
        }
        return subMenus;
    }


}

