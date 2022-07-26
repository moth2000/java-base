package org.day5.HW1_Teacher;

public class Teacher {
    //定义两个成员变量
    String name; //老师名字
    String id;   //老师工号
    //编写成员方法 teach() 以输入老师信息
    public void teach(){
        System.out.println("工号为: " + id + " 的 " + name + " 老师正在讲课 " );
    }
}
