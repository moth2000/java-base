package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try{
            fr = new FileReader("test.txt");
            fw = new FileWriter("testCopy.txt");

            int temp = 0;
            while ((temp = fr.read()) != -1){
                fw.write(temp);
            }
            fw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fr != null){
                    fr.close();
                }
                if (fw != null){
                    fw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
