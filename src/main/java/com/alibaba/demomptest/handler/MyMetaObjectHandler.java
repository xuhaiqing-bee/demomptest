package com.alibaba.demomptest.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author：XuHaiqing
 * @Package：com.alibaba.demomptest
 * @Project：demomptest
 * @name：MyMetaObjectHandler
 * @Date：2024/6/30 19:19
 * @Filename：MyMetaObjectHandler
 * @Description：实现元对象处理器接口
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //mp执行添加操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        // 插入数据的时候versionId置为1
        this.setFieldValByName("version", 1, metaObject);
        // 插入数据的时候deleted置为0
        this.setFieldValByName("deleted", 0, metaObject);

    }

    //mp执行修改操作，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
