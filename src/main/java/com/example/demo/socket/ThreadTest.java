package com.example.demo.socket;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/5/17 15:04
 * @Version 1.0
 */
public class ThreadTest {

    static List<String> arrayList = new ArrayList<>();

    static List<String> arrayListSafe = new Vector<>();

    static List<String> arrayListSafe2 = Collections.synchronizedList(new ArrayList<String>());

    public static void main(String[] args) {
        Thread[] threads = new Thread[500];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ArrayListThread();
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i< threads.length; i++) {
            System.out.println(arrayList.get(i));
        }
    }

}

class ArrayListThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        ThreadTest.arrayList.add(Thread.currentThread().getName());
    }

}
