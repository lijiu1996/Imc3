package com.example.demo.service;



import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author lijiawei
 * @Description Snmp协议工具类
 * @Date 2021/4/8 11:08
 * @Version 1.0
 */
public class SnmpUtil {

    public static String toHexString(String value) {

        String res = "";
        if(value == "")
            return res;
        try {
            byte[] resBytes = value.getBytes("UTF-8");
            for(int i = 0; i != resBytes.length; i++) {
                String hex = Integer.toHexString(resBytes[i]);
                res += hex.substring(hex.length()-2,hex.length());
                if(i != resBytes.length-1)
                    res += ":";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<Object> mapValueToList(Map<String,Object> data) {
        List<Object> list = (List<Object>) Arrays.asList(data.values().toArray());
        return list;
    }

    public static String hexStringToString(String str) {
        str = str.replace(":","");
        str = str.replace(" ","");
        byte[] byteword = new byte[str.length()/2];
        try {
            for (int i = 0; i< byteword.length; i++) {
                byteword[i] = (byte) (0xff & Integer.parseInt(str.substring(i*2, i*2 + 2),16));
            }
            str = new String(byteword,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(hexStringToString("e6:8e:a5:e5:8f:a3:e7:89:a9:e7:90:86:e7:8a:b6:e6:80:81:e4:b8:ba:44:6f:77:6e"));
    }
}
