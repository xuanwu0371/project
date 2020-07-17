package com.aaa.lee.mapper;

import com.aaa.lee.model.Principal;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface PrincipalMapper extends Mapper<Principal> {
    /**
     * @Author: LiShiHao
     * @date : 2020/7/16 9:55
     * Description: 条件分页查询所有重要人
     **/
    List<HashMap> selectPrincipalAll(HashMap map);
}