package org.example;

import java.util.LinkedList;

public class QueueImpl2 implements MyStack{

    private LinkedList<Integer> list;

    public QueueImpl2(){
        list = new LinkedList<>();
    }

    @Override
    public void push(int value) {
        list.addLast(value);
    }

    @Override
    public int pop() {
        return list.getFirst();
    }

    @Override
    public int peek() {
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
