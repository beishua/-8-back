package com.wx.ssm.mapper;

import com.wx.ssm.model.User;
import java.util.List;

public interface UserMapper {

    int del(User id);

    int edit(User user);

    User isHaveFindByUsernameAndPassword(User user);

    List<User> findAllBySome(User user);

    int getCount(User user);

    User findById(User user);

    int add(User user);

    User findByUserName(String userName);

    User state(User user);
}
