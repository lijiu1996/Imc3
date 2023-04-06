package com.example.demo.socket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/5/8 14:40
 * @Version 1.0
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile f = new RandomAccessFile("D:\\HelloWorld2.txt","rw");
        Person p = new Person(1001,"lijiawei",1.73);
        p.write(f);
        f.write("啦啦啦啦啦".getBytes());
    }
}

class Person {
    private int id;
    private String name;
    private double height;

    public Person() {

    }

    public Person(int id, String name, double height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }

    public void write(RandomAccessFile raf) throws IOException {
        raf.write(String.valueOf(id).getBytes());
//        raf.writeUTF(name);
//        raf.writeDouble();
        raf.write(String.valueOf(name).getBytes());
        raf.write(String.valueOf(height).getBytes());
    }
}
