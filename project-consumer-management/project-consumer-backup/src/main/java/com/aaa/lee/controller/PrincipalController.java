package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Principal;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * create by: LiShiHao
 * create Time:  2020/7/17 22:37
 * description:
 */
@RestController
@RequestMapping("/principal")
public class PrincipalController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 新增重要人
     **/
    @PostMapping("/addPrincipal")
    ResultData addPrincipal(@RequestBody Principal principal){
        return iProjectService.addPrincipal(principal);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 批量删除重要人
     **/
    @PostMapping("/delPrincipal")
    ResultData delPrincipal(@RequestBody List<Long> ids){
        return iProjectService.delPrincipal(ids);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 修改重要人信息
     **/
    @PostMapping("/updatePrincipal")
    ResultData updatePrincipal(@RequestBody Principal principal){
        return iProjectService.updatePrincipal(principal);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:08
     * Description: 查询重要人信息
     **/
    @PostMapping("/selectPrincipalAll")
    ResultData selectPrincipalAll(Principal principal){
        return iProjectService.updatePrincipal(principal);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:09
     * Description: 带条件查询重要人信息
     **/
    @PostMapping("/selectPrincipal")
    ResultData selectPrincipal(@RequestBody HashMap map){
        return iProjectService.selectPrincipal(map);
    }
}
