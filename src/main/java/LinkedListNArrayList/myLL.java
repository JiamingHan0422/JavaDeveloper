package LinkedListNArrayList;

public class myLL {
    public static void main(String[] args) {
        thell lls = new thell();
        thell llf = new thell();

        lls.addToStart(2);
        lls.addToStart(3);
        lls.addToStart(4);

        llf.addToStart(4);
        llf.addToStart(5);
        llf.addToStart(6);

        String[] strArr = String.valueOf(thell.getSum(lls) + thell.getSum(llf)).split("");
        for(int i = strArr.length-1; i>= 0; i-- )
            System.out.print(strArr[i]);
    }
}

class thell {
     class nodes {
        int data;
        nodes next;

        public nodes() {
            data = 0;
            next = null;
        }

        public nodes(int data, nodes next) {
            this.data = data;
            this.next = next;
        }
    }

    private nodes head;

    // 将节点添加到列表开头的方法
    public void addToStart(int data) {
        head = new nodes(data, head);
    }

    public nodes getFrontNode() {
        return head;
    }

    public int size() {
        int count = 0;
        nodes t = head;
        while (t.next != null) {
            count++;
            t = t.next;
        }
        return count;
    }
    public boolean isEmpty() {
        return (head == null);
    }
    public static int getSum(thell ll ){
        nodes fHead = ll.head;
        int sum =0, count= ll.size();
        while(fHead != null){
            sum += fHead.data * Math.pow(10,count);
            fHead = fHead.next;
            count--;
        }
        return sum;
    }
}