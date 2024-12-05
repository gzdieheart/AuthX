package org.gzdieheart.authx.entities;

import java.util.Collection;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
public class User implements UserDetails {

    @TableId(value = "id", type = IdType.AUTO) // 主键
    private Integer id;
    @TableField("firstname")
    private String firstName;
    @TableField("lastname")
    private String lastName;
    @TableField("email")
    private String email;
    @TableField("password")
    private String password;
    @TableField("role")
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


