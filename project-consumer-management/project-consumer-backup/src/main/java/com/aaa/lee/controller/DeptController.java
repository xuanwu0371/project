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
     * @author luyu
     * @date 2020/7/17 17:17
     * Description:新增部门
     */
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept) {
        return iProjectService.addDept(dept);
    }

    /**
     * @author luyu
     * @date 2020/7/17 17:20
     * Description:删除部门
     */
    @PostMapping("/delDept")
    public ResultData delDept(@RequestBody List<Long> ids) {
        return iProjectService.delDept(ids);
    }

    /**
     * @author luyu
     * @date 2020/7/17 17:59
     * Description:修改部门
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept) {
        return iProjectService.updateDept(dept);
    }

    /**
     * @author luyu
     * @date 2020/7/17 18:03
     * Description:查询所有部门
     */
    @PostMapping("/selectAllDept")
    public ResultData selectAllDept(@RequestBody Dept dept) {
        return iProjectService.selectAllDept(dept);
    }

    /**
     * @author luyu
     * @date 2020/7/17 18:05
     * Description:根据条件查询部门
     */
    @PostMapping("/selectAllDeptByNameOrTime")
    public ResultData selectAllDeptByNameOrTime(@RequestBody Dept dept) {
        return iProjectService.selectAllDeptByNameOrTime(dept);
    }
}

