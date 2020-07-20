package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Equipment;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/19 17:12
 * Description:设备模块
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController extends CommonController<Equipment> {
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private RedisService redisService;

    @Override
    public BaseService<Equipment> getBaseService() {
        return null;
    }

    /**
     * @Author: luyu
     * @date : 2020/7/16 11:17
     * Description: 新增设备
     **/
    @PostMapping("/addEquipment")
    public ResultData addEquipment(@RequestBody Equipment equipment) {
        ResultData resultData = equipmentService.addEquipment(equipment);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }


    /**
     * @Author: luyu
     * @date : 2020/7/18 20:44
     * Description: 根据id批量删除设备
     **/
    @PostMapping("/delEquipmentByIds")
    public ResultData delEquipmentByIds(@RequestBody Integer[] ids) {
        ResultData resultData = super.batchDelete(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();

    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 9:53
     * Description: 根据主键(id)修改设备信息
     **/
    @PostMapping("/updateEquipmentById")
    public ResultData updateEquipmentById(Equipment equipment) {
        ResultData resultData = equipmentService.updateEquipmentById(equipment);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @Author: luyu
     * @date : 2020/7/18 21:03
     * Description: 查询所有设备
     **/
    @PostMapping("/selEquipment")
    public ResultData selEquipment(Equipment equipment) {
        ResultData resultData = equipmentService.selEquipment(equipment);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 9:57
     * Description: 分页查询设备
     **/
    @PostMapping("/selEquipmentByPage")
    public ResultData selEquipmentByPage(Equipment equipment, Integer pageNumber, Integer pageSize) {
        ResultData resultData = equipmentService.selEquipmentByPage(equipment, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 10:13
     * Description: 根据条件分页查询设备
     **/
    @PostMapping("/selEquipmentByPageFiled")
    public ResultData selEquipmentByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        ResultData resultData = equipmentService.selEquipmentByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
}
