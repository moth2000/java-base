package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStudy {
    public static void main(String[] args) {
        Queue<Integer> queue= new LinkedList<>();
        MyQueue myQueue = new QueueImpl1();
        for (int i = 0; i < 10; i++){
            queue.offer(i);
            if (i % 2 == 0){
                queue.poll();
            }
            myQueue.offer(i);
            if (i % 2 == 0){
                myQueue.poll();
            }
        }

        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
        System.out.println("");
        while (!myQueue.isEmpty()){
            System.out.print(myQueue.poll() + " ");
        }

    }
}
