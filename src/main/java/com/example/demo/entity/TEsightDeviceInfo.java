package com.example.demo.entity;

/**
 * @author zhangnie
 * @ClassName TEsightDeviceInfo$
 * @Description TODO
 * @Date 2021-02-04$
 * @Version 1.0
 */
public class TEsightDeviceInfo {

    private String nedn;

    private String nename;

    private String necategory;

    private String netype;

    private String nevendorname;

    private String neip;

    private String nesysoid;

    private String nestate;

    private String timezoneid;


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

    public String getNetype() {
        return netype;
    }

    public void setNetype(String netype) {
        this.netype = netype;
    }

    public String getNevendorname() {
        return nevendorname;
    }

    public void setNevendorname(String nevendorname) {
        this.nevendorname = nevendorname;
    }

    public String getNeip() {
        return neip;
    }

    public void setNeip(String neip) {
        this.neip = neip;
    }

    public String getNesysoid() {
        return nesysoid;
    }

    public void setNesysoid(String nesysoid) {
        this.nesysoid = nesysoid;
    }

    public String getNestate() {
        return nestate;
    }

    public void setNestate(String nestate) {
        this.nestate = nestate;
    }

    public String getTimezoneid() {
        return timezoneid;
    }

    public void setTimezoneid(String timezoneid) {
        this.timezoneid = timezoneid;
    }

    @Override
    public String toString() {
        return "TEsightDeviceInfo{" +
                "nedn='" + nedn + '\'' +
                ", nename='" + nename + '\'' +
                ", necategory='" + necategory + '\'' +
                ", netype='" + netype + '\'' +
                ", nevendorname='" + nevendorname + '\'' +
                ", neip='" + neip + '\'' +
                ", nesysoid='" + nesysoid + '\'' +
                ", nestate='" + nestate + '\'' +
                ", timezoneid='" + timezoneid + '\'' +
                '}';
    }
}
