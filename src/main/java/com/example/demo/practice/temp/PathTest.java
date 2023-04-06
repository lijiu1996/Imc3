package com.example.demo.practice.temp;

/**
 * @author Li JiaWei
 * @ClassName: PathTest
 * @Description: ClassLoader获取路径和ssm获取路径的区别
 * @Date: 2022/1/24 10:55
 * @Version: 1.0
 */
public class PathTest {

    static class InnerClass {

        String inner_S;

        public String getInner_S() {
            return inner_S;
        }

        public void setInner_S(String inner_S) {
            this.inner_S = inner_S;
        }

        @Override
        public String toString() {
            return "InnerClass{" +
                    "inner_S='" + inner_S + '\'' +
                    '}';
        }
    }

    public static void pathTest01() {
        // ClassLoader类不支持根路径/的搜索
        InnerClass i = new InnerClass();
        String url1 = PathTest.class.getClassLoader().getResource("").getPath();
        String url2 = PathTest.class.getResource("/").getFile();
        String url3 = PathTest.class.getResource("").toString();
        String url4 = PathTest.class.getResource("../../../../../").toString();
        String url5 = PathTest.class.getResource("TempTest2.class").toString();
        System.out.println(url1);
        System.out.println(url2);
        System.out.println(url3);
        System.out.println(url4);
        System.out.println(url5);
    }

    public static void main(String[] args) {
        pathTest01();
    }
}
