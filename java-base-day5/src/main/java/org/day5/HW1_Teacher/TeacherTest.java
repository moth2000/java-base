package org.day5.HW1_Teacher;

public class TeacherTest {
    public static void main(String[] args) {
        //创建老师对象
        Teacher teacher = new Teacher();
        //对老师对象进行赋值
        teacher.name = "HaiCoder";
        teacher.id = "20191024";
        //调用teach()方法输出结果
        teacher.teach();
    }
}
