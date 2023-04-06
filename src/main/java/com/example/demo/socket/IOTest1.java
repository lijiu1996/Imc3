package com.example.demo.socket;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/5/8 11:00
 * @Version 1.0
 */
public class IOTest1 {
    public static void main(String[] args) throws IOException {

        /*
        File d = new File(".");
        listDir(d);

        System.out.println("------------");
        File d1 = new File("D:\\Learn\\Imc3");
        listDir(d1);

         */

        File d = new File(".");
        listJava(d);
    }

    public static void copyFile(File sourceFile,File dir) {

    }

    public static void moveFile() {
        File old = new File("D:\\IOTest\\HelloWorld.txt");
        System.out.println(old.exists());
        System.out.println(old.getAbsolutePath());
        System.out.println(old.getPath());
        System.out.println(old.getName());

        File newf = new File("D:\\HelloWorld.txt");
//        old.renameTo(newf);
        System.out.println(newf.getAbsolutePath());
        System.out.println(newf.getPath());
        System.out.println(newf.getName());
    }

    /**
     *  递归实现输入任意目录列出该目录下的文件和文件夹
     */
    public static void listDir(File dir) {
        for(File f:dir.listFiles()) {
            if(f.isDirectory()) {
                listDir(f);
            } else {
                System.out.println(f);
            }
        }
    }

    /**
     *  递归列出任意目录下含有的java文件
     * @param dir
     */
    public static void listJava(File dir) throws IOException {
        for(File f:dir.listFiles(new JavaFilter())) {
            if(f.isDirectory()) {
                listJava(f);
            } else {
                System.out.println(f.getCanonicalPath() + "-----------" + f.getParent());
            }
        }
    }

}

class JavaFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        System.out.println(dir + "::::" +  name);
        File f = new File(dir,name);
        if(f.isDirectory())
            return true;
        Pattern pattern = Pattern.compile(".*java");
            return pattern.matcher(name).matches();
    }
}

class JavaFilter2 implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return true;
    }
}
