package com.aaa.lee.mapper;

import com.aaa.lee.model.Technicist;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Lee ShiHao
 * @date : 2020/7/18 9:17
 * Description:
**/
public interface TechnicistMapper extends Mapper<Technicist> {
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:17
     * Description: 条件分页查询所有用户
    **/
    List<HashMap> selectTechnicistAll(HashMap map);
}