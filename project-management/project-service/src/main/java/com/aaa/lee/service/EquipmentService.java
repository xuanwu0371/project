package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.EquipmentMapper;
import com.aaa.lee.model.Equipment;
import com.aaa.lee.model.Equipment;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.staticproerties.TimeFormatProperties.TIME_FORMAT;
import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/19 17:07
 * Description:设备模块
 */
@Service
public class EquipmentService extends BaseService<Equipment> {

    @Autowired
    private EquipmentMapper equipmentMapper;

    private ResultData resultData = new ResultData();

    /**
     * @Author: luyu
     * @date : 2020/7/15 19:59
     * Description: 添加设备
     **/
    public ResultData addEquipment(Equipment equipment) {
        equipment.setCreateTime(new Date());
        int insert = super.add(equipment);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }


    /**
     * @Author: luyu
     * @date : 2020/7/18 20:05
     * Description: 根据id批量删除设备
     **/
    public ResultData delEquipmentByIds(List<Integer> ids) {
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: luyu
     * @date : 2020/7/18 20:24
     * Description: 根据主键(id)修改设备信息
     **/
    public ResultData updateEquipmentById(Equipment equipment) {
        Integer update = super.update(equipment);
        if (update > 0) {
            resultData.setCode(UPDATE_SUCCESS.getCode())
                    .setMsg(UPDATE_SUCCESS.getMsg());

        } else {
            resultData.setCode(UPDATE_FAILED.getCode())
                    .setMsg(UPDATE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: luyu
     * @date : 2020/7/18 18:22
     * Description: 查询所有设备
     **/
    public ResultData selEquipment(Equipment equipment) {
        List<Equipment> equipmentList = super.selectList(equipment);
        ResultData resultData = new ResultData();
        if (equipmentList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(equipmentList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 9:42
     * Description: 分页查询设备
     **/
    public ResultData selEquipmentByPage(Equipment equipment, Integer pageNumber, Integer pageSize) {
        PageInfo<Equipment> equipmentPageInfo = super.selectListByPage(equipment, pageNumber, pageSize);
        if (!equipmentPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(equipmentPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 10:00
     * Description: 根据条件分页查询设备
     **/
    public ResultData selEquipmentByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        PageInfo<Equipment> equipmentPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (equipmentPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(equipmentPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }
}