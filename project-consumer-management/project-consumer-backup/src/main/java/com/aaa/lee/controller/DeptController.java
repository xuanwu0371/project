package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Dept;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @author luyu
 * @date 2020/7/17 17:17
 * Description:
 */
@RestController
@RequestMapping("/dept")
public class DeptController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:24
     * Description: 增加部门
     **/
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept) {
        return iProjectService.addDept(dept);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:20
     * Description: 根据id批量删除部门
     **/
    @PostMapping("/delDeptById")
    public ResultData delDeptById(@RequestBody List<Integer> ids) {
        return iProjectService.delDeptById(ids);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:24
     * Description: 修改部门
     **/
    @PostMapping("/updateDeptById")
    public ResultData updateDeptById(@RequestBody Dept dept) {
        return iProjectService.updateDeptById(dept);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:24
     * Description: 查询所有部门信息
     **/
    @PostMapping("/selectAllDept")
    public ResultData selectAllDept(@RequestBody Dept dept) {
        return iProjectService.selectAllDept(dept);
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:25
     * Description: 根据条件查询部门信息
     **/
    @PostMapping("/SelDeptByPageFiled")
    public ResultData SelDeptByPageAndFiled(@RequestBody Integer pageNumber, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return iProjectService.SelDeptByPageAndFiled(pageNumber, pageSize, where, orderFiled, fileds);
    }


}

