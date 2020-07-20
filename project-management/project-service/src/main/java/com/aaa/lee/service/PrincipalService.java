package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.PrincipalMapper;
import com.aaa.lee.model.Principal;
import com.aaa.lee.model.Principal;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.staticproerties.TimeFormatProperties.TIME_FORMAT;
import static com.aaa.lee.status.OperationStatus.*;


/**
 * @author luyu
 * @date 2020/7/19 14:31
 * Description:单位负责人模块
 */
@Service
@Slf4j
public class PrincipalService extends BaseService<Principal> {
    @Autowired
    private PrincipalMapper principalMapper;

    private ResultData resultData = new ResultData();


    /**
     * @Author: Luyu
     * @date : 2020/7/15 19:59
     * Description: 添加负责人
     **/
    public ResultData addPrincipal(Principal principal) {
        principal.setCreateTime(new Date());
        int insert = super.add(principal);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }



    /**
     * @Author: Luyu
     * @date : 2020/7/18 20:05
     * Description: 根据id批量删除负责人
     **/
    public ResultData delPrincipalByIds(List<Integer> ids) {
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Luyu
     * @date : 2020/7/18 20:24
     * Description: 根据主键(id)修改负责人信息
     **/
    public ResultData updatePrincipalById(Principal principal) {
        Integer update = super.update(principal);
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
     * @date 2020/7/19 14:36
     * Description:查询所有单位负责人
     */
    public ResultData selPrincipal(Principal principal) {
        List<Principal> principalList = super.selectList(principal);
        ResultData resultData = new ResultData();
        if (principalList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(principalList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author luyu
     * @date 2020/7/19 14:38
     * Description:分页查询负责人
     */
    public ResultData selPrincipalByPage(Principal principal, Integer pageNumber, Integer pageSize) {
        PageInfo<Principal> principalPageInfo = super.selectListByPage(principal, pageNumber, pageSize);
        if (!principalPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(principalPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author luyu
     * @date 2020/7/19 14:41
     * Description:根据条件分页查询负责人
     */
    public ResultData selPrincipalByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        PageInfo<Principal> principalPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (principalPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(principalPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }
}
