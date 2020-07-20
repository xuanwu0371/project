package com.aaa.lee.mapper;

import com.aaa.lee.model.Audit;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface AuditMapper extends Mapper<Audit> {
    /**
     * @author luyu
     * @date 2020/7/18 9:48
     * Description:条件分页查询所有审核
     */
    List<HashMap> selectAuditPageInfo(HashMap map);

}