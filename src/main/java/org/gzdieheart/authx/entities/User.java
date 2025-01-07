package org.gzdieheart.authx.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 用户实体
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user") // 对应数据库中的 users 表
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO) // 主键
    private Integer id;
    @TableField("firstname")
    private String firstName;
    @TableField("lastname")
    private String lastName;
    @TableField("email")
    private String email;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("role")
    private Role role;
}