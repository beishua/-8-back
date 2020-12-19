package com.wx.ssm.service.impl;

import com.wx.ssm.mapper.UserMapper;
import com.wx.ssm.model.User;
import com.wx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int del(User id) {
        return userMapper.del(id);
    }

    @Override
    public int edit(User user) {
        return userMapper.edit(user);
    }

    @Override
    public int add(User user) {
        boolean isHave = isHaveFindUsername(user.getUserCode());
        if (isHave) {
            return 4;
        } else {
            int count = userMapper.add(user);
            return count;
        }
    }

    @Override
    public List<User> findTeamCode() {
        return userMapper.findTeamCode();
    }

    @Override
    public User findBySignTeamCode(User user) {
        return userMapper.findBySignTeamCode(user);
    }

    @Override
    public List<User> deleteByIds(User ids) {
        return userMapper.deleteByIds(ids);
    }

    private boolean isHaveFindUsername(String userCode) {
        User user = userMapper.findByUserName(userCode);
        boolean isHave = (user == null);
        return !isHave;
    }

    @Override
    public int login(User user) {
        if (isHaveFindByUsernameAndPassword(user)){
            return 1;
        }else{
            return 0;
        }
    }

    private boolean isHaveFindByUsernameAndPassword(User user){
        User model=userMapper.isHaveFindByUsernameAndPassword(user);
        return model !=null;
    }
    @Override
    public List<User> findAllBySome(User user) {
        List<User> list=userMapper.findAllBySome(user);
        return list;
    }
    @Override
    public int getCount(User user) {
        return userMapper.getCount(user);
    }

    @Override
    public String setUser(User userName) {
        return null;
    }

    @Override
    public User findById(User user) {
        return userMapper.findById(user);
    }
}
