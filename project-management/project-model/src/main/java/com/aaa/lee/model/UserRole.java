package com.aaa.lee.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_user_role")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class UserRole {
    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private Long roleId;

}