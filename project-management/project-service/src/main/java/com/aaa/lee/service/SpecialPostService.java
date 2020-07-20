package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.SpecialPostMapper;
import com.aaa.lee.model.SpecialPost;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.List;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/19 17:30
 * Description:特殊岗位人员模块
 */
@Service
public class SpecialPostService extends BaseService<SpecialPost> {
    @Autowired
    private SpecialPostMapper specialPostMapper;

    private ResultData resultData = new ResultData();

    /**
     * @Author: luyu
     * @date : 2020/7/15 19:59
     * Description: 添加特殊岗位人员
     **/
    public ResultData addSpecialPost(SpecialPost specialPost) {
        specialPost.setCreateTime(new Date());
        int insert = super.add(specialPost);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }


    /**
     * @Author: luyu
     * @date : 2020/7/18 20:05
     * Description: 根据id批量删除特殊岗位人员
     **/
    public ResultData delSpecialPostByIds(List<Integer> ids) {
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: luyu
     * @date : 2020/7/18 20:24
     * Description: 根据主键(id)修改特殊岗位人员信息
     **/
    public ResultData updateSpecialPostById(SpecialPost specialPost) {
        Integer update = super.update(specialPost);
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
     * @Author: luyu
     * @date : 2020/7/18 18:22
     * Description: 查询所有特殊岗位人员
     **/
    public ResultData selSpecialPost(SpecialPost specialPost) {
        List<SpecialPost> specialPostList = super.selectList(specialPost);
        ResultData resultData = new ResultData();
        if (specialPostList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(specialPostList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 9:42
     * Description: 分页查询特殊岗位人员
     **/
    public ResultData selSpecialPostByPage(SpecialPost specialPost, Integer pageNumber, Integer pageSize) {
        PageInfo<SpecialPost> specialPostPageInfo = super.selectListByPage(specialPost, pageNumber, pageSize);
        if (!specialPostPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(specialPostPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 10:00
     * Description: 根据条件分页查询特殊岗位人员
     **/
    public ResultData selSpecialPostByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        PageInfo<SpecialPost> specialPostPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (specialPostPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(specialPostPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }


}
