package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
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
 * @Author: Lee ShiHao
 * @date : 2020/7/19 11:34
 * Description: 部门业务
**/
@Service
public class DeptService extends BaseService<Dept> {
    @Autowired
    private DeptMapper deptMapper;
    private ResultData resultData = new ResultData<>();

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 11:34
     * Description: 新增部门
    **/
    public ResultData addDept(Dept dept) {
        //设置创建时间
        dept.setCreateTime(new Date());
        Integer add = super.add(dept);
        if (add > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 11:34
     * Description: 批量删除部门
    **/
    public ResultData delDept(List<Integer> ids) {
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 11:34
     * Description: 根据主键修改部门信息
    **/
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
            resultMap.put("code",UPDATE_SUCCESS .getCode());
            resultMap.put("msg", UPDATE_SUCCESS.getMsg());
        } else {
            resultMap.put("code", UPDATE_FAILED.getCode());
            resultMap.put("msg",UPDATE_FAILED .getMsg());
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
            reultMap.put("code", SELECT_SUCCESS.getCode());
            reultMap.put("msg", SELECT_SUCCESS.getMsg());
        } else {
            reultMap.put("code",SELECT_FAILED .getCode());
            reultMap.put("msg", SELECT_FAILED.getMsg());
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
            resultMap.put("code",SELECT_SUCCESS .getCode());
            resultMap.put("msg", SELECT_SUCCESS.getMsg());
            resultMap.put("data", depts);
        } else {
            resultMap.put("code", SELECT_FAILED.getCode());
            resultMap.put("msg",SELECT_FAILED .getMsg());
        }
        return resultMap;
    }

}
