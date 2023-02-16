package Object;

// This program illustrates why it is desirable to use the 
// getClass() method instead of the "insatnceof" operator 
// when overriding the equals() method. 
// Does this program work properly? Why?
//
// Key Points:
// 1) getClass() method vs "insatnceof" operator


// Vehicle4 Class
class Vehicle4 {

    // Attributes
    private int numOfDoors;
    private double price;


    // default constructor
    public Vehicle4() {
        System.out.println("\nCreating a Vehicle4 object using default constructor ....");
        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle4(int nd, double pr) {
        System.out.println("\nCreating a Vehicle4 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle4(Vehicle4 vec) {
        System.out.println("\nCreating a Vehicle4 object using copy constructor ....");
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
        return "This Vehicle4 has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }

    //Override the equals() method from the Object class
    public boolean equals(Object x) {
        if (x == null || this == null || !(x instanceof Vehicle4))
            return false;
        else {
            // cast the passed object to a Vehicle4 object
            Vehicle4 v = (Vehicle4)x;
            return (this.numOfDoors == v.numOfDoors && this.price == v.price);
        }
    }

//    public boolean TrueEquals(Object x) {
//        if (x == null)
//            return false;
//        else if (getClass() != x.getClass())
//            return false;
//        else {
//            Vehicle4 v5 = (Vehicle4) x;
//            return (this.numOfDoors.equals(v5.numOfDoors) && this.price.equals(v5.price));
//        }
//    }
}


// Bus4 Class - This is a derived class from the Vehicle4 Class; that is it 
// inherits the Vehicle4 class 
class Bus4 extends Vehicle4{

    // Attributes
    private int passengerCapacity;

    // Constructors
    public Bus4()	// default constructor 
    {
        System.out.println("Creating a Bus4 object using default constructor ....");

        passengerCapacity = 10;
    }

    public Bus4(int pc)
    {
        System.out.println("Creating a Bus4 object using parameterized constructor ....");

        passengerCapacity = pc;
    }

    public Bus4(Bus4 b)
    {
        System.out.println("Creating a Bus4 object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
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


    public boolean equals(Object x) {
        if (x == null || this == null || !(x instanceof Bus4))
            return false;
        else
        {
            // cast the passed object to a Bus4 object
            Bus4 b = (Bus4)x;

            return (this.getNumOfDoors() == b.getNumOfDoors() &&
                    this.getPrice() == b.getPrice() &&
                    this.passengerCapacity == b.passengerCapacity);
        }
    }
}   // end of Bus4 class



//Car4 Class - This is a derived class from the Vehicle4 Class.
//For a Car4 object, we are interested in its number of seats
class Car4 extends Vehicle4{

    // Attributes
    private int numOfSeats;

    // Constructors
    public Car4()	// default constructor 
    {
        System.out.println("Creating a Car4 object using default constructor ....");

        numOfSeats = 5;
    }

    public Car4(int nd, double pr, int ns)
    {
        super(nd, pr);
        System.out.println("Creating a Car4 object using parameterized constructor ....");

        numOfSeats = ns;
    }

    public Car4(Car4 c)
    {
        System.out.println("Creating a Car4 object using copy constructor ....");
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
        return "This Car4 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Car4 is " + numOfSeats + ".";
    }

    public boolean equals(Object x)
    {
        if (x == null || this == null || !(x instanceof Car4))
            return false;
        else
        {
            // cast the passed object to a Car4 object
            Car4 c = (Car4)x;

            return (this.getNumOfDoors() == c.getNumOfDoors() &&
                    this.getPrice() == c.getPrice() &&
                    this.numOfSeats == c.numOfSeats);
        }
    }
}   // end of Car4 class



//SportCar4 Class - This is a derived class from the Car4 Class
//For a SportCar4 object, we are interested in its gas consumption 
// as gallon per 100 miles
class SportCar4 extends Car4{

    // Attributes
    private double gasConsumption;

    // Constructors
    public SportCar4()	// default constructor 
    {
        System.out.println("Creating a sport Car4 object using default constructor ....");

        gasConsumption = 4;
    }

    public SportCar4(int nd, double pr, int ns, double gc)
    {
        super(nd, pr, ns);
        System.out.println("Creating a sport Car4 object using parameterized constructor ....");
        gasConsumption = gc;
    }

    public SportCar4(SportCar4 sc)
    {
        System.out.println("Creating a sport Car4 object using copy constructor ....");

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
        return "This Sport Car4 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car4 is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }

    public boolean equals(Object x)
    {
        System.out.println("Executing equals() from the SportCar4 Class");
        if (x == null || this == null || !(x instanceof SportCar4))
            return false;
        else
        {
            // cast the passed object to a SportCar4 object
            SportCar4 sc = (SportCar4)x;

            return (this.getNumOfDoors() == sc.getNumOfDoors() &&
                    this.getPrice() == sc.getPrice() &&
                    this.getNumOfSeats() == sc.getNumOfSeats() &&
                    this.gasConsumption == sc.gasConsumption);
        }
    }
}   // end of Sport Car4 class



//RaceCar4 Class - This is a derived class from the SportCar4 Class
//For a RaceCar4 object, we are interested in its horse power
class RaceCar4 extends SportCar4{

    // Attributes
    private int horsePower;

    // default constructor 
    public RaceCar4() {
        System.out.println("Creating a race Car4 object using default constructor ....");

        horsePower = 400;
    }

    public RaceCar4(int nd, double pr, int ns, double gc, int hp) {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race Car4 object using parameterized constructor ....");
        horsePower = hp;
    }

    public RaceCar4(RaceCar4 rc) {
        System.out.println("Creating a race Car4 object using copy constructor ....");

        setNumOfDoors(rc.getNumOfDoors());
        setPrice(rc.getPrice());
        setNumOfSeats(rc.getNumOfSeats());
        setGasConsumption(rc.getGasConsumption());

        horsePower = rc.horsePower;
    }


    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int hp) {
        horsePower = hp;
    }

    public String toString() {
        return "This Race Car4 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car4 is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car4 is: " + horsePower + ".";
    }

    public boolean equals(Object x) {
        System.out.println("Executing equals() from the RaceCar4 Class");
        if (x == null || this == null || !(x instanceof RaceCar4))
            return false;
        else
        {
            // cast the passed object to a RaceCar4 object
            RaceCar4 rc = (RaceCar4)x;

            return (this.getNumOfDoors() == rc.getNumOfDoors() &&
                    this.getPrice() == rc.getPrice() &&
                    this.getNumOfSeats() == rc.getNumOfSeats() &&
                    this.getGasConsumption() == rc.getGasConsumption() &&
                    this.horsePower == rc.horsePower);
        }
    }
}

public class object4 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle4 objects");

        Vehicle4 v1 = new Vehicle4(), v2 = new Vehicle4(4, 5000);
        v1.setPrice(22000);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus4 objects");

        Bus4 b1 = new Bus4(2, 55000, 37), b2 = new Bus4(3, 62000, 55), b3 = new Bus4(b1);


        System.out.println();
        System.out.println("Will create two Car4 objects");

        Car4 c1 = new Car4(4, 12000, 5), c2 = new Car4(2, 26000, 2);

        System.out.println();
        System.out.println("Will create two Sport Car4 objects");

        SportCar4 sc1 = new SportCar4(4, 12000, 5, 3), sc2 = new SportCar4(3, 12000, 5, 3);


        System.out.println();
        System.out.println("Will create two Race Car4 objects");

        RaceCar4 rc1 = new RaceCar4(4, 67000, 2, 4, 400), rc2 = new RaceCar4(3, 85000, 4, 4, 450);

        System.out.println("\nComparing some of the Vehicle4s");
        System.out.println("==============================");


        if(b1.equals(b2))
            System.out.println("The two Bus4 objects (b1 & b2) are equal");
        else
            System.out.println("The two Bus4 objects (b1 & b2) are not equal");


        if(b1.equals(b3))
            System.out.println("The two Bus4 objects (b1 & b3) are equal");
        else
            System.out.println("The two Bus4 objects (b1 & b3) are not equal");

        if(sc1.equals(sc2))
            System.out.println("The two sport Car4 objects (sc1 & sc2) are equal");
        else
            System.out.println("The two sport Car4 objects (sc1 & sc2) are not equal");

        if(rc1.equals(rc2))
            System.out.println("The two race Car4 objects (rc1 & rc2) are equal");
        else
            System.out.println("The two race Car4 objects (rc1 & rc2) are not equal");


        System.out.println("\nComparing some Vehicle4s from different classes");
        System.out.println("==============================================");

        // Now notice the following statements 
        rc1.setPrice(6000);
        sc1.setPrice(6000);

        rc1.setNumOfDoors(2);
        sc1.setNumOfDoors(2);

        rc1.setNumOfSeats(2);
        sc1.setNumOfSeats(2);

        rc1.setGasConsumption(5);
        sc1.setGasConsumption(5);

        rc1.setHorsePower(300);

        // rc1 和sc1返回不等
        if(rc1.equals(sc1))
            System.out.println("Race Car4 rc1 & sport Car4 sc1 are equal");
        else
            System.out.println("Race Car4 rc1 & sport Car4 sc1 are not equal");

        // sc1 和rc1返回相等
        // instanceof与getClass（）和equal的区别
        // 如果被测试的对象是被测试的同类的成员，则 instanceof 运算符将返回 true，如果是该类的后代，它也将返回 true
        if(sc1.equals(rc1))
            System.out.println("Race Car4 rc1 & sport Car4 sc1 are equal");
        else
            System.out.println("Race Car4 rc1 & sport Car4 sc1 are not equal");

    }

}

