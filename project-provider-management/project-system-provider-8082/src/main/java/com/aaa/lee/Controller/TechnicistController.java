package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Technicist;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.TechnicistService;
import lombok.extern.slf4j.Slf4j;
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
 * create Time:  2020/7/18 9:19
 * description:
 */
@RestController
@Slf4j
@RequestMapping("/technicist")
public class TechnicistController extends CommonController<Technicist> {
    @Autowired
    private TechnicistService technicistService;
    @Autowired
    private RedisService redisService;

    @Override
    public BaseService<Technicist> getBaseService() {
        return null;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:24
     * Description: 新增技术员
     **/
    @PostMapping("/addTechnicist")
    ResultData addTechnicist(@RequestBody Technicist technicist) {
        Map<String, Object> addResult = technicistService.addTechnicist(technicist);
        if (addResult.get("code").equals(INSERT_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:25
     * Description: 批量删除技术员
     **/
    @PostMapping("/delTechnicist")
    ResultData delTechnicist(@RequestBody List<Long> ids) {
        Map<String, Object> resultMap = technicistService.delTechnicist(ids);
        if (resultMap.get("code").equals(DELETE_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:26
     * Description: 修改技术员信息
     **/
    @PostMapping("/updateTechnicist")
    ResultData updateTechnicist(@RequestBody Technicist technicist) {
        Map<String, Object> resultMap = technicistService.updateTechnicist(technicist);
        if (resultMap.get("code").equals(UPDATE_SUCCESS.getCode())) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:27
     * Description: 查询技术员信息
     **/
    //todo 没有加@RequestBody
    @PostMapping("/selectAllTechnicist")
    ResultData selectAllTechnicist(Technicist technicist) {
        Map<String, Object> resultMap = technicistService.selectAllTechnicist();
        if (resultMap.get("code").equals(SELECT_SUCCESS.getCode())) {
            return super.operationSuccess(resultMap);
        } else {
            return super.operationFailed();
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:52
     * Description: 带条件查询技术员信息
     **/
    @PostMapping("/selectTechnicistPageInfo")
    ResultData selectTechnicistPageInfo(@RequestBody HashMap map) {
        Map<String, Object> userAll = technicistService.selectTechnicistAll(map, redisService);
        if (userAll.get("code").equals(SELECT_SUCCESS.getCode())) {
            return super.operationSuccess(userAll);
        } else {
            return super.operationFailed();
        }
    }

}
