package com.aaa.lee.mapper;

import com.aaa.lee.model.Equipment;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface EquipmentMapper extends Mapper<Equipment> {
    /**
     * @author yang
     * @date 2020/7/18 10:42
     *Description
     * 条件查询仪器设备
     */
    List<HashMap> selectEquipmentAll(HashMap map);
}