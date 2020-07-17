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
        return null;
    }

    /**
     * @author luyu
     * @date 2020/7/17 15:42
     * Description:增加部门
     */
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept) {
        Map<String, Object> addDept = deptService.addDept(dept);
        if (INSERT_OPERATION_SUCCESS.getCode().equals(addDept.get("code"))) {
            return super.insertOperationSuccess();
        }
        return super.insertOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/17 16:02
     * Description:批量删除部门
     */
    @PostMapping("/delDept")
    public ResultData delDept(@RequestBody List<Long> ids) {
        Map<String, Object> resultMap = deptService.delDept(ids);
        if (DELETE_OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.deleteOperationSuccess();
        }
        return super.deleteOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/17 16:22
     * Description:修改部门
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept) {
        Map<String, Object> resultMap = deptService.updateDept(dept);
        if (UPDATE_OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.updateOperationSuccess();
        }
        return super.updateOperationFailed();

    }

    /**
     * @author luyu
     * @date 2020/7/17 16:42
     * Description:查询所有部门信息
     */
    @PostMapping("/selectAllDept")
    public ResultData selectAllDept(@RequestBody Dept dept) {
        Map<String, Object> resultMap = deptService.selectAllDept(dept);
        if (SELECT_OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.selectOperationSuccess();
        }
        return super.selectOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/17 16:50
     * Description:根据条件查询部门信息
     */
    @PostMapping("/selectAllDeptByNameOrTime")
    public ResultData selectAllDeptByNameOrTime(@RequestBody Dept dept) {
        Map<String, Object> resultMap = deptService.selectAllDeptByNameOrTime(dept);
        if (SELECT_OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.selectOperationSuccess();
        }
        return super.selectOperationFailed();
    }

}
