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
import tk.mybatis.mapper.util.Sqls;

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
    public ResultData addMappingProject( MappingProject mappingProject) {
        ResultData resultData = mappingProjectService.addMappingProject(mappingProject);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 9:14
     *Description
     *    根据id批量删除测绘项目
     */
    @PostMapping("/delMappingProjectById")
    public ResultData delMappingProjectByIds(MappingProject id){
        ResultData resultData = mappingProjectService.delMappingProjectById(id);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 9:16
     *Description
     *   根据主键(id)修改测绘项目信息
     */
    @PostMapping("/updateMappingProjectById")
    public ResultData updateMappingProjectById( MappingProject mappingProject){
        ResultData resultData = mappingProjectService.updateMappingProjectById(mappingProject);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 9:19
     *Description
     * 查询所有测绘项目信息
     */
    @PostMapping("/selMappingProject")
    public ResultData selMappingProject(MappingProject mappingProject){
        ResultData resultData = mappingProjectService.selMappingProject(mappingProject);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author : yang
     * @date : 2020/7/19 15:34
     *Description :通过项目名查询一条数据
     */
    @PostMapping("/selMappingProjectByProjectName")
    public ResultData selMappingProjectByProjectName(String projectName) {
        ResultData resultData = mappingProjectService.selMappingProjectByProjectName(projectName);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author : yang
     * @date : 2020/7/19 15:35
     *Description :分页查询测绘项目信息
     */
    @PostMapping("/selMappingProjectByPage")
    public ResultData selMappingProjectByPage(MappingProject mappingProject,Integer pageNumber,Integer pageSize){
        ResultData resultData = mappingProjectService.selMappingProjectByPage(mappingProject, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/18 9:23
     *Description
     * 根据条件查询测绘项目信息
     */
    @PostMapping("/selMappingProjectByPageFiled")
    public ResultData selMappingProjectByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        ResultData resultData = mappingProjectService.selMappingProjectByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
}
