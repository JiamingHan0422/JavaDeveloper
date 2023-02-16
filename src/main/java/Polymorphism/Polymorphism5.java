package Polymorphism;

// *******************************************************************
// Polymorphism5.java By: Aiman Hanna (C) 1993 - 2021
// This program introduces the "clone" function. The program fixes the 
// problems that Polymorphism4.java has as a result of the limitations 
// of the copy constructors. 
//
// Although the clone() methods (see below) are in fact using the copy 
// constructors, this will work because the clone() method has the same 
// name in all classes, and polymorphism works with method names. In 
// contrast, the names of the copy constructors are (naturally) different
// and polymorphism does not work with methods of different names.
//
// Key Points:
// 1) The "clone" method.
// *******************************************************************

// Vehicle5 Class
class Vehicle5 {

    // Attributes
    protected int numOfDoors;
    protected double price;
    private long serialNum;
    private static long serialNumCtr = 1000;


    // Constructors
    public Vehicle5()	// default constructor 
    {
        System.out.println("\nCreating a Vehicle5 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
        serialNum = serialNumCtr++;
    }

    public Vehicle5(int nd, double pr)
    {
        System.out.println("\nCreating a Vehicle5 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
        serialNum = serialNumCtr++;
    }


    public Vehicle5(Vehicle5 vec)	// copy constructor 
    {
        System.out.println("\nCreating a Vehicle5 object using copy constructor ....");

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
        return price;
    }

    public void setPrice(double pr)
    {
        price = pr;
    }

    public String toString()
    {
        return "This Vehicle5 has " + numOfDoors +
                " doors and its price is " + price + "$.";
    }

    // Find out if that Vehicle5 has a cheaper price than the passed Vehicle5 
    public boolean isCheaper(Vehicle5 v)
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


    public Vehicle5 clone()
    {
        return new Vehicle5(this);	// Create and return a new Vehicle5 using the copy constructor
    }
} // end of Vehicle5 class




// Bus5 Class - This is a derived class from the Vehicle5 Class; that is it 
// inherits the Vehicle5 class 
class Bus5 extends Vehicle5{

    // Attributes
    private int passengerCapacity;
    private long serialNum;
    private static long serialNumCtr = 2000;

    // Constructors
    public Bus5()	// default constructor 
    {
        System.out.println("Creating a Bus5 object using default constructor ....");

        passengerCapacity = 10;
        serialNum = serialNumCtr++;
    }

    public Bus5(int pc)
    {
        System.out.println("Creating a Bus5 object using parameterized constructor ....");

        passengerCapacity = pc;
        serialNum = serialNumCtr++;
    }

    public Bus5(Bus5 b)
    {
        System.out.println("Creating a Bus5 object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
        serialNum = serialNumCtr++;
    }


    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public Bus5(int nd, double pr, int pc)
    {

        this(pc); 	// Call the constructor that sets the passenger capacity 

        System.out.println("Creating a Bus5 object using parameterized constructor for full settings....\n");

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
        return "This Bus5 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus5 is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr)
    {
        if(pr < getPrice())
            System.out.println("The price of this Bus5 will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this Bus5 will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the Bus5.");

        super.setPrice(pr);
        // Notice that you cannot access "price" directly  since it is private to the base class
        // i.e. price = pr; would be illegal

    }

    public double getPrice()
    {
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }

    public Bus5 clone()
    {
        return new Bus5(this);	// Create and return a new Bus5 using the copy constructor
    }
}   // end of Bus5 class



//Car5 Class - This is a derived class from the Vehicle5 Class.
//For a Car5 object, we are interested in its number of seats
class Car5 extends Vehicle5{

    // Attributes
    private int numOfSeats;
    private long serialNum;
    private static long serialNumCtr = 3000;

    // Constructors
    public Car5()	// default constructor 
    {
        System.out.println("Creating a Car5 object using default constructor ....");

        numOfSeats = 5;
        serialNum = serialNumCtr++;
    }

    public Car5(int nd, double pr, int ns)
    {
        super(nd, pr);
        System.out.println("Creating a Car5 object using parameterized constructor ....");

        numOfSeats = ns;
        serialNum = serialNumCtr++;
    }

    public Car5(Car5 c)
    {
        System.out.println("Creating a Car5 object using copy constructor ....");
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
        return "This Car5 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Car5 is " + numOfSeats + ".";
    }

    public double getPrice()
    {
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }

    public Car5 clone()
    {
        return new Car5(this);	// Create and return a new Car5 using the copy constructor
    }
}   // end of Car5 class



//SportCar5 Class - This is a derived class from the Car5 Class
//For a SportCar5 object, we are interested in its gas consumption 
// as gallon per 100 miles
class SportCar5 extends Car5{

    // Attributes
    private double gasConsumption;
    private long serialNum;
    private static long serialNumCtr = 4000;

    // Constructors
    public SportCar5()	// default constructor 
    {
        System.out.println("Creating a sport Car5 object using default constructor ....");

        gasConsumption = 4;
        serialNum = serialNumCtr++;
    }

    public SportCar5(int nd, double pr, int ns, double gc)
    {
        super(nd, pr, ns);
        System.out.println("Creating a sport Car5 object using parameterized constructor ....");
        gasConsumption = gc;
        serialNum = serialNumCtr++;
    }

    public SportCar5(SportCar5 sc)
    {
        System.out.println("Creating a sport Car5 object using copy constructor ....");

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
        return "This Sport Car5 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car5 is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }

    public double getPrice()
    {
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }

    public SportCar5 clone()
    {
        return new SportCar5(this);	// Create and return a new SportCar5 using the copy constructor
    }
}   // end of Sport Car5 class



//RaceCar5 Class - This is a derived class from the SportCar5 Class
//For a RaceCar5 object, we are interested in its horse power
class RaceCar5 extends SportCar5{

    // Attributes
    private int horsePower;
    private long serialNum;
    private static long serialNumCtr = 5000;

    // Constructors
    public RaceCar5()	// default constructor 
    {
        System.out.println("Creating a race Car5 object using default constructor ....");

        horsePower = 400;
        serialNum = serialNumCtr++;
    }

    public RaceCar5(int nd, double pr, int ns, double gc, int hp)
    {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race Car5 object using parameterized constructor ....");
        horsePower = hp;
        serialNum = serialNumCtr++;
    }

    public RaceCar5(RaceCar5 rc)
    {
        System.out.println("Creating a race Car5 object using copy constructor ....");

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
        return "This Race Car5 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car5 is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car5 is: " + horsePower + ".";
    }

    public double getPrice()
    {
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }

    public RaceCar5 clone()
    {
        return new RaceCar5(this);	// Create and return a new RaceCar5 using the copy constructor
    }

}   // end of Race Car5 class

public class Polymorphism5{

    // A method that would accept any Vehicle5 object and displays its information 
    public static void showVehicle5Info(Vehicle5 v)
    {
        System.out.println("Here is the information of this Vehicle5");
        System.out.println(v);
        System.out.println();
    }

    // A method that takes an array of Vehicle5s inventory and return a copy of that array
    public static Vehicle5[] copyInventory_1(Vehicle5[] va)
    {
        // This is rather a terrible method to copy the array; actually there is no copying at all
        Vehicle5[] veCar5r = va;
        return veCar5r;
    }


    // A method that takes an array of Vehicle5s inventory and return a copy of that array
    public static Vehicle5[] copyInventory_2(Vehicle5[] va)
    {
        // This is better than copyInventory_1() above; yet it is also bad
        Vehicle5[] veCar5r = new Vehicle5[va.length];	// create a new array with the same length
        // as the passed array;
        for (int i = 0; i < veCar5r.length; i++)	// then copy it
        {
            veCar5r[i] = new Vehicle5(va[i]);		// Is that Okay? Why? Why NOT?
        }
        return veCar5r;
    }


    // A method that takes an array of Vehicle5s inventory and return a copy of that array
    public static Vehicle5[] copyInventory_3(Vehicle5[] va)
    {
        // This is the correct version of this method, which uses the clone() method instead of 
        // the copy constructors
        Vehicle5[] veCar5r = new Vehicle5[va.length];	// create a new array with the same length
        // as the passed array;
        for (int i = 0; i < veCar5r.length; i++)	// then copy it
        {
            veCar5r[i] = va[i].clone();
        }
        return veCar5r;
    }

    // A method that displays the contents of an inventory
    public static void displayInventoryInfo(Vehicle5[] va)
    {
        String s;
        System.out.println("\nHere is the information of Vehicle5s in that inventory");
        for (int i = 0; i < va.length; i++)
        {
            // Obtain the class name just for display purposes
            s = va[i].getClass().toString();
            s = s.substring(6); // Remove the word "class" to get only the class name
            System.out.print((i+1) + ". " + s + " with serial number " + va[i].getSerNumber() + ". ");
            System.out.println(va[i]);

        }
    }
    public static void main(String[] args) {
        System.out.println("Will create three Vehicle5 objects");

        Vehicle5 v1 = new Vehicle5(), v2 = new Vehicle5(4, 5000), v3 = new Vehicle5(v2);

        System.out.println();
        System.out.println("Will create three Bus5 objects");

        Bus5 b1 = new Bus5(2, 55000, 37), b2 = new Bus5(3, 62000, 55), b3 = new Bus5(b1);


        System.out.println();
        System.out.println("Will create two Car5 objects");

        Car5 c1 = new Car5(4, 12000, 5), c2 = new Car5(2, 26000, 2);

        System.out.println();
        System.out.println("Will create three Sport Car5 objects");

        SportCar5 sc1 = new SportCar5(4, 12000, 5, 3), sc2 = new SportCar5(3, 18500, 4, 4),
                sc3 = new SportCar5(2, 15000, 5, 4);


        System.out.println();
        System.out.println("Will create two Race Car5 objects");

        RaceCar5 rc1 = new RaceCar5(4, 67000, 2, 4, 400), rc2 = new RaceCar5(3, 85000, 4, 4, 450);



        System.out.println("\nWill create some inventories");
        System.out.println("============================\n");

        Vehicle5[] vecInv1 = new Vehicle5[6];
        vecInv1[0] = v1;
        vecInv1[1] = b1;
        vecInv1[2] = b2;
        vecInv1[3] = sc1;
        vecInv1[4] = sc2;
        vecInv1[5] = rc1;

        System.out.print("\nInventory vecInv1: ");
        displayInventoryInfo(vecInv1);

        Vehicle5[] vecInv2 = new Vehicle5[4];
        vecInv2[0] = v2;
        vecInv2[1] = sc3;
        vecInv2[2] = rc2;
        vecInv2[3] = b3;

        System.out.print("\nInventory vecInv2: ");
        displayInventoryInfo(vecInv2);

        // Now copy these inventories using the correct copyInventory method
        Vehicle5[] vecInv3 = copyInventory_3(vecInv1);
        Vehicle5[] vecInv4 = copyInventory_3(vecInv2);

        System.out.print("\nInventory vecInv3 (should be a COPY of vecInv1): ");
        displayInventoryInfo(vecInv3);

        System.out.print("\nInventory vecInv4 (should be a COPY of vecInv2): ");
        displayInventoryInfo(vecInv4);
    }

}

/* The Output 
Will create three Vehicle5 objects

Creating a Vehicle5 object using default constructor ....

Creating a Vehicle5 object using parameterized constructor ....

Creating a Vehicle5 object using copy constructor ....

Will create three Bus5 objects

Creating a Vehicle5 object using default constructor ....
Creating a Bus5 object using parameterized constructor ....
Creating a Bus5 object using parameterized constructor for full settings....

The price of this Bus5 will be increased from 10000.0$ to 55000.0$.

Creating a Vehicle5 object using default constructor ....
Creating a Bus5 object using parameterized constructor ....
Creating a Bus5 object using parameterized constructor for full settings....

The price of this Bus5 will be increased from 10000.0$ to 62000.0$.

Creating a Vehicle5 object using default constructor ....
Creating a Bus5 object using copy constructor ....
The price of this Bus5 will be increased from 10000.0$ to 55000.0$.

Will create two Car5 objects

Creating a Vehicle5 object using parameterized constructor ....
Creating a Car5 object using parameterized constructor ....

Creating a Vehicle5 object using parameterized constructor ....
Creating a Car5 object using parameterized constructor ....

Will create three Sport Car5 objects

Creating a Vehicle5 object using parameterized constructor ....
Creating a Car5 object using parameterized constructor ....
Creating a sport Car5 object using parameterized constructor ....

Creating a Vehicle5 object using parameterized constructor ....
Creating a Car5 object using parameterized constructor ....
Creating a sport Car5 object using parameterized constructor ....

Creating a Vehicle5 object using parameterized constructor ....
Creating a Car5 object using parameterized constructor ....
Creating a sport Car5 object using parameterized constructor ....

Will create two Race Car5 objects

Creating a Vehicle5 object using parameterized constructor ....
Creating a Car5 object using parameterized constructor ....
Creating a sport Car5 object using parameterized constructor ....
Creating a race Car5 object using parameterized constructor ....

Creating a Vehicle5 object using parameterized constructor ....
Creating a Car5 object using parameterized constructor ....
Creating a sport Car5 object using parameterized constructor ....
Creating a race Car5 object using parameterized constructor ....

Will create some inventories
============================


Inventory vecInv1: 
Here is the information of Vehicle5s in that inventory
1. Vehicle5 with serial number 1000. This Vehicle5 has 4 doors and its price is 10000.0$.
2. Bus5 with serial number 2000. This Bus5 has 2 doors and its price is: 55000.0$. The passenger capacity of this Bus5 is 37.
3. Bus5 with serial number 2001. This Bus5 has 3 doors and its price is: 62000.0$. The passenger capacity of this Bus5 is 55.
4. SportCar5 with serial number 4000. This Sport Car5 has 4 doors and its price is: 12000.0$. The number of seats of this Sport Car5 is 5
and its gas consumption is 3.0 gallons/100-mile.
5. SportCar5 with serial number 4001. This Sport Car5 has 3 doors and its price is: 18500.0$. The number of seats of this Sport Car5 is 4
and its gas consumption is 4.0 gallons/100-mile.
6. RaceCar5 with serial number 5000. This Race Car5 has 4 doors and its price is: 67000.0$. The number of seats of this Race Car5 is 2
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car5 is: 400.

Inventory vecInv2: 
Here is the information of Vehicle5s in that inventory
1. Vehicle5 with serial number 1001. This Vehicle5 has 4 doors and its price is 5000.0$.
2. SportCar5 with serial number 4002. This Sport Car5 has 2 doors and its price is: 15000.0$. The number of seats of this Sport Car5 is 5
and its gas consumption is 4.0 gallons/100-mile.
3. RaceCar5 with serial number 5001. This Race Car5 has 3 doors and its price is: 85000.0$. The number of seats of this Race Car5 is 4
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car5 is: 450.
4. Bus5 with serial number 2002. This Bus5 has 2 doors and its price is: 55000.0$. The passenger capacity of this Bus5 is 37.

Creating a Vehicle5 object using copy constructor ....

Creating a Vehicle5 object using default constructor ....
Creating a Bus5 object using copy constructor ....
The price of this Bus5 will be increased from 10000.0$ to 55000.0$.

Creating a Vehicle5 object using default constructor ....
Creating a Bus5 object using copy constructor ....
The price of this Bus5 will be increased from 10000.0$ to 62000.0$.

Creating a Vehicle5 object using default constructor ....
Creating a Car5 object using default constructor ....
Creating a sport Car5 object using copy constructor ....

Creating a Vehicle5 object using default constructor ....
Creating a Car5 object using default constructor ....
Creating a sport Car5 object using copy constructor ....

Creating a Vehicle5 object using default constructor ....
Creating a Car5 object using default constructor ....
Creating a sport Car5 object using default constructor ....
Creating a race Car5 object using copy constructor ....

Creating a Vehicle5 object using copy constructor ....

Creating a Vehicle5 object using default constructor ....
Creating a Car5 object using default constructor ....
Creating a sport Car5 object using copy constructor ....

Creating a Vehicle5 object using default constructor ....
Creating a Car5 object using default constructor ....
Creating a sport Car5 object using default constructor ....
Creating a race Car5 object using copy constructor ....

Creating a Vehicle5 object using default constructor ....
Creating a Bus5 object using copy constructor ....
The price of this Bus5 will be increased from 10000.0$ to 55000.0$.

Inventory vecInv3 (should be a COPY of vecInv1): 
Here is the information of Vehicle5s in that inventory
1. Vehicle5 with serial number 1013. This Vehicle5 has 4 doors and its price is 10000.0$.
2. Bus5 with serial number 2003. This Bus5 has 2 doors and its price is: 55000.0$. The passenger capacity of this Bus5 is 37.
3. Bus5 with serial number 2004. This Bus5 has 3 doors and its price is: 62000.0$. The passenger capacity of this Bus5 is 55.
4. SportCar5 with serial number 4005. This Sport Car5 has 4 doors and its price is: 12000.0$. The number of seats of this Sport Car5 is 5
and its gas consumption is 3.0 gallons/100-mile.
5. SportCar5 with serial number 4006. This Sport Car5 has 3 doors and its price is: 18500.0$. The number of seats of this Sport Car5 is 4
and its gas consumption is 4.0 gallons/100-mile.
6. RaceCar5 with serial number 5002. This Race Car5 has 4 doors and its price is: 67000.0$. The number of seats of this Race Car5 is 2
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car5 is: 400.

Inventory vecInv4 (should be a COPY of vecInv2): 
Here is the information of Vehicle5s in that inventory
1. Vehicle5 with serial number 1019. This Vehicle5 has 4 doors and its price is 5000.0$.
2. SportCar5 with serial number 4008. This Sport Car5 has 2 doors and its price is: 15000.0$. The number of seats of this Sport Car5 is 5
and its gas consumption is 4.0 gallons/100-mile.
3. RaceCar5 with serial number 5003. This Race Car5 has 3 doors and its price is: 85000.0$. The number of seats of this Race Car5 is 4
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car5 is: 450.
4. Bus5 with serial number 2005. This Bus5 has 2 doors and its price is: 55000.0$. The passenger capacity of this Bus5 is 37.

*/
	

