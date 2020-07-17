package com.aaa.lee.base;


import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.util.Sqls;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * create by: lee
 * description:
 */
public abstract class CommonController<T> extends BaseController {
    /**
     *  create by: lee
     *  description:
     *      钩子函数
     *      在新增之前去执行某些操作
     *      下单操作:
     *          需求
     *              在在购物车中点击立即下单的按钮时----->跳转到下单页面(选择地址,选择优惠券)
     *              把购物车中的这个商品进行删除
     *              deleteCart(List<Integer> id); ----->是优先于insertOrder 前置执行
     *
    */

    protected void beforeAdd(Map map){
        // TODO 添加方法之前执行的操作
    }
    /**
     *  create by: lee
     *  description:
     *       钩子函数
     *       在新增之后去执行
     *       int result = insertOrder(Order order)
     *       if(result > 0){
     *           insertOrderDetail(OrderDetail orderDetail);
     *       }
    */
    protected void afterAdd(Map map){
        // TODO 添加方法之后执行的操作
    }


    public abstract BaseService<T> getBaseService();
    /**
     *  create by: lee
     *  description:
     *       通用的新增方法
     *       所有的公司都采用异步,也就是说前端向后端传输的数据都是json格式的数据
     *       之前在controller的方法中接收固定的实体类,是因为知道前端给你传递的类型就是这个实体类
     *       但是既然要做通用,前端所传递的类型就不会固定了---->所以使用Map类型来统一接收
    */

    public ResultData add(@RequestBody Map map){
        //因为根据咱们的封装规则,在service中是需要传递泛型的,就意味着service需要接收固定的实体类
        //但是controller是一个Map类型
        beforeAdd(map);
        //1.Map转实体类
        T instance =getBaseService().newInstance(map);
        //2.通用service
        Integer addResult = getBaseService().add(instance);
        if (addResult > 0 ){
            afterAdd(map);
           return super.operationSuccess();
        }
        return super.operationFailed();
    }
    /**
     * Author: lee
     * Description: 删除操作
    **/
    public ResultData delete(@RequestBody Map map){
        T instance =getBaseService().newInstance(map);
        Integer deleteResult = getBaseService().delete(instance);
        if (deleteResult > 0){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
    /**
     * Author: lee
     * Description: 批量删除
    **/
    public  ResultData batchDelete(@RequestParam("ids[]") Integer[] ids){
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if (deleteResult > 0 ){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
    /**
     * Author: lee
     * Description: 查询一条数据
    **/
    public ResultData selectOne(@RequestBody Map map){
        T instance =getBaseService().newInstance(map);
        T selectOne = getBaseService().selectOne(instance);
        if (!selectOne.equals("")){
            return super.operationSuccess(selectOne);
        }
        return super.operationFailed();
    }
    /**
     * Author: lee
     * Description: 查询一条数据,可以排序
     * fileds:不只是代表唯一键
     * select * from user where password = xxxx and age = xx and address = xxx
    **/
    public ResultData selectOneByFiled(@RequestParam("where") Sqls where,@RequestParam("orderByFiled") String orderByFiled,@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        T selectResult = getBaseService().selectOneByFiled(where, orderByFiled, (String) instance);
        if (!selectResult.equals("")){
            return super.operationSuccess(selectResult);
        }
        return super.operationFailed();

    }
    /**
     * Author: lee
     * Description: 查询集合,条件查询
    **/
    public ResultData selectList(@RequestBody Map map){
        T instance =getBaseService().newInstance(map);
        List selectList=getBaseService().selectList(instance);
        if(!selectList.isEmpty()){
            return super.operationSuccess(selectList);
        }
        return super.operationFailed();
    }
    /**
     * Author: lee
     * Description: 查询集合,分页查询
    **/
    public ResultData selectListByPage(@RequestBody Map map,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        T instance = getBaseService().newInstance(map);
        PageInfo<T> pageInfo = getBaseService().selectListByPage((T) instance.getClass().getFields().toString(), pageNo, pageSize);//TODO
        if (!pageInfo.equals("")){
            return super.operationSuccess(pageInfo);
        }
        return super.operationFailed();
    }

    /**
     * Author: lee
     * Description: 通过条件查询一个列表
    **/
    public ResultData selectListByFiled(@RequestParam("where") Sqls where,@RequestParam("orderByFiled") String orderByField,@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        List<T> ResultData = getBaseService().selectListByFiled(where, orderByField,(String) instance);
        if (!ResultData.isEmpty()){
            return super.operationSuccess(ResultData);
        }
        return super.operationFailed();
    }


    /**
     * Author: lee
     * Description: 根据主键进行更新
    **/
    public ResultData updateByPrimaryKey(@RequestBody Map map ){
        T instance = getBaseService().newInstance(map);
        Integer updateResult = getBaseService().update(instance);
        if (!updateResult.equals(0) ){
            return super.operationSuccess();
        }
        return super.operationFailed();

    }
    /**
     * Author: lee
     * Description: 批量更新
    **/
    public ResultData  batchUpdate(@RequestBody Map map ,@RequestParam("ids") Integer[] ids){
        T instance = getBaseService().newInstance(map);
        Integer updateResult = getBaseService().batchUpdate(instance,ids);
        if (!updateResult.equals(0)){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
}
