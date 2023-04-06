package com.example.demo.entity;

/**
 * @author lijiawei
 * @Description 中兴网管报文类
 * @Date 2021/3/26 10:42
 * @Version 1.0
 */
public class TZteRecoverInfo {

    private String snmpType;

    private String alarmId;

    private String alarmtime;

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

    public String getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(String alarmtime) {
        this.alarmtime = alarmtime;
    }

    @Override
    public String toString() {
        return "TZteRecoverInfo{" +
                "snmpType='" + snmpType + '\'' +
                ", alarmId='" + alarmId + '\'' +
                ", alarmtime='" + alarmtime + '\'' +
                '}';
    }
}
