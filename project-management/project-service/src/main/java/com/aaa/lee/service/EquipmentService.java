package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.EquipmentMapper;
import com.aaa.lee.model.Equipment;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author Yang
 * @date 2020-07-17 15:25
 */
@Service
public class EquipmentService extends BaseService<Equipment> {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * @author yang
     * @date 2020/7/17 15:27
     *Description
     *  新增仪器设备信息
     */
    public Map<String,Object> insertEquipment(Equipment equipment){
        Map<String,Object> resultMap = new HashMap<>();
        int i = equipmentMapper.insert(equipment);
        if (i > 0 ){
            resultMap.put("code",INSERT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg",INSERT_OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code",INSERT_OPERATION_FAILED.getCode());
            resultMap.put("msg",INSERT_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author yang
     * @date 2020/7/17 15:32
     *Description
     * 通过id批量删除仪器设备信息
     */
    public Map<String ,Object> delEquipmentById(List<Long> ids){
        Map<String,Object> resultMap = new HashMap<>();
        //获取参数类型，添加一个where条件
        Example id = Example.builder(Equipment.class).where(Sqls.custom().andIn("id",ids)).build();
        int i = equipmentMapper.deleteByExample(id);
        if (i > 0){
            resultMap.put("code",DELETE_OPERATION_SUCCESS.getCode());
            resultMap.put("msg",DELETE_OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code",DELETE_OPERATION_FAILED.getCode());
            resultMap.put("msg",DELETE_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author yang
     * @date 2020/7/17 15:39
     *Description
     *      修改仪器设备信息
     */
    public Map<String ,Object> updateEquipment(Equipment equipment){
        Map<String, Object> resultMap = new HashMap<>();
        if (equipment != null) {
            int i = equipmentMapper.updateByPrimaryKey(equipment);
            if (i > 0 ) {
                resultMap.put("code",UPDATE_OPERATION_SUCCESS.getCode());
                resultMap.put("msg",UPDATE_OPERATION_SUCCESS.getMsg());
            } else {
                resultMap.put("code",UPDATE_OPERATION_FAILED.getCode());
                resultMap.put("msg",UPDATE_OPERATION_FAILED.getMsg());
            }
        } else {
            resultMap.put("code",FAILED.getCode());
            resultMap.put("msg",FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author yang
     * @date 2020/7/17 15:45
     *Description
     * 分页查询仪器设备信息
     */
    public Map<String,Object> selectAllEquipmentByPage(HashMap hashMap){
        Map<String, Object> resultMap = new HashMap<>();
        Equipment equipment = new Equipment();
        PageInfo<Equipment> equipmentPageInfo = super.selectListByPage(equipment, BaseUtil.transToInt(hashMap.get("pageNo")),BaseUtil.transToInt(hashMap.get("pageNumber")));
        if (null != equipmentPageInfo && equipmentPageInfo.getSize() > 0) {
            resultMap.put("code",SELECT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg",SELECT_OPERATION_SUCCESS.getMsg());
            resultMap.put("data",equipmentPageInfo);
        } else {
            resultMap.put("code",SELECT_OPERATION_FAILED.getCode());
            resultMap.put("msg",SELECT_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }
}