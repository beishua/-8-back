package com.wx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.ssm.model.Team;
import com.wx.ssm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/team", produces = "application/json;charset=UTF-8")
public class TeamController {
    @Autowired//注入
    private TeamService teamService;

    @PostMapping("/getTeam")
    public String findAllBySome(@RequestBody Team team){
        List<Team> list=teamService.findAllBySome(team);
        int number = teamService.getCount(team);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("list",list);
        jsonObject.put("number",number);
        return jsonObject.toString();
    }
    @PostMapping("/add")
    public String add(@RequestBody Team team){
        int count=teamService.add(team);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("count",count);
        return jsonObject.toString();
    }
}
