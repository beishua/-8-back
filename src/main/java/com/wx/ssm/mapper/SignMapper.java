package com.wx.ssm.mapper;

import com.wx.ssm.controller.SignController;
import com.wx.ssm.model.Sign;

public interface SignMapper {
    int start(Sign sign);

    Sign findUserName(String userName);
}
