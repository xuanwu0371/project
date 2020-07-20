package com.aaa.lee.controller;

import com.aaa.lee.base.BaseController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.Principal;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;

import java.util.HashMap;
import java.util.List;

/**
 * @author luyu
 * @date 2020/7/19 15:04
 * Description:负责人模块
 */
@RestController
@RequestMapping("/principal")
public class PrincipalController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @author luyu
     * @date 2020/7/19 17:00
     * Description:新增负责人
     */
    @PostMapping("/addPrincipal")
    ResultData addPrincipal(Principal principal) {
        return iProjectService.addPrincipal(principal);
    }

    /**
     * @author luyu
     * @date 2020/7/19 17:00
     * Description:通过id批量删除负责人
     */
    @PostMapping("/delPrincipalByIds")
    ResultData delPrincipalByIds(@RequestBody Integer[] ids) {
        return iProjectService.delPrincipalByIds(ids);
    }

    /**
     * @author luyu
     * @date 2020/7/19 17:00
     * Description:通过主键修改负责人
     */
    @PostMapping("/updatePrincipalById")
    ResultData updatePrincipalById(Principal principal) {
        return iProjectService.updatePrincipalById(principal);
    }

    /**
     * @author luyu
     * @date 2020/7/19 14:58
     * Description:查询全部负责人
     */
    @PostMapping("/selPrincipal")
    ResultData selPrincipal(Principal principal) {
        return iProjectService.selPrincipal(principal);
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:04
     * Description:分页查询负责人
     */
    @PostMapping("/selPrincipalByPage")
    ResultData selPrincipalByPage(Principal principal, Integer pageNumber, Integer pageSize) {
        return iProjectService.selPrincipalByPage(principal, pageNumber, pageSize);
    }

    /**
     * @author luyu
     * @date 2020/7/19 15:04
     * Description:根据条件分页查询负责人
     */
    @PostMapping("/selPrincipalByPageFiled")
    ResultData selPrincipalByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return iProjectService.selPrincipalByPageFiled(number, pageSize, where, orderFiled, fileds);
    }

}
