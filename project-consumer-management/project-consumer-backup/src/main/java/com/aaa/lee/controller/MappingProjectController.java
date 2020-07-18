package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.MappingProject;
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
 * @date 2020-07-18 09:33
 */
@RestController
@RequestMapping("/mappingProject")
public class MappingProjectController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @author yang
     * @date 2020/7/18 9:35
     *Description
     *    新增测绘项目
     */
    @PostMapping("/addMappingProject")
    ResultData addMappingProject(@RequestBody MappingProject mappingProject){
        return iProjectService.addMappingProject(mappingProject);
    }

    /**
     * @author yang
     * @date 2020/7/18 9:38
     *Description
     * 批量删除测绘项目
     */
    @PostMapping("/delMappingProject")
    ResultData delMappingProject(@RequestBody List<Long> ids){
        return iProjectService.delMappingProject(ids);
    }

    /**
     * @author yang
     * @date 2020/7/18 9:39
     *Description
     * 修改测绘项目信息
     */
    @PostMapping("/updateMappingProject")
    ResultData updateMappingProject(@RequestBody MappingProject mappingProject){
        return iProjectService.updateMappingProject(mappingProject);
    }

    /**
     * @author yang
     * @date 2020/7/18 9:41
     *Description
     * 查询测绘项目信息
     */
    @PostMapping("/selectMappingProjectAll")
    ResultData selectMappingProjectAll(MappingProject mappingProject){
        return iProjectService.selectMappingProjectAll(mappingProject);
    }

    /**
     * @author yang
     * @date 2020/7/18 9:43
     *Description
     * 条件查询测绘项目信息
     */
    @PostMapping("/selectMappingProject")
    ResultData selectMappingProject(@RequestBody HashMap map){
        return  iProjectService.selectMappingProject(map);
    }


}
