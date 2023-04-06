package com.example.demo.juc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

/**
 * @author lijiawei
 * @Description 线程池研究
 * @Date 2021/9/24 9:10
 * @Version 1.0
 */
public class Test6 {

    private static Log log = LogFactory.getLog(Test6.class);

    public static void main(String[] args) {



//        try {
//            Thread.sleep(12000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    //尝试使用Timer
    public static void test1() {
        Timer timer = new Timer();
        String time = "2021-09-26 09:44:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("I love you");
            }
        }, parse);
    }

    /**
     *  1.出现异常 结束后续提交的任务的执行
     *  2.出现比较耗时的任务 影响后续的执行
     */
    public static void test2() {
        Timer timer = new Timer();
        //添加任务1 延迟500ms执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("--- one Task ---");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("aaaa");
            }
        },500);
        //添加任务2，延迟1000ms执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(;;) {
                    System.out.println("--- two Task---");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },1000);
    }

    // 使用ScheduledThreadPool 解决timer中异常延时的问题
    public static void test3() {

    }
}
