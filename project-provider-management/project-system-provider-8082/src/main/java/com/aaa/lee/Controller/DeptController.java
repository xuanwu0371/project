package com.aaa.lee.Controller;


import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Dept;
import com.aaa.lee.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

@RestController
@RequestMapping("/dept")
public class DeptController extends CommonController<Dept> {
    @Autowired
    private DeptService deptService;

    @Override
    public BaseService<Dept> getBaseService() {
        return deptService;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:24
     * Description: 增加部门
    **/
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept) {
        ResultData resultData = deptService.addDept(dept);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:20
     * Description: 根据id批量删除部门
    **/
    @PostMapping("/delDeptById")
    public ResultData delDeptById(@RequestBody List<Integer> ids) {
        ResultData resultData = deptService.delDeptById(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:24
     * Description: 修改部门
    **/
    @PostMapping("/updateDeptById")
    public ResultData updateDeptById(@RequestBody Dept dept) {
        ResultData resultData = deptService.updateDeptById(dept);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();

    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:24
     * Description: 查询所有部门信息
    **/
    @PostMapping("/selectAllDept")
    public ResultData selectAllDept(@RequestBody Dept dept) {
        ResultData resultData = deptService.selectAllDept(dept);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:25
     * Description: 根据条件查询部门信息
    **/
    @PostMapping("/SelDeptByPageFiled")
    public ResultData SelDeptByPageAndFiled(@RequestBody Integer pageNumber, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        ResultData resultData = deptService.SelDeptByPageAndFiled(pageNumber, pageSize, where, orderFiled, fileds);
        if (resultData.equals("")){
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(resultData);
        }else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

}
