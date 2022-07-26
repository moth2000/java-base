package org.day5.HW3_Student;

public class Student {
    //定义成员变量
    private String name; //学生姓名
    private int age;    //学生年龄

    public Student(){}
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    //打印学生信息
    public void show(){
        System.out.println("学生姓名为: " + this.name + " 年龄为: " + this.age);
    }
    //获得学生姓名
    public String getName(){
        return name;
    }
    //修改学生姓名
    public void setName(String name){
        this.name = name;
    }
    //获得学生年龄
    public int getAge(){
        return age;
    }
    //更改学生姓名
    public void setAge(int age){
        this.age = age;
    }
}
