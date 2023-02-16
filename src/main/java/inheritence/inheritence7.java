//package inheritence;
//
//// 这个程序说明了更多的默认构造函数。 该程序与 inherit6.java 类似，只是基类具有一些已定义的构造函数。 该程序会编译/运行吗？ 为什么？
//// 由于基类已经定义了一些构造函数，该语言不会为该类创建任何默认构造函数。 当类根本没有定义的构造函数时，情况就不同了（请参阅 Inherit6.java）。
//// Key Points:
//// 	1) Default constructors
//
////对基类构造函数的调用永远不能使用基类的名称，而是使用关键字super
////对 super 的调用必须始终是构造函数定义中采取的第一个动作
////注意如果不使用super，那么会自动发出对基类默认构造函数的调用
////因此，如果基类没有默认构造函数，就会出现编译错误
//
//// Vehicle7 Class
//class Vehicle7 {
//    // Attributes
//    private int numOfDoors;
//    private double price;
//
//    // Constructors
//    public Vehicle7(int nd, double pr) {
//        System.out.println("Creating a Vehicle7 object using parameterized constructor ....");
//        numOfDoors = nd;
//        price = pr;
//    }
//
//    // copy constructor
//    // 由于这块写了一个构造函数， 那么 子类在对基类默认构造函数调用的时候若没有找到默认构造函数将报错
//    public Vehicle7(Vehicle7 vec)	{
//        System.out.println("Creating a Vehicle7 object using copy constructor ....");
//        numOfDoors = vec.numOfDoors;
//        price = vec.price;
//    }
////这里必须要写一个默认构造函数
////    public Vehicle7() {
////    }
//
//    public int getNumOfDoors() {
//        return numOfDoors;
//    }
//
//    public void setNumOfDoors(int nd) {
//        numOfDoors = nd;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double pr) {
//        price = pr;
//    }
//
//    public String toString() {
//        return "This Vehicle7 has " + numOfDoors +
//                "doors and it price is " + price + "$.";
//    }
//}
//
//
//class Bus7 extends Vehicle7{
//
//    // Attributes
//    private int passengerCapacity;
//
//    // default constructor
//    public Bus7() {
////        super(); Bu7 找不到默认构造函数 则报错
//        System.out.println("Creating a Bus7 object using default constructor ....\n");
//        passengerCapacity = 10;
//    }
//
//    public Bus7(int pc) {
////        super();
//        System.out.println("Creating a Bus7 object using parameterized constructor ....\n");
//        passengerCapacity = pc;
//    }
//
//    public Bus7(Bus7 b) {
////        super();
//        System.out.println("Creating a Bus7 object using copy constructor ....\n");
//        passengerCapacity = b.passengerCapacity;
//    }
//
//    public int getPassangerCapacity() {
//        return passengerCapacity;
//    }
//
//    public void setPassengerCapacity(int pc) {
//        passengerCapacity = pc;;
//    }
//
//    public String toString() {
//        return "This Bus7 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
//                "$. The passenger capacity of this Bus7 is " + passengerCapacity + ".";
//    }
//}
//
//public class inheritence7 {
//    public static void main(String[] args) {
//        System.out.println("Will create two Vehicle7 objects");
//
//        Vehicle7 v1 = new Vehicle7(4, 12000), v2 = new Vehicle7(v1);
//
//        System.out.println();
//        System.out.println("Will create three Bus77 objects");
//
//        Bus7 b1 = new Bus7(), b2 = new Bus7(55), b3 = new Bus7(b1);
//
//        System.out.println("Here is the information of the first Bus7:\n" + b1 + "\n");
//        System.out.println("Here is the information of the second Bus7:\n" + b2 + "\n");
//        System.out.println("Here is the information of the third Bus7:\n" + b3 + "\n");
//
//    }
//}
//
///* Compilation results
//Errors (3 items)
//
//x- Description	Resource	Path	Location	Type
//Implicit super constructor Vehicle7() is undefined. Must explicitly invoke another constructor	Inherit7.java	/Inherit7/src	line 75	Java Problem
//
//x- Description	Resource	Path	Location	Type
//Implicit super constructor Vehicle7() is undefined. Must explicitly invoke another constructor	Inherit7.java	/Inherit7/src	line 82	Java Problem
//
//x- Description	Resource	Path	Location	Type
//Implicit super constructor Vehicle7() is undefined. Must explicitly invoke another constructor	Inherit7.java	/Inherit7/src	line 89	Java Problem
//*/
//
