package com.aaa.lee.vo;

import com.aaa.lee.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import java.util.List;

/**
 * create by: LiShiHao
 * create Time:  2020/7/16 18:30
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoleVo {
    private List<Long> menuId;

    private Role role;

    private Integer pageNo;

    private Integer pageSize;

}
