package com.example.demo.protocol;

import com.example.demo.conf.DeviceConstant;
import com.example.demo.conf.MyOID;
import com.example.demo.config.SnmpConfig;
import com.example.demo.entity.TZteRecoverInfo;
import com.example.demo.entity.TZteSnmpInfo;
import com.example.demo.mapper.EsightDeviceInfoMapper;
import com.example.demo.service.SnmpUtil;
import org.apache.commons.lang.StringUtils;
import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lijiawei
 * @Description 发送SnmpTrap
 * @Date 2021/3/19 10:12
 * @Version 1.0
 */

@Component
public class SnmpSender {

    @Resource
    SnmpConfig snmpConfig;

    @Resource
    EsightDeviceInfoMapper esightDeviceInfoMapper;

    private Snmp snmp = null;

    private TransportMapping<UdpAddress> transportMapping = null;

    public void init() throws IOException {
        transportMapping = new DefaultUdpTransportMapping();
        snmp = new Snmp(transportMapping);
        transportMapping.listen();
    }

    public ResponseEvent sendTrap(List<Object> data,List<String> alarmOids) throws IOException {
        PDU pdu = new PDU();
        for(int i = 0; i < alarmOids.size() ; i++) {
            VariableBinding vb = new VariableBinding();
            String oid = alarmOids.get(i);
            vb.setOid(new OID(oid));
            if(DeviceConstant.hexOids.contains(oid)) {
                vb.setVariable(new OctetString(SnmpUtil.toHexString(data.get(i).toString())));
            } else if (StringUtils.isNumeric(data.get(i).toString())){
                vb.setVariable(new Integer32(Integer.valueOf(data.get(i).toString())));
            } else {
                vb.setVariable(new OctetString(data.get(i).toString()));
            }
            pdu.add(vb);
        }
        System.out.println(pdu);
        pdu.setType(PDU.TRAP);
        Target target = createTarget();
        return snmp.send(pdu,target);
    }

    public ResponseEvent sendTrap(TZteSnmpInfo tZteSnmpInfo) throws IOException {

        PDU pdu = new PDU();

        List<String> alarmOids = DeviceConstant.zteAlarmOids;
        List<String> snmpValues = new ArrayList<>();
        snmpValues.add(tZteSnmpInfo.getSnmpType());
        snmpValues.add(tZteSnmpInfo.getAlarmId());
        snmpValues.add(tZteSnmpInfo.getAlarmTime());
        snmpValues.add(tZteSnmpInfo.getAlarmCode());
        snmpValues.add(tZteSnmpInfo.getAlarmCodeDesc());
        snmpValues.add(tZteSnmpInfo.getAlarmType());
        snmpValues.add(tZteSnmpInfo.getAlarmSystemType());
        snmpValues.add(tZteSnmpInfo.getAlarmSeverity());
        snmpValues.add(tZteSnmpInfo.getAlarmSpecific());
        snmpValues.add(tZteSnmpInfo.getAlarmAddition());
        snmpValues.add(tZteSnmpInfo.getAlarmNeId());
        snmpValues.add(tZteSnmpInfo.getAlarmNeType());
        snmpValues.add(tZteSnmpInfo.getAlarmNeIp());
        snmpValues.add(tZteSnmpInfo.getAlarmLocation());

        for(int i = 0; i < alarmOids.size(); i++) {
            VariableBinding vb = new VariableBinding();
            String oid = alarmOids.get(i);
            vb.setOid(new OID(oid));
            if(oid =="1.3.6.1.4.1.3902.1092.1.3.1.5" || oid == "1.3.6.1.4.1.3902.1092.1.3.1.9" || oid == "1.3.6.1.4.1.3902.1092.1.3.1.10" || oid == "1.3.6.1.4.1.3902.1092.1.3.1.14") {
                vb.setVariable(new OctetString(SnmpUtil.toHexString(snmpValues.get(i))));
            } else {
                vb.setVariable(new OctetString(snmpValues.get(i)));
            }
            pdu.add(vb);
        }
        System.out.println(pdu);
        pdu.setType(PDU.TRAP);
        Target target = createTarget();
        return snmp.send(pdu,target);
    }

    public ResponseEvent sendTrap(TZteRecoverInfo tZteRecoverInfo) throws IOException {

        PDU pdu = new PDU();
        List<String> recoverOids = DeviceConstant.zteRecoverOids;
        List<String> snmpValues = new ArrayList<>();
        snmpValues.add(tZteRecoverInfo.getSnmpType());
        snmpValues.add(tZteRecoverInfo.getAlarmId());
        snmpValues.add(tZteRecoverInfo.getAlarmtime());

        for(int i = 0; i < recoverOids.size(); i++) {
            VariableBinding vb = new VariableBinding();
            String oid = recoverOids.get(i);
            vb.setOid(new OID(oid));
            vb.setVariable(new OctetString(snmpValues.get(i)));
            pdu.add(vb);
        }

        pdu.setType(PDU.TRAP);
        Target target = createTarget();

        return snmp.send(pdu,target);
    }

    public Target createTarget() {
        Target target = new CommunityTarget();
        target.setVersion(SnmpConstants.version2c);
        ((CommunityTarget)target).setCommunity(new OctetString("public"));
        String ip = snmpConfig.getIp();
        int port = snmpConfig.getPort();
        String address = "udp:" + ip + "/" + port;
        target.setAddress(GenericAddress.parse(address));
        target.setRetries(5);
        target.setTimeout(3000);
        return target;
    }
}



