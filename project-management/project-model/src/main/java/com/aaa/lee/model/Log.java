package com.aaa.lee.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_log")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Log {
    /**
     * 日志ID
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 操作用户
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 耗时
     */
    @Column(name = "TIME")
    private Long time;

    /**
     * 操作者IP
     */
    @Column(name = "IP")
    private String ip;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 操作地点
     */
    private String location;

    /**
     * 操作内容
     */
    @Column(name = "OPERATION")
    private String operation;

    /**
     * 操作方法
     */
    @Column(name = "METHOD")
    private String method;

    /**
     * 方法参数
     */
    @Column(name = "PARAMS")
    private String params;

}