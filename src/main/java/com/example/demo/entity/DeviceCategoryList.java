package com.example.demo.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnie
 * @ClassName CategoryList$
 * @Description 设备类型列表
 * @Date 2021-01-14$
 * @Version 1.0
 */
@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceCategoryList extends ArrayList<DeviceCategory> {

    @XmlElement(name = "deviceCategory")
    public List<DeviceCategory> getDeviceCategoryList() {
        return this;
    }

}
