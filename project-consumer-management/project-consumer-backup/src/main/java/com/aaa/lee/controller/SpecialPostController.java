package com.aaa.lee.controller;

import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.SpecialPost;
import com.aaa.lee.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.Sqls;
/**
 * @author luyu
 * @date 2020/7/20 9:47
 * Description:
 */
@RestController
@RequestMapping("/specialPost")
public class SpecialPostController {

    @Autowired
    private IProjectService iProjectService;
    /**
     * @author luyu
     * @date 2020/7/20 9:49
     * Description:新增特殊人员
     */
    @PostMapping("/addSpecialPost")
    public  ResultData addSpecialPost(@RequestBody SpecialPost specialPost){
        return iProjectService.addSpecialPost(specialPost);
    }
/**
 * @author luyu
 * @date 2020/7/20 9:49
 * Description:批量删除特殊人员
 */
    @PostMapping("/delSpecialPostByIds")
    public  ResultData delSpecialPostByIds(@RequestBody Integer[] ids){
        return iProjectService.delSpecialPostByIds(ids);
    }
/**
 * @author luyu
 * @date 2020/7/20 9:49
 * Description:根据主键id修改特殊人员
 */
    @PostMapping("/updateSpecialPostById")
    public   ResultData updateSpecialPostById(SpecialPost specialPost){
        return iProjectService.updateSpecialPostById(specialPost);
    }
/**
 * @author luyu
 * @date 2020/7/20 9:49
 * Description:查询所有特殊人员
 */
    @PostMapping("/selSpecialPost")
    public   ResultData selSpecialPost(SpecialPost specialPost){
        return iProjectService.selSpecialPost(specialPost);
    }
/**
 * @author luyu
 * @date 2020/7/20 9:49
 * Description:分页查询特殊人员
 */
    @PostMapping("/selSpecialPostByPage")
    public  ResultData selSpecialPostByPage(SpecialPost specialPost, Integer pageNumber, Integer pageSize){
        return iProjectService.selSpecialPostByPage(specialPost,pageNumber,pageSize);
    }
/**
 * @author luyu
 * @date 2020/7/20 9:49
 * Description:根据条件分页查询特殊人员
 */
    @PostMapping("/selSpecialPostByPageFiled")
    public  ResultData selSpecialPostByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        return iProjectService.selSpecialPostByPageFiled(number,pageSize,where,orderFiled,fileds);
    }

}
