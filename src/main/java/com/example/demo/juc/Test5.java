package com.example.demo.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * @author lijiawei
 * @Description  CountDownLatch、CylicBarrier、Samophare等同步工具使用
 * @Date 2021/9/22 11:40
 * @Version 1.0
 */
public class Test5 {


    public static void main(String[] args) {
//        longZhu();
    }

    public static void door1() {

    }

    public static void door() {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        IntStream.range(0,6).forEach(x ->
                new Thread(() -> {
                    System.out.println("学生" + x + "已离开教室");
                    countDownLatch.countDown();
                    System.out.println("学生" + x + "在寝室happy");
                }).start());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("班长离开教室并锁门");
    }

    public static void longZhu() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println(Thread.currentThread().getName() + " 收集完毕, 召唤神龙");
        });
        IntStream.range(0,7).forEach(x -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 收集到第" + x + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("第" + x + "颗龙珠就是个玩具");
            }, "t" + x ).start();
        });
    }


}
