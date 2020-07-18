package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.MappingUnit;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author Yang
 * @date 2020-07-18 11:25
 */
@RestController
@RequestMapping("/mappingUnit")
public class MappingUnitController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @author yang
     * @date 2020/7/18 11:26
     *Description
     * 新增测绘单位信息
     */
    @PatchMapping("/addMappingUnit")
    ResultData addMappingUnit(@RequestBody MappingUnit mappingUnit){
        return iProjectService.addMappingUnit(mappingUnit);
    }

    /**
     * @author yang
     * @date 2020/7/18 11:28
     *Description
     * 批量删除测绘单位信息
     */
    @PatchMapping("/delMappingUnit")
    ResultData delMappingUnit(@RequestBody List<Long> ids){
        return iProjectService.delMappingUnit(ids);
    }

    /**
     * @author yang
     * @date 2020/7/18 11:29
     *Description
     * 修改测绘单位信息
     */
    @PatchMapping("/updateMappingUnit")
    ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit){
        return iProjectService.updateMappingUnit(mappingUnit);
    }

    /**
     * @author yang
     * @date 2020/7/18 11:30
     *Description
     * 查询测绘单位信息
     */
    @PatchMapping("/selecrMappingUnitAll")
    ResultData seleceMappingUnitAll(MappingUnit mappingUnit){
        return iProjectService.selectMappingUnitAll(mappingUnit);
    }

    /**
     * @author yang
     * @date 2020/7/18 11:32
     *Description
     * 条件查询测绘单位信息
     */
    @PatchMapping("/selectMappingUnit")
    ResultData selectMappingUnti(@RequestBody HashMap map){
        return iProjectService.selectMappingUnit(map);
    }
}
