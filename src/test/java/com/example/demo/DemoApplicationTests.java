package com.example.demo;

import com.example.demo.service.EsightDeviceInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private EsightDeviceInfoService esightDeviceInfoService;

    @Test
    void contextLoads() {
        System.out.println(esightDeviceInfoService.getEsightDeviceInfo());
    }

}
