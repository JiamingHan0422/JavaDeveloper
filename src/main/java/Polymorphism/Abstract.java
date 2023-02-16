package Polymorphism;

// *******************************************************************
// Abstract1.java By: Aiman Hanna (C) 1993 - 2021
// This program introduces abstract classes and abstract methods. 
// Sometimes, it is does NOT make sense to create objects from 
// specific classes. In such case, these classes should be created 
// as abstract. An abstract class can only be used to derive other 
// classes. An abstract class must have at least one abstract method.
// Abstract methods must have an empty body; that is they cannot 
// have any implementations. A derived class that is not abstract
// is referred to as concrete class. Derived concrete classes must 
// define ALL the abstract methods of their base class. 
//
// NOTE: Although an object of an abstract class cannot be created, 
// it is perfectly fine to have a parameter of an abstract class type.
// This makes it possible to plug in an object of any of its descendant
// classes.
//
// Key Points:
// 1) Abstract classes.
// 2) Abstract methods.
// *******************************************************************

// VehicleA Class
abstract class VehicleA {

    // Attributes
    protected int numOfDoors;
    protected double price;
    private long serialNum;
    private static long serialNumCtr = 1000;


    // Constructors
    public VehicleA()	// default constructor 
    {
        System.out.println("\nCreating a VehicleA object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
        serialNum = serialNumCtr++;
    }

    public VehicleA(int nd, double pr)
    {
        System.out.println("\nCreating a VehicleA object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
        serialNum = serialNumCtr++;
    }


    public VehicleA(VehicleA vec)	// copy constructor 
    {
        System.out.println("\nCreating a VehicleA object using copy constructor ....");

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

    // Find out if that VehicleA has a cheaper price than the passed VehicleA 
    public boolean isCheaper(VehicleA v)
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

    // Some abstract methods that MUST be defined by derived classes

    abstract public String toString();


    // abstract can also be specified as follows 
    public abstract long getSerNumber();


    abstract public VehicleA clone();

} // end of VehicleA class




// BusA Class - This is a derived class from the VehicleA Class; that is it 
// inherits the VehicleA class 
class BusA extends VehicleA{

    // Attributes
    private int passengerCapacity;
    private long serialNum;
    private static long serialNumCtr = 2000;

    // Constructors
    public BusA()	// default constructor 
    {
        System.out.println("Creating a BusA object using default constructor ....");

        passengerCapacity = 10;
        serialNum = serialNumCtr++;
    }

    public BusA(int pc)
    {
        System.out.println("Creating a BusA object using parameterized constructor ....");

        passengerCapacity = pc;
        serialNum = serialNumCtr++;
    }

    public BusA(BusA b)
    {
        System.out.println("Creating a BusA object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
        serialNum = serialNumCtr++;
    }


    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public BusA(int nd, double pr, int pc)
    {

        this(pc); 	// Call the constructor that sets the passenger capacity 

        System.out.println("Creating a BusA object using parameterized constructor for full settings....\n");

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
        return "This BusA has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this BusA is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr)
    {
        if(pr < getPrice())
            System.out.println("The price of this BusA will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this BusA will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the BusA.");

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

    public BusA clone()
    {
        return new BusA(this);	// Create and return a new BusA using the copy constructor
    }
}   // end of BusA class



//CarA Class - This is a derived class from the VehicleA Class.
//For a CarA object, we are interested in its number of seats
class CarA extends VehicleA{

    // Attributes
    private int numOfSeats;
    private long serialNum;
    private static long serialNumCtr = 3000;

    // Constructors
    public CarA()	// default constructor 
    {
        System.out.println("Creating a CarA object using default constructor ....");

        numOfSeats = 5;
        serialNum = serialNumCtr++;
    }

    public CarA(int nd, double pr, int ns)
    {
        super(nd, pr);
        System.out.println("Creating a CarA object using parameterized constructor ....");

        numOfSeats = ns;
        serialNum = serialNumCtr++;
    }

    public CarA(CarA c)
    {
        System.out.println("Creating a CarA object using copy constructor ....");
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
        return "This CarA has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this CarA is " + numOfSeats + ".";
    }

    public double getPrice()
    {
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }

    public CarA clone()
    {
        return new CarA(this);	// Create and return a new CarA using the copy constructor
    }
}   // end of CarA class



//SportCarA Class - This is a derived class from the CarA Class
//For a SportCarA object, we are interested in its gas consumption 
// as gallon per 100 miles
class SportCarA extends CarA{

    // Attributes
    private double gasConsumption;
    private long serialNum;
    private static long serialNumCtr = 4000;

    // Constructors
    public SportCarA()	// default constructor 
    {
        System.out.println("Creating a sport CarA object using default constructor ....");

        gasConsumption = 4;
        serialNum = serialNumCtr++;
    }

    public SportCarA(int nd, double pr, int ns, double gc)
    {
        super(nd, pr, ns);
        System.out.println("Creating a sport CarA object using parameterized constructor ....");
        gasConsumption = gc;
        serialNum = serialNumCtr++;
    }

    public SportCarA(SportCarA sc)
    {
        System.out.println("Creating a sport CarA object using copy constructor ....");

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
        return "This Sport CarA has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport CarA is " + getNumOfSeats() +
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

    public SportCarA clone()
    {
        return new SportCarA(this);	// Create and return a new SportCarA using the copy constructor
    }
}   // end of Sport CarA class



//RaceCarA Class - This is a derived class from the SportCarA Class
//For a RaceCarA object, we are interested in its horse power
class RaceCarA extends SportCarA{

    // Attributes
    private int horsePower;
    private long serialNum;
    private static long serialNumCtr = 5000;

    // Constructors
    public RaceCarA()	// default constructor 
    {
        System.out.println("Creating a race CarA object using default constructor ....");

        horsePower = 400;
        serialNum = serialNumCtr++;
    }

    public RaceCarA(int nd, double pr, int ns, double gc, int hp)
    {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race CarA object using parameterized constructor ....");
        horsePower = hp;
        serialNum = serialNumCtr++;
    }

    public RaceCarA(RaceCarA rc)
    {
        System.out.println("Creating a race CarA object using copy constructor ....");

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
        return "This Race CarA has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race CarA is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race CarA is: " + horsePower + ".";
    }

    public double getPrice()
    {
        return price;
    }

    public long getSerNumber()
    {
        return serialNum;
    }

    public RaceCarA clone()
    {
        return new RaceCarA(this);	// Create and return a new RaceCarA using the copy constructor
    }

}   // end of Race CarA class

public class Abstract{

    // A method that would accept any VehicleA object and displays its information 
    public static void showVehicleAInfo(VehicleA v)
    {
        System.out.println("Here is the information of this VehicleA");
        System.out.println(v);
        System.out.println();
    }



    // A method that takes an array of VehicleAs inventory and return a copy of that array
    public static VehicleA[] copyInventory_3(VehicleA[] va)
    {
        // This is the correct version of this method, which uses the clone() method instead of 
        // the copy constructors
        VehicleA[] veCarAr = new VehicleA[va.length];	// create a new array with the same length
        // as the passed array;
        for (int i = 0; i < veCarAr.length; i++)		// then copy it
        {
            veCarAr[i] = va[i].clone();
        }
        return veCarAr;
    }

    // A method that displays the contents of an inventory
    public static void displayInventoryInfo(VehicleA[] va)
    {
        String s;
        System.out.println("\nHere is the information of VehicleAs in that inventory");
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
        System.out.println("Will create three VehicleA objects");

        // The following would be illegal now since you can NOT create objects 
        // from an abstract class
        // VehicleA v1 = new VehicleA(), v2 = new VehicleA(4, 5000), v3 = new VehicleA(v2);

        System.out.println();
        System.out.println("Will create three BusA objects");

        BusA b1 = new BusA(2, 55000, 37), b2 = new BusA(3, 62000, 55), b3 = new BusA(b1);


        System.out.println();
        System.out.println("Will create two CarA objects");

        CarA c1 = new CarA(4, 12000, 5), c2 = new CarA(2, 26000, 2);

        System.out.println();
        System.out.println("Will create three Sport CarA objects");

        SportCarA sc1 = new SportCarA(4, 12000, 5, 3), sc2 = new SportCarA(3, 18500, 4, 4),
                sc3 = new SportCarA(2, 15000, 5, 4);


        System.out.println();
        System.out.println("Will create two Race CarA objects");

        RaceCarA rc1 = new RaceCarA(4, 67000, 2, 4, 400), rc2 = new RaceCarA(3, 85000, 4, 4, 450);



        System.out.println("\nWill create some inventories");
        System.out.println("============================\n");

        VehicleA[] vecInv1 = new VehicleA[6];
        vecInv1[0] = c1;
        vecInv1[1] = b1;
        vecInv1[2] = b2;
        vecInv1[3] = sc1;
        vecInv1[4] = sc2;
        vecInv1[5] = rc1;

        System.out.print("\nInventory vecInv1: ");
        displayInventoryInfo(vecInv1);

        VehicleA[] vecInv2 = new VehicleA[4];
        vecInv2[0] = c2;
        vecInv2[1] = sc3;
        vecInv2[2] = rc2;
        vecInv2[3] = b3;

        System.out.print("\nInventory vecInv2: ");
        displayInventoryInfo(vecInv2);

        // Now copy these inventories using the correct copyInventory method
        VehicleA[] vecInv3 = copyInventory_3(vecInv1);
        VehicleA[] vecInv4 = copyInventory_3(vecInv2);

        System.out.print("\nInventory vecInv3 (should be a COPY of vecInv1): ");
        displayInventoryInfo(vecInv3);

        System.out.print("\nInventory vecInv4 (should be a COPY of vecInv2): ");
        displayInventoryInfo(vecInv4);
    }

}

/* The Output 
Will create three VehicleA objects

Will create three BusA objects

Creating a VehicleA object using default constructor ....
Creating a BusA object using parameterized constructor ....
Creating a BusA object using parameterized constructor for full settings....

The price of this BusA will be increased from 10000.0$ to 55000.0$.

Creating a VehicleA object using default constructor ....
Creating a BusA object using parameterized constructor ....
Creating a BusA object using parameterized constructor for full settings....

The price of this BusA will be increased from 10000.0$ to 62000.0$.

Creating a VehicleA object using default constructor ....
Creating a BusA object using copy constructor ....
The price of this BusA will be increased from 10000.0$ to 55000.0$.

Will create two CarA objects

Creating a VehicleA object using parameterized constructor ....
Creating a CarA object using parameterized constructor ....

Creating a VehicleA object using parameterized constructor ....
Creating a CarA object using parameterized constructor ....

Will create three Sport CarA objects

Creating a VehicleA object using parameterized constructor ....
Creating a CarA object using parameterized constructor ....
Creating a sport CarA object using parameterized constructor ....

Creating a VehicleA object using parameterized constructor ....
Creating a CarA object using parameterized constructor ....
Creating a sport CarA object using parameterized constructor ....

Creating a VehicleA object using parameterized constructor ....
Creating a CarA object using parameterized constructor ....
Creating a sport CarA object using parameterized constructor ....

Will create two Race CarA objects

Creating a VehicleA object using parameterized constructor ....
Creating a CarA object using parameterized constructor ....
Creating a sport CarA object using parameterized constructor ....
Creating a race CarA object using parameterized constructor ....

Creating a VehicleA object using parameterized constructor ....
Creating a CarA object using parameterized constructor ....
Creating a sport CarA object using parameterized constructor ....
Creating a race CarA object using parameterized constructor ....

Will create some inventories
============================


Inventory vecInv1: 
Here is the information of VehicleAs in that inventory
1. CarA with serial number 3000. This CarA has 4 doors and its price is: 12000.0$. The number of seats of this CarA is 5.
2. BusA with serial number 2000. This BusA has 2 doors and its price is: 55000.0$. The passenger capacity of this BusA is 37.
3. BusA with serial number 2001. This BusA has 3 doors and its price is: 62000.0$. The passenger capacity of this BusA is 55.
4. SportCarA with serial number 4000. This Sport CarA has 4 doors and its price is: 12000.0$. The number of seats of this Sport CarA is 5
and its gas consumption is 3.0 gallons/100-mile.
5. SportCarA with serial number 4001. This Sport CarA has 3 doors and its price is: 18500.0$. The number of seats of this Sport CarA is 4
and its gas consumption is 4.0 gallons/100-mile.
6. RaceCarA with serial number 5000. This Race CarA has 4 doors and its price is: 67000.0$. The number of seats of this Race CarA is 2
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race CarA is: 400.

Inventory vecInv2: 
Here is the information of VehicleAs in that inventory
1. CarA with serial number 3001. This CarA has 2 doors and its price is: 26000.0$. The number of seats of this CarA is 2.
2. SportCarA with serial number 4002. This Sport CarA has 2 doors and its price is: 15000.0$. The number of seats of this Sport CarA is 5
and its gas consumption is 4.0 gallons/100-mile.
3. RaceCarA with serial number 5001. This Race CarA has 3 doors and its price is: 85000.0$. The number of seats of this Race CarA is 4
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race CarA is: 450.
4. BusA with serial number 2002. This BusA has 2 doors and its price is: 55000.0$. The passenger capacity of this BusA is 37.

Creating a VehicleA object using default constructor ....
Creating a CarA object using copy constructor ....

Creating a VehicleA object using default constructor ....
Creating a BusA object using copy constructor ....
The price of this BusA will be increased from 10000.0$ to 55000.0$.

Creating a VehicleA object using default constructor ....
Creating a BusA object using copy constructor ....
The price of this BusA will be increased from 10000.0$ to 62000.0$.

Creating a VehicleA object using default constructor ....
Creating a CarA object using default constructor ....
Creating a sport CarA object using copy constructor ....

Creating a VehicleA object using default constructor ....
Creating a CarA object using default constructor ....
Creating a sport CarA object using copy constructor ....

Creating a VehicleA object using default constructor ....
Creating a CarA object using default constructor ....
Creating a sport CarA object using default constructor ....
Creating a race CarA object using copy constructor ....

Creating a VehicleA object using default constructor ....
Creating a CarA object using copy constructor ....

Creating a VehicleA object using default constructor ....
Creating a CarA object using default constructor ....
Creating a sport CarA object using copy constructor ....

Creating a VehicleA object using default constructor ....
Creating a CarA object using default constructor ....
Creating a sport CarA object using default constructor ....
Creating a race CarA object using copy constructor ....

Creating a VehicleA object using default constructor ....
Creating a BusA object using copy constructor ....
The price of this BusA will be increased from 10000.0$ to 55000.0$.

Inventory vecInv3 (should be a COPY of vecInv1): 
Here is the information of VehicleAs in that inventory
1. CarA with serial number 3007. This CarA has 4 doors and its price is: 12000.0$. The number of seats of this CarA is 5.
2. BusA with serial number 2003. This BusA has 2 doors and its price is: 55000.0$. The passenger capacity of this BusA is 37.
3. BusA with serial number 2004. This BusA has 3 doors and its price is: 62000.0$. The passenger capacity of this BusA is 55.
4. SportCarA with serial number 4005. This Sport CarA has 4 doors and its price is: 12000.0$. The number of seats of this Sport CarA is 5
and its gas consumption is 3.0 gallons/100-mile.
5. SportCarA with serial number 4006. This Sport CarA has 3 doors and its price is: 18500.0$. The number of seats of this Sport CarA is 4
and its gas consumption is 4.0 gallons/100-mile.
6. RaceCarA with serial number 5002. This Race CarA has 4 doors and its price is: 67000.0$. The number of seats of this Race CarA is 2
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race CarA is: 400.

Inventory vecInv4 (should be a COPY of vecInv2): 
Here is the information of VehicleAs in that inventory
1. CarA with serial number 3011. This CarA has 2 doors and its price is: 26000.0$. The number of seats of this CarA is 2.
2. SportCarA with serial number 4008. This Sport CarA has 2 doors and its price is: 15000.0$. The number of seats of this Sport CarA is 5
and its gas consumption is 4.0 gallons/100-mile.
3. RaceCarA with serial number 5003. This Race CarA has 3 doors and its price is: 85000.0$. The number of seats of this Race CarA is 4
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race CarA is: 450.
4. BusA with serial number 2005. This BusA has 2 doors and its price is: 55000.0$. The passenger capacity of this BusA is 37.


*/
	

