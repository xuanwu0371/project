package com.aaa.lee.service;

import com.aaa.lee.base.BaseService;
import com.aaa.lee.model.User;
import com.aaa.lee.vo.TokenVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * create by: lee
 * description:
 */
@Service
public class LoginService extends BaseService<User> {
    /**
     * @Author: lee
     * @date : 2020/7/15 15:38
     * Description: 执行登录操作
     * pojo:实体类
     * povo:封装类型(在实际开发过程中,会有很多种情况导致多表联查的时候无法装载数据
     * 我就根据返回前端的数据自己去封装一个对象出来---->view object)
     **/
    public TokenVo dologin(User user) {
        TokenVo tokenVo = new TokenVo();
        User user1 = new User();
        //1.判断User是否为null
        if (null != user) {
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user);
            //2.判断user2是否为null
            if (null == user2) {
                tokenVo.setIfSuccess(false).setType(1);
                return tokenVo;
            } else {
                //用户名查询成功,查询密码
                user1.setPassword(user.getPassword());
                User user3 = super.selectOne(user1);
                if (null == user3) {
                    tokenVo.setIfSuccess(false).setType(2);
                    return tokenVo;
                } else {
                    //登陆成功
                    /**
                     * @Author: lee
                     * @date : 2020/7/15 15:49
                     * Description:mybatis 是无法检测连接符的,他会把连接符进行转译
                     * 需要把连接符替换掉
                     **/
                    String token = UUID.randomUUID().toString().replaceAll("-", "");
                    user3.setToken(token);
                    Integer updateResult = super.update(user3);
                    if (updateResult > 0) {
                        tokenVo.setIfSuccess(true).setToken(token);
                    } else {
                        tokenVo.setIfSuccess(false).setType(4);
                        return tokenVo;
                    }
                }
            }
        } else {
            tokenVo.setIfSuccess(false).setType(4);
        }
        return tokenVo;
    }
}
