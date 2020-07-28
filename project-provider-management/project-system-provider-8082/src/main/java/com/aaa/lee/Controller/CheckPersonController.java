package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.CheckPerson;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.CheckPersonService;
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
 * @date 2020-07-19 15:20
 */
@RestController
@Slf4j
@RequestMapping("/checkPerson")
public class CheckPersonController extends CommonController<CheckPerson> {
    @Autowired
    private CheckPersonService checkPersonService;
    @Autowired
    private RedisService redisService;
    @Override
    public BaseService<CheckPerson> getBaseService() {
        return null;
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:23
     *Description :新增抽查人员信息
     */
    @PostMapping("/addCheckPerson")
    public ResultData addCheckPerson( CheckPerson checkPerson) {
        ResultData resultData = checkPersonService.addCheckPerson(checkPerson);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:24
     *Description :根据id批量删除抽查人员信息
     */
    @PostMapping("/delCheckPersonByIds")
    public ResultData delCheckPersonByIds( List<Integer> ids) {
        ResultData resultData = checkPersonService.delCheckPersonByIds(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();

    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:24
     *Description :根据主键(id)修改抽查人员信息
     */
    @PostMapping("/updateCheckPersonById")
    public ResultData updateCheckPersonById( CheckPerson checkPerson){
        ResultData resultData = checkPersonService.updateCheckPersonById(checkPerson);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:24
     *Description :查询所有抽查人员信息
     */
    @PostMapping("/selCheckPerson")
    public ResultData selCheckPerson(CheckPerson checkPerson) {
        ResultData resultData = checkPersonService.selCheckPerson(checkPerson);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:25
     *Description :查询一条数据
     */
    @PostMapping("/selCheckPersonById")
    public ResultData selCheckPersonById( CheckPerson id) {
        ResultData resultData = checkPersonService.selCheckPersonBuId(id);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:25
     *Description :分页查询抽查人员信息
     */
    @PostMapping("/selCheckPersonByPage")
    public ResultData selCheckPersonByPage(CheckPerson checkPerson,Integer pageNumber,Integer pageSize){
        ResultData resultData = checkPersonService.selCheckPersonByPage(checkPerson, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
    
    /**
     * @author : yang
     * @date : 2020/7/19 15:25
     *Description :根据条件分页查询抽查人员信息
     */
    @PostMapping("/selCheckPersonByPageFiled")
    public ResultData selCheckPersonByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        ResultData resultData = checkPersonService.selCheckPersonByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }
}
