package com.example.demo.practice.temp;

/**
 * @author Li JiaWei
 * @ClassName: TempTest
 * @Description:    异常测试
 * @Date: 2021/10/25 9:14
 * @Version: 1.0
 */

public class TempTest {

    public static void main(String[] args) {

        TempTest tempTest = new TempTest();
        try {
            tempTest.method();
        } catch (Throwable e) {
            System.out.println("没有调用fillInStackTrace()");
            System.err.println("Caught in Main1");
            e.printStackTrace();
            System.out.println("调用fillInStackTrace()");
            e.fillInStackTrace();
            System.err.println("Caught in Main2");
            e.printStackTrace();
        }
    }

    public void method() throws Throwable {
        divide();
    }

    private void divide() {
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            throw e;
        }
    }
}
