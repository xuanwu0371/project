package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Audit;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

/**
 * @author Yang
 * @date 2020-07-19 16:10
 */
@RestController
@RequestMapping("/audit")
public class AuditController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @author : yang
     * @date : 2020/7/19 16:11
     *Description :新增审核信息
     */
    @PostMapping("/addAudit")
    public ResultData addAudit(@RequestBody Audit audit){
        return iProjectService.addAudit(audit);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:14
     *Description :根据id批量删除审核信息
     */
    @PostMapping("/delAuditByIds")
    public ResultData delAuditByIds(@RequestBody Integer[] ids) {
        return iProjectService.delAudit(ids);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:15
     *Description :根据主键(id)修改审核信息
     */
    @PostMapping("/updateAuditById")
    public ResultData updateAuditById(Audit audit){
        return iProjectService.updateAuditBuId(audit);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:15
     *Description :查询所有审核信息
     */
    @PostMapping("/selAudit")
    public ResultData selAudit(Audit audit) {
       return iProjectService.selAudit(audit);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:16
     *Description :查询一条数据
     */
    @PostMapping("/selAuditById")
    public ResultData selAuditById(@RequestBody Audit id) {
        return iProjectService.selAuditById(id);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:17
     *Description :分页查询审核信息
     */
    @PostMapping("/selAuditByPage")
    public ResultData selAuditByPage(Audit audit,Integer pageNumber,Integer pageSize){
        return iProjectService.selAuditByPage(audit, pageNumber, pageSize);
    }

    /**
     * @author : yang
     * @date : 2020/7/19 16:17
     *Description :根据条件分页查询审核信息
     */
    @PostMapping("/selAuditByPageFiled")
    public ResultData selAuditByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return iProjectService.selAuditByPageFiled(number, pageSize, where, orderFiled, fileds);
    }

}
