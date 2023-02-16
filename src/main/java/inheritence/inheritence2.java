package inheritence;
// 这个程序说明了更多的继承。 派生类可以访问其父类的实例变量和方法（这将根据访问权限进行修改）。
// Key Points:
// 1) Having access to methods of parent classes

// Vehicle Class
class Vehicl2 {
    // Attributes
    private int numOfDoors;
    private double price;

    // default constructor
    public Vehicl2() {
        System.out.println("Creating a Vehicl2 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
    }

    public Vehicl2(int nd, double pr) {
        System.out.println("Creating a Vehicl2 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicl2(Vehicl2 vec) {
        System.out.println("Creating a vehicle object using copy constructor ....");

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

    public String toString()
    {
        return "This Vehicle has " + numOfDoors +
                "doors and it price is " + price + "$.";
    }
}

// Bus 类——这是 Vehicle 类的派生类； 那就是它继承了Vehicle类
class Bus2 extends Vehicl2{
    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus2() {
        System.out.println("Creating a Bus2 object using default constructor ....\n");
        passengerCapacity = 10;
    }

    public Bus2(int pc) {
        System.out.println("Creating a Bus2 object using parameterized constructor ....\n");
        passengerCapacity = pc;
    }

    public Bus2(Bus2 b) {
        System.out.println("Creating a Bus2 object using copy constructor ....\n");
        passengerCapacity = b.passengerCapacity;
    }

    public int getPassangerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int pc) {
        passengerCapacity = pc;;
    }

    public String toString() {
        return "This Bus has " + getNumOfDoors() + " and its price is: " + getPrice() +
                "$. The passenger capacity of this bus is " + passengerCapacity + ".";
    }
}

public class inheritence2 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicl2 objects");

        Vehicl2 v1 = new Vehicl2(), v2 = new Vehicl2(4, 5000);

        System.out.println();
        System.out.println("Will create three Bus objects");

        Bus2 b1 = new Bus2(), b2 = new Bus2(55), b3 = new Bus2(b1);

        //Change the information of some of those bus objects
        b1.setNumOfDoors(2);
        b1.setPrice(55000);
        b1.setPassengerCapacity(37);

        b2.setPrice(62000);
        b3.setPrice(32000);

        System.out.println("Here is the information of the first bus:\n" + b1 + "\n");
        System.out.println("Here is the information of the second bus:\n" + b2 + "\n");
        System.out.println("Here is the information of the third bus:\n" + b3 + "\n");
    }
}



