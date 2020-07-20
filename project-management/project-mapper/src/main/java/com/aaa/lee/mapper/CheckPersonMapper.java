package com.aaa.lee.mapper;

import com.aaa.lee.model.CheckPerson;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface CheckPersonMapper extends Mapper<CheckPerson> {
    /**
     * @author luyu
     * @date 2020/7/18 17:30
     * Description:条件分页查询所有监察人员
     */
    List<HashMap> selectCheckPersonPageInfo(HashMap map);
}