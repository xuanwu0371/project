package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Dict;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

/**
 * create by: LiShiHao
 * create Time:  2020/7/19 15:33
 * description:
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:35
     * Description: 新增字典
     **/
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict Dict) {
        return iProjectService.addDict(Dict);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:36
     * Description: 根据id批量删除字典
     **/
    @PostMapping("/delDictByIds")
    public ResultData delDictByIds(@RequestBody Integer[] ids) {
        return iProjectService.delDictByIds(ids);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:36
     * Description: 根据主键更新字典
     **/
    @PostMapping("/updateDictById")
    public ResultData updateDictById(Dict Dict) {
        return iProjectService.updateDictById(Dict);
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:36
     * Description: 根据条件查询字典
     **/
    @PostMapping("/SelDictByPageFiled")
    public ResultData SelDictByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return iProjectService.SelDictByPageFiled(number, pageSize, where, orderFiled, fileds);
    }
}
