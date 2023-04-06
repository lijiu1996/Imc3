package com.example.demo.practice.pattern.responseChain;

/**
 * @author Li JiaWei
 * @ClassName: Handler
 * @Description:  责任链模式处理器虚基类
 *      1.责任链有多种实现方式 一种典型的实现方式是根据传入的条件按照链一直找到应该可以处理该条件的类
 *          然后由该类对传入的参数进行处理，处理完后不再继续向前查找处理类
 *      2.还有一种实现方法是，沿着责任链条进行查找 找到可以处理条件的类后继续传递给链的下一个，如果
 *
 * @Date: 2022/1/25 11:24
 * @Version: 1.0
 */
public abstract class Handler {

    private Handler next;

    //
    public Handler linkWith(Handler handler) {
        return next;
    }

    public abstract boolean checkNext(String email, String password);

}
