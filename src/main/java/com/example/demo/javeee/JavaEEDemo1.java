package com.example.demo.javeee;

import java.io.*;
import java.nio.CharBuffer;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/6/22 11:02
 * @Version 1.0
 */
public class JavaEEDemo1 {

    public static void main(String[] args) throws IOException {

        ByteArrayInputStream cc;
        BufferedInputStream bb;
        FileInputStream aa;
        String a = "1234";
        int b = 66;
        DataOutputStream dout = new DataOutputStream(new FileOutputStream("D:\\test.txt"));
        dout.writeInt(b);
        dout.close();
    }

    public void p() {
        System.out.println("demo2");
    }

}
