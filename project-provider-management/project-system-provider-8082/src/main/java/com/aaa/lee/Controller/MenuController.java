package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Menu;
import com.aaa.lee.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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

    @Override
    public BaseService<Menu> getBaseService() {
        return null;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:12
     * Description: 在菜单管理中新增菜单或者是按钮
     **/
    @PostMapping("/insertMenuOrButton")
    public ResultData insertMenuOrButton(@RequestBody Menu menu){
        ResultData resultData = menuService.insertMenuOrButton(menu);
        return resultData.getCode().equals(INSERT_SUCCESS.getCode()) ?
                resultData : super.insertOperationFailed();
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 16:11
     * Description: 删除按钮或者菜单
     **/
    @PostMapping("/deleteMenuOrButton")
    public ResultData deleteMenuOrButton(@RequestParam("menuId") Long menuId){
        ResultData resultData = menuService.deleteMenuOrButton(menuId);
        return resultData.getCode().equals(DELETE_SUCCESS.getCode()) ?
                resultData : super.deleteOperationFailed();
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 16:08
     * Description: 在菜单管理中修改菜单或者按钮
     **/
    @PostMapping("/updateMenuOrButton")
    public ResultData updateMenuOrButton(@RequestBody Menu menu){
        ResultData resultData = menuService.updateMenuOrButton(menu);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:11
     * Description: 查询所有菜单
    **/
    @PostMapping("/selectAllMenus")
    public ResultData selectAllMenus(){
        ResultData resultData = menuService.selectAllMenus();
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();

    }



}
