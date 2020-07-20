package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.MappingUnitMapper;
import com.aaa.lee.model.MappingUnit;
import com.aaa.lee.model.MappingUnit;
import com.github.pagehelper.PageInfo;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.List;

import static com.aaa.lee.staticproerties.TimeFormatProperties.TIME_FORMAT;
import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/19 13:48
 * Description:单位基本信息模块
 */
@Service
public class MappingUnitService extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;
    private ResultData resultData = new ResultData();
/**
 * @author luyu
 * @date 2020/7/19 16:19
 * Description:添加单位、单位注册
 */
public ResultData addMappingUnit(MappingUnit mappingUnit) {
    mappingUnit.setCreateTime(new Date());
    int insert = super.add(mappingUnit);
    if (insert > 0) {
        resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
    } else {
        resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
    }
    return resultData;
}

   /**
    * @author luyu
    * @date 2020/7/19 16:28
    * Description:根据id批量删除单位
    */
    public ResultData delMappingUnitByIds(List<Integer> ids) {
        Integer delete = super.deleteByIds(ids);
        if (delete > 0) {
            resultData.setCode(DELETE_SUCCESS.getCode()).setMsg(DELETE_SUCCESS.getMsg());
        } else {
            resultData.setCode(DELETE_FAILED.getCode()).setMsg(DELETE_FAILED.getMsg());
        }
        return resultData;
    }

   /**
    * @author luyu
    * @date 2020/7/19 16:28
    * Description:根据主键(id)修改单位信息
    */
    public ResultData updateMappingUnitById(MappingUnit mappingUnit) {
        Integer update = super.update(mappingUnit);
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
     * @author luyu
     * @date 2020/7/19 13:51
     * Description:查询所有单位基本信息
     */
    public ResultData selMappingUnit(MappingUnit mappingUnit) {
        ResultData resultData = new ResultData();
        List<MappingUnit> mappingUnitList = super.selectList(mappingUnit);
        if (mappingUnitList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode()).setMsg(SELECT_SUCCESS.getMsg()).setData(mappingUnitList);
        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return  resultData;
    }
 /**
  * @author luyu
  * @date 2020/7/19 16:28
  * Description:分页查询单位信息
  */
    public ResultData selMappingUnitByPage(MappingUnit mappingUnit, Integer pageNumber, Integer pageSize) {
        PageInfo<MappingUnit> mappingUnitPageInfo = super.selectListByPage(mappingUnit, pageNumber, pageSize);
        if (!mappingUnitPageInfo.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(mappingUnitPageInfo);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }
/**
 * @author luyu
 * @date 2020/7/19 16:28
 * Description:根据条件分页查询单位
 */
    public ResultData selMappingUnitByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds ){
        PageInfo<MappingUnit> mappingUnitPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (mappingUnitPageInfo.equals("")){
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(mappingUnitPageInfo);
        }else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;

    }

}
