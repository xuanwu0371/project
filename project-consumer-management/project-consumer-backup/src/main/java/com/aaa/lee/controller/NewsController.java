package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.News;
import com.aaa.lee.service.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yang
 * @date 2020-07-16 20:19
 */
@RestController
@RequestMapping("/news")
@Api(value = "新闻管理",tags = "新闻管理接口")
public class NewsController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * @author yang
     * @date 2020/7/16 20:20
     *Description
     *       新增新闻
     */
    @PostMapping("/addNews")
    @ApiOperation(value = "添加新闻",notes = "新闻管理的新增新闻")
    public ResultData addNews(@RequestBody News news){
        return iProjectService.addNews(news);
    }

    /**
     * @author yang
     * @date 2020/7/17 10:44
     *Description
     * 删除新闻
     */
    @PostMapping("/delNews")
    @ApiOperation(value = "删除新闻",notes ="新闻管理的删除新闻")
    public ResultData delNews(@RequestBody List<Long> ids){
        return iProjectService.delNews(ids);
    }

    /**
     * @author yang
     * @date 2020/7/17 10:47
     *Description
     * 修改新闻信息
     */
    @PostMapping("/updateNews")
    @ApiOperation(value = "修改新闻",notes = "新闻管理的修改新闻信息")
    public ResultData updateNews(@RequestBody News news){
        return iProjectService.updateNews(news);
    }

    /**
     * @author yang
     * @date 2020/7/17 10:49
     *Description
     * 查询所有新闻
     */
    @PostMapping("/selectNews")
    @ApiOperation(value = "查询新闻",notes = "新闻管理的下旬新闻")
    public ResultData selectNews(News news){
        return iProjectService.selectNews(news);
    }
    //todo 杨海鹏

}
