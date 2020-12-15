package com.wx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.ssm.model.Sign;
import com.wx.ssm.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sign", produces = "application/json;charset=UTF-8")
public class SignController {
    @Autowired//注入
    private SignService signService;

    @PostMapping("/start")
    public String start(@RequestBody Sign sign){
        int result=signService.start(sign);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result",result);
        return jsonObject.toString();
    }

}
