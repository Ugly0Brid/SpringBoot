package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id) {
        return userMapper.Sel(id);
    }

    public List<User> SelAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.SelAll();
    }

    public boolean AddUser(User user) {
        String name = user.getName();
        if (null == name) {
            return false;
        }
        int result = userMapper.AddUser(user);
        if (1 == result) {
            return true;
        } else {
            return false;
        }
    }

    public boolean DelUserById(int id) {
        int result = userMapper.DelUserById(id);
        if (1 == result) {
            return true;
        } else {
            return false;
        }
    }

}
