package com.example.demo.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author zhangnie
 * @ClassName Interface$
 * @Description 接口设备信息
 * @Date 2020-12-29$
 * @Version 1.0
 */
@XmlRootElement
public class Interface {

    /**
     * @description 接口索引。
     */
    private int ifIndex;

    /**
     * @description 接口类型
     */
    private int ifType;

    /**
     * @description 接口类型描述
     */
    private String ifTypeDesc;

    /**
     * @description 接口描述。
     */
    private String ifDescription;

    /**
     * @description 管理状态
     */
    private int adminStatus;

    /**
     * @description 管理状态描述
     */
    private String adminStatusDesc;

    /**
     * @description 操作状态    1：Up，2：Down，3：Testing，4：Unknown，5：Dormant，6：NotPresent，7：LowerLayerDown。
     */
    private int operationStatus;

    /**
     * @description 操作状态描述
     */
    private String operationStatusDesc;

    /**
     * @description 显示状态  -2：Unmanaged，-1：Disable，1：Up，2：Down，4：Unkown。
     */
    private int showStatus;

    /**
     * @description 显示状态描述
     */
    private String statusDesc;

    /**
     * @description 接口速率
     */
    private long ifSpeed;

    /**
     * @description 指定速率
     */
    private long appointedSpeed;

    /**
     * @description 接口别名。
     */
    private String ifAlias;

    /**
     * @description 物理地址
     */
    private String phyAddress;

    /**
     * @description 最大传输单元
     */
    private int mtu;

    /**
     * @description IP地址/掩码
     */
    private List<Item> ipHash;


    public int getIfIndex() {
        return ifIndex;
    }

    public void setIfIndex(int ifIndex) {
        this.ifIndex = ifIndex;
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

    public long getIfSpeed() {
        return ifSpeed;
    }

    public void setIfSpeed(long ifSpeed) {
        this.ifSpeed = ifSpeed;
    }

    public long getAppointedSpeed() {
        return appointedSpeed;
    }

    public void setAppointedSpeed(long appointedSpeed) {
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

    public List<Item> getIpHash() {
        return ipHash;
    }

    public void setIpHash(List<Item> ipHash) {
        this.ipHash = ipHash;
    }


    @Override
    public String toString() {
        return "Interface{" +
                "ifIndex=" + ifIndex +
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
                ", ipHash=" + ipHash +
                '}';
    }
}
