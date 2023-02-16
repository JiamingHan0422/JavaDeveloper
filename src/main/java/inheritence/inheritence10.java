package inheritence;

// *******************************************************************
// Inherit10.java By: Aiman Hanna (C) 1993 - 2021
// This program illustrates the subject of inheritance and
// access rights. Notice that this program does NOT work. Why?
// There are 10 errors in this program. Can you locate them?
// Key Points:
// 	1) Access rights
// *******************************************************************

// Vehicle10 Class
class Vehicle10 {

    // Attributes
    // 将访问权限private改成 protected 就好了
    protected int numOfDoors;
    protected double price;

    // default constructor
    public Vehicle10() {
        System.out.println("Creating a Vehicle10 object using default constructor ....");
        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle10(int nd, double pr) {
        System.out.println("Creating a Vehicle10 object using parameterized constructor ....");
        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle10(Vehicle10 vec) {
        System.out.println("Creating a Vehicle10 object using copy constructor ....");
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
        return "This Vehicle10 has " + numOfDoors +
                "doors and it price is " + price + "$.";
    }
} // end of Vehicle10 class

class Bus10 extends Vehicle10{

    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus10()	{
        System.out.println("Creating a Bus10 object using default constructor ....\n");
        // 访问权限问题， 这些属性值是父类private的，即使是继承也需要降低访问权限为 protected
        super.numOfDoors = 2;
        super.price = 32000; //此处super可以省略， 但没法super（numOfDoors，price） 因为 super只能玩默认的构造函数
        passengerCapacity = 10;
    }

    public Bus10(int pc, int nd, double pr) {
        System.out.println("Creating a Bus10 object using parameterized constructor ....\n");
        numOfDoors = nd;
        super.price = pr;
        passengerCapacity = pc;
    }

    public Bus10(Bus10 b) {
        System.out.println("Creating a Bus10 object using copy constructor ....\n");
        super.numOfDoors = b.numOfDoors;
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
        return "This Bus10 has " + numOfDoors + " doors and its price is: " + price +
                "$. The passenger capacity of this Bus10 is " + passengerCapacity + ".";
    }
}

public class inheritence10 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle10 objects");

        Vehicle10 v1 = new Vehicle10(), v2 = new Vehicle10(4, 5000);

        System.out.println();
        System.out.println("Will create three Bus10 objects");

        Bus10 b1 = new Bus10(), b2 = new Bus10(55, 3, 65000), b3 = new Bus10(b1);

        System.out.println("Here is the information of the first Bus10:\n" + b1 + "\n");
        System.out.println("Here is the information of the second Bus10:\n" + b2 + "\n");
        System.out.println("Here is the information of the third Bus10:\n" + b3 + "\n");
    }
}

