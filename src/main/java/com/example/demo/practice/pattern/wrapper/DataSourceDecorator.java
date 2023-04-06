package com.example.demo.practice.pattern.wrapper;

import javax.xml.crypto.Data;

/**
 * @author Li JiaWei
 * @ClassName: MyDecorator
 * @Description: 装饰器基类 主要功能 -- 缓存一个DataSource类在内部
 * @Date: 2022/1/25 10:24
 * @Version: 1.0
 */
public abstract class DataSourceDecorator implements DataSource {

    private DataSource inner;

    public DataSourceDecorator(DataSource inner) {
        this.inner = inner;
    }

    @Override
    public void writeData(String data) {
        inner.writeData(data);
    }

    @Override
    public String readData() {
        return inner.readData();
    }
}
