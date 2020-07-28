package com.aaa.lee.mapper;

import com.aaa.lee.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface MappingProjectMapper extends Mapper<MappingProject> {
    /**
     * @author yang
     * @date 2020/7/18 10:41
     *Description
     * 条件查询测绘项目
     */
    List<HashMap> selectMappingProjectAll(HashMap map);
    /**
     * @author : yang
     * @date : 2020/7/27 21:08
     *Description :获取最后一个id
     */
    Long getLastId( );
}