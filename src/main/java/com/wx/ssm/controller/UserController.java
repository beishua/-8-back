package com.wx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.ssm.model.User;
import com.wx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class UserController {
    @Autowired//注入
    private UserService userService;

    @PostMapping("/getUsers")
    public String findAllBySome(@RequestBody User user){
        List<User> list=userService.findAllBySome(user);
        int number = userService.getCount(user);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("list",list);
        jsonObject.put("number",number);
        return jsonObject.toString();
    }

    @PostMapping("/del")
    public String del(@RequestBody User id){
        int result=userService.del(id);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result);
        return jsonObject.toString();
    }
    @PostMapping("/findById")
    public String findById(@RequestBody User user){
        User result=userService.findById(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        return jsonObject.toString();
    }
    @PostMapping("/userEdit")
    public String update(@RequestBody User user){
        int result=userService.edit(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",result);
        return jsonObject.toString();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        int result=userService.login(user);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result);
        return jsonObject.toString();
    }
    @PostMapping("/userRegister")
    public String add(@RequestBody User user){
        int result=userService.add(user);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result);
        return jsonObject.toString();
    }

    @PostMapping("/manage")
    public String setUser(User userName){
        String result = userService.setUser(userName);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result);
        return jsonObject.toString();
    }
//    @PostMapping("/exit")
//    public String exit(User userName){
//        return null;
//    }
}
