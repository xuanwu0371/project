package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
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
public class MenuController extends CommonController<Menu> {
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
    public ResultData insertMenuOrButton(@RequestBody Menu menu){
        Map<String, Object> Result = menuService.insertMenuOrButton(menu);
        if (!Result.isEmpty()){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 16:08
     * Description: 在菜单管理中修改菜单或者按钮
    **/
    @PostMapping("/updateMenuOrButton")
    public ResultData updateMenuOrButton(@RequestBody Menu menu){
        Map<String, Object> Result = menuService.updateMenuOrButton(menu);
        if (!Result.isEmpty()){
            return super.updateOperationSuccess();
        }else {
            return super.operationFailed();
        }
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 16:11
     * Description: 删除按钮或者菜单
    **/
    @PostMapping("/deleteMenuOrButton")
    private ResultData deleteMenuOrButton(@RequestParam("menuId") Long menuId){
        Map<String, Object> Result = menuService.deleteMenuOrButton(menuId);
        if (!Result.isEmpty()){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }


    @Override
    public BaseService<Menu> getBaseService() {
        return null;
    }
}
