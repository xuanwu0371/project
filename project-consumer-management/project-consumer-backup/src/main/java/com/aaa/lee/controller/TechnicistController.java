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
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

/**
 * @author luyu
 * @date 2020/7/19 15:42
 * Description:技术人员模块
 */
@RestController
@RequestMapping("/technicist")
public class TechnicistController extends BaseController {
    @Autowired
    private IProjectService iProjectService;


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:37
     * Description:新增技术人员
     **/
    @PostMapping("/addTechnicist")
    ResultData addTechnicist(@RequestBody Technicist technicist) {
        return iProjectService.addTechnicist(technicist);
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:47
     * Description:删除技术人员
     */
    @PostMapping("/delTechnicistByIds")
    ResultData delTechnicist(@RequestBody Integer[] ids) {
        return iProjectService.delTechnicist(ids);
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:47
     * Description:根据id修改技术人员
     */
    @PostMapping("/updateTechnicistById")
    ResultData updateTechnicistById(@RequestBody Technicist technicist) {
        return iProjectService.updateTechnicistById(technicist);
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:47
     * Description:查询全部技术人员
     */
    @PostMapping("/selTechnicist")
    ResultData selTechnicist(Technicist technicist) {
        return iProjectService.selTechnicist(technicist);
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:47
     * Description:分页查询所有技术人员
     */
    @PostMapping("/selTechnicistByPage")
    ResultData selTechnicistByPage(Technicist technicist, Integer pageNumber, Integer pageSize) {
        return iProjectService.selTechnicistByPage(technicist, pageNumber, pageSize);
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:47
     * Description:根据条件分页查询技术人员
     */
    @PostMapping("/selTechnicistByPageFiled")
    ResultData selTechnicistByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return iProjectService.selTechnicistByPageFiled(number, pageSize, where, orderFiled, fileds);
    }

}
