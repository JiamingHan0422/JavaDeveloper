package inheritence;

// This program illustrates the subject of inheritance and 
// access rights. This program is almost identical to 
// Inherit10.java, however it works. What is the difference?
//
// Key Points: 
// 	1) Access rights
//  2) The "protected" keyword


// Vehicle11 Class
class Vehicle11 {

    // Attributes
     int numOfDoors;	// Notice the access rights of the
     double price;		// class attributes 这里用 defult 或者 protected权限都可以， defult更保险

    // default constructor
    public Vehicle11() {
        System.out.println("Creating a Vehicle11 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle11(int nd, double pr) {
        System.out.println("Creating a Vehicle11 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle11(Vehicle11 vec) {
        System.out.println("Creating a Vehicle11 object using copy constructor ....");

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
        return "This Vehicle11 has " + numOfDoors +
                "doors and it price is " + price + "$.";
    }
}

class Bus11 extends Vehicle11{
    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus11() {
        System.out.println("Creating a Bus11 object using default constructor ....\n");
        numOfDoors = 2;
        super.price = 32000;
        passengerCapacity = 10;
    }

    public Bus11(int pc, int nd, double pr) {
        System.out.println("Creating a Bus11 object using parameterized constructor ....\n");
        numOfDoors = nd;
        super.price = pr;
        passengerCapacity = pc;
    }

    public Bus11(Bus11 b) {
        System.out.println("Creating a Bus11 object using copy constructor ....\n");
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
        return "This Bus11 has " + numOfDoors + " doors and its price is: " + price +
                "$. The passenger capacity of this Bus11 is " + passengerCapacity + ".";
    }
}

public class inheritence11 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle11 objects");

        Vehicle11 v1 = new Vehicle11(), v2 = new Vehicle11(4, 5000);

        System.out.println();
        System.out.println("Will create three Bus11 objects");

        Bus11 b1 = new Bus11(), b2 = new Bus11(55, 3, 65000), b3 = new Bus11(b1);

        System.out.println("Here is the information of the first Bus11:\n" + b1 + "\n");
        System.out.println("Here is the information of the second Bus11:\n" + b2 + "\n");
        System.out.println("Here is the information of the third Bus11:\n" + b3 + "\n");
    }
}

	
