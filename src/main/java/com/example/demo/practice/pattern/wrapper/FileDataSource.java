package com.example.demo.practice.pattern.wrapper;

/**
 * @author Li JiaWei
 * @ClassName: FileDataSource
 * @Description:    懒得搞io了 直接模拟一个类缓存文件内容
 * @Date: 2022/1/25 10:21
 * @Version: 1.0
 */
public class FileDataSource implements DataSource {

    private String content;

    public FileDataSource(String fileName) {
        content = fileName;
    }

    @Override
    public void writeData(String data) {
        content += data;
    }

    @Override
    public String readData() {
        return content;
    }
}
