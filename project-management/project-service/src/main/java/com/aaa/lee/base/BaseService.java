package com.aaa.lee.base;

import com.aaa.lee.mapper.UserMapper;
import com.aaa.lee.utils.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;
import com.aaa.lee.utils.Map2BeanUtils;
import com.aaa.lee.utils.SpringContextUtils;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.staticproerties.OrderStatic.ASC;
import static com.aaa.lee.staticproerties.OrderStatic.DESC;

/**
 * create by: lee
 * description:
 * 通用service
 */
public abstract class BaseService<T> {

    // 全局变量，缓存子类的泛型类型
    private Class<T> cache = null;

    @Autowired
    private Mapper<T> mapper;

    protected Mapper getMapper() {
        return mapper;
    }

    /**
     * @author Seven Lee
     * @description
     *      新增数据
     * @param [t]
     * @date 2020/7/9
     * @return java.lang.Integer
     * @throws
     **/
    public Integer add(T t) {
        return mapper.insert(t);
    }

    /**
     * @author Seven Lee
     * @description
     *      根据主键进行删除
     * @param [t]
     * @date 2020/7/9
     * @return java.lang.Integer
     * @throws
     **/
    public Integer delete(T t) {
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * @author Seven Lee
     * @description
     *      根据主键进行批量删除
     * @param [ids]
     * @date 2020/7/9
     * @return java.lang.Integer
     * @throws
     **/
    public Integer deleteByIds(List<Integer> ids) {
        /**
         * delete * from user where 1 = 1 and id in (1,2,3,4,5,6,7,8)
         * andIn("id")--->id就是数据库中的主键名称
         */
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }

    /**
     * @author Seven Lee
     * @description
     *      更新操作
     * @param [t]
     * @date 2020/7/9
     * @return java.lang.Integer
     * @throws
     **/
    public Integer update(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * @author Seven Lee
     * @description
     *      update username = ?  from user where id in (1,2,3,4,5,6,7)
     * @param [t, ids]
     * @date 2020/7/9
     * @return java.lang.Integer
     * @throws
     **/
    public Integer batchUpdate(T t, Integer[] ids) {
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t, example);
    }

    /**
     * @author Seven Lee
     * @description
     *      查询一条数据
     *      形参中的t所传递的数据--->主键，唯一键(username, phone number....)
     * @param [t]
     * @date 2020/7/9
     * @return T
     * @throws
     **/
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    /**
     * @author Seven Lee
     * @description
     *      查询一条数据
     *      可以排序(orderByFiled:ASC,DESC)
     *      fileds:不只是代表唯一键
     *          password
     *          age
     *          address
     *          select * from user where password = xxxx and age = xx and address = xxx
     *
     * @param [where, orderByFiled, fileds]
     * @date 2020/7/9
     * @return T
     * @throws
     **/
    public T selectOneByFiled(Sqls where, String orderByFiled, String... fileds) {
        return (T) selectByFileds(null, null, where, orderByFiled, null, fileds).get(0);
    }

    /**
     * @author Seven Lee
     * @description
     *      通过条件查询一个列表
     * @param [where, orderByField, fields]
     * @date 2020/7/9
     * @return java.util.List<T>
     * @throws
     **/
    public List<T> selectListByFiled(Sqls where, String orderByField, String... fields) {
        return selectByFileds(null, null, where, orderByField, null, fields);
    }

    /**
     * @author Seven Lee
     * @description
     *      实现条件查询的分页
     * @param [pageNo, pageSize, where, orderFiled, fileds]
     * @date 2020/7/9
     * @return com.github.pagehelper.PageInfo<T>
     * @throws
     **/
    public PageInfo<T> selectListByPageAndFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return new PageInfo<T>(selectByFileds(pageNo, pageSize, where, orderFiled, null, fileds));
    }

    /**
     * @author Seven Lee
     * @description
     *      查询集合，条件查询
     * @param [t]
     * @date 2020/7/9
     * @return java.util.List<T>
     * @throws
     **/
    public List<T> selectList(T t) {
        return mapper.select(t);
    }

    /**
     * @author Seven Lee
     * @description
     *      查询集合，分页查询
     * @param []
     * @date 2020/7/9
     * @return com.github.pagehelper.PageInfo<T>
     * @throws
     **/
    public PageInfo<T> selectListByPage(T t, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     * @author Seven Lee
     * @description
     *      Map转换实体类型
     * @param [map]
     * @date 2020/7/9
     * @return T
     * @throws
     **/
    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArguement());
    }

    /**
     * @author Seven Lee
     * @description
     *      实现查询通用
     *          不但可以作用于分页，还可以作用于排序，还能作用于多条件查询
     *      orderByFiled:是所要排序的字段
     * @param []
     * @date 2020/7/9
     * @return java.util.List<T>
     * @throws
     **/
    private List<T> selectByFileds(Integer pageNo, Integer pageSize, Sqls where, String orderByFiled, String orderWord, String... fileds) {
        Example.Builder builder = null;
        if(null == fileds || fileds.length == 0) {
            // 查询所有数据
            builder = Example.builder(getTypeArguement());
        } else {
            // 说明需要进行条件查询
            builder = Example.builder(getTypeArguement()).select(fileds);
        }
        if(where != null) {
            // 说明有用户自定义的where语句条件
            builder = builder.where(where);
        }
        if(orderByFiled != null) {
            // 说明我需要对某个字段进行排序
            if(DESC.equals(orderWord.toUpperCase())) {
                // 说明需要倒序
                builder = builder.orderByDesc(orderByFiled);
            } else if(ASC.equals(orderWord.toUpperCase())) {
                builder = builder.orderByAsc(orderByFiled);
            } else {
                builder = builder.orderByDesc(orderByFiled);
            }
        }
        Example example = builder.build();
        // 实现分页
        if(pageNo != null & pageSize != null) {
            PageHelper.startPage(pageNo, pageSize);
        }
        return getMapper().selectByExample(example);
    }

    /**
     * @author Seven Lee
     * @description
     *      获取子类泛型类型
     * @param []
     * @date 2020/7/9
     * @return java.lang.Class<T>
     * @throws
     **/
    public Class<T> getTypeArguement() {
        if(null == cache) {
            cache = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }

    /**
     * @author Seven Lee
     * @description
     *      获取spring容器/获取spring的上下文
     *      在项目开始运行的时候，会去加载spring配置，
     *      如果你们项目需要在项目启动的时候也加载自己的配置文件
     *      在spring的源码中有一个必须要看的方法(init())
     *      init()--->就是在项目启动的时候去加载spring的配置
     *       如果你的项目中也需要把某一些配置一开始就托管给spring
     *       需要获取到spring的上下文(ApplicationContext)
     *
     * @param []
     * @date 2020/7/9
     * @return org.springframework.context.ApplicationContext
     * @throws
     **/
    public ApplicationContext getApplicationContext() {
        return SpringContextUtils.getApplicationContext();
    }

}
