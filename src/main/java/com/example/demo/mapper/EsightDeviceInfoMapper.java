package com.example.demo.mapper;

import com.example.demo.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangnie
 * @ClassName EsightDeviceInfoMapper$
 * @Description 华为网管信息
 * @Date 2021-02-04$
 * @Version 1.0
 */
@Mapper
public interface EsightDeviceInfoMapper {

    @Select("select * from t_esight_devices_info")
    List<TEsightDeviceInfo> getEsightDeviceInfo();

    @Select("select * from t_esight_nedevice_info")
    List<TEsightNEDeviceInfo> getEsightNEDeviceInfo();

    @Select("select * from t_esight_neinterface_info where neip = #{ip}")
    List<TEsightInterfaceInfo> getEsightInterfaceInfo(@Param("ip") String ip);

    @Select("select * from t_zte_snmp_info where needSend = 1")
    List<TZteSnmpInfo> getZteSnmpInfo();

    @Select("select * from t_zte_recover_info where needSend = 1")
    List<TZteRecoverInfo> getZteRecoverInfo();

    @Select("select * from t_zte_snmp_info where needSend = -1")
    TZteSnmpInfo getZteSnmpInfoConfig();

    @Select("select * from t_zte_recover_info where needSend = -1")
    TZteRecoverInfo getZteSnmpRecoverConfig();
}
