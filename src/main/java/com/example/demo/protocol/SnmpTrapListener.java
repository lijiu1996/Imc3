package com.example.demo.protocol;

import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.Snmp;
import org.snmp4j.event.SnmpEngineListener;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.mp.MPv3;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;

import java.io.IOException;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/3/19 11:38
 * @Version 1.0
 */
public class SnmpTrapListener {

    private Snmp snmp = null;


    public static void main(String[] args) {
        try {
            SnmpTrapListener snmpTrapListener = new SnmpTrapListener();
            snmpTrapListener.init();
            snmpTrapListener.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        ThreadPool threadPool = ThreadPool.create("Trap",2);
        MultiThreadedMessageDispatcher dispatcher = new MultiThreadedMessageDispatcher(threadPool, new MessageDispatcherImpl());
        Address listenAddress = GenericAddress.parse("udp:192.168.155.193/4700");
        DefaultUdpTransportMapping udpTransportMapping = new DefaultUdpTransportMapping((UdpAddress) listenAddress);
        snmp = new Snmp(dispatcher,udpTransportMapping);
        snmp.getMessageDispatcher().addMessageProcessingModel(new MPv1());
        snmp.getMessageDispatcher().addMessageProcessingModel(new MPv2c());
        snmp.getMessageDispatcher().addMessageProcessingModel(new MPv3());
        snmp.listen();
    }

    public void run() {
        SnmpReveiver snmpReceiver = new SnmpReveiver();
        snmp.addCommandResponder(snmpReceiver);
    }
}
