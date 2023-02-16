package Polymorphism;

// *******************************************************************
// Polymorphism4.java By: Aiman Hanna (C) 1993 - 2021
// This program examines the subject of polymorphism in relation to copy
// constructors. Does this program behave as expected? Why?
// 深copy和浅copy只是在 类的实例对象上操作不同，浅copy只做引用传递，他不copy关于类的实例变量。而深copy完完全全copy关于类的实例变量，相当于真的copy了一个新的对象出来
//
// Key Points:
// 1) Polymorphism & Copy Constructors.
// *******************************************************************

// Vehicle4 Class
class Vehicle4 {

    // Attributes
    protected int numOfDoors;
    protected double price;
    private long serialNum;
    private static long serialNumCtr = 1000;


    // Constructors
    public Vehicle4()	// default constructor
    {
        System.out.println("\nCreating a Vehicle4 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
        serialNum = serialNumCtr++;
    }

    public Vehicle4(int nd, double pr)
    {
        System.out.println("\nCreating a Vehicle4 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
        serialNum = serialNumCtr++;
    }


    public Vehicle4(Vehicle4 vec)	// copy constructor
    {
        System.out.println("\nCreating a Vehicle4 object using copy constructor ....");

        numOfDoors = vec.numOfDoors;
        price = vec.price;
        serialNum = serialNumCtr++;		// Never duplicate a serial number
    }

    public int getNumOfDoors()
    {
        return numOfDoors;
    }

    public void setNumOfDoors(int nd)
    {
        numOfDoors = nd;
    }

    public double getPrice()
    {
        // Obtain the class name just for display purposes
        String s = this.getClass().toString();
        s = s.substring(6); // Remove the word "class" to get only the class name

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public void setPrice(double pr)
    {
        price = pr;
    }

    public String toString()
    {
        return "This Vehicle4 has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }

    // Find out if that Vehicle4 has a cheaper price than the passed Vehicle4
    public boolean isCheaper(Vehicle4 v)
    {
        // Obtain the class names just for display purposes
        String s1 = this.getClass().toString(), s2 = v.getClass().toString();
        s1 = s1.substring(6); // Remove the word "class" to get only the class name
        s2 = s2.substring(6);


        if(getPrice() < v.getPrice())
        {

            System.out.println("The price of this " + s1 +
                    " object is cheaper than the price of the passed " +
                    s2 + " object.");
            return true;
        }
        else
        {
            System.out.println("The price of this " + s1 +
                    " object is NOT cheaper than the price of the passed " +
                    s2 + " object.");
            return false;
        }
    }

    public long getSerNumber()
    {
        return serialNum;
    }

} // end of Vehicle4 class




// Bus4 Class - This is a derived class from the Vehicle4 Class; that is it
// inherits the Vehicle4 class
class Bus4 extends Vehicle4{

    // Attributes
    private int passengerCapacity;
    private long serialNum;
    private static long serialNumCtr = 2000;

    // Constructors
    public Bus4()	// default constructor
    {
        System.out.println("Creating a Bus4 object using default constructor ....");

        passengerCapacity = 10;
        serialNum = serialNumCtr++;
    }

    public Bus4(int pc)
    {
        System.out.println("Creating a Bus4 object using parameterized constructor ....");

        passengerCapacity = pc;
        serialNum = serialNumCtr++;
    }

    public Bus4(Bus4 b)
    {
        System.out.println("Creating a Bus4 object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
        serialNum = serialNumCtr++;
    }


    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public Bus4(int nd, double pr, int pc)
    {

        this(pc); 	// Call the constructor that sets the passenger capacity

        System.out.println("Creating a Bus4 object using parameterized constructor for full settings....\n");

        // Notice that we now cannot call super to set the other two attributes
        // (i.e. super(nd, pr);) since either "this" or 'super" must be the first
        // statement, and it is not possible to have both of them as such!
        setPrice(pr);
        setNumOfDoors(nd);
        // serialNum is assigned in the call to the "this" constructor
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

    // Override the setPrice() method
    public void setPrice(double pr)
    {
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

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "Bus4";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }
}   // end of Bus4 class



//Car4 Class - This is a derived class from the Vehicle4 Class.
//For a Car4 object, we are interested in its number of seats
class Car4 extends Vehicle4{

    // Attributes
    private int numOfSeats;
    private long serialNum;
    private static long serialNumCtr = 3000;

    // Constructors
    public Car4()	// default constructor
    {
        System.out.println("Creating a Car4 object using default constructor ....");

        numOfSeats = 5;
        serialNum = serialNumCtr++;
    }

    public Car4(int nd, double pr, int ns)
    {
        super(nd, pr);
        System.out.println("Creating a Car4 object using parameterized constructor ....");

        numOfSeats = ns;
        serialNum = serialNumCtr++;
    }

    public Car4(Car4 c)
    {
        System.out.println("Creating a Car4 object using copy constructor ....");
        setNumOfDoors(c.getNumOfDoors());
        setPrice(c.getPrice());
        numOfSeats = c.numOfSeats;
        serialNum = serialNumCtr++;
    }


    public int getNumOfSeats()
    {
        return numOfSeats;
    }

    public void setNumOfSeats(int ns)
    {
        numOfSeats = ns;;
    }

    public String toString()
    {
        return "This Car4 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Car4 is " + numOfSeats + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "Car4";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }
}   // end of Car4 class



//SportCar4 Class - This is a derived class from the Car4 Class
//For a SportCar4 object, we are interested in its gas consumption
// as gallon per 100 miles
class SportCar4 extends Car4{

    // Attributes
    private double gasConsumption;
    private long serialNum;
    private static long serialNumCtr = 4000;

    // Constructors
    public SportCar4()	// default constructor
    {
        System.out.println("Creating a sport Car4 object using default constructor ....");

        gasConsumption = 4;
        serialNum = serialNumCtr++;
    }

    public SportCar4(int nd, double pr, int ns, double gc)
    {
        super(nd, pr, ns);
        System.out.println("Creating a sport Car4 object using parameterized constructor ....");
        gasConsumption = gc;
        serialNum = serialNumCtr++;
    }

    public SportCar4(SportCar4 sc)
    {
        System.out.println("Creating a sport Car4 object using copy constructor ....");

        setNumOfDoors(sc.getNumOfDoors());
        setPrice(sc.getPrice());
        setNumOfSeats(sc.getNumOfSeats());

        gasConsumption = sc.gasConsumption;
        serialNum = serialNumCtr++;
    }


    public double getGasConsumption()
    {
        return gasConsumption;
    }

    public void setGasConsumption(double gc)
    {
        gasConsumption = gc;;
    }

    public String toString()
    {
        return "This Sport Car4 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car4 is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "SportCar4";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }
}   // end of Sport Car4 class



//RaceCar4 Class - This is a derived class from the SportCar4 Class
//For a RaceCar4 object, we are interested in its horse power
class RaceCar4 extends SportCar4{

    // Attributes
    private int horsePower;
    private long serialNum;
    private static long serialNumCtr = 5000;

    // Constructors
    public RaceCar4()	// default constructor
    {
        System.out.println("Creating a race Car4 object using default constructor ....");

        horsePower = 400;
        serialNum = serialNumCtr++;
    }

    public RaceCar4(int nd, double pr, int ns, double gc, int hp)
    {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race Car4 object using parameterized constructor ....");
        horsePower = hp;
        serialNum = serialNumCtr++;
    }

    public RaceCar4(RaceCar4 rc)
    {
        System.out.println("Creating a race Car4 object using copy constructor ....");

        setNumOfDoors(rc.getNumOfDoors());
        setPrice(rc.getPrice());
        setNumOfSeats(rc.getNumOfSeats());
        setGasConsumption(rc.getGasConsumption());

        horsePower = rc.horsePower;
        serialNum = serialNumCtr++;
    }


    public int getHorsePower()
    {
        return horsePower;
    }

    public void setHorsePower(int hp)
    {
        horsePower = hp;
    }

    public String toString()
    {
        return "This Race Car4 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car4 is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car4 is: " + horsePower + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "RaceCar4";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }

}   // end of Race Car4 class

public class Polymorphism4{

    // A method that would accept any Vehicle4 object and displays its information
    public static void showVehicle4Info(Vehicle4 v)
    {
        System.out.println("Here is the information of this Vehicle4");
        System.out.println(v);
        System.out.println();
    }

    // A method that takes an array of Vehicle4s inventory and return a copy of that array
    public static Vehicle4[] copyInventory_1(Vehicle4[] va)
    {
        // This is rather a terrible method to copy the array; actually there is no copying at all
        Vehicle4[] veCar4r = va;
        return veCar4r;
    }


    // A method that takes an array of Vehicle4s inventory and return a copy of that array
    public static Vehicle4[] copyInventory_2(Vehicle4[] va)
    {
        // This is better than copyInventory_1() above; yet it is also bad
        Vehicle4[] veCar4r = new Vehicle4[va.length];	// create a new array with the same length
        // as the passed array;
        for (int i = 0; i < veCar4r.length; i++)	// then copy it
        {
            veCar4r[i] = new Vehicle4(va[i]);		// Is that Okay? Why? Why NOT?
        }
        return veCar4r;
    }

    // A method that displays the contents of an inventory
    public static void displayInventoryInfo(Vehicle4[] va)
    {
        String s;
        System.out.println("\nHere is the information of Vehicle4s in that inventory");
        for (int i = 0; i < va.length; i++)
        {
            // Obtain the class name just for display purposes
            s = va[i].getClass().toString();
            s = s.substring(6); // Remove the word "class" to get only the class name
            System.out.println((i+1) + ". " + s + " with serial number " + va[i].getSerNumber());

        }
    }
    public static void main(String[] args) {
        System.out.println("Will create three Vehicle4 objects");

        Vehicle4 v1 = new Vehicle4(), v2 = new Vehicle4(4, 5000), v3 = new Vehicle4(v2);

        System.out.println();
        System.out.println("Will create three Bus4 objects");

        Bus4 b1 = new Bus4(2, 55000, 37), b2 = new Bus4(3, 62000, 55), b3 = new Bus4(b1);


        System.out.println();
        System.out.println("Will create two Car4 objects");

        Car4 c1 = new Car4(4, 12000, 5), c2 = new Car4(2, 26000, 2);

        System.out.println();
        System.out.println("Will create three Sport Car4 objects");

        SportCar4 sc1 = new SportCar4(4, 12000, 5, 3), sc2 = new SportCar4(3, 18500, 4, 4),
                sc3 = new SportCar4(2, 15000, 5, 4);


        System.out.println();
        System.out.println("Will create two Race Car4 objects");

        RaceCar4 rc1 = new RaceCar4(4, 67000, 2, 4, 400), rc2 = new RaceCar4(3, 85000, 4, 4, 450);



        System.out.println("\nWill create some inventories");
        System.out.println("============================\n");

        Vehicle4[] vecInv1 = new Vehicle4[6];
        vecInv1[0] = v1;
        vecInv1[1] = b1;
        vecInv1[2] = b2;
        vecInv1[3] = sc1;
        vecInv1[4] = sc2;
        vecInv1[5] = rc1;

        System.out.print("\nInventory vecInv1: ");
        displayInventoryInfo(vecInv1);

        Vehicle4[] vecInv2 = new Vehicle4[4];
        vecInv2[0] = v2;
        vecInv2[1] = sc3;
        vecInv2[2] = rc2;
        vecInv2[3] = b3;

        System.out.print("\nInventory vecInv2: ");
        displayInventoryInfo(vecInv2);

        // Now copy these inventories using the copyInventory methods
        Vehicle4[] vecInv3 = copyInventory_1(vecInv1);
        Vehicle4[] vecInv4 = copyInventory_2(vecInv2);

        System.out.print("\nInventory vecInv3 (should be a COPY of vecInv1): ");
        displayInventoryInfo(vecInv3);

        System.out.print("\nInventory vecInv4 (should be a COPY of vecInv2): ");
        displayInventoryInfo(vecInv4);
    }

}

/* The Output
Will create three Vehicle4 objects

Creating a Vehicle4 object using default constructor ....

Creating a Vehicle4 object using parameterized constructor ....

Creating a Vehicle4 object using copy constructor ....

Will create three Bus4 objects

Creating a Vehicle4 object using default constructor ....
Creating a Bus4 object using parameterized constructor ....
Creating a Bus4 object using parameterized constructor for full settings....

Executing getPrice() from the Bus4 class. The price is 10000.0$.
Executing getPrice() from the Bus4 class. The price is 10000.0$.
Executing getPrice() from the Bus4 class. The price is 10000.0$.
The price of this Bus4 will be increased from 10000.0$ to 55000.0$.

Creating a Vehicle4 object using default constructor ....
Creating a Bus4 object using parameterized constructor ....
Creating a Bus4 object using parameterized constructor for full settings....

Executing getPrice() from the Bus4 class. The price is 10000.0$.
Executing getPrice() from the Bus4 class. The price is 10000.0$.
Executing getPrice() from the Bus4 class. The price is 10000.0$.
The price of this Bus4 will be increased from 10000.0$ to 62000.0$.

Creating a Vehicle4 object using default constructor ....
Creating a Bus4 object using copy constructor ....
Executing getPrice() from the Bus4 class. The price is 55000.0$.
Executing getPrice() from the Bus4 class. The price is 10000.0$.
Executing getPrice() from the Bus4 class. The price is 10000.0$.
Executing getPrice() from the Bus4 class. The price is 10000.0$.
The price of this Bus4 will be increased from 10000.0$ to 55000.0$.

Will create two Car4 objects

Creating a Vehicle4 object using parameterized constructor ....
Creating a Car4 object using parameterized constructor ....

Creating a Vehicle4 object using parameterized constructor ....
Creating a Car4 object using parameterized constructor ....

Will create three Sport Car4 objects

Creating a Vehicle4 object using parameterized constructor ....
Creating a Car4 object using parameterized constructor ....
Creating a sport Car4 object using parameterized constructor ....

Creating a Vehicle4 object using parameterized constructor ....
Creating a Car4 object using parameterized constructor ....
Creating a sport Car4 object using parameterized constructor ....

Creating a Vehicle4 object using parameterized constructor ....
Creating a Car4 object using parameterized constructor ....
Creating a sport Car4 object using parameterized constructor ....

Will create two Race Car4 objects

Creating a Vehicle4 object using parameterized constructor ....
Creating a Car4 object using parameterized constructor ....
Creating a sport Car4 object using parameterized constructor ....
Creating a race Car4 object using parameterized constructor ....

Creating a Vehicle4 object using parameterized constructor ....
Creating a Car4 object using parameterized constructor ....
Creating a sport Car4 object using parameterized constructor ....
Creating a race Car4 object using parameterized constructor ....

Will create some inventories
============================


Inventory vecInv1:
Here is the information of Vehicle4s in that inventory
1. Vehicle4 with serial number 1000
2. Bus4 with serial number 2000
3. Bus4 with serial number 2001
4. SportCar4 with serial number 4000
5. SportCar4 with serial number 4001
6. RaceCar4 with serial number 5000

Inventory vecInv2:
Here is the information of Vehicle4s in that inventory
1. Vehicle4 with serial number 1001
2. SportCar4 with serial number 4002
3. RaceCar4 with serial number 5001
4. Bus4 with serial number 2002

Creating a Vehicle4 object using copy constructor ....

Creating a Vehicle4 object using copy constructor ....

Creating a Vehicle4 object using copy constructor ....

Creating a Vehicle4 object using copy constructor ....

Inventory vecInv3 (should be a COPY of vecInv1):
Here is the information of Vehicle4s in that inventory
1. Vehicle4 with serial number 1000
2. Bus4 with serial number 2000
3. Bus4 with serial number 2001
4. SportCar4 with serial number 4000
5. SportCar4 with serial number 4001
6. RaceCar4 with serial number 5000

Inventory vecInv4 (should be a COPY of vecInv2):
Here is the information of Vehicle4s in that inventory
1. Vehicle4 with serial number 1013
2. Vehicle4 with serial number 1014
3. Vehicle4 with serial number 1015
4. Vehicle4 with serial number 1016

*/


