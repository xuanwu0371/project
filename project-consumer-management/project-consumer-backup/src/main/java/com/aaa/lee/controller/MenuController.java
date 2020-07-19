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
     * @date : 2020/7/19 15:28
     * Description: 增加菜单
    **/
    @PostMapping("/insertMenuOrButton")
    public ResultData insertMenuOrButton(@RequestBody Menu menu){
        return iProjectService.insertMenuOrButton(menu);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:28
     * Description: 删除菜单
    **/
    @PostMapping("/deleteMenuOrButton")
    public ResultData deleteMenuOrButton(@RequestParam("menuId") Long menuId){
        return iProjectService.deleteMenuOrButton(menuId);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:28
     * Description: 更新菜单
    **/
    @PostMapping("/updateMenuOrButton")
    public ResultData updateMenuOrButton(@RequestBody Menu menu){
        return iProjectService.updateMenuOrButton(menu);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:29
     * Description: 查询菜单
    **/
    @PostMapping("/selectAllMenus")
    public ResultData selectAllMenus(){
        return iProjectService.selectAllMenus();
    }


}
