package com.example.demo.socket;

/**
 * @author lijiawei
 * @Description 内部类
 * @Date 2021/5/12 10:21
 * @Version 1.0
 */
public class Outer {

    private String location;

    public Outer() {
        location = "现在处于外部";
    }

    private void tellLocation() {
        System.out.println( this.location);
    }

    public class Inner {
        private String location;

        private Inner() {
            this.location = "现在处于内部!!!!";
        }

        public void tellInnerLocation() {
            tellLocation();
            System.out.println(this.location);
            System.out.println(Outer.this.location);
        }

    }

    public static void main(String[] args) {
        Inner tmp = new Outer().new Inner();
        tmp.tellInnerLocation();
    }
}
