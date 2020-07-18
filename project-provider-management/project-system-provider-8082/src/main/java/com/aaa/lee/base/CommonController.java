package com.aaa.lee.base;


import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.util.Sqls;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     * @author Seven Lee
     * @description
     *      更新操作
     * @param [map]
     * @date 2020/3/11
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    public ResultData update(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
        int updateResult = getBaseService().update(t);
        if(updateResult > 0){
            return  operationSuccess();
        }
        return operationFailed();
    }
    /**
     * @author Seven Lee
     * @description
     *      查询一条数据
     * @param [map]
     * @date 2020/3/11
     * @return java.lang.Object
     * @throws
     **/
    public ResultData getOne(@RequestBody Map map) {
        T t = getBaseService().newInstance(map);
        t = getBaseService().selectOne(t);
        if (null != t) {
            return operationSuccess(t);
        }
        return operationFailed();
    }

    /**
     * @author Seven Lee
     * @description
     *      条件查询多条结果
     * @param [map]
     * @date 2020/3/11
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    public ResultData getList(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
        List<T> resultT = getBaseService().selectList(t);
        if(resultT.size() > 0) {
            return operationSuccess(resultT);
        }
        return operationFailed("未找到查询结果");
    }
    /**
     * @author Seven Lee
     * @description
     *      带条件的分页查询
     * @param [map, pageNo, pageSize]
     * @date 2020/3/11
     * @return java.lang.Object
     * @throws
     **/
    public ResultData getListByPage(@RequestBody Map map, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        T t = getBaseService().newInstance(map);
        PageInfo<T> pageInfo = getBaseService().selectListByPage(t,pageNo,pageSize);
        List<T> resultList = pageInfo.getList();
        if(resultList.size() > 0) {
            return operationSuccess(pageInfo);
        }
        return operationFailed("未找到查询结果");
    }
    /**
     * @author Seven Lee
     * @description
     *      不带条件的分页查询
     * @param [pageNo, pageSize]
     * @date 2020/3/11
     * @return java.lang.Object
     * @throws
     **/
    public ResultData getListByPage( @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
        PageInfo<T> pageInfo =getBaseService().selectListByPage(null,pageNo,pageSize);
        List<T> resultList = pageInfo.getList();
        if(resultList.size() > 0) {
            return operationSuccess(pageInfo);
        }
        return operationFailed("未找到查询结果");
    }
    /**
     * @author Seven Lee
     * @description
     *      从本地当前线程中获取request对象
     * @param []
     * @date 2020/3/11
     * @return javax.servlet.http.HttpServletRequest
     * @throws
     **/
    public HttpServletRequest getServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }

    /**
     * @author Seven Lee
     * @description
     *      获取当前客户端session对象(如果没有则创建一个新的session)
     * @param []
     * @date 2020/3/11
     * @return javax.servlet.http.HttpSession
     * @throws
     **/
    public HttpSession getSession() {
        return getServletRequest().getSession();
    }

    /**
     * @author Seven Lee
     * @description
     *      获取当前客户端session对象(如果没有则直接返回null)
     * @param []
     * @date 2020/3/11
     * @return javax.servlet.http.HttpSession
     * @throws
     **/
    public HttpSession getExistSession() {
        return getServletRequest().getSession(false);
    }
}
