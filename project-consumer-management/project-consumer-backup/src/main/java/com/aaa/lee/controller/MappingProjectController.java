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
import tk.mybatis.mapper.util.Sqls;


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
    public ResultData addMappingProject(@RequestBody MappingProject mappingProject){
        return iProjectService.addMappingProject(mappingProject);
    }

    /**
     * @author yang
     * @date 2020/7/18 9:38
     *Description
     * 根据id批量删除测绘项目
     */
    @PostMapping("/delMappingProjectByIds")
    public ResultData delMappingProjectByIds(@RequestBody Integer[] ids){
        return iProjectService.delMappingProjectByIds(ids);
    }

    /**
     * @author yang
     * @date 2020/7/18 9:39
     *Description
     * 根据主键(id)修改测绘项目信息
     */
    @PostMapping("/updateMappingProjectById")
    public ResultData updateMappingProjectById(@RequestBody MappingProject mappingProject){
       return iProjectService.updateMappingProjectById(mappingProject);
    }

    /**
     * @author yang
     * @date 2020/7/18 9:41
     *Description
     * 查询所有测绘项目信息
     */
    @PostMapping("/selMappingProject")
    public ResultData selMappingProject(MappingProject mappingProject){
       return iProjectService.selMappingProject(mappingProject);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:30
     *Description :查询一条数据
     */
    @PostMapping("/selMappingProjectById")
    public ResultData selMappingProjectById(@RequestBody MappingProject id) {
       return iProjectService.selMappingProjectById(id);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:31
     *Description :分页查询测绘项目信息
     */
    @PostMapping("/selMappingProjectByPage")
    public ResultData selMappingProjectByPage(MappingProject mappingProject,Integer pageNumber,Integer pageSize){
        return iProjectService.selMappingProjectByPage(mappingProject,pageNumber,pageSize);
    }

    /**
     * @author yang
     * @date 2020/7/18 9:43
     *Description
     * 条据条件查询测绘项目信息
     */
    @PostMapping("/selMappingProjectByPageFiled")
    public ResultData selMappingProjectByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        return iProjectService.selMappingProjectByPageFiled(number, pageSize, where, orderFiled, fileds);
    }
}
