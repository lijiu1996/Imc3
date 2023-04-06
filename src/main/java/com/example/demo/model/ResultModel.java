package com.example.demo.model;

/**
 * @author zhangnie
 * @ClassName LogoVO$
 * @Description 登录类
 * @Date 2021-02-03$
 * @Version 1.0
 */
public class ResultModel<T> {

    private int code;

    private T data;

    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LogoVO{" +
                "code=" + code +
                ", data='" + data + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
