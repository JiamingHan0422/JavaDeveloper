package inheritence;

// 该程序说明了在使用继承时默认构造函数的重要性。
// 请注意，此程序中的基类没有定义的构造函数。 该程序会编译/运行吗？ 如果是这样，请仔细注意它的输出。
// Key Points:
// 	1) Default constructors

// Vehicle6 Class
class Vehicle6 {
    // Attributes
    private int numOfDoors;
    private double price;

    // 请注意，此类没有定义的构造函数 所以用的是系统默认的构造函数
    //    public Vehicle6(){
    //    }
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
        return "This Vehicle6 has " + numOfDoors +
                "doors and it price is " + price + "$.";
    }
}

class Bus6 extends Vehicle6{
    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus6() {
        System.out.println("Creating a Bus6 object using default constructor ....\n");
        passengerCapacity = 10;
    }

    public Bus6(int pc) {
        System.out.println("Creating a Bus6 object using parameterized constructor ....\n");
        passengerCapacity = pc;
    }

    public Bus6(Bus6 b) {
        System.out.println("Creating a Bus6 object using copy constructor ....\n");
        passengerCapacity = b.passengerCapacity;
    }


    public int getPassangerCapacity() {
        return passengerCapacity;
    }


    public void setPassengerCapacity(int pc) {
        passengerCapacity = pc;;
    }

    public String toString() {
        return "This Bus6 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus6 is " + passengerCapacity + ".";
    }
}

public class inheritence6 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle6 objects");

        Vehicle6 v1 = new Vehicle6(), v2 = new Vehicle6();

        System.out.println();
        System.out.println("Will create three Bus6 objects");

        Bus6 b1 = new Bus6(), b2 = new Bus6(55), b3 = new Bus6(b1);

        System.out.println("Here is the information of the first Bus6:\n" + b1 + "\n");
        System.out.println("Here is the information of the second Bus6:\n" + b2 + "\n");
        System.out.println("Here is the information of the third Bus6:\n" + b3 + "\n");
    }
}

/* The Output
Will create two Vehicle6 objects

Will create three Bus6 objects
Creating a Bus6 object using default constructor ....

Creating a Bus6 object using parameterized constructor ....

Creating a Bus6 object using copy constructor ....

Here is the information of the first Bus6:
This Bus6 has 0 doors and its price is: 0.0$. The passenger capacity of this Bus6 is 10.

Here is the information of the second Bus6:
This Bus6 has 0 doors and its price is: 0.0$. The passenger capacity of this Bus6 is 55.

Here is the information of the third Bus6:
This Bus6 has 0 doors and its price is: 0.0$. The passenger capacity of this Bus6 is 10.
*/

