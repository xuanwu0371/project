package com.aaa.lee.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_score")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Score {
    /**
     * 编号
     */
    @Id
    private Long id;

    /**
     * 增加的分值
     */
    @Column(name = "score_plus")
    private Integer scorePlus;

    /**
     * 减少的分值
     */
    @Column(name = "score_subtract")
    private Integer scoreSubtract;

    /**
     * 当前分值
     */
    private Integer score;

    /**
     * 关联单位编号
     */
    @Column(name = "unit_id")
    private Long unitId;

    /**
     * 增加/减少分值的原因
     */
    private String reason;

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