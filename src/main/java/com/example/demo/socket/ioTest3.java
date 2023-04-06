package com.example.demo.socket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lijiawei
 * @Description 正则表达式测试Demo
 * @Date 2021/5/10 14:09
 * @Version 1.0
 */
public class ioTest3 {
    public static void main(String[] args) throws IOException {
        testInputStream();
    }

    public static void testInputStream() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\HelloWorld.txt");
        int c;
        while ((c = fis.read())!= -1) {
            System.out.println(Integer.toHexString(c));
        }
        System.out.println("------");
        String s = "Hello wold你";
        byte[] bb = s.getBytes();
        printByteArray(bb);
        byte[] bbg = s.getBytes("GBK");
        byte[] bbu = s.getBytes("UTF-8");
        printByteArray(bbg);
        printByteArray(bbu);

        System.out.println("---------------");
        System.out.println(Integer.toBinaryString(0xe4));

        System.out.println("---------------");
        System.out.println(new String(s.getBytes(),"GBK"));
    }

    /**
     *  十六进制输出一个byte数组
     */
    public static void printByteArray(byte[] bytes) {
        for(byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
    }

    public static void testRegex() {
        /**
         * String.matches(regex) == Pattern.matches(regex,str)
          */

        String s = "ab123ff";
        Pattern p = Pattern.compile("([a-z]{2}).*(?=[a-z]{2})");
        Matcher m = p.matcher(s);
        System.out.println(m.matches());
        System.out.println(m.group());
//        System.out.println(m.group(1));
//        System.out.println(m.group(2));

    }
}
