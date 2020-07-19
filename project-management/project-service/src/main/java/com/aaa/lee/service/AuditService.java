package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.AuditMapper;
import com.aaa.lee.model.Audit;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.List;

import static com.aaa.lee.status.OperationStatus.*;
/**
 * @author Yang
 * @date 2020-07-19 14:01
 */
@Service
@Slf4j
public class AuditService extends BaseService<Audit> {
    @Autowired
    private AuditMapper auditMapper;

    private ResultData resultData = new ResultData();

    /**
     * @author : yang
     * @date : 2020/7/19 14:07
     *Description :添加审核信息
     */
    public ResultData addAudit(Audit audit){
        audit.setCreateTime(new Date());
        int insert = super.add(audit);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/19 14:14
     *Description :根据id批量删除审核信息
     */
    public ResultData delAuditByIds(List<Integer> ids){
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/19 14:18
     *Description :根据主键（id）修改审核信息
     */
    public ResultData updateAuditBuId(Audit audit){
        Integer update = super.update(audit);
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
     * @author : yang
     * @date : 2020/7/19 14:20
     *Description :查询所有审核信息
     */
    public ResultData selAudit(Audit audit){
        List<Audit> auditList = super.selectList(audit);
        ResultData resultData = new ResultData();
        if (auditList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(auditList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/19 14:22
     *Description :查询一条数据
     */
    public ResultData selAuditById(Audit id) {
        Audit audit = super.selectOne(id);
        if (!audit.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(audit);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/19 14:23
     *Description :分页查询审核信息
     */
    public ResultData selAuditByPage(Audit audit, Integer pageNumber, Integer pageSize) {
        PageInfo<Audit> userPageInfo = super.selectListByPage(audit, pageNumber, pageSize);
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
     * @author : yang
     * @date : 2020/7/19 14:24
     *Description :根据条件分页查询审核信息
     */
    public ResultData selAuditByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds ){
        PageInfo<Audit> auditPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (auditPageInfo.equals("")){
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(auditPageInfo);
        }else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }
}
