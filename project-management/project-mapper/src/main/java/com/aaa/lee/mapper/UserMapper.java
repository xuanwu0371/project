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
     * @Author: Li ShiHao
     * @Date: 2020/7/27 15:10
     * @Description: 获取最后一个id
     */

    Long getLastId( );
}