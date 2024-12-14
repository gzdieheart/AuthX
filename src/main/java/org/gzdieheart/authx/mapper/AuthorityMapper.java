package org.gzdieheart.authx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.gzdieheart.authx.entities.Authority;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * 权限mapper
 */

@Mapper
public interface AuthorityMapper extends BaseMapper<Authority> {
    /**
     * 根据指定的userId去和user_authority关联表查出该uers所属authority列表
     *
     * @param userId
     * @return
     */
    @Select("select * from authority left join user_authority ua on authority.id = ua.authority_id where ua.user_id = #{userId}")
    List<Authority> getListByUserId(Integer userId);
}