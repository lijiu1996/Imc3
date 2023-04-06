package com.example.demo.practice.temp;

import java.util.Arrays;
import java.util.List;

/**
 * @author Li JiaWei
 * @ClassName: TempTest3
 * @Description:
 * @Date: 2021/11/3 15:26
 * @Version: 1.0
 */
public class TempTest3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","d");
        for (String s: list) {
            System.out.println(s);
        }
        System.out.println("=============");
        list.forEach(s -> System.out.println(s));
        System.out.println("=============");
        list.forEach(System.out::println);
        System.out.println("=============");
        list.stream().forEach(System.out::println);
        System.out.println("=============");
        list.stream().parallel().forEach(System.out::println);
        System.out.println("=============");
    }
}
