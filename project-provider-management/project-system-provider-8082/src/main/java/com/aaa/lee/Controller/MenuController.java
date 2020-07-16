package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Menu;
import com.aaa.lee.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * create by: LiShiHao
 * create Time:  2020/7/16 10:17
 * description:
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:11
     * Description: 查询所有菜单
    **/
    @GetMapping("/getMenus")
    public List<Menu> selectAllMenus(){
        return menuService.selectAllMenus();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:12
     * Description: 在菜单管理中新增菜单或者是按钮
    **/
    @PostMapping("/insertMenuOrButton")
    public ResultData<Menu> insertMenuOrButton(@RequestBody Menu menu){
        Map<String, Object> stringObjectMap = menuService.insertMenuOrButton(menu);
        if ()
    }










}
