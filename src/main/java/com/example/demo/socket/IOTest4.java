package com.example.demo.socket;

import java.io.*;

/**
 * @author lijiawei
 * @Description 联系Reader Writer相关方法
 * @Date 2021/5/12 19:39
 * @Version 1.0
 */
public class IOTest4 {

    public static void main(String[] args) throws IOException {
        String path = "D:\\HelloWorld4.txt";
//        aLittleTest2(path);
//        aLittleTest(path);
//        String pathsrc = "C:\\Users\\a1\\Desktop\\docker.jpg";
//        String newpath = "D:\\docker.jpg";
//        fileCopyTest(pathsrc,newpath);
//        aLittleTest4(path);
        aLittleTest5(path);

    }


    public static void aLittleTest(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        int b = -1;
        while((b = fis.read())!=-1) {
            System.out.println(Integer.toHexString(b & 0xFF));
        }
        fis.close();
    }

    public static void aLittleTest2(String path) throws IOException {
        FileOutputStream fos = new FileOutputStream(path,true);
        int b = 256;
        fos.write(b);
        fos.close();
    }

    public static void fileCopyTest(String path1,String path2) throws IOException {
        File file1 = new File(path1);
        File file2 = new File(path2);
        if(!file2.exists()){
            file2.createNewFile();
        }

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        byte[] bytes = new byte[1024];
        int len = -1;
        while((len = fis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }
        fos.close();
    }

    public static void aLittleTest3(String path) throws IOException {
        byte[] bytes = {'a','b','c','d',(byte)0xe4,(byte)0xb8,(byte)0xad};
        String s1 = new String(bytes);
        System.out.println(s1);
    }

    /**
     * 联系使用InputStreamReader 以及OutputStreamWriter
     * @param path
     * @throws IOException
     */
    public static void aLittleTest4(String path) throws IOException {
        InputStreamReader iso = new InputStreamReader(new FileInputStream(path),"unicode");
        int len = -1;
        char[] tmp = new char[1024];
        while((len = iso.read(tmp))!=-1) {
            System.out.println(new String(tmp,0,len));
        }
    }

    public static void aLittleTest5(String path) throws IOException {
        PrintWriter f = new PrintWriter(path);
        f.print("123中文");
        f.close();
        FileReader f2 = new FileReader(path);
        int c = -1;
        while((c=f2.read())!= -1) {
            System.out.println((char)c);
        }
    }


}
