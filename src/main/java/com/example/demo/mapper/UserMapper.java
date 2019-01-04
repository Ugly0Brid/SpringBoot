package com.example.demo.mapper;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;

import java.util.List;

@Repository
public interface UserMapper {
    User Sel(int id);

    int AddUser(User user);

    int DelUserById(int id);

    List<User> SelAll();
}
