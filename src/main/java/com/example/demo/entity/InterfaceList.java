package com.example.demo.entity;

/**
 * @author zhangnie
 * @ClassName InterfaceList$
 * @Description TODO
 * @Date $
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="list")
@XmlAccessorType(XmlAccessType.FIELD)
public class InterfaceList
        extends ArrayList<Interface>
{
    @XmlElement(name="interface")
    public List<Interface> getInterfaceList()
    {
        return this;
    }
}
