package com.aaa.lee.service;

import com.aaa.lee.base.ResultData;
import com.aaa.lee.model.*;
import com.aaa.lee.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.Sqls;

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
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:51
     * Description: 用户管理
     **/
    @PostMapping("/addUser")
    ResultData addUser(@RequestBody User user);

    @PostMapping("/delUserByIds")
    ResultData delUserByIds(@RequestBody List<Integer> ids);

    @PostMapping("/updateUserById")
    ResultData updateUserById(User user);

    @PostMapping("/selUser")
    ResultData selUser(User user);

    @PostMapping("/selUserById")
    ResultData selUserById(@RequestBody User id);

    @PostMapping("/selUserByPage")
    ResultData selUserByPage(User user, Integer pageNumber, Integer pageSize);

    @PostMapping("/SelUserByPageFiled")
    ResultData selUserByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 14:54
     * Description: 角色管理
     **/
    @PostMapping("/insertRole")
    ResultData insertRole(RoleVo roleVo);

    @PostMapping("/deleteRole")
    ResultData deleteRole(@RequestParam("roleId") Long roleId);

    @PostMapping("/updateRole")
    ResultData updateRole(@RequestBody RoleVo roleVo);

    @PostMapping("/selRoleByPage")
    ResultData selRoleByPage(Role role, Integer pageNumber, Integer pageSize);

    @PostMapping("/selRoleByPageByFiled")
    ResultData selRoleByPageByFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:00
     * Description: 菜单管理
     **/
    @PostMapping("/insertMenuOrButton")
    ResultData insertMenuOrButton(@RequestBody Menu menu);

    @PostMapping("/deleteMenuOrButton")
    ResultData deleteMenuOrButton(@RequestParam("menuId") Long menuId);

    @PostMapping("/updateMenuOrButton")
    ResultData updateMenuOrButton(@RequestBody Menu menu);

    @PostMapping("/selectAllMenus")
    ResultData selectAllMenus();


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:02
     * Description: 部门管理
     **/
    @PostMapping("/addDept")
    ResultData addDept(@RequestBody Dept dept);

    @PostMapping("/delDeptById")
    ResultData delDeptById(@RequestBody List<Integer> ids);

    @PostMapping("/updateDeptById")
    ResultData updateDeptById(@RequestBody Dept dept);

    @PostMapping("/selectAllDept")
    ResultData selectAllDept(@RequestBody Dept dept);

    @PostMapping("/SelDeptByPageFiled")
    ResultData SelDeptByPageAndFiled(@RequestBody Integer pageNumber, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:06
     * Description: 字典管理
     **/
    @PostMapping("/addDict")
    ResultData addDict(@RequestBody Dict Dict);

    @PostMapping("/delDictByIds")
    ResultData delDictByIds(@RequestBody Integer[] ids);

    @PostMapping("/updateDictById")
    ResultData updateDictById(Dict Dict);

    @PostMapping("/SelDictByPageFiled")
    ResultData SelDictByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


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
    ResultData selectNews(@RequestBody News news);

    /**
     * @author yang
     * @date 2020/7/17 16:46
     * Description
     * 新增仪器设备信息
     */
    @PostMapping("/equipment/insertEquipment")
    ResultData insertEquipment(@RequestBody Equipment equipment);

    /**
     * @author yang
     * @date 2020/7/17 16:57
     * Description
     * 通过id批量删除仪器设备信息
     */
    @PostMapping("/equipment/delEquipment")
    ResultData delEquipmentById(@RequestBody List<Long> ids);

    /**
     * @author yang
     * @date 2020/7/17 16:58
     * Description
     * 修改仪器设备信息
     */
    @PostMapping("/equipment/updateEquipment")
    ResultData updateEquipment(@RequestBody Equipment equipment);

    /**
     * @author yang
     * @date 2020/7/17 17:00
     * Description
     * 分页查询仪器设备信息
     */
    @PostMapping("/equipment/selectAllEquipmentByPage")
    ResultData selectAllEquipmentByPage(@RequestBody HashMap hashMap);


    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 新增重要人
     **/
    @PostMapping("/addPrincipal")
    ResultData addPrincipal(@RequestBody Principal principal);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 批量删除重要人
     **/
    @PostMapping("/delPrincipal")
    ResultData delPrincipal(@RequestBody List<Long> ids);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:07
     * Description: 修改重要人信息
     **/
    @PostMapping("/updatePrincipal")
    ResultData updatePrincipal(@RequestBody Principal principal);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:08
     * Description: 查询重要人信息
     **/
    @PostMapping("/selectPrincipalAll")
    ResultData selectPrincipalAll(Principal principal);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/17 22:09
     * Description: 带条件查询重要人信息
     **/
    @PostMapping("/selectPrincipal")
    ResultData selectPrincipal(@RequestBody HashMap map);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:24
     * Description: 新增技术员
     **/
    @PostMapping("/addTechnicist")
    ResultData addTechnicist(@RequestBody Technicist technicist);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:25
     * Description: 批量删除技术员
     **/
    @PostMapping("/delTechnicist")
    ResultData delTechnicist(@RequestBody List<Long> ids);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:26
     * Description: 修改技术员信息
     **/
    @PostMapping("/updateTechnicist")
    ResultData updateTechnicist(@RequestBody Technicist technicist);

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:27
     * Description: 查询技术员信息
     **/
    //todo 没有加@RequestBody
    @PostMapping("/selectAllTechnicist")
    ResultData selectAllTechnicist();

    /**
     * @Author: Lee ShiHao
     * @date : 2020/7/18 9:30
     * Description: 带条件查询用户信息
     **/
    @PostMapping("/selectTechnicist")
    ResultData selectTechnicist(@RequestBody HashMap map);
}
