package com.example.demo.socket;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/5/8 15:04
 * @Version 1.0
 */
public class IOTest2 {
    public static void main(String[] args) throws IOException {
        /**
        String filePath = "D:\\Learn\\Imc3\\src\\main\\java\\com\\example\\demo\\socket\\ioTest.java";
        String filePath2 = "D:\\tempOut.txt";
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String s;
        int lineno = 1;

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath2)));
        while((s = in.readLine()) != null) {
            out.println(lineno + ": " + s);
            System.out.println(s);
            lineno++;
        }
        out.close();*/

//        String src = "C:\\Users\\a1\\Desktop\\docker.jpg";
//        String dst = "D:\\docker.jpg";
//        copyFile(src,dst);

        String path = "D:\\HelloWorld2.txt";

        readerRead(path);
        streamRead(path);


        String path3 = "D:\\HelloWorld3.txt";




        /*  DataOutputStream 使用
        char c3 = '中';
        String c4 = "中";
        DataOutputStream fo = new DataOutputStream(new FileOutputStream(path3));
        fo.writeChar(c3);
//        fo.write(c4.getBytes());
        fo.writeUTF(c4);
//        fo.write(c4.getBytes());
        fo.close();
        System.out.println("-------");

        DataInputStream doo = new DataInputStream(new FileInputStream(path3));
        char c = doo.readChar();
        String s = doo.readUTF();
        System.out.println("-----" + c);
        System.out.println(" ------" + s);
         */

        /*  PrintStream 使用
        PrintStream po = new PrintStream(new FileOutputStream(path3));
        char c3 = '中';
        String c4 = "中";
        po.print(c3);
        po.print(c4);
        po.close();
         */

//          DataOutputStream使用
        /*
        DataOutputStream doo = new DataOutputStream(new FileOutputStream(path3));
        doo.writeChar('中');
        doo.writeByte('中');
        doo.writeChar(3);
        doo.writeByte(3);
        doo.close();
        */

        /*  FileOutputStream使用
        FileOutputStream fo = new FileOutputStream(path3);
        String s = new String("hello world");
        fo.write(s.getBytes());
        fo.close();
         */

    }

    public static String read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void copyFile(String srcPath, String desPath) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(desPath));
        byte[] temp = new byte[1024];
        int len = -1;
        while ((len = bufferedInputStream.read(temp)) != -1) {
            bufferedOutputStream.write(temp,0,len);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public static String readFile(String srcPath) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(srcPath));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine())!= null) {
            sb.append(s);
            System.out.println(s);
        }
        return sb.toString();
    }

    public static void sumA(String srcPath) throws IOException {

        String total = readFile(srcPath);
        Map<Character,Integer> resultMap = new HashMap<>();
        for(char c : total.toCharArray()) {
            if(resultMap.containsKey(c)) {
                int res = resultMap.get(c);
                resultMap.put(c,++res);
            } else {
                resultMap.put(c,1);
            }
        }
        System.out.println(resultMap);
    }

    public static void streamRead(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        int c;
        while ((c = fileInputStream.read()) != -1) {
            System.out.println(c);
        }
        System.out.println();
    }

    public static void readerRead(String path) throws IOException{
        FileReader fileReader = new FileReader(path);
        int c;
        while ((c = fileReader.read()) != -1) {
            System.out.print((char)c);
        }
        System.out.println();
    }

    /**
     * 显示输出字符数组
     * @param org
     * @return
     */
    public static String lookByteArray(byte[] org) {
        StringBuilder sb = new StringBuilder();
        for(byte b : org) {
            sb.append(Integer.toHexString(b & 0xff));
            sb.append(" ");
        }
        return sb.toString();
    }


}
