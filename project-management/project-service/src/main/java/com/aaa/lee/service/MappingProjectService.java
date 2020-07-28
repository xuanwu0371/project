package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.MappingProjectMapper;
import com.aaa.lee.model.MappingProject;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.*;

import static com.aaa.lee.staticproerties.TimeFormatProperties.TIME_FORMAT;
import static com.aaa.lee.status.OperationStatus.*;


/**
 * @author Yang
 * @date 2020-07-18 08:27
 */
@Service
@Slf4j
public class MappingProjectService extends BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    private ResultData resultData = new ResultData();

    /**
     * @author yang
     * @date 2020/7/18 8:29
     * Description
     * 增加测绘项目
     */
    public ResultData addMappingProject(MappingProject mappingProject) {
        mappingProject.setCreateTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        int insert = super.add(mappingProject);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/18 8:44
     * Description
     * 根据id批量测删除绘项目
     */
    public ResultData delMappingProjectById(MappingProject id) {
        Integer delete = super.delete(id);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/18 8:48
     * Description
     * 根据主键(id)修改测绘项目信息
     */
    public ResultData updateMappingProjectById(MappingProject mappingProject) {
        mappingProject.setModifyTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        Integer update = super.update(mappingProject);
        if (update > 0) {
            resultData.setCode(UPDATE_SUCCESS.getCode())
                    .setMsg(UPDATE_SUCCESS.getMsg());

        } else {
            resultData.setCode(UPDATE_FAILED.getCode())
                    .setMsg(UPDATE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/18 8:51
     * Description
     * 查询全部测绘项目信息
     */
    public ResultData selMappingProject(MappingProject mappingProject) {
        List<MappingProject> mappingProjectList = super.selectList(mappingProject);
        ResultData resultData = new ResultData();
        if (mappingProjectList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(mappingProjectList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/19 14:58
     * Description :通过项目名查询一条数据
     */
    public ResultData selMappingProjectByProjectName(String projectName) {
        if (!projectName.equals("")) {
            MappingProject mappingProject = new MappingProject();
            mappingProject.setProjectName(projectName);
            List<MappingProject> list = super.selectList(mappingProject);
            if (list.size() > 0) {
                resultData.setCode(SELECT_SUCCESS.getCode())
                        .setMsg((SELECT_SUCCESS).getMsg())
                        .setData(list);
            } else {
                resultData.setCode(SELECT_FAILED.getCode())
                        .setMsg(SELECT_FAILED.getMsg());
            }
        }
        return resultData;
    }


    /**
     * @author yang
     * @date 2020/7/18 8:53
     * Description
     * 分页查询项目信息
     */
    public ResultData selMappingProjectByPage(MappingProject mappingProject, Integer pageNumber, Integer pageSize) {
        PageInfo<MappingProject> userPageInfo = super.selectListByPage(mappingProject, pageNumber, pageSize);
        if (!userPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(userPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/18 8:58
     * Description
     * 根据条件分页查询测绘项目信息
     */
    public ResultData selMappingProjectByPageFiled(Integer number, Integer pageSize, Sqls where, String
            orderFiled, String... fileds) {
        PageInfo<MappingProject> mappingProjectPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (mappingProjectPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(mappingProjectPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }

}