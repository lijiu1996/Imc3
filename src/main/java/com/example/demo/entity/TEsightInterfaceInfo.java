package com.example.demo.entity;

/**
 * @author lijiawei
 * @Description /network/port接口返回数据
 * @Date 2021/2/7 14:57
 * @Version 1.0
 */
public class TEsightInterfaceInfo {

    private String neip;

    private String nedn;

    private String portdn;

    private String name;

    private String operstatus;

    private String iftype;

    private String ipaddress;

    private String portno;

    private String ifindex;

    private String adminstatus;

    private String ifspeed;

    public String getIfindex() {
        return ifindex;
    }

    public void setIfindex(String ifindex) {
        this.ifindex = ifindex;
    }

    public String getAdminstatus() {
        return adminstatus;
    }

    public void setAdminstatus(String adminstatus) {
        this.adminstatus = adminstatus;
    }

    public String getIfspeed() {
        return ifspeed;
    }

    public void setIfspeed(String ifspeed) {
        this.ifspeed = ifspeed;
    }

    public String getPortno() {
        return portno;
    }

    public void setPortno(String portno) {
        this.portno = portno;
    }

    public String getNeip() {
        return neip;
    }

    public void setNeip(String neip) {
        this.neip = neip;
    }

    public String getNedn() {
        return nedn;
    }

    public void setNedn(String nedn) {
        this.nedn = nedn;
    }

    public String getPortdn() {
        return portdn;
    }

    public void setPortdn(String portdn) {
        this.portdn = portdn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperstatus() {
        return operstatus;
    }

    public void setOperstatus(String operstatus) {
        this.operstatus = operstatus;
    }

    public String getIftype() {
        return iftype;
    }

    public void setIftype(String iftype) {
        this.iftype = iftype;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Override
    public String toString() {
        return "TEsightInterfaceInfo{" +
                "neip='" + neip + '\'' +
                ", nedn='" + nedn + '\'' +
                ", portdn='" + portdn + '\'' +
                ", name='" + name + '\'' +
                ", operstatus='" + operstatus + '\'' +
                ", iftype='" + iftype + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                '}';
    }
}
