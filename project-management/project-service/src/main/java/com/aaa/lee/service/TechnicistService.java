package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.TechnicistMapper;
import com.aaa.lee.model.Technicist;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 8:29
     * Description: 新增技术员
    **/
    public Map<String, Object> addTechnicist(Technicist technicist) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        int addResult = technicistMapper.insert(technicist);
        if (addResult > 0) {
            resultMap.put("code", INSERT_SUCCESS.getCode());
            resultMap.put("msg", INSERT_SUCCESS.getMsg());
        } else {
            resultMap.put("code", INSERT_FAILED.getCode());
            resultMap.put("msg", INSERT_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:03
     * Description: 批量删除技术员
    **/
    public Map<String,Object> delTechnicist(List<Long> ids){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //获取到参数类型,然后添加一个where条件,是in类型,id属于ids中的
        Example example = Example.builder(Technicist.class).where(Sqls.custom().andIn("id", ids)).build();
        int i = technicistMapper.deleteByExample(example);
        if (i > 0) {
            resultMap.put("code",DELETE_SUCCESS .getCode());
            resultMap.put("msg", DELETE_SUCCESS.getMsg());
        } else {
            resultMap.put("code",DELETE_FAILED .getCode());
            resultMap.put("msg",DELETE_FAILED .getMsg());
        }
        return resultMap;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:08
     * Description: 修改技术员信息
    **/
    public Map<String, Object> updateTechnicist(Technicist technicist) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        technicist.setModifyTime(new Date());
        int i = technicistMapper.updateByPrimaryKeySelective(technicist);
        if (i > 0) {
            resultMap.put("code",UPDATE_SUCCESS .getCode());
            resultMap.put("msg", UPDATE_SUCCESS.getMsg());
        } else {
            resultMap.put("code", UPDATE_FAILED.getCode());
            resultMap.put("msg", UPDATE_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:11
     * Description: 查询全部技术员
    **/
    public Map<String, Object> selectAllTechnicist() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Technicist> technicistList = technicistMapper.selectAll();
        if (null != technicistList && !technicistList.isEmpty()) {
            resultMap.put("code",SELECT_SUCCESS .getCode());
            resultMap.put("msg", SELECT_SUCCESS.getMsg());
            resultMap.put("data", technicistList);
        } else {
            resultMap.put("code", SELECT_FAILED.getCode());
            resultMap.put("msg", SELECT_FAILED.getMsg());
        }
        return resultMap;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:16
     * Description: 分页条件查询技术员
    **/
    public PageInfo<HashMap> selectTechnicistPageInfo(HashMap map) {
        PageHelper.startPage(BaseUtil.transToInt(map.get("pageNo")), BaseUtil.transToInt(map.get("pageNumber")));
        List<HashMap> list = technicistMapper.selectTechnicistAll(map);
        PageInfo<HashMap> pageInfo = new PageInfo<HashMap>(list);
        if (!"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }
    /**
     * @Author: lee
     * @date : 2020/7/15 20:38
     * Description: 分页查询全部技术员
     **/
    public Map<String, Object> selectTechnicistAll(HashMap map, RedisService redisService) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Object tokenId = redisService.getOne(map.get("tokenId").toString());
        //检测token
        if (null == tokenId) {
            resultMap.put("code",SELECT_FAILED .getCode());
            resultMap.put("msg", SELECT_SUCCESS.getMsg());
        }
        if (map.size() > 0) {
            PageInfo<HashMap> pageInfo = selectTechnicistPageInfo(map);
            if (null != pageInfo && pageInfo.getSize() > 0) {
                resultMap.put("code",SELECT_SUCCESS .getCode());
                resultMap.put("msg", SELECT_SUCCESS.getMsg());
            } else {
                resultMap.put("code",SELECT_FAILED .getCode());
                resultMap.put("msg", SELECT_FAILED.getMsg());
            }

        }
        return resultMap;
    }
}
