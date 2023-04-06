package com.example.demo.service;

import com.example.demo.entity.Device;
import com.example.demo.entity.DeviceCategory;
import com.example.demo.entity.Interfaces;
import com.example.demo.mapper.ImcDeviceInfoMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author zhangnie
 * @ClassName ImcDeviceInfoService$
 * @Description TODO
 * @Date $
 * @Version 1.0
 */
@Service
public class ImcDeviceInfoService
{
    @Resource
    private ImcDeviceInfoMapper imcDeviceInfoMapper;

    public List<Interfaces> getInterfaceList(Integer deviceId)
    {
        return this.imcDeviceInfoMapper.getInterfaceList(deviceId);
    }

    public List<Device> getDeviceList()
    {
        return this.imcDeviceInfoMapper.getDeviceList();
    }

    public Device getDevice(int deviceId)
    {
        return this.imcDeviceInfoMapper.getDevice(deviceId);
    }

    public List<DeviceCategory> getDeviceCategory()
    {
        return this.imcDeviceInfoMapper.getDeviceCategory();
    }
}
