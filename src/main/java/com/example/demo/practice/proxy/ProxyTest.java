package com.example.demo.practice.proxy;

/**
 * @author Li JiaWei
 * @ClassName: ProxyTest
 * @Description:    动态代理Demo
 * @Date: 2022/1/19 9:14
 * @Version: 1.0
 */
public class ProxyTest  {

    public static void main(String[] args) {

        // 可以看出,使用静态代理的方案实现代理，需要对每一种被代理的类均实现一种代理类
        // 但是现实中有很多代理添加的功能是一致的，所以需要动态代理来提供统一接口
        HelloProxy helloProxy = new HelloProxy(new HelloImpl());
        helloProxy.sayHello();
        System.out.println("==============");
        GoodByeProxy goodByeProxy = new GoodByeProxy(new GoodByeImpl());
        goodByeProxy.goodBye();
        System.out.println("==============");

        //使用JDK提供的方案实现动态代理
        Hello helloProxyDynamic = (Hello) new LogProxyDynamic(new HelloImpl()).getInstance();
        GoodBye goodByeProxyDynamic = (GoodBye) new LogProxyDynamic(new GoodByeImpl()).getInstance();
        helloProxyDynamic.sayHello();
        goodByeProxyDynamic.goodBye();
//        System.out.println("===============");
        // 上面是实现一,还有一种实现可以通过在bind的时候newProxy来实现

        //使用CGLIB实现动态代理

    }
}
