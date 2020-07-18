package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Technicist;
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
 * create Time:  2020/7/18 8:27
 * description:
 */
@RestController
@RequestMapping("/technicist")
public class TechnicistController extends BaseController {
    @Autowired
    private IProjectService iProjectService;


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:37
     * Description:新增技术员
     **/
    @PostMapping("/addTechnicist")
    ResultData addTechnicist(@RequestBody Technicist technicist) {
        return iProjectService.addTechnicist(technicist);
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:25
     * Description: 批量删除技术员
     **/
    @PostMapping("/delTechnicist")
    ResultData delTechnicist(@RequestBody List<Long> ids){
        return iProjectService.delTechnicist(ids);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:38
     * Description: 修改技术员信息
    **/
    @PostMapping("/updateTechnicist")
    ResultData updateTechnicist(@RequestBody Technicist technicist){
        return iProjectService.updateTechnicist(technicist);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:27
     * Description: 查询技术员信息
     **/
    //todo 没有加@RequestBody
    @PostMapping("/selectAllTechnicist")
    ResultData selectAllTechnicist(Technicist technicist){
        return iProjectService.selectAllTechnicist();
    }


}
