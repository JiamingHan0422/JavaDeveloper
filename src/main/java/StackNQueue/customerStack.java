package StackNQueue;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

import static java.sql.Types.NULL;

public class customerStack {
    public static void main(String[] args) {
        customStack<String> cs = new customStack<>();

        cs.push("my");
        cs.push("Heart");
        cs.push("will");
        System.out.println(cs.size());
        System.out.println(cs.peek());
        System.out.println(cs.pop());
        System.out.println(cs.size());
        System.out.println(cs.pop());
        System.out.println(cs.size());
        System.out.println(cs.pop());
        System.out.println(cs.size());
        System.out.println(cs.isEmpty());
    }

}

class customStack <E> {
    private int size =0;
    private final int Defulat_Cap = 10;
    Object[] element ;
    public customStack(){
        element = new Object[Defulat_Cap];
    }

    public void push(E e){
        int len = size;
        if(len == element.length)
            extendCap();
        element[size++] = e;
    }

    public E pop(){
        E e = (E) element[--size];
        element[size] = NULL;
        return e;
    }

    public E peek(){
        if (size !=0)
            return (E) element[size-1];
        else
            throw new EmptyStackException();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size() ==0);
    }

    public void extendCap(){
        int newSize = element.length *2;
        element = Arrays.copyOf(element,newSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(element[i].toString());
            if(i < size-1)
                sb.append(",");
        }
        sb.append(']');
        return sb.toString();
    }
}

//public class stackBasedOnLL {
//    private LinkedList stack;
//
//    public stack() {
//        stack = new LinkedList();
//    }
//    public boolean isEmpty() {
//        return (stack.size() == 0);
//    }
//
//    /*Stack is LIFO, so we better add to front to make sure
//     the new words that we just add in wont be remove out. */
//    public void push(String s){
//        stack.addToFront(s);
//    }
//
//	/* or
//	public void push(String s) {
//		stack.add(0, s);
//	}  */
//
//    public String pop() {
//        String top = "";
//        if(! isEmpty()) {
//            top= stack.getFrontData();
//            stack.removeFront();
//        }
//        else
//            top += "stack empty";
//        return top;
//    }
//
//    //print out the front node.
//    public String peek() {
//        String top = "";
//        if(! isEmpty()) {
//            top = stack.getFrontData();
//        }
//        else
//            top += "stack empty";
//        return top;
//    }
//}
