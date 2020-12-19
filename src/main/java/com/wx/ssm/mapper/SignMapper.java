package com.wx.ssm.mapper;

import com.wx.ssm.model.Sign;
import com.wx.ssm.model.Team;
import com.wx.ssm.model.User;

import java.util.List;

public interface SignMapper {

    Team findLeaderCode(Team team);

    List<User> getSign(User user);

//    Team teamFindById(Team team);
}
