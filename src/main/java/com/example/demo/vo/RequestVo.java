package com.example.demo.vo;

/**
 * @author Li JiaWei
 * @ClassName: RequestVo
 * @Description:
 * @Date: 2021/12/29 16:51
 * @Version: 1.0
 */
public class RequestVo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestVo{" +
                "name='" + name + '\'' +
                '}';
    }
}
