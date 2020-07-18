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

    /**
     * @author yang
     * @date 2020/7/17 9:17
     * Description
     * 新闻管理：新增新闻
     */
    @PostMapping("/addNews")
    ResultData addNews(@RequestBody News news) {
        Map<String, Object> addResult = newsService.addNews(news);
        if (OPERATION_SUCCESS.getCode().equals(addResult.get("code"))) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 9:18
     * Description
     * 删除新闻
     */
    @PostMapping("/delNews")
    ResultData delNews(@RequestBody List<Long> ids) {
        Map<String, Object> resultMap = newsService.delNews(ids);
        if (OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 9:26
     * Description
     * 修改新闻信息
     */
    @RequestMapping("/updateNews")
    ResultData updateNews(@RequestBody News news) {
        Map<String, Object> resultMap = newsService.updateNews(news);
        if (OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 10:07
     * Description
     * 查询全部新闻
     */
    @PostMapping("/selectNews")
    public ResultData selectNews() {
        Map<String, Object> resultMap = newsService.selectNews();
        if (OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.operationSuccess(resultMap);
        }
        return super.operationFailed();
    }

    /**
     * @author yang
     * @date 2020/7/17 9:34
     * Description
     * 分页查询全部新闻
     */
    @PostMapping("/selectAllNews")
    ResultData selectAllNews(@RequestBody HashMap map) {
        Map<String, Object> resultMap = newsService.selectAllNews(map, redisService);
        if (OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.operationSuccess(resultMap);
        } else {
            return super.operationFailed();
        }
    }

    /**
     * @author yang
     * @date 2020/7/17 9:56
     * Description
     * 分页条件查询
     */
    @PostMapping("/selectNewsPageInfo")
    ResultData selectNewsPageInfo(HashMap map) {
        return null;

    }
//TODO 分页查询


    public BaseService getBaseService() {
        return null;
    }
}