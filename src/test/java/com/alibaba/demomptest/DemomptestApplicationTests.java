package com.alibaba.demomptest;

import com.alibaba.demomptest.entity.User;
import com.alibaba.demomptest.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@SpringBootTest
class DemomptestApplicationTests {

    @Autowired
    private UserMapper userMapper;

    // 查询
    @Test
    void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    // 插入
    @Test
    void insertUser() {
        User user = new User();
        user.setId(9L);
        user.setName("内马尔");
        user.setAge(25);
        user.setEmail("neima@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    // 更新
    @Test
    void updateUser() {
        User user = userMapper.selectById(4);
        user.setAge(45);
        user.setEmail("199@163c.com");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    // 删除
    @Test
    void deleteUser() {
        int i = userMapper.deleteById(3);
        System.out.println(i);
    }

    @Test
    void testOptimisticLocker() {
        User user = new User();
        user.setId(8L);
        user.setName("八号");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    // 更新测试乐观锁
    @Test
    void testOptimisticLocker1() {
        // 在更新的时候versionId+1了
        User user = userMapper.selectById(8L);
        user.setAge(66);
        user.setName("内马尔");
        userMapper.updateById(user);
    }

    // 根据多个id批量查询
    @Test
    void testSelect01() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 4));
        users.forEach(System.out::println);
    }

    // 根据多个条件查询
    @Test
    void testSelect02() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "李四");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 分页查询
    @Test
    void testSelectPage() {
        Page<User> page = new Page<>(1, 3);
        Page<User> page1 = userMapper.selectPage(page, null);
        // 返回总页数
        System.out.println(page1.getPages());
        // 返回当前页
        System.out.println(page1.getCurrent());
        // 返回数据集合
        for (User record : page1.getRecords()) {
            System.out.println(record);
        }
        // 返回表中记录数量
        System.out.println(page1.getTotal());
        // 每页的记录数
        System.out.println(page1.getSize());
        // 是否有下一页
        System.out.println(page1.hasNext());
        // 是否有上一页
        System.out.println(page1.hasPrevious());

    }

    @Test
    void testSelectPages() {
        Page<User> page = new Page<>(1, 2);
        Page<User> pages = userMapper.selectPage(page, null);
        System.out.println(pages.getPages());
        System.out.println(pages.getTotal());
        pages.getRecords().forEach(System.out::println);
        System.out.println(pages.hasPrevious() + "-----" + pages.hasNext());
    }

    // 删除
    @Test
    void deleteTest() {
        int delete = userMapper.deleteById(1807374588151283713L);
        System.out.println(delete);
    }

    // 批删
    @Test
    void deleteTest02() {
        int delete = userMapper.deleteBatchIds(Arrays.asList(1807374588151283713L, 1813760713799491586L));
        System.out.println(delete);
    }

    // 按条件删除
    @Test
    void deleteTest03() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Billie");
        map.put("age", 24);
        int delete = userMapper.deleteByMap(map);
        System.out.println(delete);
    }

    // 逻辑删除
    @Test
    void deleteLogic() {
        int result = userMapper.deleteById(4);
        System.out.println("result = " + result);
    }

    // 复杂条件查询
    @Test
    void testSelect(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 条件 ge(>=) gt(>) le(<=) lt(<)
//        queryWrapper.lt("age",20);
        // 条件 eq(=) ne(!=)
//        queryWrapper.ne("name","张三");
        // 条件 between(介于) notbetween(不介于)
//        queryWrapper.notBetween("age",20,30);
        // 包含
//        queryWrapper.notLike("name","马");
        // 排序
        queryWrapper.orderByDesc("age","id");
        for (User user : userMapper.selectList(queryWrapper)) {
            System.out.println(user);
        }

    }




}
