package com.aaa.lee.Controller;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.base.CommonController;
import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.User;
import com.aaa.lee.redis.RedisService;
import com.aaa.lee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.lee.status.OperationStatus.*;

/**
 * create by: lee
 * description:
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController extends CommonController<User> {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 11:17
     * Description: 用户管理中的新增用户
    **/

    @PostMapping("/addUser")
    ResultData addUser(@RequestBody User user){
        Map<String,Object> addResult  = userService.addUser(user);
        if (INSERT_OPERATION_SUCCESS.getCode().equals(addResult.get("code"))){
            return super.insertOperationSuccess();
        }
            return super.insertOperationFailed();
    }

    /**
     * @author luyu
     * @date 2020/7/16 18:53
     * Description
     * 批量删除用户
     */
    @PostMapping("/delUser")
    ResultData delUser(@RequestBody List<Long> ids){
        Map<String,Object> resultMap=userService.delUser(ids);
        if (DELETE_OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))){
           return  super.deleteOperationSuccess();
        }
           return super.deleteOperationFailed();
    }

/**
 * @author luyu
 * @date 2020/7/16 19:01
 * Description
 * 修改用户信息
 */
@PostMapping("/updateUser")
ResultData updateUser(@RequestBody User user){
    Map<String,Object> resultMap=userService.updateUser(user);
    if (UPDATE_OPERATION_SUCCESS.getCode().equals(resultMap.get("code"))){
        return super.updateOperationSuccess();
    }
        return super.updateOperationFailed();

}
/**
 * @author luyu
 * @date 2020/7/16 19:09
 * Description
 * 查询并导出用户信息
 */

ResultData selectAll(){
    //TODO   使用Excel导出用户信息，需完善
return null;
}
/**
 * @author luyu
 * @date 2020/7/16 19:09
 * Description
 * 分页条件查询
 */
ResultData selectUserPageInfo(HashMap map){
return null;
//TODO 不一定用得上，先空着
}
/**
 * @author luyu
 * @date 2020/7/16 19:11
 * Description
 * 带条件查询用户信息
 */
@PostMapping("/selectUser")
ResultData selectUserAll(@RequestBody HashMap map){
    Map<String,Object> userAll=userService.selectUserAll(map,redisService);
    if(SELECT_OPERATION_SUCCESS.getCode().equals(userAll.get("code"))){
        return super.selectOperationSuccess(userAll);
    }else{
        return super.selectOperationFailed();
    }
}

    @Override
    public BaseService getBaseService() {
        return null;
    }
}
