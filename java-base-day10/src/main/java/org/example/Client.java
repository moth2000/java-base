package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)throws Exception {

        Socket socket=new Socket("127.0.0.1",8888);
        System.out.println("客户端已启动");

        OutputStream outputStream=socket.getOutputStream();
        PrintWriter out=new PrintWriter(outputStream);
        Scanner sc= new Scanner(System.in);
        out.write(sc.next());
        out.flush();

        socket.shutdownOutput();

        InputStream inputStream= socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(inputStream);
        BufferedReader br=new BufferedReader(isr);

        String  info = null;
        while((info=br.readLine())!=null){
            System.out.println("收到服务端的响应:" + info);
        }


        br.close();
        isr.close();
        out.close();

        out.close();
        socket.close();
    }
}
