package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.NewsMapper;
import com.aaa.lee.model.News;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
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
 * @date 2020-07-16 18:32
 */
@Service
@Slf4j
public class NewsService extends BaseService<News> {
    @Autowired
    private NewsMapper newsMapper;
    
    private ResultData resultData = new ResultData();

    /**
     * @author yang
     * @date 2020/7/16 18:35
     * Description
     * 新增新闻
     */
    public ResultData addNews(News news) {
        news.setGmtCreate(new Date());
        int insert = super.add(news);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 19:03
     * Description
     * 根据id批量删除新闻
     */
    public ResultData delNewsByIds(List<Integer> ids){
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 19:10
     * Description
     * 根据主键（id）修改新闻
     */
    public ResultData updateNewsBuId(News news){
        news.setGmtModified(new Date());
        Integer update = super.update(news);
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
     * @author yang
     * @date 2020/7/16 19:13
     * Description
     * 查询所有新闻信息
     */
    public ResultData selNews(News news){
        List<News> newsList = super.selectList(news);
        ResultData resultData = new ResultData();
        if (newsList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(newsList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:05
     *Description :查询一条数据
     */
    public ResultData selNewsById(News id) {
        News news = super.selectOne(id);
        if (!news.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(news);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 19:18
     * Description
     * 分页查询新闻信息
     */
    public ResultData selAuditByPage(News news, Integer pageNumber, Integer pageSize) {
        PageInfo<News> userPageInfo = super.selectListByPage(news, pageNumber, pageSize);
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
     * @author yang
     * @date 2020/7/16 19:26
     * Description
     * 根据条件分页查询新闻信息
     */
    public ResultData selNewsByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds ){
        PageInfo<News> newsPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (newsPageInfo.equals("")){
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(newsPageInfo);
        }else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }
}
