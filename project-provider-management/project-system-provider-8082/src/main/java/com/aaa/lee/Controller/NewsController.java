package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.News;
import com.aaa.lee.redis.RedisService;

import com.aaa.lee.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author Yang
 * @date 2020-07-16 19:59
 */
@RestController
@Slf4j
@RequestMapping("/news")
public class NewsController extends CommonController<News> {

    @Autowired
    private NewsService newsService;
    @Autowired
    private RedisService redisService;
    public BaseService getBaseService() {
        return newsService;
    }

    /**
     * @author yang
     * @date 2020/7/17 9:17
     * Description
     * 新增新闻
     */
    @PostMapping("/addNews")
    public ResultData addNews( News news) {
        ResultData resultData = newsService.addNews(news);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 9:18
     * Description
     * 根据id批量删除新闻
     */
    @PostMapping("/delNewsByIds")
    public ResultData delNewsByIds( List<Integer> ids) {
        ResultData resultData = newsService.delNewsByIds(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 9:26
     * Description
     * 根据主键(id)修改新闻信息
     */
    @RequestMapping("/updateNewsById")
    public ResultData updateNewsById( News news) {
        ResultData resultData = newsService.updateNewsBuId(news);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 10:07
     * Description
     * 查询全部新闻
     */
    @PostMapping("/selNews")
    public ResultData selNews(News news) {
        ResultData resultData = newsService.selNews(news);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author : yang
     * @date : 2020/7/19 15:44a
     *Description :查询一条数据
     */
    @PostMapping("/selNewsById")
    public ResultData selNewsById( News id) {
        ResultData resultData = newsService.selNewsById(id);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 9:34
     * Description
     * 分页查询新闻
     */
    @PostMapping("/selNewsByPage")
    public ResultData selNewsByPage(News news,Integer pageNumber,Integer pageSize){
        ResultData resultData = newsService.selAuditByPage(news, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 9:56
     * Description
     * 根据条件分页查询新闻
     */
    @PostMapping("/selNewsByPageFiled")
    public ResultData selNewsByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        ResultData resultData = newsService.selNewsByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
}