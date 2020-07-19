package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.DictMapper;
import com.aaa.lee.model.Dict;
import com.aaa.lee.model.User;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @Author: Lee ShiHao
 * @date : 2020/7/19 14:32
 * Description: 字典管理
**/
@Service
public class DictService extends BaseService<Dict> {

    @Autowired
    private DictMapper dictMapper;
    private ResultData resultData = new ResultData<>();

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:32
     * Description: 新增字典
    **/
    public ResultData addDict(Dict dict) {
        int insert = super.add(dict);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:33
     * Description: 通过id批量删除字典
    **/
    public ResultData delDictByIds(List<Integer> ids) {
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:34
     * Description: 根据主键(id)修改字典信息
    **/
    public ResultData updateDictById(Dict dict) {
        Integer update = super.update(dict);
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
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:39
     * Description: 根据条件分页查询字典
    **/
    public ResultData SelDictByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds ){
        PageInfo<Dict> dictPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (dictPageInfo.equals("")){
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(dictPageInfo);
        }else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }



}
