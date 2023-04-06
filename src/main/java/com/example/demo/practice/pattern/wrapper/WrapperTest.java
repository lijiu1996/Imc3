package com.example.demo.practice.pattern.wrapper;

/**
 * @author Li JiaWei
 * @ClassName: WrapperTest
 * @Description:  设计模式学习 -- 装饰器模式Test类
 * @Date: 2022/1/24 16:48
 * @Version: 1.0
 */
public class WrapperTest {

    public static void main(String[] args) {

        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("test.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = encoded;

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
//        System.out.println("- Encoded --------------");
//        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());

    }


}
