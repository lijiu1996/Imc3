package com.example.demo.service;

import com.example.demo.entity.TEsightDeviceInfo;
import com.example.demo.entity.TEsightInterfaceInfo;
import com.example.demo.entity.TEsightNEDeviceInfo;
import com.example.demo.mapper.EsightDeviceInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangnie
 * @ClassName EsightDeviceInfoService$
 * @Description 华为网管service
 * @Date 2021-02-04$
 * @Version 1.0
 */
@Service
public class EsightDeviceInfoService {

    @Resource
    private EsightDeviceInfoMapper esightDeviceInfoMapper;

    public List<TEsightDeviceInfo> getEsightDeviceInfo() {
        return esightDeviceInfoMapper.getEsightDeviceInfo();
    }

    public List<TEsightNEDeviceInfo> getEsightNeDeviceInfo() {
        return esightDeviceInfoMapper.getEsightNEDeviceInfo();
    }

    public List<TEsightInterfaceInfo> getEsightNeInterfaceInfo(String ip) {
        return esightDeviceInfoMapper.getEsightInterfaceInfo(ip);
    }
}
