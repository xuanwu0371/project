package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.CheckPerson;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

/**
 * @author Yang
 * @date 2020-07-19 16:19
 */
@RestController
@RequestMapping("/checkPerson")
public class CheckPersonController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @author : yang
     * @date : 2020/7/19 16:20
     *Description :新增抽查人员信息
     */
    @PostMapping("/addCheckPerson")
    public ResultData addCheckPerson(@RequestBody CheckPerson checkPerson) {
       return iProjectService.addCheckPerson(checkPerson);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:22
     *Description :根据id批量删除抽查人员信息
     */
    @PostMapping("/delCheckPersonByIds")
    public ResultData delCheckPersonByIds(@RequestBody Integer[] ids) {
        return iProjectService.delCheckPersonByIds(ids);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:23
     *Description :根据主键(id)修改抽查人员信息
     */
    @PostMapping("/updateCheckPersonById")
    public ResultData updateCheckPersonById(CheckPerson checkPerson){
      return iProjectService.updateCheckPersonById(checkPerson);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:23
     *Description :查询所有抽查人员信息
     */
    @PostMapping("/selCheckPerson")
    public ResultData selCheckPerson(CheckPerson checkPerson) {
       return iProjectService.selCheckPerson(checkPerson);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:24
     *Description :查询一条数据
     */
    @PostMapping("/selCheckPersonById")
    public ResultData selCheckPersonById(@RequestBody CheckPerson id) {
        return iProjectService.selCheckPersonById(id);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:24
     *Description :分页查询抽查人员信息
     */
    @PostMapping("/selCheckPersonByPage")
    public ResultData selCheckPersonByPage(CheckPerson checkPerson,Integer pageNumber,Integer pageSize){
       return iProjectService.selCheckPersonByPage(checkPerson,pageNumber,pageSize);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:25
     *Description :根据条件分页查询抽查人员信息
     */
    @PostMapping("/selCheckPersonByPageFiled")
    public ResultData selCheckPersonByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        return iProjectService.selCheckPersonByPageFiled(number, pageSize, where, orderFiled, fileds);
    }
}
