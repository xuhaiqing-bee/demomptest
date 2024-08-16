package com.alibaba.demomptest.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author：XuHaiqing
 * @Package：com.alibaba.demomptest.entity
 * @Project：demomptest
 * @name：User
 * @Date：2024/6/29 19:07
 * @Filename：User
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //表示添加的时候设置值
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //表示添加和修改的时候设置值
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;//版本号
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;//逻辑删除
}
