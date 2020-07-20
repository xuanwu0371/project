package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.MappingUnit;
import com.aaa.lee.model.MappingUnit;
import com.aaa.lee.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/19 16:33
 * Description:单位模块
 */
@RestController
@RequestMapping("/mappingUnit")
public class MappingUnitController extends CommonController<MappingUnit> {
    @Autowired
    private MappingUnitService mappingUnitService;

    @Override
    public BaseService<MappingUnit> getBaseService() {
        return null;
    }

    /**
     * @author luyu
     * @date 2020/7/19 16:33
     * Description:新增、注册单位
     */
    @PostMapping("/addMappingUnit")
    public ResultData addMappingUnit(@RequestBody MappingUnit mappingUnit) {
        ResultData resultData = mappingUnitService.addMappingUnit(mappingUnit);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }


    /**
     * @author luyu
     * @date 2020/7/19 16:34
     * Description:根据id批量删除单位
     */
    @PostMapping("/delMappingUnitByIds")
    public ResultData delMappingUnitByIds(@RequestBody Integer[] ids) {
        ResultData resultData = super.batchDelete(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();

    }

    /**
     * @author luyu
     * @date 2020/7/19 16:34
     * Description:根据主键修改单位信息
     */
    @PostMapping("/updateMappingUnitById")
    public ResultData updateMappingUnitById(MappingUnit mappingUnit) {
        ResultData resultData = mappingUnitService.updateMappingUnitById(mappingUnit);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 14:14
     * Description:查询所有单位基本信息
     */
    @PostMapping("/selMappingUnit")
    public ResultData selMappingUnit(MappingUnit mappingUnit) {
        ResultData resultData = mappingUnitService.selMappingUnit(mappingUnit);
        if (resultData.getCode().equals(SELECT_SUCCESS.getCode())) {
            return resultData;
        }
        return super.selectOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 16:34
     * Description:分页查询单位信息
     */
    @PostMapping("/selMappingUnitByPage")
    public ResultData selMappingUnitByPage(MappingUnit mappingUnit, Integer pageNumber, Integer pageSize) {
        ResultData resultData = mappingUnitService.selMappingUnitByPage(mappingUnit, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 16:34
     * Description:根据条件分页查询单位信息
     */
    @PostMapping("/selMappingUnitByPageFiled")
    public ResultData selMappingUnitByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        ResultData resultData = mappingUnitService.selMappingUnitByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
}
