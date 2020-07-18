package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.MappingProject;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.MappingProjectService;
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
 * @date 2020-07-18 09:01
 */
@RestController
@Slf4j
@RequestMapping("/mappingProject")
public class MappingProjectController extends CommonController<MappingProject> {
    @Autowired
    private MappingProjectService mappingProjectService;
    @Autowired
    private RedisService redisService;
    @Override
    public BaseService<MappingProject> getBaseService() {
        return null;
    }

    /**
     * @author yang
     * @date 2020/7/18 9:11
     *Description
     *     新增测绘项目
     */
    @PostMapping("/addMappingProject")
    ResultData addMappingProject(@RequestBody MappingProject mappingProject){
        Map<String, Object> addResult = mappingProjectService.addMappingProject(mappingProject);
        if (addResult.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 9:14
     *Description
     *   批量删除测绘项目
     */
    @PostMapping("/delMappingProject")
    ResultData delMappingProject(@RequestBody List<Long> ids){
        Map<String, Object> resultMap = mappingProjectService.delMappingProject(ids);
        if (resultMap.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 9:16
     *Description
     *   修改测绘项目信息
     */
    @PostMapping("/updateMappingProject")
    ResultData updateMappingProject(@RequestBody MappingProject mappingProject){
        Map<String,Object> resultMap = mappingProjectService.updateMappingProject(mappingProject);
        if (resultMap.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 9:19
     *Description
     * 查询测绘项目信息
     */
    @PostMapping("/selectMappingProjectAll")
    ResultData selectMappingProjectAll(MappingProject mappingProject){
        Map<String, Object> resultMap = mappingProjectService.selectMappingProjectAll();
        if (resultMap.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess(resultMap);
        } else {
            return super.operationFailed();
        }
    }

    /**
     * @author yang
     * @date 2020/7/18 9:23
     *Description
     * 条件查询测绘项目信息
     */
    @PostMapping("/selectMappingProject")
    ResultData selectMappingProject(@RequestBody HashMap map){
        Map<String,Object> mappingProjectAll = mappingProjectService.selectMappingProjectsAll(map,redisService);
        if (mappingProjectAll.get("code").equals(OPERATION_SUCCESS.getCode())) {
            return super.operationSuccess(mappingProjectAll);
        } else {
            return super.operationFailed();
        }
    }
}
