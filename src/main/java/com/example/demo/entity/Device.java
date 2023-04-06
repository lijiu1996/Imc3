package com.example.demo.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zhangnie
 * @ClassName Device$
 * @Description TODO
 * @Date $
 * @Version 1.0
 */
@XmlRootElement(name = "device")
public class Device {

    private Integer id;

    private String label;

    private String ip;

    private Integer status;

    private String runTime;

    private String sysDescription;

    private int  devPingState;

    private int categoryId;

    private int symbolId;

    private String symbolName;

    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getSysDescription() {
        return sysDescription;
    }

    public void setSysDescription(String sysDescription) {
        this.sysDescription = sysDescription;
    }

    public int getDevPingState() {
        return devPingState;
    }

    public void setDevPingState(int devPingState) {
        this.devPingState = devPingState;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", ip='" + ip + '\'' +
                ", status=" + status +
                ", runTime='" + runTime + '\'' +
                ", sysDescription='" + sysDescription + '\'' +
                ", devPingState=" + devPingState +
                ", categoryId=" + categoryId +
                ", symbolId=" + symbolId +
                ", symbolName='" + symbolName + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
