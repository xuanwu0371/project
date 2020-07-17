package com.aaa.lee.service;

import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.LoginLog;
import com.aaa.lee.model.News;
import com.aaa.lee.model.User;
import com.aaa.lee.staticproerties.RedisProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

/**
 * create by: lee
 * description:
 */
@FeignClient(value = "")
public interface IProjectService {
    /**
     * @Author: lee
     * @date : 2020/7/15 15:20
     * Description: 执行登录操作
     **/
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
     * @Author: lee
     * @date : 2020/7/15 15:21
     * Description: 新增日志
     **/
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginlog);

    /**
     * @author luyu
     * @date 2020/7/16 19:59
     * Description
     * 添加用户
     */
    @PostMapping("/user/addUser")
    ResultData addUser(@RequestBody User user);

    /**
     * @author luyu
     * @date 2020/7/16 20:01
     * Description
     * 批量删除用户
     */
    @DeleteMapping("/user/delUser")
    ResultData delUser(@RequestBody List<Long> ids);

    /**
     * @author luyu
     * @date 2020/7/16 20:03
     * Description
     * 修改用户信息
     */
    @PostMapping("/user/updateUser")
    ResultData updateUser(@RequestBody User user);


    //TODO 需要加一个导出用户信息的接口

    /**
     * @author luyu
     * @date 2020/7/16 20:06
     * Description
     * 条件分页查询所有用户
     */
    @PostMapping("/user/selectUser")
    ResultData selectUserAll(@RequestBody HashMap map);


    /**
     * @author luyu
     * @date 2020/7/16 18:38
     * Description
     * 查询所有用户角色
     */
    @PostMapping("/selectAllRoles")
    ResultData selectAllRoles(@RequestBody User user);

    /**
     * @author yang
     * @date 2020/7/17 10:35
     *Description
     * 添加新闻
     */
    @PostMapping("/news/addNews")
    ResultData addNews(@RequestBody News news);

    /**
     * @author yang
     * @date 2020/7/17 10:40
     *Description
     * 删除新闻
     */
    @PostMapping("/news/delNews")
    ResultData delNews(@RequestBody List<Long> ids);

    /**
     * @author yang
     * @date 2020/7/17 10:39
     *Description
     * 修改新闻
     */
    @PostMapping("/news/updateNews")
    ResultData updateNews(@RequestBody News news);

    /**
     * @author yang
     * @date 2020/7/17 10:41
     *Description
     * 查询所有新闻
     */
    @PostMapping("/news/selectNews")
    ResultData selectNews();
}


