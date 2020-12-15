package com.wx.ssm.service.impl;

import com.wx.ssm.controller.SignController;
import com.wx.ssm.mapper.SignMapper;
import com.wx.ssm.model.Sign;
import com.wx.ssm.model.Team;
import com.wx.ssm.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    @Override
    public int start(Sign sign) {
        boolean is= isFindUserName(sign.getUserCode());
        if (is){
            return 1;
        }else{
            int count= signMapper.start(sign);
            return count;
        }
    }

    private boolean isFindUserName(String userCode) {
        Sign sign=signMapper.findUserName(userCode);
        boolean is=(sign==null);
        return !is;
    }
}
