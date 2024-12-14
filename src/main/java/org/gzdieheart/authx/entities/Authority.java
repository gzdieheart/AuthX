package org.gzdieheart.authx.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/12/13
 * 权限实体
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("authority") // 对应数据库中的 authority 表
public class Authority implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
}
