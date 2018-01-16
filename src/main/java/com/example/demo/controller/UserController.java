package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/10
 * Time：11:26
 * ========================
 */
@RestController
public class UserController {

    @Autowired
    private UserJpa userJpa;

    /*查找所有用户*/
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserEntity> findUsers() {
        return userJpa.findAll();
    }

    /*添加,更新用户*/
    @RequestMapping(value="/save",method = RequestMethod.GET)
    public UserEntity add(UserEntity userEntity){
        return userJpa.save(userEntity);
    }

    /*删除用户*/
    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJpa.delete(id);
        return userJpa.findAll();
    }
}
