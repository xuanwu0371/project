package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.mapper.CheckPersonMapper;
import com.aaa.lee.model.CheckPerson;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author Yang
 * @date 2020-07-19 14:26
 */
@Service
@Slf4j
public class CheckPersonService extends BaseService<CheckPerson> {
    @Autowired
    private CheckPersonMapper checkPersonMapper;

    private ResultData resultData = new ResultData();

    /**
     * @author : yang
     * @date : 2020/7/19 14:35
     *Description :新增抽查人员
     */
    public ResultData addCheckPerson(CheckPerson checkPerson){
        checkPerson.setCreateTime(new Date());
        int insert = super.add(checkPerson);
        if (insert > 0) {
            resultData.setCode(INSERT_SUCCESS.getCode()).setMsg(INSERT_SUCCESS.getMsg());
        } else {
            resultData.setCode(INSERT_FAILED.getCode()).setMsg(INSERT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/19 14:39
     *Description :根据id批量删除抽查人员
     */
    public ResultData delCheckPersonByIds(List<Integer> ids){
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
     * @date : 2020/7/19 14:41
     *Description :根据主键(id)修改抽查人员信息
     */
    public ResultData updateCheckPersonById(CheckPerson checkPerson){
        checkPerson.setModifyTime(new Date());
        Integer update = super.update(checkPerson);
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
     * @date : 2020/7/19 14:42
     *Description :查询所有抽查人员信息
     */
    public  ResultData selCheckPerson(CheckPerson checkPerson){
        List<CheckPerson> checkPersonList = super.selectList(checkPerson);
        ResultData resultData = new ResultData();
        if (checkPersonList.size() > 0) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(checkPersonList);

        } else {
            resultData.setCode(SELECT_FAILED.getCode()).setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/19 14:44
     *Description :查询一条数据
     */
    public ResultData selCheckPersonBuId(CheckPerson id){
        CheckPerson checkPerson = super.selectOne(id);
        if (!checkPerson.equals("")) {
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(checkPerson);
        } else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/19 14:45
     *Description :分页查询抽查人员信息
     */
    public ResultData selCheckPersonByPage(CheckPerson checkPerson, Integer pageNumber, Integer pageSize) {
        PageInfo<CheckPerson> userPageInfo = super.selectListByPage(checkPerson, pageNumber, pageSize);
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
     * @date : 2020/7/19 14:48
     *Description :根据条件分页查询抽查人员信息
     */
    public ResultData selCheckPersonByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds ){
        PageInfo<CheckPerson> checkPersonPageInfo = super.selectListByPageAndFiled(number, pageSize, where, orderFiled, fileds);
        if (checkPersonPageInfo.equals("")){
            resultData.setCode(SELECT_SUCCESS.getCode())
                    .setMsg(SELECT_SUCCESS.getMsg())
                    .setData(checkPersonPageInfo);
        }else {
            resultData.setCode(SELECT_FAILED.getCode())
                    .setMsg(SELECT_FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * @author : yang
     * @date : 2020/7/21 16:43
     *Description :根据抽查比例查询抽查人员信息
     */
    public ResultData selCheckPersonProportion(Integer proportion){

        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (proportion != null) {
          List<Map> result = checkPersonMapper.selCheckPersonProportion(proportion);
        } else {

        }
        return null;
    }
}
