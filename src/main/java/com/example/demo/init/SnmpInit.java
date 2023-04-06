package com.example.demo.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/3/25 17:13
 * @Version 1.0
 */
public class SnmpInit implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Init snmpInit = contextRefreshedEvent.getApplicationContext().getBean(Init.class);
        snmpInit.init();
    }
}
