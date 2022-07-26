package org.day5.HW3_Student;

public class StudentTest {
    public static void main(String[] args) {
        //空参构造方法创造对象
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(20);
        stu1.show();
        //有参构造方法创建对象
        Student stu2 = new Student("李四",18);
        stu2.show();
    }
}
