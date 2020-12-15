package com.wx.ssm.service.impl;

import com.wx.ssm.mapper.TeamMapper;
import com.wx.ssm.model.Team;
import com.wx.ssm.model.User;
import com.wx.ssm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Team> findAllBySome(Team team) {
        List<Team> list=teamMapper.findAllBySome(team);
        return list;
    }

    @Override
    public int getCount(Team team) {
        return teamMapper.getCount(team);
    }

    @Override
    public int add(Team team) {
        boolean isHave= isHaveFindTeamCode(team.getTeamCode());
        if (isHave){
            return 2;
        }else{
            int count= teamMapper.add(team);
            return count;
        }
    }
    private boolean isHaveFindTeamCode(String teamCode) {
        Team team=teamMapper.findByTeamCode(teamCode);
        boolean isHave=(team==null);
        return !isHave;
    }

    @Override
    public int del(Team id) {
        return teamMapper.del(id);
    }

    @Override
    public int edit(Team team) {
        return teamMapper.edit(team);
    }

    @Override
    public Team findById(Team team) {
        return teamMapper.findById(team);
    }

    @Override
    public List<Team> leaderName(User user) {
        return teamMapper.leaderName(user);
    }


}
