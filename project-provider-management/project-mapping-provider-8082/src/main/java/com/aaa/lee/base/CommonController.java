package com.aaa.lee.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * create by: lee
 * description:通用controller,只供provider使用
 */
public abstract class CommonController<T> extends BaseController {
    /**
     * @Author: lee
     * @date : 2020/7/15 18:48
     * Description: 在新增之前所执行的内容,可以用来日志处理
     **/
    protected void beforeAdd(Map map) {
        //也就是说如果在插入之前你需要执行某些业务的时候,则需要编写内容
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 18:51
     * Description: 在新增之后所执行的内容
     **/
    protected void afterAdd(Map map) {
        //也就是说如果在插入之前你需要执行某些业务的时候,则需要编写内容
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 18:52
     * Description: 为了让子类继承的时候可以重写这个方法
     **/
    public abstract BaseService<T> getBaseService();

    /**
     * @Author: lee
     * @date : 2020/7/15 18:55
     * Description: 新增数据
     **/
    public ResultData add(@RequestBody Map map) {
        //先把map转换成对象
        T instance = getBaseService().newInstance(map);
        Integer insertResult = getBaseService().add(instance);
        try {
            if (insertResult > 0) {
                return super.insertOperationSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.operationSuccess();
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 19:01
     * Description: 查询list数据
     **/
    public ResultData selectListData(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        try {
            List<T> tList = getBaseService().selectList(instance);
            return super.operationSuccess("查询list数据成功", tList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.operationFailed("查询list数据失败");
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 19:05
     * Description: 不带条件的分页查询
     **/
    public ResultData selectAllByPage(@RequestBody Map map) {
        Integer pageNo = (Integer) map.get("pageNo");
        Integer pageNumber = (Integer) map.get("pageNumber");
        Object t = map.get("t");
        try {
            PageInfo<T> tPageInfo = getBaseService().selectListByPage((T) t, pageNo, pageNumber);
            return super.operationSuccess(tPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.operationFailed("分页查询失败");
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 19:10
     * Description: 查询一条数据
     **/
    public ResultData selectOne(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        try {
            T selectOne = getBaseService().selectOne(instance);
            if (null != selectOne && !"".equals(selectOne)) {
                return super.operationSuccess(selectOne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.operationFailed("查询一条数据失败");
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 19:13
     * Description: 删除数据
     **/
    public ResultData delete(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        try {
            Integer result = getBaseService().delete(instance);
            if (result > 0) {
                return super.deleteOperationSuccess("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.operationFailed("删除失败");
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 19:16
     * Description: 根据id批量删除
     **/
    public ResultData batchDelete(@RequestBody Map map) {
        List<Integer> ids = (List<Integer>) map.get("ids");
        try {
            Integer result = getBaseService().deleteByIds(ids);
            if (result > 0) {
                return super.deleteOperationSuccess("批量删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.operationFailed("批量删除失败");
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 19:24
     * Description: 修改数据
     **/
    public ResultData update(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        try {
            Integer updateResult = getBaseService().update(instance);
            if (updateResult > 0) {
                return super.operationSuccess("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.operationFailed("修改失败");
    }
    /**
     * @Author: lee
     * @date : 2020/7/15 19:26
     * Description:
     * 防止数据不安全,
     * 所以不能直接在controller某个方法中直接接收HttpServletRequest对象
     * 必须要从当前线程中获取对象
    **/
    public HttpServletRequest getServletRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        //instanceof 测试它左边的对象是否是它右边的类的实例
        if (requestAttributes instanceof ServletRequestAttributes ){
            servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }
    /**
     * @Author: lee
     * @date : 2020/7/15 19:35
     * Description:
     * 使用本地线程中的HttpServletRequest对象获取客户端的session对象
     * 如果不存在则重新创建一个
    **/
    public HttpSession getSession(){
        return getServletRequest().getSession();
    }

    /**
     * @Author: lee
     * @date : 2020/7/15 19:37
     * Description:
     * 获取当前客户端的session对象,
     * 如果不存在,则直接返回为null
    **/
    public HttpSession getExistSession(){
        return getServletRequest().getSession(false);
    }

}
