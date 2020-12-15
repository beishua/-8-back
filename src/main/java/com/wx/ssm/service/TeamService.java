package com.wx.ssm.service;

import com.wx.ssm.model.Team;
import com.wx.ssm.model.User;

import java.util.List;

public interface TeamService {
    List<Team> findAllBySome(Team team);

    int getCount(Team team);

    int add(Team team);

    int del(Team id);

    int edit(Team team);

    Team findById(Team team);

    List<Team> leaderName(User user);
}
