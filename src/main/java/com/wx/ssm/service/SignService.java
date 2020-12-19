package com.wx.ssm.service;

import com.wx.ssm.controller.SignController;
import com.wx.ssm.model.Sign;
import com.wx.ssm.model.Team;
import com.wx.ssm.model.User;

import java.util.List;

public interface SignService {
    int start(Team team);

    List<User> getSign(User user);

//    Team teamFindById(Team team);

}
