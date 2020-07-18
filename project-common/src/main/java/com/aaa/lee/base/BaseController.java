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
 * code:406 msg:系统异常
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
     * @author yang
     * @date 2020/7/16 11:32
     *Description
     *   登录成功,使用系统消息
     */
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:32
     *Description
     *     登录成功,自定义返回消息
     */
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:33
     *Description
     *       登录成功,返回数据信息，使用系统消息
     */
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:33
     *Description
     *      登录成功, 返回数据信息，自定义消息
     */
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:33
     *Description
     *     登录失败，使用系统消息
     */
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:34
     *Description
     *     登录失败，使用系统消息，详细解释说明
     */
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:46
     *Description
     *       用户已经存在，使用系统消息
     */
    protected ResultData userExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:48
     *Description
     *       用户已经存在，自定义返回消息
     */
    protected ResultData userExist(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:26
     *Description
     * 用户已经存在，返回数据信息，使用系统消息
     */
    protected ResultData userExist(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(USER_EXIST.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:29
     *Description
     * 用户已经存在，返回数据信息，自定义信息
     */
    protected ResultData userExist(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(USER_EXIST.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:30
     *Description
     * 用户不存在，返回系统信息
     */
    protected ResultData userNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:34
     *Description
     *       用户不存在，返会系统信息，详细解释说明
     */
    protected ResultData userNotExist(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:38
     *Description
     * 密码错误，返回系统信息
     */
    protected ResultData passwordWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:40
     *Description
     *       密码错误，返回系统信息，详细解释说明
     */
    protected ResultData passwordWrong(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:42
     *Description
     *    用户退出异常，返回系统信息
     */
    protected ResultData logoutWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:44
     *Description
     * 用户退出异常，返回系统异常，详细解释说明
     */
    protected ResultData logoutWrong(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGOUT_WRONG.getCode());
        resultData.setMsg(LOGOUT_WRONG.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:46
     *Description
     *       系统异常，返回系统消息
     */
    protected ResultData systemException(){
        ResultData resultData = new ResultData();
        resultData.setCode(SYSTEM_EXCEPTION.getCode());
        resultData.setMsg(SYSTEM_EXCEPTION.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:50
     *Description
     * 系统异常，返回系统信息，详细解释说明
     */
    protected ResultData systemException(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(SYSTEM_EXCEPTION.getCode());
        resultData.setMsg(SYSTEM_EXCEPTION.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:35
     *Description
     *    操作成功，返回系统消息
     */
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:52
     *Description
     * 操作成功，返回自定义消息
     */
    protected ResultData operationSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:35
     *Description
     *     操作成功,返回数据信息，系统消息
     */
    protected ResultData operationSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:56
     *Description
     * 操作成功，返回数据信息，自定义消息
     */
    protected ResultData operationSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:36
     *Description
     *       操作失败，返回系统消息
     */
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 11:36
     *Description
     *      操作失败，返回自定义消息
     */
    protected ResultData operationFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 14:59
     *Description
     * 新增成功，返回系统信息
     */
    protected ResultData insertOperationSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:02
     *Description
     * 新增成功，返回自定义信息
     */
    protected ResultData insertOperationSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:03
     *Description
     * 新增成功，返回系统信息，数据信息
     */
    protected ResultData insertOperationSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(INSERT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:05
     *Description
     * 新增成功，返回自定义信息，数据信息
     */
    protected ResultData insertOperationSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:08
     *Description
     * 新增失败，返回系统信息
     */
    protected ResultData insertOperationFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:10
     *Description
     * 新增失败，返回自定义信息
     */
    protected ResultData insertOperationFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_FAILED.getCode());
        resultData.setMsg(INSERT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:12
     *Description
     *       删除成功，返回系统信息
     */
    protected ResultData deleteOperationSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:14
     *Description
     * 删除成功，返回自定义信息
     */
    protected ResultData deleteOperationSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:16
     *Description
     * 删除成功，返回系统信息，数据信息
     */
    protected ResultData deleteOperationSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(DELETE_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:17
     *Description
     * 删除成功，返回自定义信息，数据信息
     */
    protected ResultData deletaOperationSuccess(String msg, Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:22
     *Description
     * 删除失败，返回系统信息
     */
    protected ResultData deleteOperationFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(DELETE_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:23
     *Description
     * 删除失败，返回自定义信息
     */
    protected ResultData deleteOperationFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:25
     *Description
     * 更新成功，返回系统信息
     */
    protected ResultData updateOperationSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:27
     *Description
     * 更新成功，返回自定义信息
     */
    protected ResultData updateOperationSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:28
     *Description
     * 更新成功，返回系统信息，数据信息
     */
    protected  ResultData updateOperationSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:30
     *Description
     * 更新成功，返回自定义信息，数据信息
     */
    protected ResultData updateOperationSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:32
     *Description
     * 更新失败，返回系统信息
     */
    protected ResultData updateOperationFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:34
     *Description
     * 更新失败，返回自定义信息
     */
    protected ResultData updateOperationFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:36
     *Description
     * 查询成功，返回系统信息
     */
    protected ResultData selectOperationSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:38
     *Description
     * 查询成功，返回自定义信息
     */
    protected ResultData selectOperationSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:39
     *Description
     * 查询成功，返回系统信息，数据信息
     */
    protected ResultData selectOperationSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:42
     *Description
     * 查询成功，返回自定义信息，数据信息
     */
    protected ResultData selectOperationSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:43
     *Description
     *      查询失败，返回系统信息
     */
    protected ResultData selectOperationFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:45
     *Description
     * 查询失败，返回自定义信息
     */
    protected ResultData selectOperationFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:46
     *Description
     * 路由过滤成功，返回系统信息
     */
    protected ResultData zuulFilterSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:48
     *Description
     * 路由过滤成功，返回自定义信息
     */
    protected ResultData zuulFilterSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:50
     *Description
     * 路由过滤成功，返回系统信息，数据信息
     */
    protected ResultData zuulFilterSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:52
     *Description
     * 路由过滤成功，返回自定义信息，数据信息
     */
    protected ResultData zuulFilterSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:55
     *Description
     * 路由过滤失败，返回系统信息
     */
    protected ResultData zuulFilterFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:56
     *Description
     * 路由过滤失败，返回自定义信息
     */
    protected ResultData zuulFilterFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 15:58
     *Description
     * token值存在，返回系统信息
     */
    protected ResultData zuulFilterTokenSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 16:01
     *Description
     * token值存在，返回自定义信息
     */
    protected ResultData zuulFilterTokenSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 16:03
     *Description
     * token值存在，返回系统信息，数据信息
     */
    protected ResultData zuulFilterTokenSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 16:05
     *Description
     * token值存在，返回自定义信息，数据信息
     */
    protected ResultData zuulFilterTokenSuccess(String msg,Object data){
        ResultData resultData =  new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 16:07
     *Description
     *      token值不存在，返回系统信息
     */
    protected ResultData zuulFilterTokenFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 16:09
     *Description
     *       token值不存在，返回自定义信息
     */
    protected ResultData zuulFilterTokenFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 16:10
     *Description
     * request对象为nul，返回系统信息
     */
    protected ResultData requestIsNull(){
        ResultData resultData = new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(REQUEST_IS_NULL.getMsg());
        return resultData;
    }

    /**
     * @author yang
     * @date 2020/7/16 16:12
     *Description
     * request对象为null，返回自定义信息
     */
    protected ResultData requestIsNull(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(REQUEST_IS_NULL.getCode());
        resultData.setMsg(msg);
        return resultData;
    }




}
