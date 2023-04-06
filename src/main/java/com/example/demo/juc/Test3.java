package com.example.demo.juc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author lijiawei
 * @Description 实现生产者消费者问题
 * @Date 2021/9/17 15:18
 * @Version 1.0
 */

interface Product {
    int getRemain();
    Message get();
    void produce(String name);
}

// 通过Condition实现生产者消费者
class Product_2 implements Product {

    Lock lock = new ReentrantLock();
    Condition pro = lock.newCondition();
    Condition con = lock.newCondition();

    LinkedList<Message> linkedList = new LinkedList<>();
    private int size;

    public Product_2(int size) {
        this.size = size;
    }

    @Override
    public int getRemain() {
        return linkedList.size();
    }

    @Override
    public Message get() {
        lock.lock();
        try {
            while (linkedList.size() == 0) {
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = linkedList.removeFirst();
            System.out.println(Thread.currentThread().getName() + "消费了一条消息：" + message);
            pro.signalAll();
            return message;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void produce(String name) {
        lock.lock();
        try {
            while (linkedList.size() == size) {
                try {
                    pro.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = new Message(name);
            linkedList.add(message);
            System.out.println(name + "生产了一条消息");
            con.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

// 通过原生synchronized方法实现生产者消费者
class Product_1 implements Product {

    LinkedList<Message> linkedList = new LinkedList<>();
    private int size;

    public Product_1(int size) {
        this.size = size;
    }

    //遗留消息数
    public int getRemain() {
        return linkedList.size();
    }

    // 消费一条消息
    public synchronized Message get() {
        while(linkedList.size()==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Message message = linkedList.removeFirst();
        System.out.println(Thread.currentThread().getName() + "消费了一条消息:" + message);
        notify();
        return message;
    }

    // 生产一条消息
    public synchronized void produce(String name) {
        while (linkedList.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Message message = new Message(name);
        linkedList.add(message);
        System.out.println(name + "生产了一条消息");
        notify();
        return;
    }
}

class Message {
    private static int totalId = 0;
    private int id;
    private String name;

    public Message(String name) {
        this.id = ++totalId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Test3 {

    public static void main(String[] args) {

        Product product = new Product_2(4);
        List<Thread> threadsList = new ArrayList<>();
        IntStream.range(0,50).forEach(x -> {
           threadsList.add( new Thread(() -> {
                for (int i = 0; i < 2; i++) {
                    String name = Thread.currentThread().getName();
                    product.produce(name);
                }
           },"生产者" + x));
        });
        IntStream.range(0,25).forEach(x -> {
            threadsList.add( new Thread(() -> {
                for(int i = 0 ; i < 4; i++) {
                    Message message = product.get();
                }
            },"消费者" + x));
        });
        threadsList.forEach(Thread::start);
        threadsList.forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(product.getRemain());
    }
}

