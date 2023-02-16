package Polymorphism;

// *******************************************************************
// Polymorphism3.java By: Aiman Hanna (C) 1993 - 2021
// This program illustrates the subject upcasting and downcasting
// of objects. Notice that in many cases downcasting is needed (see,
// for instance, the equals() method in Object3.java). However, in
// many other cases it would be illegal to write (results in compilation
// errors), or it would result in run-time error (see the end of this program!).
//
// Key Points:
// 1) Upcasting.
// 2) Downcasting.
// *******************************************************************

// Vehicle3 Class
class Vehicle3 {

    // Attributes
    protected int numOfDoors;
    protected double price;


    // Constructors
    public Vehicle3()	// default constructor
    {
        System.out.println("\nCreating a Vehicle3 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle3(int nd, double pr)
    {
        System.out.println("\nCreating a Vehicle3 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
    }


    public Vehicle3(Vehicle3 vec)	// copy constructor
    {
        System.out.println("\nCreating a Vehicle3 object using copy constructor ....");

        numOfDoors = vec.numOfDoors;
        price = vec.price;
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
        return "This Vehicle3 has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }

    // Find out if that Vehicle3 has a cheaper price than the passed Vehicle3
    public boolean isCheaper(Vehicle3 v)
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

} // end of Vehicle3 class




// Bus3 Class - This is a derived class from the Vehicle3 Class; that is it
// inherits the Vehicle3 class
class Bus3 extends Vehicle3{

    // Attributes
    private int passengerCapacity;

    // Constructors
    public Bus3()	// default constructor
    {
        System.out.println("Creating a Bus3 object using default constructor ....");

        passengerCapacity = 10;
    }

    public Bus3(int pc)
    {
        System.out.println("Creating a Bus3 object using parameterized constructor ....");

        passengerCapacity = pc;
    }

    public Bus3(Bus3 b)
    {
        System.out.println("Creating a Bus3 object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
    }


    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public Bus3(int nd, double pr, int pc)
    {

        this(pc); 	// Call the constructor that sets the passenger capacity

        System.out.println("Creating a Bus3 object using parameterized constructor for full settings....\n");

        // Notice that we now cannot call super to set the other two attributes
        // (i.e. super(nd, pr);) since either "this" or 'super" must be the first
        // statement, and it is not possible to have both of them as such!
        setPrice(pr);
        setNumOfDoors(nd);

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
        return "This Bus3 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus3 is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr)
    {
        if(pr < getPrice())
            System.out.println("The price of this Bus3 will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this Bus3 will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the Bus3.");

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
        String s = "Bus3";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

}   // end of Bus3 class



//Car3 Class - This is a derived class from the Vehicle3 Class.
//For a Car3 object, we are interested in its number of seats
class Car3 extends Vehicle3{

    // Attributes
    private int numOfSeats;

    // Constructors
    public Car3()	// default constructor
    {
        System.out.println("Creating a Car3 object using default constructor ....");

        numOfSeats = 5;
    }

    public Car3(int nd, double pr, int ns)
    {
        super(nd, pr);
        System.out.println("Creating a Car3 object using parameterized constructor ....");

        numOfSeats = ns;
    }

    public Car3(Car3 c)
    {
        System.out.println("Creating a Car3 object using copy constructor ....");
        setNumOfDoors(c.getNumOfDoors());
        setPrice(c.getPrice());
        numOfSeats = c.numOfSeats;
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
        return "This Car3 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Car3 is " + numOfSeats + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "Car3";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

}   // end of Car3 class



//SportCar3 Class - This is a derived class from the Car3 Class
//For a SportCar3 object, we are interested in its gas consumption
// as gallon per 100 miles
class SportCar3 extends Car3{

    // Attributes
    private double gasConsumption;

    // Constructors
    public SportCar3()	// default constructor
    {
        System.out.println("Creating a sport Car3 object using default constructor ....");

        gasConsumption = 4;
    }

    public SportCar3(int nd, double pr, int ns, double gc)
    {
        super(nd, pr, ns);
        System.out.println("Creating a sport Car3 object using parameterized constructor ....");
        gasConsumption = gc;
    }

    public SportCar3(SportCar3 sc)
    {
        System.out.println("Creating a sport Car3 object using copy constructor ....");

        setNumOfDoors(sc.getNumOfDoors());
        setPrice(sc.getPrice());
        setNumOfSeats(sc.getNumOfSeats());

        gasConsumption = sc.gasConsumption;
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
        return "This Sport Car3 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car3 is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "SportCar3";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }
}   // end of Sport Car3 class



//RaceCar3 Class - This is a derived class from the SportCar3 Class
//For a RaceCar3 object, we are interested in its horse power
class RaceCar3 extends SportCar3{

    // Attributes
    private int horsePower;

    // Constructors
    public RaceCar3()	// default constructor
    {
        System.out.println("Creating a race Car3 object using default constructor ....");

        horsePower = 400;
    }

    public RaceCar3(int nd, double pr, int ns, double gc, int hp)
    {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race Car3 object using parameterized constructor ....");
        horsePower = hp;
    }

    public RaceCar3(RaceCar3 rc)
    {
        System.out.println("Creating a race Car3 object using copy constructor ....");

        setNumOfDoors(rc.getNumOfDoors());
        setPrice(rc.getPrice());
        setNumOfSeats(rc.getNumOfSeats());
        setGasConsumption(rc.getGasConsumption());

        horsePower = rc.horsePower;
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
        return "This Race Car3 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car3 is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car3 is: " + horsePower + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "RaceCar3";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

}   // end of Race Car3 class

public class Polymorphism3{

    // A method that would accept any Vehicle3 object and displays its information
    public static void showVehicle3Info(Vehicle3 v)
    {
        System.out.println("Here is the information of this Vehicle3");
        System.out.println(v);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Will create two Vehicle3 objects");

        Vehicle3 v1 = new Vehicle3(), v2 = new Vehicle3(4, 5000);
        v1.setPrice(22000);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus3 objects");

        Bus3 b1 = new Bus3(2, 55000, 37), b2 = new Bus3(3, 62000, 55), b3 = new Bus3(b1);


        System.out.println();
        System.out.println("Will create two Car3 objects");

        Car3 c1 = new Car3(4, 12000, 5), c2 = new Car3(2, 26000, 2);

        System.out.println();
        System.out.println("Will create two Sport Car3 objects");

        SportCar3 sc1 = new SportCar3(4, 12000, 5, 3), sc2 = new SportCar3(3, 18500, 4, 4);


        System.out.println();
        System.out.println("Will create two Race Car3 objects");

        RaceCar3 rc1 = new RaceCar3(4, 67000, 2, 4, 400), rc2 = new RaceCar3(3, 85000, 4, 4, 450);

        System.out.println("\nWill perform some upcasting operations");
        System.out.println("======================================\n");

        v1 = b1; 	// Upcasting - assign a derived class object to a base class object
        System.out.println("\nHere is the information of v1 after upcasting");
        System.out.println(v1);		// Notice that this will call the toString() method. Which one?
        // Hint: Late binding
        c1 = rc1;
        System.out.println("\nHere is the information of c1 after upcasting");
        System.out.println(c1);		// Notice that this will call the toString() method. Which one?

        // Now the following downcasting would be illegal
        // All of these would result in a compilation error for type mismatch
        // rc2 = v2;
        // b1 = v2;
        // sc1 = c2;

        // Now, try to downcast using explicit casting. Will this compile? Will it run?
        System.out.println("\nWill perform some casting operations using explicit casting");
        System.out.println("===============================================================\n");

        sc1 = (SportCar3)rc2;	// Will this explicit casting make a difference? Why? Why not?
        System.out.println("\nHere is the information of sc1 after explicit casting");
        System.out.println(sc1);		// This will also call the toString() method. Which one?

        System.out.println("\nWill attempt another downcasting operation ");
        System.out.println("===========================================\n");
        rc2 = (RaceCar3) v2;
        System.out.println("Here is the information of rc2 after downcasting");
        System.out.println(rc2);  // Notice that this will call the toString() method. Which one?
    }

}

/* The Output
Will create two Vehicle3 objects

Creating a Vehicle3 object using default constructor ....

Creating a Vehicle3 object using parameterized constructor ....

Will create three Bus3 objects

Creating a Vehicle3 object using default constructor ....
Creating a Bus3 object using parameterized constructor ....
Creating a Bus3 object using parameterized constructor for full settings....

Executing getPrice() from the Bus3 class. The price is 10000.0$.
Executing getPrice() from the Bus3 class. The price is 10000.0$.
Executing getPrice() from the Bus3 class. The price is 10000.0$.
The price of this Bus3 will be increased from 10000.0$ to 55000.0$.

Creating a Vehicle3 object using default constructor ....
Creating a Bus3 object using parameterized constructor ....
Creating a Bus3 object using parameterized constructor for full settings....

Executing getPrice() from the Bus3 class. The price is 10000.0$.
Executing getPrice() from the Bus3 class. The price is 10000.0$.
Executing getPrice() from the Bus3 class. The price is 10000.0$.
The price of this Bus3 will be increased from 10000.0$ to 62000.0$.

Creating a Vehicle3 object using default constructor ....
Creating a Bus3 object using copy constructor ....
Executing getPrice() from the Bus3 class. The price is 55000.0$.
Executing getPrice() from the Bus3 class. The price is 10000.0$.
Executing getPrice() from the Bus3 class. The price is 10000.0$.
Executing getPrice() from the Bus3 class. The price is 10000.0$.
The price of this Bus3 will be increased from 10000.0$ to 55000.0$.

Will create two Car3 objects

Creating a Vehicle3 object using parameterized constructor ....
Creating a Car3 object using parameterized constructor ....

Creating a Vehicle3 object using parameterized constructor ....
Creating a Car3 object using parameterized constructor ....

Will create two Sport Car3 objects

Creating a Vehicle3 object using parameterized constructor ....
Creating a Car3 object using parameterized constructor ....
Creating a sport Car3 object using parameterized constructor ....

Creating a Vehicle3 object using parameterized constructor ....
Creating a Car3 object using parameterized constructor ....
Creating a sport Car3 object using parameterized constructor ....

Will create two Race Car3 objects

Creating a Vehicle3 object using parameterized constructor ....
Creating a Car3 object using parameterized constructor ....
Creating a sport Car3 object using parameterized constructor ....
Creating a race Car3 object using parameterized constructor ....

Creating a Vehicle3 object using parameterized constructor ....
Creating a Car3 object using parameterized constructor ....
Creating a sport Car3 object using parameterized constructor ....
Creating a race Car3 object using parameterized constructor ....

Will perform some upcasting operations
======================================


Here is the information of v1 after upcasting
Executing getPrice() from the Bus3 class. The price is 55000.0$.
This Bus3 has 2 doors and its price is: 55000.0$. The passenger capacity of this Bus3 is 37.

Here is the information of c1 after upcasting
Executing getPrice() from the RaceCar3 class. The price is 67000.0$.
This Race Car3 has 4 doors and its price is: 67000.0$. The number of seats of this Race Car3 is 2
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car3 is: 400.

Will perform some casting operations using explicit casting
===============================================================


Here is the information of sc1 after explicit casting
Executing getPrice() from the RaceCar3 class. The price is 85000.0$.
This Race Car3 has 3 doors and its price is: 85000.0$. The number of seats of this Race Car3 is 4
and its gas consumption is 4.0 gallons/100-mile.The horse power of this Race Car3 is: 450.

Will attempt another downcasting operation
===========================================

Exception in thread "main" java.lang.ClassCastException: Vehicle3 cannot be cast to RaceCar3
	at Polymorphism3.main(Polymorphism3.java:481)
*/


