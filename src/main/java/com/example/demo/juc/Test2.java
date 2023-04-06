package com.example.demo.juc;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author lijiawei
 * @Description 多线程经典问题 -- 售票
 * @Date 2021/9/17 14:32
 * @Version 1.0
 */

class Ticket {

    private Lock lock = new ReentrantLock();
    private int ticket ;

    public Ticket(int ticket) {
        this.ticket = ticket;
    }

    public int getTicket() {
        return ticket;
    }

    public synchronized void sail() {
        if(ticket > 0)
            ticket--;
    }

    public void sail2() {
        lock.lock();
        try {
            ticket--;
        } finally {
            lock.unlock();
        }
    }
}

public class Test2 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket(100000);
        List<Thread> threadList = new ArrayList<>();
        IntStream.range(0,10).forEach(x -> {
            threadList.add(new Thread(() -> {
                for(int i = 0; i < 10000; i++) {
                    ticket.sail2();
                }
            }));
        });
        threadList.forEach(Thread::start);
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(ticket.getTicket());

    }
}
