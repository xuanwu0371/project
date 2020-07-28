package com.aaa.lee.mapper;

import com.aaa.lee.model.CheckPerson;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CheckPersonMapper extends Mapper<CheckPerson> {

    /**
     * @author : yang
     * @date : 2020/7/21 16:59
     *Description :根据抽查比例查询抽查人员信息
     */
    List<Map> selCheckPersonProportion(Integer proportion);
}