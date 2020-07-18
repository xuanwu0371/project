package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.UserMapper;
import com.aaa.lee.model.User;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
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
import static com.aaa.lee.status.OperationStatus.DELETE_FAILED;


/**
 * create by: lee
 * description:
 */
@Service
@Slf4j
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;

     private ResultData resultData = new ResultData<>();

    /**
     * @Author: lee
     * @date : 2020/7/15 19:59
     * Description: 添加用户
     **/
    public ResultData addUser(User user) {
        user.setCreateTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        int insert = userMapper.insert(user);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:01
     * Description: 根据主键删除用户
    **/
    public ResultData delUserByKey(User user){
        Integer delete = userMapper.deleteByPrimaryKey(user);
        if (delete >0){
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        }else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:05
     * Description: 根据id批量删除用户
    **/
    public ResultData delUserByIds(List<Integer> ids){
        Integer delete = super.deleteByIds(ids);
        if (delete >0){
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        }else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:24
     * Description: 根据id修改用户信息
    **/
    public ResultData updateUserById(User user){
        Integer update = super.update(user);
        if (update>0){
            resultData.setCode(UPDATE_SUCCESS.getCode())
                    .setMsg(UPDATE_SUCCESS.getMsg());

        }else {
            resultData.setCode(UPDATE_FAILED.getCode())
                    .setMsg(UPDATE_FAILED.getMsg());
        }
        return  resultData;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 18:22
     * Description: 查询所有用户
     **/
    public ResultData selUser(User user) {
        List<User> userList = userMapper.selectAll();
        ResultData resultData = new ResultData();
        if (userList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
           .setMsg(SELECT_SUCCESS.getMsg())
           .setData(userList);

        }else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:30
     * Description: 通过主键查询用户
    **/
    public ResultData selUserById(User id){
        User user = selectOne(id);
        if (!user.equals("")){
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(user);
        }else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

}
