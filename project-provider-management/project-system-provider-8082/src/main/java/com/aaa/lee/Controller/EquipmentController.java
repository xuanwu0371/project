package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Equipment;
import com.aaa.lee.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author Yang
 * @date 2020-07-17 16:00
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController extends CommonController<Equipment> {
    @Autowired
    private EquipmentService equipmentService;
    @Override
    public BaseService<Equipment> getBaseService() {
        return null;
    }

    /**
     * @author yang
     * @date 2020/7/17 16:03
     *Description
     *       新增仪器设备信息
     */
    @PostMapping("/insertEquipment")
    public ResultData insertEquipment(@RequestBody Equipment equipment){
        Map<String,Object> insertEquipment = equipmentService.insertEquipment(equipment);
        if (insertEquipment.get("msg").equals(INSERT_SUCCESS.getMsg())) {
            return super.operationSuccess();
        } else {
            return super.operationFailed();
        }
    }

    /**
     * @author yang
     * @date 2020/7/17 16:20
     *Description
     * 通过id批量删除仪器设备信息
     */
    @PostMapping("/delEquipment")
    public ResultData delEquipmentById(@RequestBody List<Long> ids){
        Map<String,Object> delEquipment = equipmentService.delEquipmentById(ids);
        if (delEquipment.get("msg").equals(DELETE_SUCCESS.getMsg())) {
            return super.operationSuccess();
        } else {
            return super.operationFailed();
        }
    }
    /**
     * @author yang
     * @date 2020/7/17 16:37
     *Description
     * 修改仪器设备信息
     */
    @PostMapping("/updateEquipment")
    public ResultData updateEquipment(@RequestBody Equipment equipment){
        Map<String,Object> updateEquipment = equipmentService.updateEquipment(equipment);
        if (updateEquipment.get("msg").equals(UPDATE_SUCCESS.getCode())){
            return super.operationSuccess();
        } else {
            return super.operationFailed();
        }
    }

    /**
     * @author yang
     * @date 2020/7/17 16:41
     *Description
     * 分页查询仪器设备信息
     */
    @PostMapping("/selectAllEquipmentByPage")
    public ResultData selectAllEquipmentByPage(@RequestBody HashMap hashMap){
        Map<String,Object> AllEquipment = equipmentService.selectAllEquipmentByPage(hashMap);
        if (AllEquipment.get("msg").equals(SELECT_SUCCESS.getMsg())){
            return super.operationSuccess();
        } else {
            return super.operationFailed();
        }
    }
}
