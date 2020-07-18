package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.PrincipalMapper;
import com.aaa.lee.model.Principal;
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
 * create Time:  2020/7/17 21:46
 * description:
 */
@Service
@Slf4j
public class PrincipalService extends BaseService<Principal> {
    @Autowired
    private PrincipalMapper principalMapper;

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 21:49
     * Description: 重要人增加
     **/
    public Map<String, Object> addPrincipal(Principal principal) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        principal.setModifyTime(new Date());
        int addResult = principalMapper.insert(principal);
        if (addResult > 0) {
            resultMap.put("code", INSERT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", INSERT_OPERATION_SUCCESS.getMsg());
            return resultMap;
        } else {
            resultMap.put("code", INSERT_OPERATION_FAILED.getCode());
            resultMap.put("msg", INSERT_OPERATION_FAILED.getMsg());
            return resultMap;
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 21:56
     * Description: 重要人删除
     **/
    public Map<String, Object> delPrincipal(List<Long> ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //获取到参数类型,然后添加一个where条件,是in类型,id属于ids中的
        Example example = Example.builder(Principal.class).where(Sqls.custom().andIn("id", ids)).build();
        int i = principalMapper.deleteByExample(example);
        if (i > 0) {
            resultMap.put("code", DELETE_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", DELETE_OPERATION_SUCCESS.getMsg());
            return resultMap;
        } else {
            resultMap.put("code", DELETE_OPERATION_FAILED.getCode());
            resultMap.put("msg", DELETE_OPERATION_FAILED.getMsg());
            return resultMap;
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 21:57
     * Description: 修改重要人信息
     **/
    public Map<String, Object> updatePrincipal(Principal principal) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        principal.setModifyTime(new Date());
        int i = principalMapper.updateByPrimaryKeySelective(principal);
        if (i > 0) {
            resultMap.put("code", UPDATE_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", UPDATE_OPERATION_SUCCESS.getMsg());
            return resultMap;
        } else {
            resultMap.put("code", UPDATE_OPERATION_FAILED.getCode());
            resultMap.put("msg", UPDATE_OPERATION_FAILED.getMsg());
            return resultMap;
        }

    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 21:58
     * Description: 查询全部重要人信息，可用于重要人信息导出
     **/
    public Map<String, Object> selectPrincipalAll() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Principal> principals = principalMapper.selectAll();
        if (null != principals && !principals.isEmpty()) {
            resultMap.put("code", SELECT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", SELECT_OPERATION_SUCCESS.getMsg());
            resultMap.put("data", principals);
            return resultMap;
        } else {
            resultMap.put("code", SELECT_OPERATION_FAILED.getCode());
            resultMap.put("msg", SELECT_OPERATION_FAILED.getMsg());
            return resultMap;
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:00
     * Description: 分页条件查询
     **/
    public PageInfo<HashMap> selectPrincipalsPageInfo(HashMap map) {
        PageHelper.startPage(BaseUtil.transToInt(map.get("pageNo")), BaseUtil.transToInt(map.get("pageNumber")));
        List<HashMap> list = principalMapper.selectPrincipalAll(map);
        PageInfo<HashMap> pageInfo = new PageInfo<HashMap>(list);
        if (null != pageInfo && !"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:03
     * Description: 分页查询全部重要人
     **/
    public Map<String, Object> selectPrincipalsAll(HashMap map, RedisService redisService) {
        Map<String, Object> resultMap = new HashMap<>();
        Object tokenId = redisService.getOne(map.get("tokenId").toString());
        //检测token
        if (null == tokenId) {
            resultMap.put("code", SELECT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", SELECT_OPERATION_SUCCESS.getMsg());
            return resultMap;
        }
        if (map.size() > 0) {
            PageInfo<HashMap> pageInfo = selectPrincipalsPageInfo(map);
            if (null != pageInfo && pageInfo.getSize() > 0) {
                resultMap.put("code", SELECT_OPERATION_SUCCESS.getCode());
                resultMap.put("msg", SELECT_OPERATION_SUCCESS.getMsg());
                return resultMap;
            } else {
                resultMap.put("code", SELECT_OPERATION_FAILED.getCode());
                resultMap.put("msg", SELECT_OPERATION_FAILED.getMsg());
            }

        }
        return resultMap;
    }

}
