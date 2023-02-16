package LinkedListNArrayList;

class ll {

    public void ShowString() {
        node temp = head;
        if (temp == null)
            System.out.println("\nThere is nothing to display; list is empty.");
        else
            System.out.println("\nHere are the contents of the list.");
        while (temp != null) {
            System.out.print(temp.data + " ---> ");
            temp = temp.next;        // Move to the next node
        }
        System.out.println("X");
    }

    class node {
        String data;
        node next;

        public node() {
            data = "";
            next = null;
        }

        public node(String data, node next) {
            this.data = data;
            this.next = next;
        }
    }

    private node head;

    // 将节点添加到列表开头的方法
    public void addToStart(String data) {
        head = new node(data, head);
    }

    public void addAtEnd(String data) {
        if (head == null)
            head = new node(data, null);
        else {
            node t = head;
            while (t.next != null)
                t = t.next;
            t.next = new node(data, null);
        }
    }

    public void add(int index, String data) {
        if (index >= 0 && index <= size()) {
            if (index == 0)
                addToStart(data);
            else {
                node t = head;
                for (int i = 0; i < index; i++)
                    t = t.next;
                t.next = new node(data, t.next);
            }
        }
    }

    public String getFrontData() {
        if (head != null) {
            System.out.println("Empty list");
            return null;
        }
        return head.data;
    }

    public node getFrontNode() {
        return head;
    }

    public void removeLast() {
        if (!isEmpty()) {
            if (head.next == null)
                head = null;
            else {
                node t = head;
                while (t.next != null)
                    t = t.next;
                t.next = null;
            }
        }
    }

    public void removeFront() {
        if (!isEmpty())
            head = head.next;
        else
            System.out.println("No front to remove");
    }

    public void remove(int index) {

    }

    public node find(String x) {
        if (head == null)
            return null;

        node t = head;
        while (t.next != null) {
            if (t.data.equals(x))
                return t;
            t = t.next;
        }
        return null;
    }

    // 指示值是否在列表中的方法
    public boolean contains(String i) {
        return (find(i) != null);
    }

    public boolean insertAfter(String i, String insertVal) {
        if (head == null) {
            System.out.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
            return false;
        }
        node t = head;
        while (t.next != null && !t.data.equals(i))
            t = t.next;
        if (t == null) {
            System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
            return false;
        }
        t.next = new node(insertVal, t.next);
        return true;
    }

    public boolean insertBefore(String i, String insertVal) {
        if (head == null) {
            System.out.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
            return false;
        }

        if (head.data.equals(i)) {
            head = new node(insertVal, head.next);
            return true;
        }

        node t = head;
        // before 和 after 的区别就在这。
        while (t.next != null && !t.next.data.equals(i))
            t = t.next;
        if (t == null) {
            System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
            return false;
        }
        t.next = new node(insertVal, t.next);
        return true;
    }

    public int size() {
        int count = 0;
        node t = head;
        while (t.next != null) {
            count++;
            t = t.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = null;
    }

    public void addAll(ll other) {
        node t = head;
        while (t.next != null)
            t = t.next;
        t.next = other.head;

//        node cur = other.getFrontNode();
//        while(cur != null) {
//            addAtEnd(cur.data);
//            cur = cur.next;
//        }
    }

    public boolean replace(String i1, String i2) {
//        if(find(i1) != null){
//            node t = head;
//            while(t.next !=null && !t.data.equals(i1))
//                t = t.next;
//            t.data = i2;
//            return true;
//        }
//        else
//            return false;

            node t = find(i1);
            if(t == null){
                System.out.println("can not find replaced value");
                return false;
            }
            t.data = i2;
            return true;
    }
}

public class tryLL {
    public static void main(String[] args) {
        ll lls = new ll();
        ll llf = new ll();

        lls.addToStart("2");
        lls.addToStart("3");
        lls.addToStart("4");

        llf.addToStart("4");
        llf.addToStart("5");
        llf.addToStart("6");

        lls.ShowString();

    }
}
