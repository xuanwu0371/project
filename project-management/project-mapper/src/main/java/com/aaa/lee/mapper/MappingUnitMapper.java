package com.aaa.lee.mapper;

import com.aaa.lee.model.MappingUnit;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface MappingUnitMapper extends Mapper<MappingUnit> {
    /**
     * @author yang
     * @date 2020/7/18 11:07
     *Description
     * 条件查询测绘单位信息
     */
    List<HashMap> selectMappingUnitAll(HashMap map);
}