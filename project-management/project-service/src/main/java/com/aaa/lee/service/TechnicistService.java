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
 * create by: LiShiHao
 * create Time:  2020/7/18 8:28
 * description:
 */
@Service
@Slf4j
public class TechnicistService extends BaseService<Technicist> {
    @Autowired
    private TechnicistMapper technicistMapper;

    private ResultData resultData = new ResultData<>();

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 10:16
     * Description: 新增技术员
     **/
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
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:03
     * Description: 根据id批量删除技术员
     **/
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
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:08
     * Description: 修改技术员信息
     **/
    public ResultData updateUserById(Technicist technicist) {
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
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:11
     * Description: 分页查询技术员
     **/
    public ResultData selTechnicistByPage(Technicist technicist, Integer pageNumber, Integer pageSize) {
        PageInfo<Technicist> list = super.selectListByPage(technicist, pageNumber, pageSize);
        if (!list.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(list);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:16
     * Description: 分页条件查询技术员
     **/
    public ResultData selectTechnicistPageInfo(Integer pageNumber, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        PageInfo<Technicist> list = super.selectListByPageAndFiled(pageNumber, pageSize, where, orderFiled, fileds);

        if (list.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(list);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }


}
