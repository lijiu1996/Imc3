package com.example.demo.init;

import com.example.demo.conf.DeviceConstant;
import com.example.demo.config.SnmpConfig;
import com.example.demo.entity.Device;
import com.example.demo.entity.TZteRecoverInfo;
import com.example.demo.entity.TZteSnmpInfo;
import com.example.demo.mapper.DcsInfoMapper;
import com.example.demo.mapper.DcsInfoTwoMapper;
import com.example.demo.mapper.EsightDeviceInfoMapper;
import com.example.demo.mapper.ImcDeviceInfoMapper;
import com.example.demo.protocol.SnmpSender;
import com.example.demo.service.SnmpUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.naming.event.ObjectChangeListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/3/25 17:15
 * @Version 1.0
 */
@Component
public class Init {

    @Resource
    SnmpConfig snmpConfig;

    @Resource
    SnmpSender snmpSender;

    @Resource
    EsightDeviceInfoMapper esightDeviceInfoMapper;

    @Resource
    DcsInfoMapper dcsInfoMapper;
    
    @Resource
    ImcDeviceInfoMapper imcDeviceInfoMapper;

    @Resource
    DcsInfoTwoMapper dcsInfoMapperTwo;

    private long sleepTime;

    public void init() {

        /*
        test2();
        zteOidInitial();
        hexOidInitial();
        int interval = snmpConfig.getInterval();
        try {
            snmpSender.init();
            while (true) {
                List<TZteSnmpInfo> zteSnmpInfoList = esightDeviceInfoMapper.getZteSnmpInfo();
                for (TZteSnmpInfo zteSnmpInfo : zteSnmpInfoList) {
                    snmpSender.sendTrap(zteSnmpInfo);
                }
                Thread.sleep(interval*500);
                List<TZteRecoverInfo> zteRecoverInfos = esightDeviceInfoMapper.getZteRecoverInfo();
                for (TZteRecoverInfo zteRecoverInfo:zteRecoverInfos) {
                    snmpSender.sendTrap(zteRecoverInfo);
                }
                Thread.sleep(interval*500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
//        sendZteSnmpInfo();
//      sendEsightSnmpInfo();

        sleepTime = snmpConfig.getInterval() *1000;
        hexOidInitial();
        zteOidInitial();
        esightOidInitial();
        try {
            snmpSender.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread zteSend = new Thread(new zteSendTask(),"中兴网管报警发送线程");
        Thread zteHeart = new Thread(new zteHeartTask(), "中兴网管心跳发送线程");
        executorService.submit(zteSend);
        executorService.submit(zteHeart);
//        Thread hwHeart = new Thread(new esightHeartTask(),"华为网管心跳发送线程");
//        executorService.submit(hwHeart);
//        Thread hwTrap = new Thread(new esightSnmpTask(), "华为网管报警发送线程");
//        executorService.submit(hwTrap);

    }

    public void sendRecover() throws IOException {
        List<TZteRecoverInfo> zteRecoverInfos = esightDeviceInfoMapper.getZteRecoverInfo();
        for (TZteRecoverInfo zteRecoverInfo:zteRecoverInfos) {
            snmpSender.sendTrap(zteRecoverInfo);
        }
    }

    public void oidListInitial(List<String> oidList, String tableName) {
        Map<String,Object> map =dcsInfoMapperTwo.getSendInfoByFlag(-1,tableName).get(0);
        List<Object> oidValues = SnmpUtil.mapValueToList(map);
        for(int i = 0; i < oidValues.size() -1; i++) {
            oidList.add(oidValues.get(i).toString());
        }
    }

    public void zteOidInitial() {
        List<String> alarmOids = DeviceConstant.zteAlarmOids;
        List<String> recoverOids = DeviceConstant.zteRecoverOids;
        List<String> heartOids = DeviceConstant.zteHeartOids;
        oidListInitial(alarmOids, "t_zte_snmp_info");
        oidListInitial(recoverOids, "t_zte_recover_info");
        oidListInitial(heartOids,"t_zte_heart_info");
    }

    public void esightOidInitial() {
        List<String> eishgtAlarmOids = DeviceConstant.esightOids;
        List<String> esightHeartOids = DeviceConstant.esightHeartOids;
        oidListInitial(eishgtAlarmOids,"t_esight_snmp_info");
        oidListInitial(esightHeartOids, "t_esight_heart_info");
    }

    public void hexOidInitial() {
        DeviceConstant.hexOids.add("1.3.6.1.4.1.3902.1092.1.3.1.5");
        DeviceConstant.hexOids.add("1.3.6.1.4.1.3902.1092.1.3.1.9");
        DeviceConstant.hexOids.add("1.3.6.1.4.1.3902.1092.1.3.1.10");
        DeviceConstant.hexOids.add("1.3.6.1.4.1.3902.1092.1.3.1.14");
        DeviceConstant.hexOids.add("1.3.6.1.4.1.2011.2.15.2.4.3.3.27.0");
        DeviceConstant.hexOids.add("1.3.6.1.4.1.2011.2.15.2.4.3.3.28.0");
    }

    public void oidInitial() {

        TZteSnmpInfo tZteSnmpInfo = esightDeviceInfoMapper.getZteSnmpInfoConfig();
        TZteRecoverInfo tZteRecoverInfo = esightDeviceInfoMapper.getZteSnmpRecoverConfig();
        List<String> alarmOids = DeviceConstant.zteAlarmOids;
        List<String> recoverOids = DeviceConstant.zteRecoverOids;

        alarmOids.add(tZteSnmpInfo.getSnmpType());
        alarmOids.add(tZteSnmpInfo.getAlarmId());
        alarmOids.add(tZteSnmpInfo.getAlarmTime());
        alarmOids.add(tZteSnmpInfo.getAlarmCode());
        alarmOids.add(tZteSnmpInfo.getAlarmCodeDesc());
        alarmOids.add(tZteSnmpInfo.getAlarmType());
        alarmOids.add(tZteSnmpInfo.getAlarmSystemType());
        alarmOids.add(tZteSnmpInfo.getAlarmSeverity());
        alarmOids.add(tZteSnmpInfo.getAlarmSpecific());
        alarmOids.add(tZteSnmpInfo.getAlarmAddition());
        alarmOids.add(tZteSnmpInfo.getAlarmNeId());
        alarmOids.add(tZteSnmpInfo.getAlarmNeType());
        alarmOids.add(tZteSnmpInfo.getAlarmNeIp());
        alarmOids.add(tZteSnmpInfo.getAlarmLocation());
        recoverOids.add(tZteRecoverInfo.getSnmpType());
        recoverOids.add(tZteRecoverInfo.getAlarmId());
        recoverOids.add(tZteRecoverInfo.getAlarmtime());
    }

    public void test() {
        List<HashMap<String,Object>> temp = dcsInfoMapper.selectTest("t_zte_recover_info");
        for(HashMap<String,Object> record:temp) {
            System.out.println("------ new record -------");
            System.out.println(record);
        }

    }

    /**
     *  从数据库根据表名以及是否需要send 获取待发送的SnmpInfo
     */
    public void test2() {
        List<LinkedHashMap<String, Object>> zteSnmpInfoList = dcsInfoMapperTwo.getSendInfoByFlag(1,"t_zte_snmp_info");
        for(HashMap<String, Object> record: zteSnmpInfoList) {
            System.out.println("----- new record -----------");
            System.out.println(record);
        }
    }

    private void sendEsightSnmpInfo() {
        int interval = snmpConfig.getInterval();
        try {
            snmpSender.init();
            while (true) {
                List<LinkedHashMap<String, Object>> t_esight_snmp_info = dcsInfoMapperTwo.getSendInfoByFlag(1, "t_esight_snmp_info");
                for(Map map: t_esight_snmp_info) {
                    List<Object> sendInfo = SnmpUtil.mapValueToList(map);
                    snmpSender.sendTrap(sendInfo,DeviceConstant.esightOids);
                }
                Thread.sleep(interval * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendZteSnmpInfo() {
        zteOidInitial();
        int interval = snmpConfig.getInterval();
        try {
            snmpSender.init();
            while (true) {
                List<LinkedHashMap<String, Object>> t_zte_snmp_info = dcsInfoMapperTwo.getSendInfoByFlag(1, "t_zte_snmp_info");
                for(Map map: t_zte_snmp_info) {
                    List<Object> sendInfo = SnmpUtil.mapValueToList(map);
                    snmpSender.sendTrap(sendInfo,DeviceConstant.zteAlarmOids);
                }
                Thread.sleep(interval*500);
                List<LinkedHashMap<String,Object>> t_zte_recover_info = dcsInfoMapperTwo.getSendInfoByFlag(1,"t_zte_recover_info");
                for(Map map: t_zte_recover_info) {
                    List<Object> sendInfo = SnmpUtil.mapValueToList(map);
                    snmpSender.sendTrap(sendInfo,DeviceConstant.zteRecoverOids);
                }
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    class zteSendTask implements Runnable {

        @Override
        public void run() {

            while(true) {
                try {
                    sendZteSnmpTrap();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    sendZteRecoverTrap();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class zteHeartTask implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    sendZteHeartTrap();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class esightSnmpTask implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    sendEsightSnmpTrap();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class esightHeartTask implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    sendEsightHeartTrap();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据表名发送该表的Snmp数据
     */
    private void sendTrapByName(String tablename, List<String> Oids) throws IOException {
        List<LinkedHashMap<String, Object>> t_snmp_info = dcsInfoMapperTwo.getSendInfoByFlag(1,tablename);
        for(Map map: t_snmp_info) {
            List<Object> sendInfo = SnmpUtil.mapValueToList(map);
            snmpSender.sendTrap(sendInfo, Oids);
        }
    }

    /**
     *  发送zte_snmp告警
     */
    private void sendZteSnmpTrap() throws IOException {
        sendTrapByName("t_zte_snmp_info",DeviceConstant.zteAlarmOids);
    }

    /**
     *  发送zte_recover报文
     * @throws IOException
     */
    private void sendZteRecoverTrap() throws IOException {
        sendTrapByName("t_zte_recover_info", DeviceConstant.zteRecoverOids);
    }

    /**
     *  发送zte_heart报文
     * @throws IOException
     */
    private void sendZteHeartTrap() throws IOException {
        sendTrapByName("t_zte_heart_info",DeviceConstant.zteHeartOids);
    }

    private void sendEsightSnmpTrap() throws IOException {
        sendTrapByName("t_esight_snmp_info",DeviceConstant.esightOids);
    }

    private void sendEsightHeartTrap() throws IOException {
        sendTrapByName("t_esight_heart_info",DeviceConstant.esightHeartOids);
        System.out.println("发送心跳");
    }
}

