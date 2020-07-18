package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.MappingProjectMapper;
import com.aaa.lee.model.MappingProject;
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
 * @author Yang
 * @date 2020-07-18 08:27
 */
@Service
@Slf4j
public class MappingProjectService extends BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    /**
     * @author yang
     * @date 2020/7/18 8:29
     *Description
     *     增加测绘项目
     */
    public Map<String,Object> addMappingProject(MappingProject mappingProject){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        mappingProject.setModifyTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        int addResult = mappingProjectMapper.insert(mappingProject);
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
     * @date 2020/7/18 8:44
     *Description
     * 测绘项目删除
     */
    public Map<String,Object> delMappingProject(List<Long> ids){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //获取到参数类型,然后添加一个where条件,是in类型,id属于ids中的
        Example example = Example.builder(MappingProject.class).where(Sqls.custom().andIn("id", ids)).build();
        int i = mappingProjectMapper.deleteByExample(example);
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
     * @date 2020/7/18 8:48
     *Description
     * 修改测绘项目信息
     */
    public Map<String,Object> updateMappingProject(MappingProject mappingProject){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        mappingProject.setModifyTime(DateUtil.formatDate(new Date(), TIME_FORMAT));
        int i = mappingProjectMapper.updateByPrimaryKeySelective(mappingProject);
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
     * @date 2020/7/18 8:51
     *Description
     * 查询全部测绘项目信息
     */
    public Map<String,Object> selectMappingProjectAll(){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<MappingProject> mappingProjects = mappingProjectMapper.selectAll();
        if (null != mappingProjects && !mappingProjects.isEmpty()) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            resultMap.put("data", mappingProjects);
            return resultMap;
        } else {
            resultMap.put("code", OPERATION_FAILED.getCode());
            resultMap.put("msg", OPERATION_FAILED.getMsg());
            return resultMap;
        }
    }

    /**
     * @author yang
     * @date 2020/7/18 8:53
     *Description
     * 分页条件查询项目信息
     */
    public PageInfo<HashMap> selectMappingProjectPageInfo(HashMap map){
        PageHelper.startPage(BaseUtil.transToInt(map.get("pageNo")), BaseUtil.transToInt(map.get("pageNumber")));
        List<HashMap> list = mappingProjectMapper.selectMappingProjectAll(map);
        PageInfo<HashMap> pageInfo = new PageInfo<HashMap>(list);
        if (null != pageInfo && !"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }

    /**
     * @author yang
     * @date 2020/7/18 8:58
     *Description
     * 分页查询全部测绘项目信息
     */
    public Map<String, Object> selectMappingProjectsAll(HashMap map, RedisService redisService) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Object tokenId = redisService.getOne(map.get("tokenId").toString());
        //检测token
        if (null == tokenId) {
            resultMap.put("code", OPERATION_SUCCESS.getCode());
            resultMap.put("msg", OPERATION_SUCCESS.getMsg());
            return resultMap;
        }
        if (map.size() > 0) {
            PageInfo<HashMap> pageInfo = selectMappingProjectPageInfo(map);
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
