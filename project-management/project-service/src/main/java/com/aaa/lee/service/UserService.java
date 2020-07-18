package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.UserMapper;
import com.aaa.lee.model.User;
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
 * create by: lee
 * description:
 */
@Service
@Slf4j
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;

    /**
     * @Author: lee
     * @date : 2020/7/15 19:59
     * Description: 新增用户
     **/
    public Map<String, Object> addUser(User user) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        user.setCreateTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        int addResult = userMapper.insert(user);
        if (addResult > 0) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 20:19
     * Description: 批量删除用户
     **/
    public Map<String, Object> delUser(List<Long> ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //获取到参数类型,然后添加一个where条件,是in类型,id属于ids中的
        Example example = Example.builder(User.class).where(Sqls.custom().andIn("id", ids)).build();
        int i = userMapper.deleteByExample(example);
        if (i > 0) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 20:28
     * Description: 修改用户信息
     **/
    public Map<String, Object> updateUser(User user) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        user.setModifyTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i > 0) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author luyu
     * @date 2020/7/16 19:29
     * Description
     * 查询全部用户信息
     */
    public Map<String, Object> selectAll() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<User> userList = userMapper.selectAll();
        if (null != userList && !userList.isEmpty()) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            resultMap.put("data", userList);
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }


    /**
     * @Author: lee
     * @date : 2020/7/15 20:38
     * Description: 分页查询全部用户
     **/
    public Map<String, Object> selectUserAll(HashMap map, RedisService redisService) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Object tokenId = redisService.getOne(map.get("tokenId").toString());
        //检测token
        if (null == tokenId) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
        }
        if (map.size() > 0) {
            PageInfo<HashMap> pageInfo = selectUserPageInfo(map);
            if (null != pageInfo && pageInfo.getSize() > 0) {
                resultMap.put("code", OPERATION_SUCCESS.getCode());
                resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            } else {
                resultMap.put("code", OPERATION_FAILED.getCode());
                resultMap.put("msg", OPERATION_FAILED.getMsg());
            }

        }
        return resultMap;
    }

    /**
     * @Author: LiShiHao
     * @date : 2020/7/15 21:26
     * Description:分页条件查询
     **/
    public PageInfo<HashMap> selectUserPageInfo(HashMap map) {
        PageHelper.startPage(BaseUtil.transToInt(map.get("pageNo")), BaseUtil.transToInt(map.get("pageNumber")));
        List<HashMap> list = userMapper.selectUserAll(map);
        PageInfo<HashMap> pageInfo = new PageInfo<HashMap>(list);
        if (null != pageInfo && !"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }
}
