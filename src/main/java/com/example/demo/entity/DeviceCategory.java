package com.example.demo.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zhangnie
 * @ClassName DeviceCategory$
 * @Description TODO
 * @Date $
 * @Version 1.0
 */
@XmlRootElement
public class DeviceCategory implements Serializable{

        private int id;
        private String name;

        public int getId()
        {
            return this.id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getName()
        {
            return this.name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "DeviceCategory{id=" + this.id + ", name='" + this.name + '\'' + '}';
        }
}
