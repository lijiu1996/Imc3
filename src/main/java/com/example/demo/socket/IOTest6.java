package com.example.demo.socket;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/5/14 14:32
 * @Version 1.0
 */

class House implements Serializable {
    private static final long serialVersionUID = 6502595868691722204L;
}

class Animal implements Serializable {
    private String name;
    private House preferredHouse;
    Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", preferredHouse=" + preferredHouse +
                '}';
    }
}

public class IOTest6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("dog",house));
        animalList.add(new Animal("hamster",house));
        animalList.add(new Animal("cat",house));
        System.out.println(animalList);
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream o1 = new ObjectOutputStream(buf1);
        o1.writeObject(animalList);
        o1.writeObject(animalList);
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animalList);

        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));

        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
        List animals1 = (List)in1.readObject();
        List animals2 = (List)in1.readObject();
        List animals3 = (List)in2.readObject();
        System.out.println("animals1:" + animals1);
        System.out.println("animals2:" + animals2);
        System.out.println("animals3:" + animals3);
        System.out.println(System.identityHashCode(animals1));
        System.out.println(System.identityHashCode(animals2));
    }
}
