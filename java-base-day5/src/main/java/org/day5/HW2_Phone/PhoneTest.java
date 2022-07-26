package org.day5.HW2_Phone;

public class PhoneTest {
    public static void main(String[] args) {
        //创建手机对象
        Phone phone = new Phone();
        //给手机对象赋值
        phone.brand = "小米";
        phone.price = 3998;
        phone.color = "黑色";
        //打印打电话和发短信的信息
        phone.call();
        phone.sendMessage();
    }
}
