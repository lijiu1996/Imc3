package com.example.demo.practice.pattern.wrapper;

/**
 * @author Li JiaWei
 * @ClassName: CompressionDecorator
 * @Description:
 * @Date: 2022/1/25 10:40
 * @Version: 1.0
 */
public class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource inner) {
        super(inner);
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String data) {
        return  "$" + data;
    }

    private String decompress(String data) {
        if(data.startsWith("$"))
            return data.substring(1);
        return null;
    }

}
