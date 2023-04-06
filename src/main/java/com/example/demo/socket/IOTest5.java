package com.example.demo.socket;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @author lijiawei
 * @Description 测试一下序列话
 * @Date 2021/5/13 11:50
 * @Version 1.0
 */
public class IOTest5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "D:\\HelloWorld2.txt";
//        aLittleTest(path);
        aLittleTest2(path);
    }

    public static void aLittleTest(String path) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader(path));
        BufferedOutputStream bf = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("D:\\test.gz")));
        int c;
        while((c = b.read())!= -1) {
            bf.write(c);
        }
        b.close();
        bf.close();
    }

    /**
     *  尝试序列化一个对象
     */
    public static void aLittleTest2(String path) throws IOException, ClassNotFoundException {

        Per p = new Per(18,"lijiawei",50);
        Per p2 = new Per(20,"zzz",60);
        TaT tt = new TaT();
        tt.setP1(p);
        tt.setP2(p2);
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path));
        obj.writeObject(tt);
        obj.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        TaT tttt = (TaT)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(tttt);
    }


}

class TaT implements Serializable {
    private Per p1 ;
    private Per p2 ;

    TaT() {

    }

    public Per getP1() {
        return p1;
    }

    public void setP1(Per p1) {
        this.p1 = p1;
    }

    public Per getP2() {
        return p2;
    }

    public void setP2(Per p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "TaT{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}

class Per implements Serializable {
    private static final long serialVersionUID = 1360579068787866765L;
    private int age;
    private String name;
    private int score;

    public Per(int age, String name, int score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Per{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if( 0 > score || 100 < score) {
            throw new IllegalArgumentException("学生的分数必须在0到100之间");
        }
    }
}
