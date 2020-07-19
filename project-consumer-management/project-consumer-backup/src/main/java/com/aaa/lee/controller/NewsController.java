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
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @author Yang
 * @date 2020-07-16 20:19
 */
@RestController
@RequestMapping("/news")
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
    public ResultData addNews(@RequestBody News news) {
        return iProjectService.addNews(news);
    }

    /**
     * @author yang
     * @date 2020/7/17 10:44
     *Description
     * 根据id批量删除新闻
     */
    @PostMapping("/delNewsByIds")
    public ResultData delNewsByIds(@RequestBody Integer[] ids) {
       return iProjectService.delNewsByIds(ids);
    }

    /**
     * @author yang
     * @date 2020/7/17 10:47
     *Description
     * 根据主键(id)修改新闻信息
     */
    @RequestMapping("/updateNewsById")
    public ResultData updateNewsById(News news) {
       return iProjectService.updateNewsById(news);
    }

    /**
     * @author yang
     * @date 2020/7/17 10:49
     *Description
     * 查询所有新闻
     */
    @PostMapping("/selNews")
    public ResultData selNews(News news) {
        return iProjectService.selNews(news);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:35
     *Description :查询一条数据
     */
    @PostMapping("/selNewsById")
    public ResultData selNewsById(@RequestBody News id) {
       return iProjectService.selNewsById(id);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:35
     *Description :分页查询新闻
     */
    @PostMapping("/selNewsByPage")
    public ResultData selNewsByPage(News news,Integer pageNumber,Integer pageSize){
       return iProjectService.selNewsByPage(news,pageNumber,pageSize);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:36
     *Description :根据条件分页查询新闻
     */
    @PostMapping("/selNewsByPageFiled")
    public ResultData selNewsByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        return iProjectService.selNewsByPageFiled(number, pageSize, where, orderFiled, fileds);
    }
}
