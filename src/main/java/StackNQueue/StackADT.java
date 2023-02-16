package StackNQueue;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

class MyStack <E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        if (size == elements.length) {
            // 扩容
            ensureCapacity();
        }
        elements[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }
    public int Size(){
        return size;
    }

     public E Peek(){
         int len = Size();

         if (len == 0)
             throw new EmptyStackException();
         return (E) elements[len-1];
     }

    public boolean empty() {
        return Size() == 0;
    }
    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(elements[i].toString());
            if(i < size-1)
                sb.append(",");
        }
        sb.append(']');
        return sb.toString();
    }
}

public class StackADT {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack);
        System.out.println(stack.Peek());
        System.out.println(stack.pop());
        System.out.println(stack.Peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack);
    }
}