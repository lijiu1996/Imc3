package com.example.demo.entity;

/**
 * @author lijiawei
 * @Description 中兴网管Snmp数据类
 * @Date 2021/3/24 16:44
 * @Version 1.0
 */
public class TZteSnmpInfo {

    private String snmpType;

    private String alarmId;

    private String alarmTime;

    private String alarmCode;

    private String alarmCodeDesc;

    private String alarmType;

    private String alarmSystemType;

    private String alarmSeverity;

    private String alarmSpecific;

    private String alarmAddition;

    private String alarmNeId;

    private String alarmNeType;

    private String alarmNeIp;

    private String alarmLocation;

    public String getSnmpType() {
        return snmpType;
    }

    public void setSnmpType(String snmpType) {
        this.snmpType = snmpType;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }

    public String getAlarmCodeDesc() {
        return alarmCodeDesc;
    }

    public void setAlarmCodeDesc(String alarmCodeDesc) {
        this.alarmCodeDesc = alarmCodeDesc;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmSystemType() {
        return alarmSystemType;
    }

    public void setAlarmSystemType(String alarmSystemType) {
        this.alarmSystemType = alarmSystemType;
    }

    public String getAlarmSeverity() {
        return alarmSeverity;
    }

    public void setAlarmSeverity(String alarmSeverity) {
        this.alarmSeverity = alarmSeverity;
    }

    public String getAlarmSpecific() {
        return alarmSpecific;
    }

    public void setAlarmSpecific(String alarmSpecific) {
        this.alarmSpecific = alarmSpecific;
    }

    public String getAlarmAddition() {
        return alarmAddition;
    }

    public void setAlarmAddition(String alarmAddition) {
        this.alarmAddition = alarmAddition;
    }

    public String getAlarmNeId() {
        return alarmNeId;
    }

    public void setAlarmNeId(String alarmNeId) {
        this.alarmNeId = alarmNeId;
    }

    public String getAlarmNeType() {
        return alarmNeType;
    }

    public void setAlarmNeType(String alarmNeType) {
        this.alarmNeType = alarmNeType;
    }

    public String getAlarmNeIp() {
        return alarmNeIp;
    }

    public void setAlarmNeIp(String alarmNeIp) {
        this.alarmNeIp = alarmNeIp;
    }

    public String getAlarmLocation() {
        return alarmLocation;
    }

    public void setAlarmLocation(String alarmLocation) {
        this.alarmLocation = alarmLocation;
    }

    @Override
    public String toString() {
        return "TZteSnmpInfo{" +
                "snmpType='" + snmpType + '\'' +
                ", alarmId='" + alarmId + '\'' +
                ", alarmTime='" + alarmTime + '\'' +
                ", alarmCode='" + alarmCode + '\'' +
                ", alarmCodeDesc='" + alarmCodeDesc + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", alarmSystemType='" + alarmSystemType + '\'' +
                ", alarmSeverity='" + alarmSeverity + '\'' +
                ", alarmSpecific='" + alarmSpecific + '\'' +
                ", alarmAddition='" + alarmAddition + '\'' +
                ", alarmNeId='" + alarmNeId + '\'' +
                ", alarmNeType='" + alarmNeType + '\'' +
                ", alarmNeIp='" + alarmNeIp + '\'' +
                ", alarmLocation='" + alarmLocation + '\'' +
                '}';
    }
}
