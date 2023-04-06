package com.example.demo.practice.proxy;

/**
 * @author Li JiaWei
 * @ClassName: HelloProxy
 * @Description:   通过静态代理主动实现代理方法
 * @Date: 2022/1/19 9:20
 * @Version: 1.0
 */
public class HelloProxy implements Hello {

    private Hello target;

    public HelloProxy(Hello target) {
        this.target = target;
    }


    @Override
    public void sayHello() {
        System.out.println("before...");
        target.sayHello();
        System.out.println("after...");
    }
}
