package org.day5.HW2_Phone;

//定义手机类
public class Phone {
    //定义成员
    String brand; //手机品牌
    int price;    //手机价格
    String color; //手机颜色

    //定义打电话的方法
    public void call(){
        System.out.println("正在使用价格为: " + price + " 元 " + color + " 的 "+ brand + " 手机打电话...");
    }

    //定义发短信的方法
    public void sendMessage(){
        System.out.println("正在使用价格为: " + price + " 元 " + color + " 的 "+ brand + " 手机发短信...");
    }
}
