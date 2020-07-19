package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Dict;

import com.aaa.lee.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * create by: LiShiHao
 * create Time:  2020/7/17 11:22
 * description:字典管理的provider
 */
@RestController
@RequestMapping("/dict")
public class DictController extends CommonController<Dict> {
    @Autowired
    private DictService DictService;
    @Override
    public BaseService<Dict> getBaseService() {
        return DictService;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:42
     * Description: 新增字典
    **/
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict Dict) {
        ResultData resultData = DictService.addDict(Dict);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }



    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:42
     * Description: 根据id批量删除字典
    **/
    @PostMapping("/delDictByIds")
    public ResultData delDictByIds(@RequestBody Integer[] ids) {
        ResultData resultData = super.batchDelete(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();

    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:42
     * Description: 根据主键更新字典
    **/
    @PostMapping("/updateDictById")
    public ResultData updateDictById(Dict Dict){
        ResultData resultData = DictService.updateDictById(Dict);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:43
     * Description: 根据条件分页查询字典
    **/
    @PostMapping("/SelDictByPageFiled")
    public ResultData SelDictByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        ResultData resultData = DictService.SelDictByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

}
