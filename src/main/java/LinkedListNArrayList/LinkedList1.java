package LinkedListNArrayList;

import java.util.LinkedList;

import static java.sql.Types.NULL;

class IntList {
    private class Node {
        private int v;
        private Node next;	// 指向下一个节点的链接，类型为 Node1
        public Node() {
            v = 0;
            next = null;
        }
        public Node(int i, Node xt) {
            v = i;
            next = xt;
        }

//        public int getV() {
//            return v;
//        }
//
//        public Node getNext() {
//            return next;
//        }
    }

    private Node head;

    public IntList() {
        head = null;
    }

    // 将节点添加到列表开头的方法
    public void addToStart(int i) {
        Node n = new Node(i, head);
        head = n;
        n = null;
    }
    public void addAtEnd(int i) {
        if(head == null) {
            head = new Node(i, null);
            return;
        }

        Node t = head;
        while(t.next != null)
            t = t.next;

        Node n = new Node(i, null);
        t.next = n;
        n = null;
    }

    public void add(int index, int d) {
        if(index >= 0 && index <= size()  ) {
            if(index == 0)
                addToStart(d);
            else {
                Node cur = head;
                for(int i=0; i<index-1; i++)
                    cur = cur.next;
                Node n = new Node(d, cur.next);
                cur.next = n;
            }
        }
    }

    public int getFrontData() {
        if(head == null){
            System.out.println("Empty list");
            return NULL;
        }

        return head.v;
    }

    public Node getFrontNode() {
        return head;
    }
    public void removeFront() {
        if(!isEmpty())
            head = head.next;
         else
             System.out.println("No front to remove");
    }

    public void removeLast() {
        if(!isEmpty()) {
            if(head.next == null)
                head = null;
            else {
                Node t = head;
                while(t.next != null)
                    t = t.next;
                t.next = null;
            }
        }
    }

    public void remove(int index) {
        if(index >= 0 && index <= size() ) {
            if(index == 0)
                removeFront();
            else if(index == size()-1)
                removeLast();
            else {
                Node cur = head;
                for(int i=0; i<index-1; i++)
                    cur = cur.next;
                cur.next = cur.next.next;
            }
        }
    }

    public Node find(int x) {
        if (head == null)	 // 这个特例验证能去掉吗？？
            return null; // 真的需要吗？为什么？
        Node t = head;
        while(t != null) {
            if (t.v == x)
                return t;		// Is that dangerous?? See Later
            t = t.next;
        }
        return null;		// value was not found in the list
    }

    public boolean insertAfter (int i, int x) {
        // 在第一个值为 i 的节点之后插入一个值为 x 的新节点
        // 如果没有找到值为 i 的节点，则不会进行插入并返回 false
        if (head == null) {
            System.out.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
            return false;
        }
        Node t = head;
        while(t!= null && t.v != i)
            t = t.next;

        if (t == null) {
            System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
            return false;
        }

        // 如果达到这一点，那么i就被发现了；
        Node n = new Node(x, t.next);
        t.next = n;
        n = null;			// These 3 lines can be replaced by
        // t.next = new Node(x, t.next);
        return true;
    }

    public boolean insertBefore (int i, int x) {
        // 在第一个值为 i 的节点之前插入一个值为 x 的新节点
        // 如果没有找到值为 I 的节点，则不会进行插入并返回 false
        if (head == null) {
            System.out.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
            return false;
        }
        // i is the first value at head
        if(head.v == i) {
            head = new Node(x, head);
            return true;
        }

        Node t = head;
        while(t.next!= null && t.next.v != i)
            t = t.next;
        if (t.next == null) {
            System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
            return false;
        }

        // 如果达到这一点，那么i就被发现了；
        Node n = new Node(x, t.next);
        t.next = n;
        n = null;			// These 3 lines can be replaced by
        // t.next = new Node(x, t.next);
        return true;
    }

    // 返回列表大小的方法,  是否有更有效的方法来查找大小？
    public int size() {
        int ctr = 0;
        Node temp = head;	// Point to the start of the list
        while(temp!= null) {
            ctr++;
            temp = temp.next;
        }
        return ctr;
    }

    // 指示值是否在列表中的方法
    public boolean contains(int i) {
        if(find(i) != null)
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        if(head == null)
            return true;
        else
            return false;
    }

    public void clear() {
        head = null;
    }

    public void addAll(IntList other) {
        Node cur = other.getFrontNode();
        while(cur != null) {
            addAtEnd(cur.v);
            cur = cur.next;
        }
    }

    //一种在列表中搜索值为 i1 的节点的方法，如果找到，则将该节点修改为值为 i2。
    public boolean replace(int i1, int i2) {
        Node t = find(i1);
        if(t == null) {
            System.out.println("\nCould not find value " + i1 + " in the list; no replacement is possible.");
            return false;
        }
        t.v = i2;
        return true;
    }

    public void showListContents() {
        Node temp = head;
        if (temp == null)
            System.out.println("\nThere is nothing to display; list is empty." );
        else
            System.out.println("\nHere are the contents of the list." );
        while(temp != null) {
            System.out.print(temp.v + " ---> ");
            temp = temp.next;		// Move to the next node
        }
        System.out.println("X");
    }

}


public class LinkedList1 {
    public static void main(String[] args) {
        IntList lst1 = new IntList();

        lst1.addToStart(18);
        lst1.addToStart(22);
        lst1.addToStart(4);
        lst1.addToStart(7);
        lst1.addToStart(32);
        lst1.addToStart(48);
        lst1.addAtEnd(108);
        lst1.addToStart(18);
        lst1.addToStart(12);

        lst1.addToStart(32);

        lst1.showListContents();

        lst1.replace(4, 52);
        lst1.showListContents();


        lst1.replace(95, 72);
        lst1.showListContents();

        lst1.insertAfter(7, 93);
        lst1.showListContents();

        lst1.insertBefore(48, 55);
        lst1.showListContents();

        lst1.insertBefore(32, 68);
        lst1.showListContents();

        lst1.replace(18, 44);
        lst1.showListContents();

        lst1.insertAfter(18, 98);
        lst1.showListContents();

        lst1.insertAfter(60, 3);
        lst1.showListContents();
    }
}

