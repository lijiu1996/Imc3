package com.example.demo.mapper;

import com.example.demo.entity.Device;
import com.example.demo.entity.DeviceCategory;
import com.example.demo.entity.Interfaces;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImcDeviceInfoMapper {

    List<Interfaces> getInterfaceList(Integer deviceId);

    List<Device> getDeviceList();

    Device getDevice(int deviceId);

    List<DeviceCategory> getDeviceCategory();


}
