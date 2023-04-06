package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lijiawei
 * @Description snmp报文配置文件实体类
 * @Date 2021/4/7 16:12
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "snmp")
@PropertySource("classpath:snmp_config.properties")
public class SnmpConfig {

    private String ip;

    private int port;

    private int interval;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "SnmpConfig{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", interval=" + interval +
                '}';
    }
}
