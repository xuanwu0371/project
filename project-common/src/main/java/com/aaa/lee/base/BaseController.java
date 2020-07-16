package com.aaa.lee.base;




import static com.aaa.lee.status.LoginStatus.*;
import static com.aaa.lee.status.OperationStatus.*;

/**
 * 统一controller
 * 所有的controller都要继承这个controller,进行统一返回
 * <p>
 * <p>
 * eg:
 * 登录成功和失败
 * code:200 msg:登陆成功
 * code:400 msg:登陆失败,系统异常
 * code:201 msg:用户已经存在
 * code:401 msg:用户不存在
 * code:402 msg:密码错误
 * code:405 msg:用户退出异常
 * code:1 msg:操作成功
 * code:2 msg:操作失败
 * code:3 msg:新增成功
 * code:4 msg:新增失败
 * code:5 msg:删除成功
 * code:6 msg:删除失败
 * code:7 msg:更新成功
 * code:8 msg:更新失败
 * code:9 msg:查询成功
 * code:10 msg:查询失败
 * code:11 msg:路由过滤成功
 * code:12 msg:路由过滤失败
 * code:13 msg:token值存在
 * code:14 msg:token值不存在
 * code:15 msg:request对象为null
 *
 */
public class BaseController {
    /**
     * create by: lee
     * description:
     * 登录成功
     * 使用系统消息
     */
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * create by: lee
     * description:
     * 登录成功
     * 自定义返回消息
     */
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * create by: lee
     * description:
     * 登录成功
     * 返回数据信息,使用系统消息
     */
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * create by: lee
     * description:
     * 登录成功
     * 返回数据信息,使用自定义消息
     */
    protected ResultData loginSuccess(String msg,Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * create by: lee
     * description:
     * 登录失败,使用系统消息
     */
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * create by: lee
     * description:
     * 登录失败,
     * 使用系统消息,详细解释说明
     */
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * create by: lee
     * description:
     * 操作成功,
     * 使用系统消息
     */
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 操作成功,
     * 使用自定义消息
    **/
    protected ResultData operationSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 操作成功,
     * 使用系统消息,返回数据
     **/
    protected ResultData operationSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * Author: lee
     * Description: 操作成功,
     * 使用自定义消息,返回数据
    **/
    protected ResultData operationSuccess(String msg,Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * create by: lee
     * description:操作失败
     * 返回系统消息
     */
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }
    /**
     * create by: lee
     * description:
     * 操作失败
     * 返回自定义消息
     */
    protected ResultData operationFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * create by: lee
     * description:
     * 删除成功
     * 返回系统消息
     */
    protected ResultData deleteOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION_SUCCESS.getCode());
        resultData.setMsg(DELETE_OPERATION.getMsg());
        return resultData;
    }
    /**
     * create by: lee
     * description:
     * 删除成功
     * 返回自定义消息
     */
    protected ResultData deleteOperation(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 修改操作
     * 返回系统消息
    **/
    protected ResultData updateOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION.getCode());
        resultData.setMsg(UPDATE_OPERATION.getMsg());
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 修改操作
     * 返回自定义消息
     **/
    protected ResultData updateOperation(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 新增操作
     * 返回系统消息
    **/
    protected ResultData insertOperation() {
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION.getCode());
        resultData.setMsg(INSERT_OPERATION.getMsg());
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 新增操作
     * 返回自定义
     **/
    protected ResultData insertOperation(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 路由过滤成功
     * 返回系统消息
    **/
    protected ResultData zuulFilterSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 路由过滤成功
     * 返回自定义消息
    **/
    protected ResultData zuulFilterSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 路由过滤失败
     * 返回系统消息
     **/
    protected ResultData zuulFilterFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * 路由过滤失败
     * 返回自定义消息
     **/
    protected ResultData zuulFilterFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * token值存在
     * 返回系统消息
     **/
    protected ResultData zuulFilterTokenSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * token值存在
     * 返回自定义消息
     **/
    protected ResultData zuulFilterTokenSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * token值不存在
     * 返回系统
     **/
    protected ResultData zuulFilterTokenFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_FAILED.getMsg());
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * token值不存在
     * 返回自定义消息
     **/
    protected ResultData zuulFilterTokenFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * request对象为null
     * 返回系统
     **/
    protected ResultData requestIsNull(){
        ResultData resultData = new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(REQUEST_IS_NULL.getMsg());
        return resultData;
    }
    /**
     * Author: lee
     * Description:
     * request对象为null
     * 返回自定义消息
     **/
    protected ResultData requestIsNull(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

}
