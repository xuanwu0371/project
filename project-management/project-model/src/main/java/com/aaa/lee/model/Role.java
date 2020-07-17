package com.aaa.lee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Table(name = "t_role")
public class Role {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "ROLE_ID")
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;


}