package com.example.demo.vo;

/**
 * @author Li JiaWei
 * @ClassName: ResponseVo
 * @Description:
 * @Date: 2021/12/29 16:51
 * @Version: 1.0
 */
public class ResponseVo {

    private int id;
    private String region;
    private String user_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
