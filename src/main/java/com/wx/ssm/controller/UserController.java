package com.wx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.wx.ssm.model.User;
import com.wx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class UserController {
    @Autowired//注入
    private UserService userService;
    public static String sessionCode = null;

    @PostMapping("/getUsers")
    public String findAllBySome(@RequestBody User user) {
        List<User> list = userService.findAllBySome(user);
        int number = userService.getCount(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", list);
        jsonObject.put("number", number);
        return jsonObject.toString();
    }

    @PostMapping("/del")
    public String del(@RequestBody User id) {
        int result = userService.del(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject.toString();
    }

    @PostMapping("/findById")
    public String findById(@RequestBody User user) {
        User result = userService.findById(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject.toString();
    }

    @PostMapping("/userEdit")
    public String update(@RequestBody User user) {
        int result = userService.edit(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", result);
        return jsonObject.toString();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (user.getCode().equals(sessionCode)) {
            int result = userService.login(user);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", result);
            return jsonObject.toString();
        }
        return "2";
    }

    @PostMapping("/userRegister")
    public String add(@RequestBody User user) {
        int result = userService.add(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject.toString();
    }

    @PostMapping("/manage")
    public String setUser(User userName) {
        String result = userService.setUser(userName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject.toString();
    }

    @PostMapping("/teamCode")
    public String findTeamCode() {
        List<User> list = userService.findTeamCode();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", list);
        return jsonObject.toString();
    }

    @PostMapping("/findBySignTeamCode")
    public String findBySignTeamCode(@RequestBody User user) {
        User user1 = userService.findBySignTeamCode(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user1", user1);
        return jsonObject.toString();
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteByIds")
    public String deleteByIds(@RequestBody User ids) {
        try {
            //批量删除
            userService.deleteByIds(ids);//删除的方法
        } catch (Exception e) {
            return "error";
        }
        return "ok";
    }

    @GetMapping("/code")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //		设置浏览器无缓存
        resp.setHeader("pragam", "No-cache");
        resp.setHeader("Cache", "No-cache");
        resp.setDateHeader("Expires", 0);
        //创建空白图片
        BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        //1.获取图片画笔
        Graphics g = image.getGraphics();
        Random r = new Random();//随机数
//        r.nextInt(10)，随机数在0到255之间 而且必须是整数 0-1
        //2.设置画笔颜色
//        设置背景颜色，RGB 三个参数
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        //3. .绘制矩形的背景
        g.fillRect(0, 0, 100, 30);
        //4.调用自定义的方法,获取长度为4的字母数字组合的字符串
        String number = getNumber(4);
        System.out.println(number);
        sessionCode = number;
        req.getSession().setAttribute("code", number);
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("宋体", Font.BOLD, 34));
        //5.设置颜色字体后，绘制字符串
        g.drawString(number, 5, 25);
        //6.绘制8条干扰线
        for (int i = 0; i < 18; i++) {
            g.setColor(new
                    Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(100),
                    r.nextInt(30),
                    r.nextInt(100),
                    r.nextInt(30));
//            直线参数 （a,b,x,y),a,b代表起点，x，y代表终点
        }
        resp.setContentType("image/jpeg");
        OutputStream ops = resp.getOutputStream();
        ImageIO.write(image, "jpeg", ops);
        ops.close();
    }
    /**
     * 字符串的拼接
     *
     * @param size
     * @return
     */
    private String getNumber(int size) {
        String str = "asdfghjklqwertyuiopzxcvbnm";//我把I和O都去掉，因为和1,0不好识别
        StringBuilder number = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            number.append(str.charAt(r.nextInt(str.length())));
//            str.charAt 拿到下标为0-str长度之间的下标，下标从0开始
        }
        return number.toString();
    }
}
