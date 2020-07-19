package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.DeptMapper;
import com.aaa.lee.model.Dept;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public ResultData delDeptById(List<Integer> ids) {
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
    public ResultData updateDeptById(Dept dept) {
        Map<String, Object> resultMap = new HashMap<>();
        //设置修改时间
        dept.setModifyTime(new Date());
        //获取当前部门的信息
        Integer update = super.update(dept);
        if (update > 0) {
            resultData.setCode(UPDATE_SUCCESS.getCode())
                    .setMsg(UPDATE_SUCCESS.getMsg());

        } else {
            resultData.setCode(UPDATE_FAILED.getCode())
                    .setMsg(UPDATE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:05
     * Description: 查询所有部门
    **/
    public ResultData selectAllDept(Dept dept) {
        List<Dept> list = super.selectList(dept);
        if (list.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(list);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:17
     * Description: 根据条件分页查询部门
    **/
    public ResultData SelDeptByPageAndFiled(Integer pageNumber,Integer pageSize,Sqls where, String orderFiled, String... fileds ){
        PageInfo<Dept> deptPageInfo = super.selectListByPageAndFiled(pageNumber, pageSize, where, orderFiled, fileds);
        if (deptPageInfo.equals("")){
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(deptPageInfo);
        }else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }
}
