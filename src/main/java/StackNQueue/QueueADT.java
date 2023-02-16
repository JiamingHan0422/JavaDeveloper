package StackNQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueADT {
    public static void main(String[] args) {
        // Queue可以直接基于链表来实现
//        Queue<Integer> qe2 = new LinkedList<>();
//        qe2.add(10);
//        qe2.add(11);
//        qe2.add(12);
//        System.out.println(qe2.size());
//        System.out.println(qe2.isEmpty());
//        System.out.println(qe2.peek());
//        System.out.println(qe2.remove());
//        System.out.println(qe2.remove());
//        System.out.println(qe2.remove());
//        System.out.println(qe2.size());
//        System.out.println(qe2.isEmpty());

        MyQueue qe = new MyQueue(10);
        qe.enqueue(10);
        qe.enqueue(11);
        qe.enqueue(12);
        System.out.println(qe.size());
        System.out.println(qe.isEmpty());
        System.out.println(qe.front());
        System.out.println(qe.dequeue());
        System.out.println(qe.dequeue());
        System.out.println(qe.dequeue());
        System.out.println(qe.size());
        System.out.println(qe.isEmpty());
    }
}

// 也可以基于array
 class MyQueue {
    private Integer[] arr;
    private Integer size;
    private Integer first;
    private Integer last;

    public MyQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        first = 0;
        last = 0;
    }

    public Integer front() {
        if (size == 0) {
            return null;
        }
        return arr[first];
    }

    public void enqueue(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[last] = obj;
        // 若尾是最后一个
        if(last == arr.length - 1 )
            last =  0;
        else
            last ++;
//        last = last == arr.length - 1 ? 0 : last + 1;
    }

    public Integer dequeue() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = first;
        if(first == arr.length - 1 )
            first =  0;
        else
            first ++;
//        first = first == arr.length - 1 ? 0 : first + 1;
        return arr[tmp];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size ==0);
    }
}