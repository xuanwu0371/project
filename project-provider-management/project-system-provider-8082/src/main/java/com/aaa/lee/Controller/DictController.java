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
        Map<String, Object> insertDict = dictService.insertDict(dict);
        if (insertDict.get("msg").equals("新增成功")){
            return super.insertOperationSuccess();
        }else {
            return super.insertOperationFailed();
        }
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:41
     * Description: 通过id批量删除字典
    **/
    @PostMapping("/delDictsById")
    public ResultData delDictsById(@RequestBody List<Long> ids){
        Map<String, Object> delDict = dictService.delDictsById(ids);
        if (delDict.get("msg").equals("删除成功")){
            return super.deleteOperationSuccess();
        }else {
            return super.deleteOperationFailed();
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:34
     * Description: 修改字典信息
    **/
    @PostMapping("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
        Map<String, Object> updateDict = dictService.updateDict(dict);
        if (updateDict.get("msg").equals("修改成功")){
            return super.updateOperationSuccess();
        }else {
            return super.updateOperationFailed();
        }
    }
    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:24
     * Description: 分页查询字典
     **/
    @PostMapping("/selectAllDictByPage")
    public ResultData selectAllDictByPage(@RequestBody HashMap hashMap){
        Map<String, Object> AllDict = dictService.selectAllDictByPage(hashMap);
        if (AllDict.get("msg").equals("查询成功")){
            return super.selectOperationSuccess();
        }else {
            return super.selectOperationSuccess();
        }
    }

}
