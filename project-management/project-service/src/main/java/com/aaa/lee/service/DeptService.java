package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.DeptMapper;
import com.aaa.lee.model.Dept;
import com.aaa.lee.utils.DateUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/17 9:04
 * Description
 * 部门业务
 */
@Service
public class DeptService extends BaseService<Dept> {
    @Autowired
    private DeptMapper deptMapper;

    /**
     * @author luyu
     * @date 2020/7/17 9:04
     * Description
     * 新增部门
     */
    public Map<String, Object> addDept(Dept dept) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //设置创建时间
        dept.setCreateTime(new Date());
        int addResult = deptMapper.insert(dept);
        if (addResult > 0) {
            resultMap.put("code", INSERT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", INSERT_OPERATION_FAILED.getMsg());
        } else {
            resultMap.put("code", INSERT_OPERATION_FAILED.getCode());
            resultMap.put("msg", INSERT_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author luyu
     * @date 2020/7/17 9:18
     * Description:批量删除部门
     */
    public Map<String, Object> delDept(List<Long> ids) {
        Map<String, Object> resultMap = new HashMap<>();
        //获取到参数类型，然后添加一个where条件，是in类型，id属于ids中的
        Example example = Example.builder(Dept.class).where(Sqls.custom().andIn("deptId", ids)).build();
        int delsultmap = deptMapper.deleteByExample(example);
        if (delsultmap > 0) {
            resultMap.put("code", INSERT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", INSERT_OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code", INSERT_OPERATION_FAILED.getCode());
            resultMap.put("msg", INSERT_OPERATION_FAILED.getMsg());
        }

        return resultMap;
    }

    /**
     * @author luyu
     * @date 2020/7/17 11:02
     * Description:修改部门信息
     */
    public Map<String, Object> updateDept(Dept dept) {
        Map<String, Object> resultMap = new HashMap<>();
        //设置修改时间
        dept.setModifyTime(new Date());
        //获取当前部门的信息
        Dept dept1 = deptMapper.selectByPrimaryKey(dept);
        if (dept1 != null) {
            dept.setCreateTime(dept1.getCreateTime());
        }
        int updateResult = deptMapper.updateByPrimaryKey(dept);
        if (updateResult > 0) {
            resultMap.put("code", UPDATE_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", UPDATE_OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code", UPDATE_OPERATION_FAILED.getCode());
            resultMap.put("msg", UPDATE_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author luyu
     * @date 2020/7/17 9:24
     * Description:查询所有部门
     */
    public Map<String, Object> selectAllDept(Dept dept) {
        Map<String, Object> reultMap = new HashMap<>();
        List<Dept> list = deptMapper.selectAll();
        if (list.size() > 0) {
            reultMap.put("code", SELECT_OPERATION_SUCCESS.getCode());
            reultMap.put("msg", SELECT_OPERATION_SUCCESS.getMsg());
        } else {
            reultMap.put("code", SELECT_OPERATION_FAILED.getCode());
            reultMap.put("msg", SELECT_OPERATION_FAILED.getMsg());
        }
        return reultMap;
    }

    /**
     * @author luyu
     * @date 2020/7/17 10:02
     * Description:根据条件查询部门信息
     */
    public Map<String, Object> selectAllDeptByNameOrTime(Dept dept) {
        Map<String, Object> resultMap = new HashMap<>();
        //根据条件查询部门信息
        List<Dept> depts = deptMapper.selectDeptByNameOrTime(dept);
        if (depts.size() > 0 && depts != null) {
            resultMap.put("code", SELECT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", SELECT_OPERATION_SUCCESS.getMsg());
            resultMap.put("data", depts);
        } else {
            resultMap.put("code", SELECT_OPERATION_FAILED.getCode());
            resultMap.put("msg", SELECT_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

}
