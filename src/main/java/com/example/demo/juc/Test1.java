package com.example.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author lijiawei
 * @Description 通过synchronized实现ReentranLock
 * @Date 2021/9/17 11:39
 * @Version 1.0
 */


public class Test1 {

    public static int myvalue1 = 0;

    public static void add() {
        myvalue1++;
    }

    public static void main(String[] args) throws InterruptedException {

        MyLock myLock = new MyLock();

        List<Thread> threadList = new ArrayList<>();

        IntStream.range(0,100).forEach(x -> {
            threadList.add(
            new Thread(() -> {
                for (int i = 0; i < 300000 ; i++) {
                    myLock.lock();
                    try {
                        myvalue1++;
                    } finally {
                        myLock.unlock();
                    }
                }
//                    myLock.lock();
//                    try {
//                        myvalue1++;
//                    } finally {
//                        myLock.unlock();
//                    }

            },"t" + x));
        });
        threadList.forEach(Thread::start);
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(myvalue1);
    }

}

class MyLock {

    int state = 0;

    public void lock() {
        synchronized (this) {
            while (state != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            state = 1;
        }
    }

    public void unlock() {
        synchronized (this) {
            state = 0;
            notifyAll();
        }
    }
}