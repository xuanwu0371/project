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
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

/**
 * @author luyu
 * @date 2020/7/19 17:20
 * Description:设备模块
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * @author luyu
     * @date 2020/7/19 17:20
     * Description:新增设备
     */
    @PostMapping("/addEquipment")
    ResultData addEquipment(@RequestBody Equipment equipment) {
        return iProjectService.addEquipment(equipment);
    }

    /**
     * @author luyu
     * @date 2020/7/19 17:20
     * Description:根据主键批量删除设备
     */
    @PostMapping("/delEquipmentByIds")
    ResultData delEquipmentByIds(@RequestBody Integer[] ids) {
        return iProjectService.delEquipmentByIds(ids);
    }

    /**
     * @author luyu
     * @date 2020/7/19 17:20
     * Description:根据主键id修改设备
     */
    @PostMapping("/updateEquipmentById")
    ResultData updateEquipmentById(Equipment equipment) {
        return iProjectService.updateEquipmentById(equipment);
    }

    /**
     * @author luyu
     * @date 2020/7/19 17:20
     * Description:查询所有设备
     */
    @PostMapping("/selEquipment")
    ResultData selEquipment(Equipment equipment) {
        return iProjectService.selEquipment(equipment);
    }

    /**
     * @author luyu
     * @date 2020/7/19 17:20
     * Description:分页查询设备信息
     */
    @PostMapping("/selEquipmentByPage")
    ResultData selEquipmentByPage(Equipment equipment, Integer pageNumber, Integer pageSize) {
        return iProjectService.selEquipmentByPage(equipment, pageNumber, pageSize);
    }

    /**
     * @author luyu
     * @date 2020/7/19 17:20
     * Description:根据条件分页查询设备信息
     */
    @PostMapping("/selEquipmentByPageFiled")
    ResultData selEquipmentByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return iProjectService.selEquipmentByPageFiled(number, pageSize, where, orderFiled, fileds);
    }
}
