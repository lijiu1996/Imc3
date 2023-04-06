package com.example.demo.practice.pattern.wrapper;

/**
 * @author Li JiaWei
 * @ClassName: MyWritter
 * @Description:
 * @Date: 2022/1/25 10:12
 * @Version: 1.0
 */
public interface DataSource {

    void writeData(String data);
    String readData();
}
