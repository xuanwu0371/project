package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.mapper.DictMapper;
import com.aaa.lee.model.Dict;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * create by: LiShiHao
 * create Time:  2020/7/17 10:54
 * description:字典管理的service
 */
@Service
public class DictService extends BaseService<Dict> {

    @Autowired
    private DictMapper dictMapper;


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:13
     * Description: 新增字典信息
     **/
    public Map<String, Object> insertDict(Dict dict) {
        Map<String, Object> resultMap = new HashMap<>();
        int i = dictMapper.insert(dict);
        if (i > 0) {
            resultMap.put("code", INSERT_SUCCESS.getCode());
            resultMap.put("msg", INSERT_SUCCESS.getMsg());
        } else {
            resultMap.put("code",INSERT_FAILED .getCode());
            resultMap.put("msg", INSERT_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:03
     * Description: 通过id批量删除字典
     **/
    public Map<String, Object> delDictsById(List<Long> ids) {
        Map<String, Object> resultMap = new HashMap<>();
        //获取参数类型,添加一个where条件
        Example id = Example.builder(Dict.class).where(Sqls.custom().andIn("id", ids)).build();
        int i = dictMapper.deleteByExample(id);
        if (i > 0) {
            resultMap.put("code",DELETE_SUCCESS .getCode());
            resultMap.put("msg", DELETE_SUCCESS.getMsg());
        } else {
            resultMap.put("code", DELETE_FAILED.getCode());
            resultMap.put("msg", DELETE_FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:09
     * Description: 修改字典信息
     **/
    public Map<String, Object> updateDict(Dict dict) {
        Map<String, Object> resultMap = new HashMap<>();
        if (dict != null) {
            int i = dictMapper.updateByPrimaryKey(dict);
            if (i > 0) {
                resultMap.put("code", UPDATE_SUCCESS.getCode());
                resultMap.put("msg", UPDATE_SUCCESS.getMsg());

            } else {
                resultMap.put("code",UPDATE_FAILED .getCode());
                resultMap.put("msg",UPDATE_FAILED .getMsg());

            }
        } else {
            resultMap.put("code", UPDATE_FAILED.getCode());
            resultMap.put("msg",UPDATE_FAILED .getMsg());
        }
        return resultMap;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 10:55
     * Description: 分页查询字典
     **/
    public Map<String, Object> selectAllDictByPage(HashMap hashMap) {
        Map<String, Object> resultMap = new HashMap<>();
        Dict dict = new Dict();
        PageInfo<Dict> dictPageInfo = super.selectListByPage(dict, BaseUtil.transToInt(hashMap.get("pageNo")), BaseUtil.transToInt(hashMap.get("pageNumber")));
        if (null != dictPageInfo && dictPageInfo.getSize() > 0) {
            resultMap.put("code", SELECT_SUCCESS.getCode());
            resultMap.put("msg", SELECT_SUCCESS.getMsg());
            resultMap.put("data", dictPageInfo);
        } else {
            resultMap.put("code", SELECT_FAILED.getCode());
            resultMap.put("msg", SELECT_FAILED.getMsg());
        }
        return resultMap;
    }


}
