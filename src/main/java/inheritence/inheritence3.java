package inheritence;
// 该程序说明派生类如何覆盖其父类的方法。

// Key Points: 
// 1) Method overriding 
// 2) Calling methods of base class - the keyword "super"


// Vehicle3 Class
class Vehicle3 {
    // Attributes
    private int numOfDoors;
    private double price;

    // default constructor
    public Vehicle3() {
        System.out.println("Creating a Vehicle3 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle3(int nd, double pr) {
        System.out.println("Creating a Vehicle3 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle3(Vehicle3 vec) {
        System.out.println("Creating a Vehicle3 object using copy constructor ....");

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
        return "This Vehicle3 has " + numOfDoors +
                "doors and it price is " + price + "$.";
    }
} // end of Vehicle3 class


// Bus3 类——这是 Vehicle3 类的派生类； 那就是它继承了Vehicle3类
class Bus3 extends Vehicle3{

    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus3() {
        System.out.println("Creating a Bus3 object using default constructor ....\n");

        passengerCapacity = 10;
    }

    public Bus3(int pc) {
        System.out.println("Creating a Bus3 object using parameterized constructor ....\n");

        passengerCapacity = pc;
    }

    public Bus3(Bus3 b) {
        System.out.println("Creating a Bus3 object using copy constructor ....\n");

        passengerCapacity = b.passengerCapacity;
    }

    public int getPassangerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int pc) {
        passengerCapacity = pc;;
    }

    public String toString() {
        return "This Bus3 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus3 is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr) {
        if(pr < getPrice())
            System.out.println("The price of this Bus3 will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this Bus3 will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the Bus3.");
        super.setPrice(pr);
// 请注意，您不能直接访问“price”，因为它是基类私有的
// i.e. price = pr; would be illegal
    }
}   // end of Bus3 class

public class inheritence3 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle3 objects");

        Vehicle3 v1 = new Vehicle3(), v2 = new Vehicle3(4, 5000);
        v1.setPrice(22000);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus3 objects");

        Bus3 b1 = new Bus3(), b2 = new Bus3(55), b3 = new Bus3(b1);

        //改变其中一些Bus3对象的信息
        b1.setNumOfDoors(2);
        b1.setPrice(55000);
        b1.setPassengerCapacity(37);

        b2.setPrice(62000);
        b3.setPrice(9900);

        System.out.println();
        System.out.println("Here is the information of the first Bus3:\n" + b1 + "\n");
        System.out.println("Here is the information of the second Bus3:\n" + b2 + "\n");
        System.out.println("Here is the information of the third Bus3:\n" + b3 + "\n");

    }

}

/* The Output 
Will create two Vehicle3 objects
Creating a Vehicle3 object using default constructor ....
Creating a Vehicle3 object using parameterized constructor ....

Will create three Bus3 objects
Creating a Vehicle3 object using default constructor ....
Creating a Bus3 object using default constructor ....

Creating a Vehicle3 object using default constructor ....
Creating a Bus3 object using parameterized constructor ....

Creating a Vehicle3 object using default constructor ....
Creating a Bus3 object using copy constructor ....

The price of this Bus3 will be increased from 10000.0$ to 55000.0$.
The price of this Bus3 will be increased from 10000.0$ to 62000.0$.
The price of this Bus3 will be reduced from 10000.0$ to 9900.0$.

Here is the information of the first Bus3:
This Bus3 has 2 doors and its price is: 55000.0$. The passenger capacity of this Bus3 is 37.

Here is the information of the second Bus3:
This Bus3 has 4 doors and its price is: 62000.0$. The passenger capacity of this Bus3 is 55.

Here is the information of the third Bus3:
This Bus3 has 4 doors and its price is: 9900.0$. The passenger capacity of this Bus3 is 10.
*/
	
