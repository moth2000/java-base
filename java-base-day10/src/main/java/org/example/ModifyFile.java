package org.example;

import java.io.*;

public class ModifyFile {
    public static void main(String[] args) throws Exception{
           String content = "Hello World!";
           byte[] data = content.getBytes("UTF-8");
           File file = new File("test.txt");

        //添加文字进文档
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(data);
        outputStream.close();

        System.out.println("已运行完毕!");
       }

}

