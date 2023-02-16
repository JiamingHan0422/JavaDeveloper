package Object;

class object6 {
    String a;
    int c= 2;

    public object6(String ab) {
        a = ab;
    }
}

public class object5 {
    String a;
    int c= 2;
    public object5(String ab) {
        a = ab;
    }
    // 因为 == 比较的是对象引用， 它检查两个操作数是否指向完全相同的同一个对象
    public boolean equals(Object object2) {
        if(a == object2) {
            return true;
        }
        else return false;
    }

    //getClass 方法也能精准的判断两不同对象是否相等，即使是衍生类也不行
    public boolean equals2(Object object2) {
        if (this==object2)
            return true;
        if (this == null)
            return false;
        else if (this.getClass() != object2.getClass())
            return false;
        else
            return false;
    }
    //这个是判断对象的字符串名字和该属性是否相等的
    public boolean equals3 (Object object2) {
        if(a.equals(object2)) {
        return true;
    }
        else return false;
    }
    // instanceof 方法 是衍生类的话就可以
    public boolean equals4(Object object2) {
        return object2 instanceof object5 && a.equals(((object5)object2).a);
    }

    public static void main(String[] args) {

        object5 object1 = new object5("test");
        object6 object2 = new object6("test");

        //那怕object1.a.equals(object2.a);都不行， 如果想相等可以用 a.toString()方法
        object1.equals2(object2);
        System.out.println(object1.equals2(object2));

        object1.equals4(object2);
        System.out.println(object1.equals4(object2));

        //如果两对象都有一个int属性，且其值相等 则他们的==是相等的
        boolean b = object1.c == object2.c;
        System.out.println(b);
    }
}