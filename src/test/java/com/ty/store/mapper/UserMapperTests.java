package com.ty.store.mapper;

import com.ty.store.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class) //注解是一个测试启动器，可以加载

public class  UserMapperTests {

    @Autowired
    private  UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("ty");
        user.setPassword("121212");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUsername() {
        String username = "user01";
        User result = userMapper.findByUsername(username);
    }
    @Test
    public void updatePasswordByUid() {
        Integer uid = 7;
        String password = "123456";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUid() {
        Integer uid = 7;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }
    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(1);
        user.setPhone("17858802222");
        user.setEmail("admin@cy.com");
        user.setGender(1);
        user.setModifiedUser("系统管理员");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }
    @Test
    public void updateAvatarByUid() {
        Integer uid = 3;
        String avatar = "/upload/avatar.png";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }
}
