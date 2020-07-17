package com.aaa.lee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_special_post")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class SpecialPost {
    /**
     * 编号
     */
    @Id
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 有效证件号
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 性别 0:女 1:男 2:保密
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 工作年限
     */
    @Column(name = "work_year")
    private Integer workYear;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 所学专业
     */
    private String major;

    /**
     * 学历
     */
    @Column(name = "education_background")
    private String educationBackground;

    /**
     * 学位
     */
    private String degree;

    /**
     * 特殊岗位
     */
    @Column(name = "special_post")
    private String specialPost;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private Long userId;

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

}