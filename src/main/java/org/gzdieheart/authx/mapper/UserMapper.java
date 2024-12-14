package org.gzdieheart.authx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.gzdieheart.authx.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 用户mapper
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE email = #{email}")
    Optional<User> findByEmail(String email);
}
