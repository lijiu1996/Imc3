package com.example.demo.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zhangnie
 * @ClassName Item$
 * @Description IP和Mask
 * @Date 2021-01-05$
 * @Version 1.0
 */
public class Item {

    private String ip;

    private String mask;

    @XmlElement(name="item")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @XmlElement(name="item")
    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ip='" + ip + '\'' +
                ", mask='" + mask + '\'' +
                '}';
    }
}
