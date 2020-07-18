package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.MappingUnit;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.MappingUnitService;
import lombok.extern.slf4j.Slf4j;
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
 * @date 2020-07-18 11:10
 */
@RestController
@Slf4j
@RequestMapping("/mappingUnit")
public class MappingUnitController extends CommonController<MappingUnit> {
    @Autowired
    private MappingUnitService mappingUnitService;
    @Autowired
    private RedisService redisService;
    @Override
    public BaseService<MappingUnit> getBaseService() {
        return null;
    }

    /**
     * @author yang
     * @date 2020/7/18 11:12
     *Description
     * 新增测绘单位信息
     */
    @PostMapping("/addMappingUnit")
    ResultData addMappingUnit(@RequestBody MappingUnit mappingUnit){
        Map<String, Object> addResult = mappingUnitService.addMappingUnit(mappingUnit);
        if (addResult.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 11:14
     *Description
     * 批量删除测绘单位信息
     */
    @PostMapping("/delMappingUnit")
    ResultData delMappingUnit(@RequestBody List<Long> ids){
        Map<String, Object> resultMap = mappingUnitService.delMappingUnit(ids);
        if (resultMap.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 11:15
     *Description
     *  修改测绘单位信息
     */
    @PostMapping("/updateMappingUnit")
    ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit){
        Map<String,Object> resultMap = mappingUnitService.updateMappingUnit(mappingUnit);
        if (resultMap.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 11:16
     *Description
     *  查询测绘单位信息
     */
    @PostMapping("/selectMappingUnitAll")
    ResultData selectMappingUnitAll(MappingUnit mappingUnit){
        Map<String, Object> resultMap = mappingUnitService.selectMappingUnitAll();
        if (resultMap.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess(resultMap);
        } else {
            return super.operationFailed();
        }
    }

    /**
     * @author yang
     * @date 2020/7/18 11:17
     *Description
     * 条件查询测绘单位信息
     */
    @PostMapping("/selectMappingUnit")
    ResultData selectMappingUnit(@RequestBody HashMap map){
        Map<String,Object> mappingUnitAll = mappingUnitService.selectMappingUnitsAll(map,redisService);
        if (mappingUnitAll.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess(mappingUnitAll);
        } else {
            return super.operationFailed();
        }
    }
}
