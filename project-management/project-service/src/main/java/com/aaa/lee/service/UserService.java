package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.UserMapper;
import com.aaa.lee.model.User;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    private ResultData resultData = new ResultData();

    /**
     * @Author: lee
     * @date : 2020/7/15 19:59
     * Description: 添加用户
     **/
    public ResultData addUser(User user) {
        if (user.getId() == null) {
            user.setId(userMapper.getLastId() + 1);
            user.setPassword("123456");
            user.setStatus("1");
            user.setCreateTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
            user.setType("1");
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            user.setToken(token);
            int insert = super.add(user);
            if (insert > 0) {
                resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
            } else {
                resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
            }
        }else {
            user.setModifyTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
            Integer update = super.update(user);
            if (update > 0) {
                resultData.setCode(UPDATE_SUCCESS.getCode())
                        .setMsg(UPDATE_SUCCESS.getMsg());
            } else {
                resultData.setCode(UPDATE_FAILED.getCode())
                        .setMsg(UPDATE_FAILED.getMsg());
            }

        }
        return resultData;
    }


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:05
     * Description: 根据id批量删除用户
     **/

    public ResultData delUserById(User id) {
        Integer delete = super.delete(id);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/20 19:28
     * Description: 重置用户密码
     * 根据前端传过来的id来重置密码
     **/
    public ResultData resetUserPwd(User user) {
        if (!user.getId().equals("")) {
            User user1 = super.selectOne(user);
            user1.setPassword("123456");
            super.update(user1);
            resultData.setCode(SUCCESS.getCode())
                    .setMsg(SUCCESS.getMsg());
        } else {
            resultData.setCode(FAILED.getCode())
                    .setMsg(FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:24
     * Description: 根据主键(id)修改用户信息
     **/
    public ResultData updateUser(User user) {
        user.setModifyTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        Integer update = super.update(user);
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
     * @date : 2020/7/18 18:22
     * Description: 查询所有用户
     **/
    public ResultData selUser(User user) {
        PageInfo<User> list = super.selectListByPage(user, 1, 1);
        System.out.println(list);
        List<User> userList = super.selectList(user);
        if (userList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(userList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 20:30
     * Description: 查询一条数据
     **/
    public ResultData selUserById(User user) {
        User user1 = super.selectOne(user);
        if (!user1.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(user1);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Li ShiHao
     * @Date: 2020/7/27 10:49
     * @Description: 通过用户名查询一条数据
     */
    public ResultData selUserByUsername(User username) {
        if (!username.equals("")) {
            User user = super.selectOne(username);
            List<User> list = new ArrayList<User>();
            list.add(user);
            if (!user.equals("")) {
                this.resultData.setCode(SELECT_SUCCESS.getCode())
                        .setMsg(SELECT_SUCCESS.getMsg())
                        .setData(list);
            } else {
                this.resultData.setCode(SELECT_FAILED.getCode())
                        .setMsg(SELECT_FAILED.getMsg());
            }

        } else {
            List<User> list = selectList(username);
            if (list.size() != 0) {
                this.resultData.setCode(SELECT_SUCCESS.getCode())
                        .setMsg(SELECT_SUCCESS.getMsg())
                        .setData(list);
            } else {
                this.resultData.setCode(SELECT_FAILED.getCode())
                        .setMsg(SELECT_FAILED.getMsg());
            }

        }
        return this.resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 9:42
     * Description: 分页查询用户
     **/
    public ResultData selUserByPage(User user, Integer pageNumber, Integer pageSize) {
        PageInfo<User> userPageInfo = super.selectListByPage(user, pageNumber, pageSize);
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
     * @Author: Lee ShiHao
     * @date : 2020/7/19 10:00
     * Description: 根据条件分页查询用户
     **/
    public ResultData selUserByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        PageInfo<User> userPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (userPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(userPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }
}
