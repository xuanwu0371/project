package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.SpecialPost;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * @author luyu
 * @date 2020/7/20 9:42
 * Description:特殊人员模块
 */
@RestController
@RequestMapping("/specialPost")
public class SpecialPostController extends CommonController<SpecialPost> {
    @Autowired
    private SpecialPostService specialPostService;
    @Autowired
    private RedisService redisService;

    @Override
    public BaseService<SpecialPost> getBaseService() {
        return specialPostService;
    }


    /**
     * @Author: luyu
     * @date : 2020/7/16 11:17
     * Description: 新增特殊人员
     **/
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(@RequestBody SpecialPost specialPost) {
        ResultData resultData = specialPostService.addSpecialPost(specialPost);
        return (resultData.getCode().equals(INSERT_SUCCESS.getCode()))
                ? resultData : super.insertOperationFailed();
    }


    /**
     * @Author: luyu
     * @date : 2020/7/18 20:44
     * Description: 根据id批量删除特殊人员
     **/
    @PostMapping("/delSpecialPostByIds")
    public ResultData delSpecialPostByIds(@RequestBody Integer[] ids) {
        ResultData resultData = super.batchDelete(ids);
        return resultData.getCode().equals(operationSuccess().getCode()) ?
                resultData : super.deleteOperationFailed();

    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 9:53
     * Description: 根据主键(id)修改特殊人员信息
     **/
    @PostMapping("/updateSpecialPostById")
    public ResultData updateSpecialPostById(SpecialPost specialPost) {
        ResultData resultData = specialPostService.updateSpecialPostById(specialPost);
        return resultData.getCode().equals(UPDATE_SUCCESS.getCode()) ?
                resultData : super.updateOperationFailed();
    }

    /**
     * @Author: luyu
     * @date : 2020/7/18 21:03
     * Description: 查询所有特殊人员
     **/
    @PostMapping("/selSpecialPost")
    public ResultData selSpecialPost(SpecialPost specialPost) {
        ResultData resultData = specialPostService.selSpecialPost(specialPost);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 9:57
     * Description: 分页查询特殊人员
     **/
    @PostMapping("/selSpecialPostByPage")
    public ResultData selSpecialPostByPage(SpecialPost specialPost, Integer pageNumber, Integer pageSize) {
        ResultData resultData = specialPostService.selSpecialPostByPage(specialPost, pageNumber, pageSize);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }

    /**
     * @Author: luyu
     * @date : 2020/7/19 10:13
     * Description: 根据条件分页查询特殊人员
     **/
    @PostMapping("/selSpecialPostByPageFiled")
    public ResultData selSpecialPostByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        ResultData resultData = specialPostService.selSpecialPostByPageFiled(number, pageSize, where, orderFiled, fileds);
        return resultData.getCode().equals(SELECT_SUCCESS.getCode()) ?
                resultData : super.selectOperationFailed();
    }


}
