package com.example.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author lijiawei
 * @Description 交替打印问题
 *                  如何实现n个线程交替打印到100
 * @Date 2021/9/18 13:45
 * @Version 1.0
 */

class Print {

    private int authority = 0;
    private int startNum = 1;

    private int threadNum;

    private Lock lock = new ReentrantLock();

    private List<Condition> conditions = new ArrayList<>();

    public Print(int threadNum) {
        this.threadNum = threadNum;
        IntStream.range(0,threadNum).forEach( x -> conditions.add(lock.newCondition()));
    }

    /**
     *  多线程共享打印权限，传入打印字符以及字符循环次数
     */
    public void printNumber(int autOrg,String letter,int iter) throws InterruptedException {
        lock.lock();
        try {
            while (autOrg != this.authority) {
                conditions.get(autOrg).await();
            }
            //如果后继线程不连续，需要额外传入参数autNext
            authority= (autOrg + 1) % threadNum;
            StringBuilder sbd = new StringBuilder();
            IntStream.range(0,iter).forEach(x -> sbd.append(letter));
            System.out.println(sbd.toString());
            conditions.get(authority).signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     *  多线程共享打印权限 交替运行直到100为止
     */
    public void printNumberMax(int autOrg,int max) {
        lock.lock();
        try {
            while(true) {
                while (autOrg != this.authority) {
                    try {
                        conditions.get(autOrg).await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                authority = (autOrg + 1) % threadNum;
                if(startNum <= max) {
                    System.out.println(Thread.currentThread().getName() + " " + startNum++);
                    conditions.get(authority).signal();
                } else {
                    conditions.get(authority).signal();
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     *  多线程共享打印权限 交替运行直到100为止，使用wait notify实现
     */
    public void printNumberMaxO(int autOrg, int max) {
        synchronized (this){
            while(true) {
                while (autOrg != this.authority) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                authority = (autOrg + 1) % threadNum;
                if(startNum <= max) {
                    System.out.println(Thread.currentThread().getName() + " " + startNum++);
                    this.notifyAll();
                } else {
                    this.notifyAll();
                    break;
                }
            }
        }
    }
}

/**
 *  依赖信号量机制实现并发打印问题
 */
class PrintSem {
    private int threadNum;

    private List<Semaphore> semaphores= new ArrayList<>();

    PrintSem(int threadNum) {
        this.threadNum = threadNum;
        for(int i = 0; i < threadNum ; i++) {
            if(i == 0) {
                semaphores.add(new Semaphore(1));
            } else
                semaphores.add(new Semaphore(0));
        }
    }

    public void printNum(int autOrg, String letter, int iter) {
        try {
            semaphores.get(autOrg).acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuilder sbd = new StringBuilder();
        sbd.append(Thread.currentThread().getName());
        sbd.append(" ");
        IntStream.range(0,iter).forEach(x -> sbd.append(letter));
        System.out.println(sbd.toString());
        autOrg = (autOrg + 1) % threadNum;
        semaphores.get(autOrg).release();
    }
}

public class Test4 {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    public static void test5() {
        int threadNum = 7;
        PrintSem p = new PrintSem(threadNum);
        IntStream.range(0,threadNum).forEach(x ->
                new Thread(() -> {
                    for(int i = 0; i < 10; i++) {
                        p.printNum(x,String.valueOf((char)('A' + x)),x+1);
                    }
                },"t" + x).start());

    }

    public static void test4() {
        int threadNum = 7;
        Print p = new Print(threadNum);
        IntStream.range(0,threadNum).forEach(x -> {
            new Thread(() -> {
                p.printNumberMaxO(x,100);
            }).start();
        });
    }

    public static void test3() {
        int threadNum = 7;
        Print p = new Print(threadNum);
        IntStream.range(0,threadNum).forEach(x -> {
            new Thread(() -> {
                p.printNumberMax(x,100);
            }).start();
        });
    }

    public static void test2()  {
        Print p = new Print(2);
        String a = "0123456789";
        String b = "abcdefghij";
        String[] strings = {a,b};

        IntStream.range(0,2).forEach(x -> {
            new Thread(() -> {
                try {
                    for(int i = 0; i < a.length(); i++) {
                        p.printNumber(x,strings[x].substring(i,i+1),1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }

    // 使用Lock Condition方式指定输出1A2B3C十次
    public static void test1() {
        Print p = new Print(3);
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    p.printNumber(0,"A",1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    p.printNumber(1,"B",2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for(int i = 0; i < 10; i++) {
                    p.printNumber(2,"C",3);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
