package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Menu;
import com.aaa.lee.service.MenuService;
import com.aaa.lee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.aaa.lee.status.OperationStatus.*;


/**
 * create by: LiShiHao
 * create Time:  2020/7/16 10:17
 * description:
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends CommonController<Menu> {
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    @Override
    public BaseService<Menu> getBaseService() {
        return null;
    }

    ResultData resultData = new ResultData();

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:12
     * Description: 在菜单管理中新增菜单或者是按钮
     **/
    @PostMapping("/insertMenuOrButton")
    public ResultData insertMenuOrButton(Menu menu) {
        Boolean aBoolean = menuService.insertMenuOrButton(menu);
        return aBoolean ?
                resultData.setCode(INSERT_SUCCESS.getCode())
                        .setMsg(INSERT_SUCCESS.getMsg())
                : super.insertOperationFailed();

    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 16:11
     * Description: 删除按钮或者菜单
     **/
    @PostMapping("/deleteMenuOrButton")
    public ResultData deleteMenuOrButton(Long menuId) {
        Boolean aBoolean = menuService.deleteMenuOrButton(menuId);
        return aBoolean ?
                resultData.setCode(DELETE_SUCCESS.getCode())
                        .setMsg(DELETE_SUCCESS.getMsg())
                : super.deleteOperationFailed();
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 16:08
     * Description: 在菜单管理中修改菜单或者按钮
     **/
    @PostMapping("/updateMenuOrButton")
    public ResultData updateMenuOrButton(@RequestBody Menu menu) {
        Boolean aBoolean = menuService.updateMenuOrButton(menu);
        return aBoolean ?
                resultData.setCode(UPDATE_SUCCESS.getCode())
                        .setMsg(UPDATE_SUCCESS.getMsg())
                : super.updateOperationFailed();
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:11
     * Description: 查询所有菜单
     **/
    @PostMapping("/selectAllMenus")
    public ResultData selectAllMenus() {
        List<Menu> menus = menuService.selectAllMenus();
        return menus.size() > 0
                ? resultData.setCode(SELECT_SUCCESS.getCode())
                .setMsg(SELECT_SUCCESS.getMsg())
                .setData(menus)
                : super.selectOperationFailed();

    }


}
