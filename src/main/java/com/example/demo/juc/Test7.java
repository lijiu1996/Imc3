package com.example.demo.juc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author Li JiaWei
 * @ClassName: Test7
 * @Description:
 * @Date: 2021/10/8 9:51
 * @Version: 1.0
 */
public class Test7 {

    private static int k;

    public static void main(String[] args) throws InterruptedException {

        //Timer scheduleAtFixedDate 与 schedule区别
        //某一次执行任务超出预计时间 scheduleAtFixDate会按时结束 schedule则不会瞬间执行完

        final long timeInterval = 1000;
//        Thread thread = new Thread(() -> {
//            while (true) {
//                System.out.println(System.currentTimeMillis() + " :hello");
//                try {
//                    Thread.sleep(timeInterval);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();

//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                int i = 0;
//                if(k == 10) {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println(System.currentTimeMillis() +" :hello " +k);
//                k++;
//            }
//        };
//        Timer timer = new Timer();
//        long delay = 0;
//        timer.scheduleAtFixedRate(task,delay,timeInterval);
//        timer.schedule(task,delay,timeInterval);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        long beginTime = System.currentTimeMillis();
        int cycle = 10;
        long endTime = beginTime + cycle *1000;
        service.scheduleAtFixedRate(()-> {
            System.out.println(System.currentTimeMillis()/1000 + " :hello");
            if(System.currentTimeMillis() >endTime)
                service.shutdown();
        },3,1, TimeUnit.SECONDS);

    }
}

class DataContainer {

    int size;
    List<Integer> dataList = new ArrayList<>();

    public synchronized void add(int i) {
        dataList.add(i);
        size++;
    }

    public synchronized int size() {
        return size;
    }

}

