package com.aaa.lee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_audit")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Audit {
    /**
     * 编号
     */
    @Id
    private Long id;

    /**
     * 审核项
     */
    private String name;

    /**
     * 审核类别 1:单位信息审核 2:项目登记审核 3:项目上交审核 4:成果汇交审核
     */
    private Integer type;

    /**
     * 单位用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 审核状态 0:通过 1:拒绝
     */
    private Integer status;

    /**
     * 提交时间
     */
    @Column(name = "submit_time")
    private Date submitTime;

    /**
     * 审核时间
     */
    @Column(name = "audit_time")
    private Date auditTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 关联业务编号
     */
    @Column(name = "ref_id")
    private Long refId;

    @Column(name = "create_time")
    private Date createTime;


}