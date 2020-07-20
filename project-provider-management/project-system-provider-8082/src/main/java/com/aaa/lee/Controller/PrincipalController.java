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
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/19 14:44
 * Description:负责人模块
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
     * @Author: luyu
     * @date : 2020/7/16 11:17
     * Description: 新增负责人
     **/
    @PostMapping("/addPrincipal")
    public ResultData addPrincipal(@RequestBody Principal principal) {
        ResultData resultData = principalService.addPrincipal(principal);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }


    /**
     * @Author: luyu
     * @date : 2020/7/18 20:44
     * Description: 根据id批量删除负责人
     **/
    @PostMapping("/delPrincipalByIds")
    public ResultData delPrincipalByIds(@RequestBody Integer[] ids) {
        ResultData resultData = super.batchDelete(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();

    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 9:53
     * Description: 根据主键(id)修改负责人信息
     **/
    @PostMapping("/updatePrincipalById")
    public ResultData updatePrincipalById(Principal principal) {
        ResultData resultData = principalService.updatePrincipalById(principal);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @Author: luyu
     * @date : 2020/7/17 22:08
     * Description: 查询所有负责人
     **/
    @PostMapping("/selPrincipal")
    public ResultData selPrincipal(Principal principal) {
        ResultData resultData = principalService.selPrincipal(principal);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 14:46
     * Description:分页查询负责人
     */
    @PostMapping("/selPrincipalByPage")
    public ResultData selPrincipalByPage(Principal principal, Integer pageNumber, Integer pageSize) {
        ResultData resultData = principalService.selPrincipalByPage(principal, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 14:48
     * Description:根据条件分页查询负责人
     */
    @PostMapping("/selPrincipalByPageFiled")
    public ResultData selPrincipalByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        ResultData resultData = principalService.selPrincipalByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

}
