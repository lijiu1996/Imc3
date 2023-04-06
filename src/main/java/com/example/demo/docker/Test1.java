package com.example.demo.docker;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Li JiaWei
 * @ClassName: Test1
 * @Description:
 * @Date: 2021/9/29 15:26
 * @Version: 1.0
 */
public class Test1 {

    private static Map<String,String>   hashmap = new HashMap<>();
    private static Map<String,String>   treemap = new TreeMap<>();
    private static Map<String,String>   linkedHashmap = new LinkedHashMap<>();

    public static void main(String[] args) {

        // cancelAquare研究
        // next变更的几种可能
        // 1. 后继线程 should时 指向后继第一个非取消节点
        // 2. cancel结束时被当前线程指向自己
        // 3. 后继线程 cancel时 变更指向

        // next几种变更不允许的情况
        // 前向节点取消状态指向自己
    }
}
