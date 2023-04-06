package com.example.demo.protocol;

import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.smi.VariableBinding;

import java.util.List;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/3/19 13:46
 * @Version 1.0
 */

public class SnmpReveiver implements CommandResponder {
    @Override
    public void processPdu(CommandResponderEvent commandResponderEvent) {
        if(commandResponderEvent !=null && commandResponderEvent.getPDU()!=null) {
            System.out.println("收到信息了");
            List<VariableBinding> resVbs = (List<VariableBinding>)commandResponderEvent.getPDU().getVariableBindings();
            for(int i = 0; i < resVbs.size(); i++) {
                VariableBinding resVB = resVbs.get(i);
                System.out.println(resVB.getOid() + ":" + resVB.getVariable());
            }
        }
    }
}
