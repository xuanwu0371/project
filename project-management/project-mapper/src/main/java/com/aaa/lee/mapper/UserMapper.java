package com.aaa.lee.mapper;

import com.aaa.lee.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: LiShiHao
 * @date : 2020/7/16 9:55
 * Description:
 **/
public interface UserMapper extends Mapper<User> {
/**
 * @Author: LiShiHao
 * @date : 2020/7/16 9:55
 * Description: 条件分页查询所有用户
 **/
    List<HashMap> selectUserAll(HashMap map);
}