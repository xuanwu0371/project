package com.aaa.lee.mapper;

import com.aaa.lee.model.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface DeptMapper extends Mapper<Dept> {

    /**
     * @author luyu
     * @date 2020/7/17 10:39
     * Description:通过条件查询部门信息
     */
    List<Dept> selectDeptByNameOrTime(Dept dept);
}