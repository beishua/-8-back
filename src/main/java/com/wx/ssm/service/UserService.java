package com.wx.ssm.service;

import com.wx.ssm.model.User;
import java.util.List;

public interface UserService {

    int del(User id);

    int login(User user);

    List<User> findAllBySome(User user);

    int getCount(User user);

    String setUser(User userName);

    User findById(User user);

    int edit(User user);

    int add(User user);

    List<User> findTeamCode();

    User findBySignTeamCode(User user);

    List<User> deleteByIds(User ids);
}
