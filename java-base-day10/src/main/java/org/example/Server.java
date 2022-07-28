package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main( String[] args ) throws IOException {
        ServerSocket server=new ServerSocket(8888);
        System.out.println("已启动服务器");
        Socket socket= server.accept();

        InputStream inputStream = socket.getInputStream();


        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String info = null;
        while((info = bufferedReader.readLine())!=null)
        {
            System.out.println("客户端说："+info);
        }

        socket.shutdownInput();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);

        Scanner sc = new Scanner(System.in);
        printWriter.write(sc.next());
        printWriter.flush();


        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        reader.close();
        inputStream.close();

        socket.close();
        server.close();
    }
}
