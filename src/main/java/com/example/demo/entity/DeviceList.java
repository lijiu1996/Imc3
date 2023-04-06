package com.example.demo.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnie
 * @ClassName DeviceList$
 * @Description 设备信息列表
 * @Date 2020-12-28$
 * @Version 1.0
 */
@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceList extends ArrayList<Device> {

    @XmlElement(name = "device")
    public List<Device> getDeviceList() {
        return this;
    }
}
