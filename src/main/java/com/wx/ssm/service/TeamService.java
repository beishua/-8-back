package com.wx.ssm.service;

import com.wx.ssm.model.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAllBySome(Team team);

    int getCount(Team team);

    int add(Team team);
}
