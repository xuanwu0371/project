package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.NewsMapper;
import com.aaa.lee.model.News;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
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
 * @date 2020-07-16 18:32
 */
@Service
public class NewsService extends BaseService<News> {
    @Autowired
    private NewsMapper newsMapper;

    /**
     * @author yang
     * @date 2020/7/16 18:35
     *Description
     *    新增新闻
     */
    public Map<String,Object> addNews(News news){
        Map<String,Object> resultMap = new HashMap<>();
        news.setGmtCreate(new Date());
        int addResult = newsMapper.insert(news);
        if (addResult > 0) {
            resultMap.put("code", INSERT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", INSERT_OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code", INSERT_OPERATION_FAILED.getCode());
            resultMap.put("msg", INSERT_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author yang
     * @date 2020/7/16 19:03
     *Description
     *      删除新闻
     */
    public Map<String,Object> delNews(List<Long> ids){
        Map<String, Object> resultMap = new HashMap<>();
        Example example = Example.builder(News.class).where(Sqls.custom().andIn("id", ids)).build();
        int i = newsMapper.deleteByExample(example);
        if (i > 0 ) {
            resultMap.put("code", DELETE_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", DELETE_OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code", DELETE_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", DELETE_OPERATION_SUCCESS.getMsg());
        }
        return resultMap;
    }

    /**
     * @author yang
     * @date 2020/7/16 19:10
     *Description
     * 修改新闻
     */
    public Map<String,Object> updateNews(News news){
        Map<String,Object> resultMap = new HashMap<>();
        news.setGmtCreate(new Date());
        int i = newsMapper.updateByPrimaryKey(news);
        if (i > 0 ) {
            resultMap.put("code",UPDATE_OPERATION_SUCCESS.getCode());
            resultMap.put("msg", UPDATE_OPERATION_SUCCESS.getMsg());
        } else {
            resultMap.put("code",UPDATE_OPERATION_FAILED.getCode());
            resultMap.put("msg",UPDATE_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author yang
     * @date 2020/7/16 19:13
     *Description
     * 查询新闻
     */
    public Map<String,Object> selectNews(){
        Map<String,Object> resultMap = new HashMap<>();
        List<News> newsList = newsMapper.selectAll();
        if (null != newsList && !newsList.isEmpty()) {
            resultMap.put("code",SELECT_OPERATION_SUCCESS.getCode());
            resultMap.put("msg",SELECT_OPERATION_SUCCESS.getMsg());
            return resultMap;
        } else {
            resultMap.put("code",SELECT_OPERATION_FAILED.getCode());
            resultMap.put("msg",SELECT_OPERATION_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @author yang
     * @date 2020/7/16 19:18
     *Description
     * 分页条件查询
     */
    public PageInfo<HashMap> selectNewsPageInfo(HashMap map){
        PageHelper.startPage(BaseUtil.transToInt(map.get("pageNo")),BaseUtil.transToInt(map.get("pageNumber")));
        List<HashMap> list = newsMapper.selectNewsAll(map);
        PageInfo<HashMap> pageInfo = new PageInfo<>(list);
        if (null != pageInfo && !"".equals(pageInfo)) {
            return pageInfo;
        }
        return null;
    }

    /**
     * @author yang
     * @date 2020/7/16 19:26
     *Description
     *       分页查询新闻
     */
    public Map<String,Object> selectAllNews(HashMap map, RedisService redisService){
        Map<String,Object> resultMap = new HashMap<>();
        if (map.size() > 0 ) {
            PageInfo<HashMap> pageInfo = selectNewsPageInfo(map);
            if (null != pageInfo && pageInfo.getSize() > 0 ) {
                resultMap.put("code",SELECT_OPERATION_SUCCESS.getCode());
                resultMap.put("msg",SELECT_OPERATION_SUCCESS.getMsg());
                return resultMap;
            } else {
                resultMap.put("code",SELECT_OPERATION_FAILED.getCode());
                resultMap.put("msg",SELECT_OPERATION_FAILED.getMsg());
            }
        }
        return resultMap;
    }
}
