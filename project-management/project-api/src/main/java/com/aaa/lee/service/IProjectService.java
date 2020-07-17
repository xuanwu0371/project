package com.aaa.lee.service;

import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.*;
import com.aaa.lee.staticproerties.RedisProperties;
import com.aaa.lee.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/allUser")
    ResultData select(@RequestBody User user);
    /**
     * @author luyu
     * @date 2020/7/16 18:38
     * Description
     * 查询所有用户角色
     */
    @PostMapping("/menu/selectAllRoles")
    ResultData selectAllRoles(@RequestBody User user);


    /**
     * @author luyu
     * @date 2020/7/16 20:06
     * Description
     * 条件分页查询所有用户
     */
    @PostMapping("/user/selectUser")
    ResultData selectUserAll(@RequestBody HashMap map);


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 8:54
     * Description: 在菜单管理中新增菜单或者是按钮
     **/
    @PostMapping("/menu/insertMenuOrButton")
    ResultData insertMenuOrButton(@RequestBody Menu menu);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 8:56
     * Description: 删除按钮或者菜单
     **/
    @PostMapping("/menu//deleteMenuOrButton")
    ResultData deleteMenuOrButton(@RequestParam("menuId") Long menuId);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 8:55
     * Description: 在菜单管理中修改菜单或者按钮
     **/
    @PostMapping("/menu/updateMenuOrButton")
    ResultData updateMenuOrButton(@RequestBody Menu menu);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 8:53
     * Description: 查询所有菜单
     **/
    @GetMapping("/menu/getMenus")
    ResultData selectAllMenus();


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:35
     * Description: 新增角色以及批量新增权限
     **/
    @PostMapping("/role/insertRole")
    ResultData insertRole(@RequestBody RoleVo roleVo);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:31
     * Description: 删除角色
     **/
    @PostMapping("/role/deleteRole")
    ResultData deleteRole(@RequestParam("roleId") Long roleId);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/16 19:38
     * Description: 修改角色及权限
     **/
    @PostMapping("/role/updateRole")
    ResultData updateRole(@RequestBody RoleVo roleVo);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 9:05
     * Description: 查询所有角色
     **/
    @PostMapping("/role/allRoles")
    ResultData selectAllRole();


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 9:05
     * Description: 角色分页查询
     **/
    @PostMapping("/role/pageRoles")
    ResultData selectAllRoleByPage(@RequestBody RoleVo roleVo);


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:45
     * Description: 新增字典信息
     **/
    @PostMapping("/insertDict")
    ResultData insertDict(@RequestBody Dict dict);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:41
     * Description: 通过id批量删除字典
     **/
    @PostMapping("/delDictsById")
    ResultData delDictsById(@RequestBody List<Long> ids);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:34
     * Description: 修改字典信息
     **/
    @PostMapping("/updateDict")
    ResultData updateDict(@RequestBody Dict dict);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 11:24
     * Description: 分页查询字典
     **/
    @PostMapping("/selectAllDictByPage")
    ResultData selectAllDictByPage(@RequestBody HashMap hashMap);

    /**
     * @author yang
     * @date 2020/7/17 10:35
     * Description
     * 添加新闻
     */
    @PostMapping("/news/addNews")
    ResultData addNews(@RequestBody News news);

    /**
     * @author yang
     * @date 2020/7/17 10:40
     * Description
     * 删除新闻
     */
    @PostMapping("/news/delNews")
    ResultData delNews(@RequestBody List<Long> ids);

    /**
     * @author yang
     * @date 2020/7/17 10:39
     * Description
     * 修改新闻
     */
    @PostMapping("/news/updateNews")
    ResultData updateNews(@RequestBody News news);

    /**
     * @author yang
     * @date 2020/7/17 10:41
     * Description
     * 查询所有新闻
     */
    @PostMapping("/news/selectNews")
    ResultData selectNews();

    /**
     * @author yang
     * @date 2020/7/17 16:46
     *Description
     * 新增仪器设备信息
     */
    @PostMapping("/equipment/insertEquipment")
    ResultData insertEquipment(@RequestBody Equipment equipment);

    /**
     * @author yang
     * @date 2020/7/17 16:57
     *Description
     * 通过id批量删除仪器设备信息
     */
    @PostMapping("/equipment/delEquipment")
    ResultData delEquipmentById(@RequestBody List<Long> ids);

    /**
     * @author yang
     * @date 2020/7/17 16:58
     *Description
     * 修改仪器设备信息
     */
    @PostMapping("/equipment/updateEquipment")
    ResultData updateEquipment(@RequestBody Equipment equipment);

    /**
     * @author yang
     * @date 2020/7/17 17:00
     *Description
     * 分页查询仪器设备信息
     */
    @PostMapping("/equipment/selectAllEquipmentByPage")
    ResultData selectAllEquipmentByPage(@RequestBody HashMap hashMap);
}
