package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Audit;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author Yang
 * @date 2020-07-19 15:11
 */
@RestController
@Slf4j
@RequestMapping("/audit")
public class AuditController extends CommonController<Audit> {
    @Autowired
    private AuditService auditService;
    @Autowired
    private RedisService redisService;
    @Override
    public BaseService<Audit> getBaseService() {
        return null;
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:14
     *Description :新增审核信息
     */
    @PostMapping("/addAudit")
    public ResultData addAudit( Audit audit) {
        ResultData resultData = auditService.addAudit(audit);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:15
     *Description :根据id批量删除审核信息
     */
    @PostMapping("/delAuditByIds")
    public ResultData delAuditByIds( Audit ids) {
        ResultData resultData = auditService.delAuditByIds(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();

    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:15
     *Description :根据主键(id)修改审核信息
     */
    @PostMapping("/updateAuditById")
    public ResultData updateAuditById( Audit audit){
        ResultData resultData = auditService.updateAuditBuId(audit);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:15
     *Description :查询所有审核信息
     */
    @PostMapping("/selAudit")
    public ResultData selAudit(Audit audit) {
        ResultData resultData = auditService.selAudit(audit);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:16
     *Description :通过审核信息名称查询一条数据
     */
    @PostMapping("/selAuditByAuditName")
    public ResultData selAuditByAuditName( Audit auditName) {
        ResultData resultData = auditService.selAuditByAuditName(auditName);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    
    /**
     * @author : yang
     * @date : 2020/7/19 15:16
     *Description :分页查询审核信息
     */
    @PostMapping("/selAuditByPage")
    public ResultData selAuditByPage(Audit audit,Integer pageNumber,Integer pageSize){
        ResultData resultData = auditService.selAuditByPage(audit, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:16
     *Description :根据条件分页查询审核信息
     */
    @PostMapping("/selAuditByPageFiled")
    public ResultData selAuditByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        ResultData resultData = auditService.selAuditByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
}
