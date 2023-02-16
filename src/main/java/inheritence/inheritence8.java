package inheritence;

// *******************************************************************
// Inherit8.java By: Aiman Hanna (C) 1993 - 2021
// 这个程序说明了“this”构造函数。 “this”构造函数可以在构造函数的定义中使用，以调用同一类的另一个构造函数。
// “this”构造函数必须是第一条语句； 因此，“this”或“super”可以与构造函数一起使用，但不能同时使用。
//
// Key Points:
// 1) The "this" constructor  
// *******************************************************************

// Vehicle8 Class
class Vehicle8 {

    // Attributes
    private int numOfDoors;
    private double price;


    // default constructor
    public Vehicle8() {
        System.out.println("Creating a Vehicle8 object using default constructor ....");
        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle8(int nd, double pr) {
        System.out.println("Creating a Vehicle8 object using parameterized constructor ....");
        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle8(Vehicle8 vec) {
        System.out.println("Creating a Vehicle8 object using copy constructor ....");
        numOfDoors = vec.numOfDoors;
        price = vec.price;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int nd) {
        numOfDoors = nd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double pr) {
        price = pr;
    }

    public String toString() {
        return "This Vehicle8 has " + numOfDoors +
                "doors and it price is " + price + "$.";
    }
}

class Bus8 extends Vehicle8{

    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus8() {
        System.out.println("Creating a Bus8 object using default constructor ....\n");
        passengerCapacity = 10;
    }

    public Bus8(int pc) {
        System.out.println("Creating a Bus8 object using parameterized constructor ....\n");
        passengerCapacity = pc;
    }

    public Bus8(Bus8 b) {
        System.out.println("Creating a Bus8 object using copy constructor ....\n");
        passengerCapacity = b.passengerCapacity;
    }

    // 允许设置price 和 number of doors 和passenger capacity的构造函数
    public Bus8(int nd, double pr, int pc) {
        // 在类的构造函数定义中，this 可以用作调用同一类的另一个构造函数的名称
        // 关于如何使用对 super 的调用的限制 也适用于 this 构造函数
        // 如果需要同时包含对 super 和 this 的调用，则必须先使用 this 进行调用，然后被调用的构造函数必须将 super 作为其第一个动作
        this(pc); 	// 调用设置载客量的构造函数 即Bus8(int pc)， 但不能直接写 Bus8(pc)，所以拿this代替

        System.out.println("Creating a Bus8 object using parameterized constructor for full settings....\n");
        // 请注意，我们现在不能调用 super 来设置其他两个属性
        //（即 super(nd, pr);）因为“this”或“super”必须是第一个语句，并且不可能同时拥有它们！

        setPrice(pr);
        setNumOfDoors(nd);
    }


    public int getPassangerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int pc) {
        passengerCapacity = pc;;
    }

    public String toString() {
        return "This Bus8 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus8 is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr) {
        if(pr < getPrice())
            System.out.println("The price of this Bus8 will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this Bus8 will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the Bus8.");

        super.setPrice(pr);
        // Notice that you cannot access "price" directly  since it is private to the base class
        // i.e. price = pr; would be illegal

    }
}   // end of Bus8 class



public class inheritence8 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle8 objects");

        Vehicle8 v1 = new Vehicle8(), v2 = new Vehicle8(4, 5000);
        v1.setPrice(22000);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus8 objects");

        Bus8 b1 = new Bus8(2, 55000, 37), b2 = new Bus8(3, 62000, 55), b3 = new Bus8(b1);

        //Change the information of some of those Bus8 objects

        b3.setPrice(9900);

        System.out.println();
        System.out.println("Here is the information of the first Bus8:\n" + b1 + "\n");
        System.out.println("Here is the information of the second Bus8:\n" + b2 + "\n");
        System.out.println("Here is the information of the third Bus8:\n" + b3 + "\n");
    }
}

	
