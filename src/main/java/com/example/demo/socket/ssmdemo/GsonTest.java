package com.example.demo.socket.ssmdemo;

import com.google.gson.Gson;

/**
 * @author Li JiaWei
 * @ClassName: GsonTest
 * @Description: 项目中要用到Gson接口
 * @Date: 2022/2/15 11:24
 * @Version: 1.0
 */
public class GsonTest {

    //思考 领域中 request与 session 的关系是啥 Field
    //使用httpClient 调用http接口 与使用Spring MVC提供的ModelAndView调用http接口的关系

    public static void main(String[] args) {
        User user = new User();
        user.setAge(18);
        user.setName("aa");
        user.setCountry("us");
        Gson gson = new Gson();
        String s = gson.toJson(user);
        System.out.println(s);
        System.out.println("//////");
        System.out.println(user);
    }
}
