package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Principal;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.PrincipalService;
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
 * create Time:  2020/7/17 22:04
 * description:
 */
@RestController
@Slf4j
@RequestMapping("/principal")
public class PrincipalController extends CommonController<Principal> {
    @Autowired
    private PrincipalService principalService;
    @Autowired
    private RedisService redisService;

    @Override
    public BaseService<Principal> getBaseService() {
        return null;
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 新增重要人
     **/
    @PostMapping("/addPrincipal")
    ResultData addPrincipal(@RequestBody Principal principal) {
        Map<String, Object> addResult = principalService.addPrincipal(principal);
        if (OPERATION_SUCCESS.getCode().equals(addResult.get("code"))) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 批量删除重要人
     **/
    @PostMapping("/delPrincipal")
    ResultData delPrincipal(@RequestBody List<Long> ids) {
        Map<String, Object> resultMap = principalService.delPrincipal(ids);
        if (OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 修改重要人信息
     **/
    @PostMapping("/updatePrincipal")
    ResultData updatePrincipal(@RequestBody Principal principal) {
        Map<String, Object> resultMap = principalService.updatePrincipal(principal);
        if (OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.operationSuccess();
        }
        return super.operationFailed();

    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:08
     * Description: 查询重要人信息
     **/
    //todo 没有加@RequestBody
    @PostMapping("/selectPrincipalAll")
    ResultData selectPrincipalAll(Principal principal) {
        Map<String, Object> resultMap = principalService.selectPrincipalAll();
        if (OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.operationSuccess(resultMap);
        } else {
            return super.operationFailed();
        }
    }

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:09
     * Description: 带条件查询重要人信息
     **/
    @PostMapping("/selectPrincipal")
    ResultData selectPrincipal(@RequestBody HashMap map) {
        Map<String, Object> principalAll = principalService.selectPrincipalsAll(map, redisService);
        if (OPERATION_SUCCESS.getCode().equals(principalAll.get("code"))) {
            return super.operationSuccess(principalAll);
        } else {
            return super.operationFailed();
        }
    }

}
