package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Menu;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * create by: LiShiHao
 * create Time:  2020/7/17 8:50
 * description:
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private IProjectService iProjectService;


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 8:51
     * Description: 查询所有菜单
     **/
    @PostMapping("/getMenus")
    public ResultData selectAllMenus() {
        return iProjectService.selectAllMenus();
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 9:00
     * Description: 在菜单管理中新增菜单或者是按钮
     **/
    @PostMapping("/insertMenuOrButton")
    public ResultData insertMenuOrButton(@RequestBody Menu menu) {
        return iProjectService.insertMenuOrButton(menu);
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 9:00
     * Description: 在菜单管理中修改菜单或者按钮
     **/
    @PostMapping("/updateMenuOrButton")
    public ResultData updateMenuOrButton(@RequestBody Menu menu) {
        return iProjectService.updateMenuOrButton(menu);
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 9:01
     * Description: 删除按钮或者菜单
     **/
    @PostMapping("/deleteMenuOrButton")
    public ResultData deleteMenuOrButton(@RequestParam("menuId") Long menuId) {
        return iProjectService.deleteMenuOrButton(menuId);
    }
}
