package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.ImcDeviceInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangnie
 * @ClassName HttpInit$
 * @Description Http访问IMC
 * @Date 2020-12-24$
 * @Version 1.0
 */

@RestController
public class HttpController {

    private Log log = LogFactory.getLog(HttpController.class);

    @Resource
    private ImcDeviceInfoService imcDeviceInfoService;

    /*
    @RequestMapping(value = "/imcrs/plat/res/device", produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity getNetworkInfoN(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了");
        System.out.println(request);
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map map2 = new HashMap(parameterMap);
        System.out.println(map2);
        System.out.println(request.getSession());
        System.out.println(request.getSession().getServletContext());
        return null;
    }

     */



    @RequestMapping(value = "/imcrs/plat/res/device", produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity getNetworkInfo() {
        DeviceList deviceList = new DeviceList();
        List<Device> deviceList1 = deviceList.getDeviceList();
        List<Device> devices = imcDeviceInfoService.getDeviceList();
        for (Device device : devices) {
            Device device1 = new Device();
            device1.setId(device.getId());
            device1.setLabel(device.getLabel());
            device1.setIp(device.getIp());
            device1.setStatus(device.getStatus());
            device1.setRunTime(device.getRunTime());
            device1.setSysDescription(device.getSysDescription());
            device1.setDevPingState(device.getDevPingState());
            device1.setCategoryId(device.getCategoryId());
            device1.setSymbolId(device.getSymbolId());
            device1.setSymbolName(device.getSymbolName());
            device1.setTypeName(device.getTypeName());
            deviceList1.add(device1);
        }
        return new ResponseEntity(deviceList1, HttpStatus.OK);
    }

    @RequestMapping(value = "/imcrs/plat/res/device/{id}/interface", produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity getNetworkPortInfo(@PathVariable Integer id) {
        InterfaceList interfaceList = new InterfaceList();
        List<Interface> interfaces = interfaceList.getInterfaceList();
        List<Interfaces> interList = imcDeviceInfoService.getInterfaceList(id);
        for (Interfaces inter : interList) {
            Interface interface1 = new Interface();
            interface1.setIfIndex(inter.getIfIndex());
            interface1.setIfType(inter.getIfType());
            interface1.setIfTypeDesc(inter.getIfTypeDesc());
            interface1.setIfDescription(inter.getIfDescription());
            interface1.setAdminStatus(inter.getAdminStatus());
            interface1.setAdminStatusDesc(inter.getAdminStatusDesc());
            interface1.setOperationStatus(inter.getOperationStatus());
            interface1.setOperationStatusDesc(inter.getOperationStatusDesc());
            interface1.setShowStatus(inter.getShowStatus());
            interface1.setStatusDesc(inter.getStatusDesc());
            interface1.setIfSpeed(inter.getIfSpeed());
            interface1.setAppointedSpeed(inter.getAppointedSpeed());
            interface1.setIfAlias(inter.getIfAlias());
            interface1.setPhyAddress(inter.getPhyAddress());
            interface1.setMtu(inter.getMtu());
            List<Item> itemList = new ArrayList<>();
            Item item = new Item();
            if (inter.getIp() != null) {
                item.setIp(inter.getIp());
            }
            if (inter.getMask() != null) {
                item.setMask(inter.getMask());
            }
            itemList.add(item);
            interface1.setIpHash(itemList);
            interfaces.add(interface1);
        }
        return new ResponseEntity(interfaces, HttpStatus.OK);
    }


    @RequestMapping(value = "/imcrs/plat/res/category", produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity getCategoryInfo() {
        DeviceCategoryList deviceCategoryList = new DeviceCategoryList();
        List<DeviceCategory> deviceCategories = deviceCategoryList.getDeviceCategoryList();
        List<DeviceCategory> deviceCategoryList1 = imcDeviceInfoService.getDeviceCategory();
        for (DeviceCategory deviceCategory : deviceCategoryList1) {
            DeviceCategory deviceCategory1 = new DeviceCategory();
            deviceCategory1.setId(deviceCategory.getId());
            deviceCategory1.setName(deviceCategory.getName());
            deviceCategories.add(deviceCategory1);
        }
        return new ResponseEntity(deviceCategories, HttpStatus.OK);
    }


    @RequestMapping(value = "/imcrs/plat/res/device/{deviceId}", produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity getNetworkInfos(@PathVariable Integer deviceId) {
        Device device = imcDeviceInfoService.getDevice(deviceId);
        Device device1 = new Device();
        device1.setId(device.getId());
        device1.setLabel(device.getLabel());
        device1.setIp(device.getIp());
        device1.setStatus(device.getStatus());
        device1.setRunTime(device.getRunTime());
        device1.setSysDescription(device.getSysDescription());
        device1.setDevPingState(device.getDevPingState());
        device1.setCategoryId(device.getCategoryId());
        device1.setSymbolId(device.getSymbolId());
        device1.setSymbolName(device.getSymbolName());
        device1.setTypeName(device.getTypeName());
        return new ResponseEntity(device1, HttpStatus.OK);
    }


}
