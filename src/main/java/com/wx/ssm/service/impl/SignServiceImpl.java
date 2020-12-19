package com.wx.ssm.service.impl;

import com.wx.ssm.mapper.SignMapper;
import com.wx.ssm.model.Sign;
import com.wx.ssm.model.Team;
import com.wx.ssm.model.User;
import com.wx.ssm.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    @Override
    public int start(Team team) {
        boolean is= isFindLeaderCode(team);
        if (is){
            return 1;
        }else{
            return 0;
        }
    }
    private boolean isFindLeaderCode(Team team) {
        Team team1 = signMapper.findLeaderCode(team);
        boolean is=(team1==null);
        return !is;
    }

    @Override
    public List<User> getSign(User user) {
        return signMapper.getSign(user);
    }

//    @Override
//    public Team teamFindById(Team team) {
//        return signMapper.teamFindById(team);
//    }

}
