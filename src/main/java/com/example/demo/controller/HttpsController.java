package com.example.demo.controller;

import com.example.demo.entity.TEsightDeviceInfo;
import com.example.demo.entity.TEsightInterfaceInfo;
import com.example.demo.entity.TEsightNEDeviceInfo;
import com.example.demo.model.ResultModel;
import com.example.demo.service.EsightDeviceInfoService;
import com.example.demo.vo.LogoVO;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangnie
 * @ClassName HttpsCpntroller$
 * @Description 华为网管模拟器
 * @Date 2021-02-03$
 * @Version 1.0
 */
@RestController
public class HttpsController {

    @Resource
    private Gson gson;

    @Resource
    private EsightDeviceInfoService esightDeviceInfoService;

    @RequestMapping(value = "/rest/openapi/sm/session", method = RequestMethod.PUT)
    public String logoPut(LogoVO logoVO) {
        String userId = logoVO.getUserid();
        String value = logoVO.getValue();
        if ("Unittec".equals(userId) && "United789".equals(value)) {
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(0);
            resultModel.setData("88a057dbc4f9a271007836c996a972f6d178ecc16bb9d760");
            resultModel.setDescription("Operation success.");
            return gson.toJson(resultModel);
        }
        return null;
    }

    @RequestMapping(value = "rest/openapi/nedevice")
    public String neDevices(@RequestHeader("openid") String openid) {
        if ("88a057dbc4f9a271007836c996a972f6d178ecc16bb9d760".equals(openid)) {
            List<TEsightDeviceInfo> esightDeviceInfoList = esightDeviceInfoService.getEsightDeviceInfo();
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(0);
            resultModel.setData(esightDeviceInfoList);
            resultModel.setDescription("Operation success");
            return gson.toJson(resultModel);
        } else {
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(1204);
            resultModel.setData("null");
            resultModel.setDescription("openid auth failed.");
            return gson.toJson(resultModel);
        }
    }

    @RequestMapping(value = "rest/openapi/network/nedevice")
    public String netDevices(@RequestHeader("openid") String openid) {
        if ("88a057dbc4f9a271007836c996a972f6d178ecc16bb9d760".equals(openid)) {
            List<TEsightNEDeviceInfo> esightNeDeviceInfosList =esightDeviceInfoService.getEsightNeDeviceInfo();
            for (TEsightNEDeviceInfo tEsightNEDeviceInfo:esightNeDeviceInfosList) {
                tEsightNEDeviceInfo.setNemac(null);
                tEsightNEDeviceInfo.setCreatetime(null);
            }
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(0);
            resultModel.setData(esightNeDeviceInfosList);
            resultModel.setDescription("Operation success");
            return gson.toJson(resultModel);
        } else {
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(1204);
            resultModel.setData("null");
            resultModel.setDescription("openid auth failed");
            return gson.toJson(resultModel);
        }
    }

    @RequestMapping(value = "rest/openapi/network/port")
    public String netInterfaces(@RequestHeader("openid") String openid,@RequestParam("neip") String ip) {
        if ("88a057dbc4f9a271007836c996a972f6d178ecc16bb9d760".equals(openid)) {
            List<TEsightInterfaceInfo> esightNeInterfaceInfosList = esightDeviceInfoService.getEsightNeInterfaceInfo(ip);
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(0);
            resultModel.setData(esightNeInterfaceInfosList);
            resultModel.setDescription("Operation success");
            return gson.toJson(resultModel);
        } else {
            ResultModel resultModel = new ResultModel();
            resultModel.setCode(1204);
            resultModel.setData("null");
            resultModel.setDescription("openid auth failed.");
            return gson.toJson(resultModel);
        }
    }
}
