package com.example.demo.entity;

/**
 * @author zhangnie
 * @ClassName Interfaces$
 * @Description TODO
 * @Date $
 * @Version 1.0
 */
public class Interfaces {

    private int deviceId;

    private int stationId;

    private int netDeviceId;

    private int ifIndex;

    private int ifType;

    private String ifTypeDesc;

    private String ifDescription;

    private int adminStatus;

    private String adminStatusDesc;

    private int operationStatus;

    private String operationStatusDesc;

    private int showStatus;

    private String statusDesc;

    private int ifSpeed;

    private int appointedSpeed;

    private String ifAlias;

    private String phyAddress;

    private int mtu;

    private String ip;

    private String mask;

    public int getIfIndex() {
        return ifIndex;
    }

    public void setIfIndex(int ifIndex) {
        this.ifIndex = ifIndex;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getNerDeviceId() {
        return netDeviceId;
    }

    public void setNerDeviceId(int nerDeviceId) {
        this.netDeviceId = nerDeviceId;
    }

    public int getIfType() {
        return ifType;
    }

    public void setIfType(int ifType) {
        this.ifType = ifType;
    }

    public String getIfTypeDesc() {
        return ifTypeDesc;
    }

    public void setIfTypeDesc(String ifTypeDesc) {
        this.ifTypeDesc = ifTypeDesc;
    }

    public String getIfDescription() {
        return ifDescription;
    }

    public void setIfDescription(String ifDescription) {
        this.ifDescription = ifDescription;
    }

    public int getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(int adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getAdminStatusDesc() {
        return adminStatusDesc;
    }

    public void setAdminStatusDesc(String adminStatusDesc) {
        this.adminStatusDesc = adminStatusDesc;
    }

    public int getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(int operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getOperationStatusDesc() {
        return operationStatusDesc;
    }

    public void setOperationStatusDesc(String operationStatusDesc) {
        this.operationStatusDesc = operationStatusDesc;
    }

    public int getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(int showStatus) {
        this.showStatus = showStatus;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public int getIfSpeed() {
        return ifSpeed;
    }

    public void setIfSpeed(int ifSpeed) {
        this.ifSpeed = ifSpeed;
    }

    public int getAppointedSpeed() {
        return appointedSpeed;
    }

    public void setAppointedSpeed(int appointedSpeed) {
        this.appointedSpeed = appointedSpeed;
    }

    public String getIfAlias() {
        return ifAlias;
    }

    public void setIfAlias(String ifAlias) {
        this.ifAlias = ifAlias;
    }

    public String getPhyAddress() {
        return phyAddress;
    }

    public void setPhyAddress(String phyAddress) {
        this.phyAddress = phyAddress;
    }

    public int getMtu() {
        return mtu;
    }

    public void setMtu(int mtu) {
        this.mtu = mtu;
    }

    public int getNetDeviceId() {
        return netDeviceId;
    }

    public void setNetDeviceId(int netDeviceId) {
        this.netDeviceId = netDeviceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "Interfaces{" +
                "deviceId=" + deviceId +
                ", stationId=" + stationId +
                ", netDeviceId=" + netDeviceId +
                ", ifIndex=" + ifIndex +
                ", ifType=" + ifType +
                ", ifTypeDesc='" + ifTypeDesc + '\'' +
                ", ifDescription='" + ifDescription + '\'' +
                ", adminStatus=" + adminStatus +
                ", adminStatusDesc='" + adminStatusDesc + '\'' +
                ", operationStatus=" + operationStatus +
                ", operationStatusDesc='" + operationStatusDesc + '\'' +
                ", showStatus=" + showStatus +
                ", statusDesc='" + statusDesc + '\'' +
                ", ifSpeed=" + ifSpeed +
                ", appointedSpeed=" + appointedSpeed +
                ", ifAlias='" + ifAlias + '\'' +
                ", phyAddress='" + phyAddress + '\'' +
                ", mtu=" + mtu +
                ", ip='" + ip + '\'' +
                ", mask='" + mask + '\'' +
                '}';
    }
}
