package Polymorphism;

// 该程序说明了与静态方法相关的“多态性”主题。 具体来说，Java 不对静态方法使用后期绑定； 相反，它使用在编译时发生的“静态绑定”。
//
// 注意：如果静态函数被覆盖并被类的对象调用（而不是直接由类名调用），则执行的确切静态方法由“对象名称”决定，而不是由对象决定 “它引用”。
// 这可能会产生或被视为意外行为，因此您应该意识到这一点。 这背后的原因再次在于 Java 对静态方法使用静态/早期绑定这一事实。 有关该案例的说明，请参见本程序的末尾。

// Key Points:
// 1) Static binding.


// Vehicle2 Class
class Vehicle2 {

    // Attributes
    protected int numOfDoors;
    protected double price;
    private static int numOfCreatedObjects = 0;


    // Constructors
    public Vehicle2()	// default constructor
    {
        System.out.println("\nCreating a Vehicle2 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
        numOfCreatedObjects++;
    }

    public Vehicle2(int nd, double pr)
    {
        System.out.println("\nCreating a Vehicle2 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
        numOfCreatedObjects++;
    }


    public Vehicle2(Vehicle2 vec)	// copy constructor
    {
        System.out.println("\nCreating a Vehicle2 object using copy constructor ....");

        numOfDoors = vec.numOfDoors;
        price = vec.price;
        numOfCreatedObjects++;
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
        return "This Vehicle2 has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }

    // Find out if that Vehicle2 has a cheaper price than the passed Vehicle2
    public boolean isCheaper(Vehicle2 v)
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
    // 由于是static 此方法不能被覆盖 override，所以只有一个版本存在
    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created Vehicle2 objects so far is " + numOfCreatedObjects + ".");
    }

} // end of Vehicle2 class



class Bus2 extends Vehicle2{

    // Attributes
    private int passengerCapacity;
    private static int numOfCreatedObjects = 0;

    // Constructors
    public Bus2()	// default constructor
    {
        System.out.println("Creating a Bus2 object using default constructor ....");

        passengerCapacity = 10;
        numOfCreatedObjects++;
    }

    public Bus2(int pc)
    {
        System.out.println("Creating a Bus2 object using parameterized constructor ....");

        passengerCapacity = pc;
        numOfCreatedObjects++;
    }

    public Bus2(Bus2 b)
    {
        System.out.println("Creating a Bus2 object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
        numOfCreatedObjects++;
    }


    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public Bus2(int nd, double pr, int pc)
    {
        // Do not increment the numOfCreatedObjects since it is done in the call of the "this" constructor
        this(pc); 	// Call the constructor that sets the passenger capacity

        System.out.println("Creating a Bus2 object using parameterized constructor for full settings....\n");

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
        return "This Bus2 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus2 is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr)
    {
        if(pr < getPrice())
            System.out.println("The price of this Bus2 will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this Bus2 will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the Bus2.");

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
        String s = "Bus2";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created Bus2 objects so far is " + numOfCreatedObjects + ".");
    }

}   // end of Bus2 class



//Car2 Class - This is a derived class from the Vehicle2 Class.
//For a Car2 object, we are interested in its number of seats
class Car2 extends Vehicle2{

    // Attributes
    private int numOfSeats;
    private static int numOfCreatedObjects = 0;

    // Constructors
    public Car2()	// default constructor
    {
        System.out.println("Creating a Car2 object using default constructor ....");

        numOfSeats = 5;
        numOfCreatedObjects++;
    }

    public Car2(int nd, double pr, int ns)
    {
        super(nd, pr);
        System.out.println("Creating a Car2 object using parameterized constructor ....");

        numOfSeats = ns;
        numOfCreatedObjects++;
    }

    public Car2(Car2 c)
    {
        System.out.println("Creating a Car2 object using copy constructor ....");
        setNumOfDoors(c.getNumOfDoors());
        setPrice(c.getPrice());
        numOfSeats = c.numOfSeats;
        numOfCreatedObjects++;
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
        return "This Car2 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Car2 is " + numOfSeats + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "Car2";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }


    public static void DisplayNumberOfCreatedObjects() {
        System.out.println("The number of created Car2 objects so far is " + numOfCreatedObjects + ".");
    }

}   // end of Car2 class



//SportCar2 Class - This is a derived class from the Car2 Class
//For a SportCar2 object, we are interested in its gas consumption
// as gallon per 100 miles
class SportCar2 extends Car2{

    // Attributes
    private double gasConsumption;
    private static int numOfCreatedObjects = 0;

    // Constructors
    public SportCar2()	// default constructor
    {
        System.out.println("Creating a sport Car2 object using default constructor ....");

        gasConsumption = 4;
        numOfCreatedObjects++;
    }

    public SportCar2(int nd, double pr, int ns, double gc)
    {
        super(nd, pr, ns);
        System.out.println("Creating a sport Car2 object using parameterized constructor ....");
        gasConsumption = gc;
        numOfCreatedObjects++;
    }

    public SportCar2(SportCar2 sc)
    {
        System.out.println("Creating a sport Car2 object using copy constructor ....");

        setNumOfDoors(sc.getNumOfDoors());
        setPrice(sc.getPrice());
        setNumOfSeats(sc.getNumOfSeats());

        gasConsumption = sc.gasConsumption;
        numOfCreatedObjects++;
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
        return "This Sport Car2 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car2 is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "SportCar2";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created SportCar2 objects so far is " + numOfCreatedObjects + ".");
    }

}   // end of Sport Car2 class



//RaceCar2 Class - This is a derived class from the SportCar2 Class
//For a RaceCar2 object, we are interested in its horse power
class RaceCar2 extends SportCar2{

    // Attributes
    private int horsePower;
    private static int numOfCreatedObjects = 0;

    // Constructors
    public RaceCar2()	// default constructor
    {
        System.out.println("Creating a race Car2 object using default constructor ....");

        horsePower = 400;
        numOfCreatedObjects++;
    }

    public RaceCar2(int nd, double pr, int ns, double gc, int hp)
    {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race Car2 object using parameterized constructor ....");
        horsePower = hp;
        numOfCreatedObjects++;
    }

    public RaceCar2(RaceCar2 rc)
    {
        System.out.println("Creating a race Car2 object using copy constructor ....");

        setNumOfDoors(rc.getNumOfDoors());
        setPrice(rc.getPrice());
        setNumOfSeats(rc.getNumOfSeats());
        setGasConsumption(rc.getGasConsumption());

        horsePower = rc.horsePower;
        numOfCreatedObjects++;
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
        return "This Race Car2 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car2 is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car2 is: " + horsePower + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "RaceCar2";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created RaceCar2 objects so far is " + numOfCreatedObjects + ".");
    }


}   // end of Race Car2 class

public class Polymorphism2{

    // A method that would accept any Vehicle2 object and displays its information
    public static void showVehicle2Info(Vehicle2 v)
    {
        System.out.println("Here is the information of this Vehicle2");
        System.out.println(v);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Will create two Vehicle2 objects");

        Vehicle2 v1 = new Vehicle2(), v2 = new Vehicle2(4, 5000);

        v1.DisplayNumberOfCreatedObjects();


        System.out.println();
        System.out.println("Will create three Bus2 objects");

        Bus2 b1 = new Bus2(2, 55000, 37), b2 = new Bus2(3, 62000, 55), b3 = new Bus2(b1);

        b1.DisplayNumberOfCreatedObjects();
        v1.DisplayNumberOfCreatedObjects();

        System.out.println();
        System.out.println("Will create two Car2 objects");

        Car2 c1 = new Car2(4, 12000, 5), c2 = new Car2(2, 26000, 2);

        c1.DisplayNumberOfCreatedObjects();

        System.out.println();
        System.out.println("Will create two Sport Car2 objects");

        SportCar2 sc1 = new SportCar2(4, 12000, 5, 3), sc2 = new SportCar2(3, 18500, 4, 4);

        sc1.DisplayNumberOfCreatedObjects();

        System.out.println();
        System.out.println("Will create two Race Car2 objects");

        RaceCar2 rc1 = new RaceCar2(4, 67000, 2, 4, 400), rc2 = new RaceCar2(3, 85000, 4, 4, 450);

        rc1.DisplayNumberOfCreatedObjects();
        v1.DisplayNumberOfCreatedObjects();

        // Now have this assignment operation
        v1 = b1;		// Since a Bus2 is a Vehicle2, this is okay 但输出结果显示 bus并没有因此变成4或者2，即使b1此时向上转型为v1

        // Notice that b1 = v1; will be illegal since a Vehicle2 is NOT a Bus2
        b1.DisplayNumberOfCreatedObjects(); // 执行的方法是由它的变量名决定的，而不是它引用的对象

        System.out.println("\n ============= After executing v1 = b1; =============\n");

        v1.DisplayNumberOfCreatedObjects(); // Will still call the method from the Vehicle2 class
        b1.DisplayNumberOfCreatedObjects();


    }

}

/* The Output
Will create two Vehicle2 objects

Creating a Vehicle2 object using default constructor ....

Creating a Vehicle2 object using parameterized constructor ....
The number of created Vehicle2 objects so far is 2.

Will create three Bus2 objects

Creating a Vehicle2 object using default constructor ....
Creating a Bus2 object using parameterized constructor ....
Creating a Bus2 object using parameterized constructor for full settings....

Executing getPrice() from the Bus2 class. The price is 10000.0$.
Executing getPrice() from the Bus2 class. The price is 10000.0$.
Executing getPrice() from the Bus2 class. The price is 10000.0$.
The price of this Bus2 will be increased from 10000.0$ to 55000.0$.

Creating a Vehicle2 object using default constructor ....
Creating a Bus2 object using parameterized constructor ....
Creating a Bus2 object using parameterized constructor for full settings....

Executing getPrice() from the Bus2 class. The price is 10000.0$.
Executing getPrice() from the Bus2 class. The price is 10000.0$.
Executing getPrice() from the Bus2 class. The price is 10000.0$.
The price of this Bus2 will be increased from 10000.0$ to 62000.0$.

Creating a Vehicle2 object using default constructor ....
Creating a Bus2 object using copy constructor ....
Executing getPrice() from the Bus2 class. The price is 55000.0$.
Executing getPrice() from the Bus2 class. The price is 10000.0$.
Executing getPrice() from the Bus2 class. The price is 10000.0$.
Executing getPrice() from the Bus2 class. The price is 10000.0$.
The price of this Bus2 will be increased from 10000.0$ to 55000.0$.
The number of created Bus2 objects so far is 3.
The number of created Vehicle2 objects so far is 5.

Will create two Car2 objects

Creating a Vehicle2 object using parameterized constructor ....
Creating a Car2 object using parameterized constructor ....

Creating a Vehicle2 object using parameterized constructor ....
Creating a Car2 object using parameterized constructor ....
The number of created Car2 objects so far is 2.

Will create two Sport Car2 objects

Creating a Vehicle2 object using parameterized constructor ....
Creating a Car2 object using parameterized constructor ....
Creating a sport Car2 object using parameterized constructor ....

Creating a Vehicle2 object using parameterized constructor ....
Creating a Car2 object using parameterized constructor ....
Creating a sport Car2 object using parameterized constructor ....
The number of created SportCar2 objects so far is 2.

Will create two Race Car2 objects

Creating a Vehicle2 object using parameterized constructor ....
Creating a Car2 object using parameterized constructor ....
Creating a sport Car2 object using parameterized constructor ....
Creating a race Car2 object using parameterized constructor ....

Creating a Vehicle2 object using parameterized constructor ....
Creating a Car2 object using parameterized constructor ....
Creating a sport Car2 object using parameterized constructor ....
Creating a race Car2 object using parameterized constructor ....
The number of created RaceCar2 objects so far is 2.
The number of created Vehicle2 objects so far is 11.

 ============= After executing v1 = b1; =============

The number of created Vehicle2 objects so far is 11.
The number of created Bus2 objects so far is 3.

*/


