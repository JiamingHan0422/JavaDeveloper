package inheritence;

// 该程序说明了不同包如何影响“受保护”的访问权限。
// 派生类通常可以访问其基类的受保护属性，但是，如果这些类属于不同的包，则以下情况成立：
// 属于不同包的派生类不能通过该基类的对象访问其基类的受保护属性。 然而，派生类有权创建自己类的对象并通过这些对象访问基类的受保护属性。

// Key Points:
// 	1) Protected access rights and packages

import Vehicle.*;	 // Bus12 类是 Vehicle 类的派生类； Vehicle 类属于另一个包

class Bus12 extends Vehicle{

    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus12() {
        System.out.println("Creating a Bus12 object using default constructor ....\n");
        numOfDoors = 2;
        super.price = 32000;
        passengerCapacity = 10;
    }

    public Bus12(int pc, int nd, double pr) {
        System.out.println("Creating a Bus12 object using parameterized constructor ....\n");
        numOfDoors = nd;
        super.price = pr;
        passengerCapacity = pc;
    }

    public Bus12(Bus12 b) {
        System.out.println("Creating a Bus12 object using copy constructor ....\n");
        numOfDoors = b.numOfDoors;
        super.price = b.price;
        passengerCapacity = b.passengerCapacity;
    }

    public int getPassangerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int pc) {
        passengerCapacity = pc;
    }

    public String toString() {
        return "This Bus12 has " + numOfDoors + " doors and its price is: " + price +
                "$. The passenger capacity of this Bus12 is " + passengerCapacity + ".";
    }

    public void showInfo() {
    // 由于 Bus12 与 Vehicle 在不同的包中，因此无法直接引用任何 Vehicle 属性，即使它们受到保护，情况也是如此。 因此，以下将是非法的

        Vehicle v1 = new Vehicle(4, 12000);
        // 注意下面语句被注释掉了，否则直接引用任何 Vehicle 属性的话会报错,想调用的话可以用它的get方法
//      System.out.println("这里是创建的Vehicle的信息：\n");
//      System.out.println("车辆有 " + v1.getNumOfDoors() + " 并且它的价格是 " + v1.getPrice() + "$.");
        System.out.println("Here is the information of the created Vehicless: \n");
        System.out.println("Vehicle has " + v1.getNumOfDoors() + " and its price is " + v1.getPrice() + "$.");

        // 相反，Bus12类可以通过自己的Bus12对象引用Vehicle类的protected属性
        Bus12 b1 = new Bus12(60, 3, 74000);
        System.out.println("Here is the information of the created Bus12:\n");
        System.out.println("The Bus12 has " + b1.numOfDoors + " doors, its price is " +
                b1.price + "$, and it has a passenger capacity of " +	b1.passengerCapacity +".");
    }
}

public class inheritence12 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle objects");

        Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000);

        System.out.println();
        System.out.println("Will create three Bus12 objects");

        Bus12 b1 = new Bus12(), b2 = new Bus12(55, 3, 65000), b3 = new Bus12(b1);

        System.out.println("Here is the information of the first Bus12:\n" + b1 + "\n");
        System.out.println("Here is the information of the second Bus12:\n" + b2 + "\n");
        System.out.println("Here is the information of the third Bus12:\n" + b3 + "\n");

        b3.showInfo();
    }
}


