package com.example.demo.practice.proxy;

/**
 * @author Li JiaWei
 * @ClassName: HelloImpl
 * @Description：Target目标类
 * @Date: 2022/1/19 9:20
 * @Version: 1.0
 */
public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("hello !");
    }
}
