package com.example.demo.socket;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/5/7 15:59
 * @Version 1.0
 */
public class ioTest {

    public static void main(String[] args) {
        List<File> path = new ArrayList<>();
        File path1 = new File(".");
        File f1 = new File("D:\\Learn\\Imc3\\.");
        path.add(path1);
        path.add(f1);

        for(File file : path) {
            System.out.println("AbsolutePath():" + file.getAbsolutePath());
            System.out.println("Path():" + file.getPath());
            System.out.println("getName():" + file.getName());
            System.out.println("getParent():" + file.getParent());
            System.out.print("list():");
            String[] list;
//            list = file.list(new DirFilter(".*"));
            list = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    Pattern pattern = Pattern.compile(".+\\..+");
                    return pattern.matcher(name).matches();
                }
            });
            for(String dirItem: list)
                System.out.println("-- " + dirItem);
        }

    }
}

class DirFilter implements FilenameFilter {

    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
