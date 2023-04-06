package com.example.demo.vo;

/**
 * @author zhangnie
 * @ClassName LogoVO$
 * @Description 登录类
 * @Date 2021-02-03$
 * @Version 1.0
 */
public class  LogoVO {

    private String userid;

    private String value;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LogoVO{" +
                "userid='" + userid + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
