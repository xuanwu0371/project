package com.aaa.lee.mapper;

import com.aaa.lee.model.News;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface NewsMapper extends Mapper<News> {
    /**
     * @author yang
     * @date 2020/7/16 19:24
     *Description
     * 分页条件查询
     */
    List<HashMap> selectNewsAll(HashMap map);
}