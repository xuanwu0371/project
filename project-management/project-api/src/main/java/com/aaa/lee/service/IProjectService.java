package com.aaa.lee.service;

import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.LoginLog;
import com.aaa.lee.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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


}
