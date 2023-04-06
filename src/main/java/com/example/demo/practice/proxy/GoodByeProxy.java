package com.example.demo.practice.proxy;

/**
 * @author Li JiaWei
 * @ClassName: GoodByeProxy
 * @Description:    通过静态代理的方式实现对GoodBye类的代理
 * @Date: 2022/1/19 9:29
 * @Version: 1.0
 */
public class GoodByeProxy implements GoodBye {

    private GoodBye target;

    public GoodByeProxy(GoodBye target) {
        this.target = target;
    }

    @Override
    public void goodBye() {
        System.out.println("before ...");
        target.goodBye();
        System.out.println("after...");
    }
}
