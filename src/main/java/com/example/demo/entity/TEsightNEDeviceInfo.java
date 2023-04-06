package com.example.demo.entity;

/**
 * @author lijiawei
 * @Description Network/nedevice 接口返回数据
 * @Date 2021/2/7 14:54
 * @Version 1.0
 */
public class TEsightNEDeviceInfo {

    private String nedn;

    private String nename;

    private String necategory;

    private String neip;

    private String nestate;

    private String neruntime;

    private String nemac;

    private String lastpolltime;

    private String createtime;

    private String putintoactiontime;

    public String getNedn() {
        return nedn;
    }

    public void setNedn(String nedn) {
        this.nedn = nedn;
    }

    public String getNename() {
        return nename;
    }

    public void setNename(String nename) {
        this.nename = nename;
    }

    public String getNecategory() {
        return necategory;
    }

    public void setNecategory(String necategory) {
        this.necategory = necategory;
    }

    public String getNeip() {
        return neip;
    }

    public void setNeip(String neip) {
        this.neip = neip;
    }

    public String getNestate() {
        return nestate;
    }

    public void setNestate(String nestate) {
        this.nestate = nestate;
    }

    public String getNeruntime() {
        return neruntime;
    }

    public void setNeruntime(String neruntime) {
        this.neruntime = neruntime;
    }

    public String getNemac() {
        return nemac;
    }

    public void setNemac(String nemac) {
        this.nemac = nemac;
    }

    public String getLastpolltime() {
        return lastpolltime;
    }

    public void setLastpolltime(String lastpolltime) {
        this.lastpolltime = lastpolltime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getPutintoactiontime() {
        return putintoactiontime;
    }

    public void setPutintoactiontime(String putintoactiontime) {
        this.putintoactiontime = putintoactiontime;
    }

    @Override
    public String toString() {
        return "TEsightNEDeviceInfo{" +
                "nedn='" + nedn + '\'' +
                ", nename='" + nename + '\'' +
                ", necategory='" + necategory + '\'' +
                ", neip='" + neip + '\'' +
                ", nestate='" + nestate + '\'' +
                ", neruntime='" + neruntime + '\'' +
                ", nemac='" + nemac + '\'' +
                ", lastpolltime='" + lastpolltime + '\'' +
                ", createtime='" + createtime + '\'' +
                ", putintoactiontime='" + putintoactiontime + '\'' +
                '}';
    }
}
