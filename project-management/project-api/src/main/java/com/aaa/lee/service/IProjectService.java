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
     * @Author: Lee ShiHao
     * @date : 2020/7/19 15:54
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
     * @author luyu
     * @date 2020/7/19 14:28
     * Description:单位模块
     */
    @PostMapping("/addMappingUnit")
    ResultData addMappingUnit(@RequestBody MappingUnit mappingUnit);

    @PostMapping("/delMappingUnitByIds")
    ResultData delMappingUnitByIds(@RequestBody Integer[] ids);

    @PostMapping("/updateMappingUnitById")
    ResultData updateMappingUnitById(MappingUnit mappingUnit);

    @PostMapping("/selMappingUnit")
    ResultData selMappingUnit(MappingUnit mappingUnit);

    @PostMapping("/selMappingUnitByPage")
    ResultData selMappingUnitByPage(MappingUnit mappingUnit, Integer pageNumber, Integer pageSize);

    @PostMapping("/selMappingUnitByPageFiled")
    ResultData selMappingUnitByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @author luyu
     * @date 2020/7/19 14:54
     * Description:负责人模块
     */
    @PostMapping("/addPrincipal")
    ResultData addPrincipal(Principal principal);

    @PostMapping("/delPrincipalByIds")
    ResultData delPrincipalByIds(@RequestBody Integer[] ids);

    @PostMapping("/updatePrincipalById")
    ResultData updatePrincipalById(Principal principal);

    @PostMapping("/selPrincipal")
    ResultData selPrincipal(Principal principal);

    @PostMapping("/selPrincipalByPage")
    ResultData selPrincipalByPage(Principal principal, Integer pageNumber, Integer pageSize);

    @PostMapping("/selPrincipalByPageFiled")
    ResultData selPrincipalByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @author luyu
     * @date 2020/7/19 15:34
     * Description:技术人员模块
     */
    @PostMapping("/addTechnicist")
    ResultData addTechnicist(@RequestBody Technicist technicist);

    @PostMapping("/delTechnicistByIds")
    ResultData delTechnicist(@RequestBody Integer[] ids);

    @PostMapping("/updateTechnicistById")
    ResultData updateTechnicistById(@RequestBody Technicist technicist);

    @PostMapping("/selTechnicist")
    ResultData selTechnicist(Technicist technicist);

    @PostMapping("/selTechnicistByPage")
    ResultData selTechnicistByPage(Technicist technicist, Integer pageNumber, Integer pageSize);

    @PostMapping("/selTechnicistByPageFiled")
    ResultData selTechnicistByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @author luyu
     * @date 2020/7/19 17:17
     * Description:设备模块
     */
    @PostMapping("/addEquipment")
    ResultData addEquipment(@RequestBody Equipment equipment);

    @PostMapping("/delEquipmentByIds")
    ResultData delEquipmentByIds(@RequestBody Integer[] ids);

    @PostMapping("/updateEquipmentById")
    ResultData updateEquipmentById(Equipment equipment);

    @PostMapping("/selEquipment")
    ResultData selEquipment(Equipment equipment);

    @PostMapping("/selEquipmentByPage")
    ResultData selEquipmentByPage(Equipment equipment, Integer pageNumber, Integer pageSize);
    @PostMapping("/selEquipmentByPageFiled")
    ResultData selEquipmentByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @author luyu
     * @date 2020/7/20 9:43
     * Description:特殊人员信息模块
     */
    @PostMapping("/addSpecialPost")
    ResultData addSpecialPost(@RequestBody SpecialPost specialPost);

    @PostMapping("/delSpecialPostByIds")
    ResultData delSpecialPostByIds(@RequestBody Integer[] ids);

    @PostMapping("/updateSpecialPostById")
    ResultData updateSpecialPostById(SpecialPost specialPost);

    @PostMapping("/selSpecialPost")
    ResultData selSpecialPost(SpecialPost specialPost);

    @PostMapping("/selSpecialPostByPage")
    ResultData selSpecialPostByPage(SpecialPost specialPost, Integer pageNumber, Integer pageSize);

    @PostMapping("/selSpecialPostByPageFiled")
    ResultData selSpecialPostByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @author : yang
     * @date : 2020/7/19 15:49
     * Description :审核信息
     */
    @PostMapping("/addAudit")
    ResultData addAudit(@RequestBody Audit audit);

    @PostMapping("/delAuditByIds")
    ResultData delAudit(@RequestBody List<Integer> ids);

    @PostMapping("/updateAuditBuId")
    ResultData updateAuditBuId(Audit audit);

    @PostMapping("/selAudit")
    ResultData selAudit(Audit audit);

    @PostMapping("/selAuditByAuditName")
    ResultData selAuditByAuditName(@RequestBody Audit auditName);

    @PostMapping("/selAuditByPage")
    ResultData selAuditByPage(Audit audit, Integer pageNumber, Integer pageSize);

    @PostMapping("/selAuditByPageFiled")
    ResultData selAuditByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @author : yang
     * @date : 2020/7/19 15:58
     * Description :抽查人员
     */
    @PostMapping("/addCheckPerson")
    ResultData addCheckPerson(@RequestBody CheckPerson checkPerson);

    @PostMapping("/delCheckPersonByIds")
    ResultData delCheckPersonByIds(@RequestBody Integer[] ids);

    @PostMapping("/updateCheckPersonById")
    ResultData updateCheckPersonById(CheckPerson checkPerson);

    @PostMapping("/selCheckPerson")
    ResultData selCheckPerson(CheckPerson checkPerson);

    @PostMapping("/selCheckPersonById")
    ResultData selCheckPersonById(@RequestBody CheckPerson id);

    @PostMapping("/selCheckPersonByPage")
    ResultData selCheckPersonByPage(CheckPerson checkPerson, Integer pageNumber, Integer pageSize);

    @PostMapping("/selCheckPersonByPageFiled")
    ResultData selCheckPersonByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @author : yang
     * @date : 2020/7/19 16:01
     * Description :测绘项目
     */
    @PostMapping("/addMappingProject")
    ResultData addMappingProject(@RequestBody MappingProject mappingProject);

    @PostMapping("/delMappingProjectById")
    ResultData delMappingProjectById(@RequestBody MappingProject id);

    @PostMapping("/updateMappingProjectById")
    ResultData updateMappingProjectById(@RequestBody MappingProject mappingProject);

    @PostMapping("/selMappingProject")
    ResultData selMappingProject(MappingProject mappingProject);

    @PostMapping("/selMappingProjectByProjectName")
    ResultData selMappingProjectByProjectName(@RequestBody MappingProject projectName);

    @PostMapping("/selMappingProjectByPage")
    ResultData selMappingProjectByPage(MappingProject mappingProject, Integer pageNumber, Integer pageSize);

    @PostMapping("/selMappingProjectByPageFiled")
    ResultData selMappingProjectByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);


    /**
     * @author : yang
     * @date : 2020/7/19 16:05
     * Description :信息公开,公告栏
     */
    @PostMapping("/addNews")
    ResultData addNews(@RequestBody News news);

    @PostMapping("/delNewsByIds")
    ResultData delNewsByIds(@RequestBody Integer[] ids);

    @RequestMapping("/updateNewsById")
    ResultData updateNewsById(News news);

    @PostMapping("/selNews")
    ResultData selNews(News news);

    @PostMapping("/selNewsById")
    ResultData selNewsById(@RequestBody News id);

    @PostMapping("/selNewsByPage")
    ResultData selNewsByPage(News news, Integer pageNumber, Integer pageSize);

    @PostMapping("/selNewsByPageFiled")
    ResultData selNewsByPageFiled(Integer number, Integer pageSize, Sqls where, String orderFiled, String... fileds);

}
