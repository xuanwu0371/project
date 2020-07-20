package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.MappingUnit;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

/**
 * @author luyu
 * @date 2020/7/19 14:27
 * Description:单位模块
 */
@RestController
@RequestMapping("/mappingUnit")
public class MappingUnitController extends BaseController {

    @Autowired
    private IProjectService iProjectService;
    /**
     * @author luyu
     * @date 2020/7/19 16:39
     * Description:新增、注册单位
     */
    @PostMapping("/addMappingUnit")
    ResultData addMappingUnit(@RequestBody MappingUnit mappingUnit){
        return iProjectService.addMappingUnit(mappingUnit);
    }
    /**
     * @author luyu
     * @date 2020/7/19 16:39
     * Description:通过id批量删除单位
     */
    @PostMapping("/delMappingUnitByIds")
    ResultData delMappingUnitByIds(@RequestBody Integer[] ids){
      return iProjectService.delMappingUnitByIds(ids);
    }
    /**
     * @author luyu
     * @date 2020/7/19 16:39
     * Description:通过主键id修改单位
     */
    @PostMapping("/updateMappingUnitById")
    ResultData updateMappingUnitById(MappingUnit mappingUnit){
        return iProjectService.updateMappingUnitById(mappingUnit);
    }
    /**
     * @author luyu
     * @date 2020/7/19 16:39
     * Description:查询全部单位信息
     */
    @PostMapping("/selMappingUnit")
    ResultData selMappingUnit(MappingUnit mappingUnit){
        return iProjectService.selMappingUnit(mappingUnit);
    }
    /**
     * @author luyu
     * @date 2020/7/19 16:39
     * Description:分页查询单位
     */
    @PostMapping("/selMappingUnitByPage")
    ResultData selMappingUnitByPage(MappingUnit mappingUnit,Integer pageNumber,Integer pageSize){
        return iProjectService.selMappingUnitByPage(mappingUnit,pageNumber,pageSize);
    }
    /**
     * @author luyu
     * @date 2020/7/19 16:40
     * Description:根据条件分页查询单位
     */
    @PostMapping("/selMappingUnitByPageFiled")
    ResultData selMappingUnitByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        return iProjectService.selTechnicistByPageFiled(number,pageSize,where,orderFiled,fileds);
    }
}
