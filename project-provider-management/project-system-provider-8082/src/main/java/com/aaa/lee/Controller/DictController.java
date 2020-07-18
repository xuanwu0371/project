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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private DictService dictService;
    @Override
    public BaseService<Dict> getBaseService() {
        return null;
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:29
     * Description: 新增字典信息
     **/
    @PostMapping("/insertDict")
    public ResultData insertDict(@RequestBody Dict dict){
        Map<String, Object> result = dictService.insertDict(dict);
        if (result.get("code").equals(INSERT_SUCCESS)){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:41
     * Description: 通过id批量删除字典
    **/
    @PostMapping("/delDictsById")
    public ResultData delDictsById(@RequestBody List<Long> ids){
        Map<String, Object> result = dictService.delDictsById(ids);
        if (result.get("code").equals(DELETE_SUCCESS)){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:34
     * Description: 修改字典信息
    **/
    @PostMapping("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
        Map<String, Object> result = dictService.updateDict(dict);
        if (result.get("code").equals(UPDATE_SUCCESS)){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:24
     * Description: 分页查询字典
     **/
    @PostMapping("/selectAllDictByPage")
    public ResultData selectAllDictByPage(@RequestBody HashMap hashMap){
        Map<String, Object> result = dictService.selectAllDictByPage(hashMap);
        if (result.get("code").equals(SELECT_SUCCESS)){
            return super.operationSuccess(result);
        }else {
            return super.operationFailed();
        }
    }

}
