package com.example.demo.practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Li JiaWei
 * @ClassName: HelloProxyDynamic
 * @Description: 动态代理实现代理，这样就不用对每一个需要代理的类都做一个代理类的实现
 *               通过cglib库 还可以实现不通过接口类即可创建代理类
 *               本代理类功能 在调用方法前后打印文字
 * @Date: 2022/1/19 9:25
 * @Version: 1.0
 */
public class LogProxyDynamic implements InvocationHandler {

    private Object target;

    public LogProxyDynamic(Object target) {
        this.target = target;
    }
    public Object getInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        Object result = method.invoke(target, args);
        System.out.println(method);
        System.out.println("after...");
        return result;
    }
}
