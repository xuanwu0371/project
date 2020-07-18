package com.aaa.lee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_check_person")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CheckPerson {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 单位名称
     */
    @Column(name = "unit_name")
    private String unitName;

    /**
     * 职务
     */
    private String duty;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 备注
     */
    private String memo;

}