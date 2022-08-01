package org.example;

import java.util.LinkedList;

public class QueueImpl1 implements MyQueue{

    private LinkedList<Integer> list;

    public QueueImpl1(){
        list = new LinkedList<>();
    }

    @Override
    public void offer(int value) {
        list.addLast(value);
    }

    @Override
    public int poll() {
        return list.removeFirst();
    }

    @Override
    public int peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
