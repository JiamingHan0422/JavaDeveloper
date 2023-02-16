package inheritence;


// 这个程序说明了“final”修饰符。 如果该修饰符位于方法定义之前，则该方法可能不会在派生类中被覆盖。
//
// Key Points:
// 1) Method overriding
// 2) method overloading
// 3) The "final" modifier

import java.util.Scanner;

// Vehicle4 Class
class Vehicle4 {

    // Attributes
    private int numOfDoors;
    private double price;

    // Constructors
    public Vehicle4()	// default constructor
    {
        System.out.println("Creating a Vehicle4 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle4(int nd, double pr)
    {
        System.out.println("Creating a Vehicle4 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
    }


    public Vehicle4(Vehicle4 vec)	// copy constructor
    {
        System.out.println("Creating a Vehicle4 object using copy constructor ....");

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

    final public void setPrice(double pr) {
        price = pr;
    }

    public String toString() {
        return "This Vehicle4 has " + numOfDoors +
                "doors and it price is " + price + "$.";
    }
} // end of Vehicle4 class


// Bus4 类——这是 Vehicle4 类的派生类； 那就是它继承了Vehicle4类
class Bus4 extends Vehicle4{

    // Attributes
    private int passengerCapacity;

    // Constructors
    public Bus4()	// default constructor
    {
        System.out.println("Creating a Bus4 object using default constructor ....\n");

        passengerCapacity = 10;
    }

    public Bus4(int pc)
    {
        System.out.println("Creating a Bus4 object using parameterized constructor ....\n");

        passengerCapacity = pc;
    }

    public Bus4(Bus4 b)
    {
        System.out.println("Creating a Bus4 object using copy constructor ....\n");

        passengerCapacity = b.passengerCapacity;
    }

    public int getPassangerCapacity()
    {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int pc)
    {
        passengerCapacity = pc;;
    }

    public String toString()
    {
        return "This Bus4 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus4 is " + passengerCapacity + ".";
    }

    // 由于 final 修饰符，以下方法重写将是非法的
    // final 一旦出现，它的属性值得将无法被修改，如 final int x = 10; Main myObj = new Main(); myObj.x = 25; 会报错。 也无法被子类override方法修改
/*
	public void setPrice(double pr){
		if(pr < getPrice())
			System.out.println("The price of this Bus4 will be reduced from " + getPrice() + "$ to " + pr + "$.");
		else if (pr > getPrice())
			System.out.println("The price of this Bus4 will be increased from " + getPrice() + "$ to " + pr + "$.");
		else
			System.out.println("No change will be applied to this price of the Bus4.");

		super.setPrice(pr);
		// Notice that you cannot access "price" directly  since it is private to the base class
		// i.e. price = pr; would be illegal

	}
*/

    // 然而，以下方法override是合法的，因为
    // 重载方法与基类中标记为“final”的方法不同。
    public void setPrice() // Notice that this is an overloading
    {
        // Create a Scanner object
        Scanner kb = new Scanner(System.in);
        double pr;
        System.out.print("Please enter the new price of this Bus4: ");
        pr = kb.nextInt();

        if(pr < getPrice())
            System.out.println("The price of this Bus4 will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this Bus4 will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the Bus4.");

        super.setPrice(pr);
        // Notice that you cannot access "price" directly  since it is private to the base class
        // i.e. price = pr; would be illegal

    }
}   // end of Bus4 class



public class inheritence4 {

    public static void main(String[] args) {
        System.out.println("Will create two Vehicle4 objects");

        Vehicle4 v1 = new Vehicle4(), v2 = new Vehicle4(4, 5000);
        v1.setPrice(22000);
        v1.setPrice(22001);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus4 objects");

        Bus4 b1 = new Bus4(), b2 = new Bus4(55), b3 = new Bus4(b1);

        //Change the information of some of those Bus4 objects
        b1.setNumOfDoors(2);
        b1.setPrice();
        b1.setPassengerCapacity(37);

        b2.setPrice();

        System.out.println();
        System.out.println("Here is the information of the first Bus4:\n" + b1 + "\n");
        System.out.println("Here is the information of the second Bus4:\n" + b2 + "\n");
        System.out.println("Here is the information of the third Bus4:\n" + b3 + "\n");
        System.out.println("Here is the information of the third Bus4:\n" + v1 + "\n");
    }
}
