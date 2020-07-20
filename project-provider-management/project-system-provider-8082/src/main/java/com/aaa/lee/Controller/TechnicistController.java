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
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/19 15:21
 * Description:技术人员模块
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
     * @author luyu
     * @date 2020/7/19 15:21
     * Description:新增技术人员
     */
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(@RequestBody Technicist technicist) {
        ResultData resultData = technicistService.addTechnicist(technicist);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:23
     * Description:根据id批量删除技术人员
     */
    @PostMapping("/delTechnicistByIds")
    public ResultData delTechnicist(@RequestBody Integer[] ids) {
        ResultData resultData = super.batchDelete(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:27
     * Description:根据主键（id）修改技术人员信息
     */
    @PostMapping("/updateTechnicistById")
    public ResultData updateTechnicistById(@RequestBody Technicist technicist) {
        ResultData resultData = technicistService.updateTechnicistById(technicist);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:29
     * Description:查询所有技术人员信息
     */
    @PostMapping("/selTechnicist")
    public ResultData selTechnicist(Technicist technicist) {
        ResultData resultData = technicistService.selTechnicist(technicist);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:31
     * Description:分页查询技术人员信息
     */
    @PostMapping("/selTechnicistByPage")
    public ResultData selTechnicistByPage(Technicist technicist, Integer pageNumber, Integer pageSize) {
        ResultData resultData = technicistService.selTechnicistByPage(technicist, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:33
     * Description:根据条件分页查询技术人员信息
     */

    @PostMapping("/selTechnicistByPageFiled")
    public ResultData selTechnicistByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        ResultData resultData = technicistService.selTechnicistByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }


}
