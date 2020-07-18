package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Equipment;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author Yang
 * @date 2020-07-17 17:03
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * @author yang
     * @date 2020/7/17 17:04
     *Description
     * 新增仪器设备信息
     */
    @PostMapping("/addEquipment")
    public ResultData addEquipment(@RequestBody Equipment equipment){
        return iProjectService.insertEquipment(equipment);
    }

    /**
     * @author yang
     * @date 2020/7/17 17:09
     *Description
     * 删除仪器设备信息
     */
    @PostMapping("/delEquipment")
    public ResultData delEquipment(@RequestBody List<Long> ids){
        return iProjectService.delEquipmentById(ids);
    }

    /**
     * @author yang
     * @date 2020/7/17 17:11
     *Description
     *       修改仪器设备信息
     */
    @PostMapping("/updateEquipment")
    public ResultData updateEquipment(@RequestBody Equipment equipment){
        return iProjectService.updateEquipment(equipment);
    }

    /**
     * @author yang
     * @date 2020/7/17 17:12
     *Description
     * 查询仪器设备信息
     */
    @PostMapping("/selectAllEquipment")
    public ResultData selectAllEquipment(@RequestBody Equipment equipment){
        return iProjectService.selectAllEquipmentByPage(equipment);
    }
}
