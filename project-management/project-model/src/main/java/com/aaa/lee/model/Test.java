package com.aaa.lee.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_test")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Test {
    @Column(name = "FIELD1")
    private String field1;

    @Column(name = "FIELD2")
    private Integer field2;

    @Column(name = "FIELD3")
    private String field3;

    @Column(name = "CREATE_TIME")
    private Date createTime;

}