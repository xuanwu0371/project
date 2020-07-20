package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.TechnicistMapper;
import com.aaa.lee.model.Technicist;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.util.Sqls;

import java.util.List;


import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/19 15:08
 * Description:技术人员信息模块
 */
@Service
@Slf4j
public class TechnicistService extends BaseService<Technicist> {
    @Autowired
    private TechnicistMapper technicistMapper;

    private ResultData resultData = new ResultData();

    /**
     * @author luyu
     * @date 2020/7/19 15:08
     * Description:新增技术人员
     */
    public ResultData addTechnicist(Technicist technicist) {
        Integer add = super.add(technicist);
        if (add > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:08
     * Description:根据id批量删除技术人员
     */
    public ResultData delTechnicist(List<Integer> ids) {
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:09
     * Description:根据主键(id)修改技术人员信息
     */
    public ResultData updateTechnicistById(Technicist technicist) {
        Integer update = super.update(technicist);
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
     * @author luyu
     * @date 2020/7/19 15:10
     * Description:查询所有技术人员信息
     */
    public ResultData selTechnicist(Technicist technicist) {
        List<Technicist> technicistList = super.selectList(technicist);
        ResultData resultData = new ResultData();
        if (technicistList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(technicistList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:12
     * Description:分页查询技术人员信息
     */
    public ResultData selTechnicistByPage(Technicist technicist, Integer pageNumber, Integer pageSize) {
        PageInfo<Technicist> technicistPageInfo = super.selectListByPage(technicist, pageNumber, pageSize);
        if (!technicistPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(technicistPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }


    /**
     * @author luyu
     * @date 2020/7/19 15:16
     * Description:根据条件分页查询技术人员
     */
    public ResultData selTechnicistByPageFiled(Integer pageNumber, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        PageInfo<Technicist> technicistInfo = super.selectListByPageAndFiled(pageNumber, pageSize, where, orderFiled, fileds);

        if (technicistInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(technicistInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }


}
