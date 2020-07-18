package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.MappingUnitMapper;
import com.aaa.lee.model.MappingUnit;
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
 * @author Yang
 * @date 2020-07-18 10:57
 */
@Service
@Slf4j
public class MappingUnitService  extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;

    /**
     * @author yang
     * @date 2020/7/18 10:59
     *Description
     *   增加测绘单位
     */
    public Map<String,Object> addMappingUnit(MappingUnit mappingUnit){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        mappingUnit.setModifyTime(new Date());
        int addResult = mappingUnitMapper.insert(mappingUnit);
        if (addResult > 0) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            return resultMap;
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
            return resultMap;
        }
    }

    /**
     * @author yang
     * @date 2020/7/18 11:01
     *Description
     *   删除测绘单位信息
     */
    public Map<String,Object> delMappingUnit(List<Long> ids){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //获取到参数类型,然后添加一个where条件,是in类型,id属于ids中的
        Example example = Example.builder(MappingUnit.class).where(Sqls.custom().andIn("id", ids)).build();
        int i = mappingUnitMapper.deleteByExample(example);
        if (i > 0) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            return resultMap;
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
            return resultMap;
        }
    }

    /**
     * @author yang
     * @date 2020/7/18 11:03
     *Description
     *  改测绘单位信息
     */
    public Map<String,Object> updateMappingUnit(MappingUnit mappingUnit){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        mappingUnit.setModifyTime(new Date());
        int i = mappingUnitMapper.updateByPrimaryKeySelective(mappingUnit);
        if (i > 0) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            return resultMap;
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
            return resultMap;
        }
    }

    /**
     * @author yang
     * @date 2020/7/18 11:04
     *Description
     *  查询全部测绘单位信息
     */
    public Map<String,Object> selectMappingUnitAll(){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<MappingUnit> mappingUnits = mappingUnitMapper.selectAll();
        if (null != mappingUnits && !mappingUnits.isEmpty()) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            resultMap.put("data", mappingUnits);
            return resultMap;
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
            return resultMap;
        }
    }

    /**
     * @author yang
     * @date 2020/7/18 11:05
     *Description
     *   分页条件查询测绘单位信息
     */
    public PageInfo<HashMap> selectMappingUnitPageInfo(HashMap map){
        PageHelper.startPage(BaseUtil.transToInt(map.get("pageNo")), BaseUtil.transToInt(map.get("pageNumber")));
        List<HashMap> list = mappingUnitMapper.selectMappingUnitAll(map);
        PageInfo<HashMap> pageInfo = new PageInfo<HashMap>(list);
        if (null != pageInfo && !"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }

    /**
     * @author yang
     * @date 2020/7/18 11:08
     *Description
     *  分页查询全部测绘单位信息
     */
    public Map<String, Object> selectMappingUnitsAll(HashMap map, RedisService redisService) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Object tokenId = redisService.getOne(map.get("tokenId").toString());
        //检测token
        if (null == tokenId) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            return resultMap;
        }
        if (map.size() > 0) {
            PageInfo<HashMap> pageInfo = selectMappingUnitPageInfo(map);
            if (null != pageInfo && pageInfo.getSize() > 0) {
                resultMap.put("code", OPERATION_SUCCESS.getCode());
                resultMap.put("msg", OPERATION_SUCCESS.getMsg());
                return resultMap;
            } else {
                resultMap.put("code", OPERATION_FAILED.getCode());
                resultMap.put("msg", OPERATION_FAILED.getMsg());
            }

        }
        return resultMap;
    }

}
