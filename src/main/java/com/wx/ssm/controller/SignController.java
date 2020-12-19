package com.wx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.ssm.model.Sign;
import com.wx.ssm.model.Team;
import com.wx.ssm.model.User;
import com.wx.ssm.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sign", produces = "application/json;charset=UTF-8")
public class SignController {
    @Autowired//注入
    private SignService signService;

    @PostMapping("/start")
    public String start(@RequestBody Team team){
        int count=signService.start(team);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("count",count);
        return jsonObject.toString();
    }
    @PostMapping("/getSign")
    public String getSign(@RequestBody User user){
        List<User> list=signService.getSign(user);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("list",list);
        return jsonObject.toString();
    }
//    @PostMapping("/teamFindById")
//    public String findTeam(Team team){
//        Team result=signService.teamFindById(team);
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("result",result);
//        return jsonObject.toString();
//    }
}
