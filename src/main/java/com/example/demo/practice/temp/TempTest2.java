package com.example.demo.practice.temp;

/**
 * @author Li JiaWei
 * @ClassName: TempTest2
 * @Description:    数组clone -- 浅复制 地址要变得
 *                  自定义对象数组 和 不可变对象数组是两回事
 *                  不可变对象数组clone 和 直接=赋值又有区别？？
 *
 *                  1. 自定义对象数组clone 里面存放的都是引用字段 clone仅仅相当于新建一个引用数组对象 然后该引用对象的元素统统用 = 赋值
 *                  2. 自定义对象数组==赋值 仅仅相当于新建立一个指针指向同一个地方
 *                  3. 不可变对象数组==赋值(字符串、数字) 相当于同一指针，改变的都是一个东西
 *                  4. 不可变对象数组clone 真正的区别是不可变对象数组并不具备改变状态的功能，所以clone以后再赋值相当于将新数组的指向改变
 *                  5. 不信的话可以做一个尝试 自定义对象数组clone以后不进行状态变化，而是指向新的对象
 *
 * @Date: 2021/10/25 9:42
 * @Version: 1.0
 */
public class TempTest2 {

    public static void main(String[] args) {

        // 自定义对象数组clone 与 自定义对象数组赋值
        Student[] arrs = new Student[1];
        arrs[0] = new Student(12,"qwe") ;
        Student[] arrsClone = arrs.clone();
        System.out.println(arrs == arrsClone);
        System.out.println(arrs.equals(arrsClone));
        arrsClone[0].setId(56);
        System.out.println(arrs == arrsClone);
        System.out.println(arrs.equals(arrsClone));

        Student[] arrs2 = new Student[1];
        arrs2[0] = new Student(13,"qwe");
        Student[] arrs2Clone = arrs2.clone();
        System.out.println(arrs2Clone == arrs2);
        System.out.println(arrs2Clone.equals(arrs2));
        arrs2Clone[0] = new Student(5555,"5555");
        System.out.println(arrs2Clone = arrs2);

//        String[] arrs = new String[] {"a", "b" };
//        String[] arrClone = arrs.clone();
//        System.out.println(arrs == arrClone);
//        arrs[1] = "dddddddd";
//        System.out.println(arrs == arrClone);


    }
}

class Student {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }
}