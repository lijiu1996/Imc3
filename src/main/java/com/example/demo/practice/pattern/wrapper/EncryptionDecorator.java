package com.example.demo.practice.pattern.wrapper;

/**
 * @author Li JiaWei
 * @ClassName: EncryptionDecorator
 * @Description:
 * @Date: 2022/1/25 10:39
 * @Version: 1.0
 */
public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource inner) {
        super(inner);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String encode(String data) {
        return "#" + data;
    }

    private String decode(String data) {
        if(data.startsWith("#"))
            return data.substring(1);
        return null;
    }
}
