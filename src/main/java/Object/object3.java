package Object;

// This program illustrates more of the "Object" class and overriding 
// the equals() method. This program fixes the problems that 
// Object2.java has.
//
// Key Points:
// 1) The "Object" class
// 2) Overriding the equals() method 
// 3) The "getClass()" method
// 4) Casting objects from Object to other classes



// Vehicle3 Class
class Vehicle3 {

    // Attributes
    private int numOfDoors;
    private double price;
    protected static int i = 12;

    // default constructor
    public Vehicle3() {
        System.out.println("\nCreating a Vehicle3 object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle3(int nd, double pr) {
        System.out.println("\nCreating a Vehicle3 object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle3(Vehicle3 vec) {
        System.out.println("\nCreating a Vehicle3 object using copy constructor ....");

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

    public void setPrice(double pr)
    {
        price = pr;
    }

    public String toString()
    {
        return "This Vehicle3 has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }

    //Override the equals() method from the Object class
//Question: Does it really makes a difference to include this == null verification below?!
    public boolean equals(Object x) {
        if (x == null || this == null || this.getClass() != x.getClass())
            return false;
        else
        {
            // cast the passed object to a Vehicle3 object
            Vehicle3 v = (Vehicle3)x;
            return (this.numOfDoors == v.numOfDoors && this.price == v.price);
        }

    }
}

class Bus3 extends Vehicle3{

    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus3() {
        System.out.println("Creating a Bus3 object using default constructor ....");

        passengerCapacity = 10;
    }

    public Bus3(int pc) {
        System.out.println("Creating a Bus3 object using parameterized constructor ....");

        passengerCapacity = pc;
    }

    public Bus3(Bus3 b) {
        System.out.println("Creating a Bus3 object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
    }

    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public Bus3(int nd, double pr, int pc) {
        this(pc); 	// Call the constructor that sets the passenger capacity
        System.out.println("Creating a Bus3 object using parameterized constructor for full settings....\n");

        // Notice that we now cannot call super to set the other two attributes 
        // (i.e. super(nd, pr);) since either "this" or 'super" must be the first 
        // statement, and it is not possible to have both of them as such!
        setPrice(pr);
        setNumOfDoors(nd);
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
        // Notice that you cannot access "price" directly  since it is private to the base class
        // i.e. price = pr; would be illegal
    }

    // 添加条件使得空object不会报错，若obj为空直接返回false
    public boolean equals(Object x) {
        if (x == null || this == null || this.getClass() != x.getClass())
            return false;
        else {
            // cast the passed object to a Bus3 object
            Bus3 b = (Bus3)x;

            return (this.getNumOfDoors() == b.getNumOfDoors() &&
                    this.getPrice() == b.getPrice() &&
                    this.passengerCapacity == b.passengerCapacity);
        }
    }
}


class Car3 extends Vehicle3{

    // Attributes
    private int numOfSeats;

    // default constructor
    public Car3() {
        System.out.println("Creating a Car3 object using default constructor ....");

        numOfSeats = 5;
    }

    public Car3(int nd, double pr, int ns)
    {
        super(nd, pr);
        System.out.println("Creating a Car3 object using parameterized constructor ....");

        numOfSeats = ns;
    }

    public Car3(Car3 c) {
        System.out.println("Creating a Car3 object using copy constructor ....");
        setNumOfDoors(c.getNumOfDoors());
        setPrice(c.getPrice());
        numOfSeats = c.numOfSeats;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int ns) {
        numOfSeats = ns;;
    }

    public String toString() {
        return "This Car3 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Car3 is " + numOfSeats + ".";
    }

    public boolean equals(Object x) {
        if (x == null || this == null || this.getClass() != x.getClass())
            return false;
        else
        {
            // cast the passed object to a Car3 object
            Car3 c = (Car3)x;

            return (this.getNumOfDoors() == c.getNumOfDoors() &&
                    this.getPrice() == c.getPrice() &&
                    this.numOfSeats == c.numOfSeats);
        }
    }
}

class SportCar3 extends Car3{
    // Attributes
    private double gasConsumption;

    // default constructor
    public SportCar3() {
        System.out.println("Creating a sport Car3 object using default constructor ....");
        gasConsumption = 4;
    }

    public SportCar3(int nd, double pr, int ns, double gc) {
        super(nd, pr, ns);
        System.out.println("Creating a sport Car3 object using parameterized constructor ....");
        gasConsumption = gc;
    }

    public SportCar3(SportCar3 sc) {
        System.out.println("Creating a sport Car3 object using copy constructor ....");

        setNumOfDoors(sc.getNumOfDoors());
        setPrice(sc.getPrice());
        setNumOfSeats(sc.getNumOfSeats());

        gasConsumption = sc.gasConsumption;
    }

    public double getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(double gc) {
        gasConsumption = gc;;
    }

    public String toString() {
        return "This Sport Car3 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car3 is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }

    public boolean equals(Object x) {
        System.out.println("Executing equals() from the SportCar3 Class");
        if (x == null || this == null || this.getClass() != x.getClass())
            return false;
        else {
            // cast the passed object to a SportCar3 object
            SportCar3 sc = (SportCar3)x;

            return (this.getNumOfDoors() == sc.getNumOfDoors() &&
                    this.getPrice() == sc.getPrice() &&
                    this.getNumOfSeats() == sc.getNumOfSeats() &&
                    this.gasConsumption == sc.gasConsumption);
        }
    }
}

class RaceCar3 extends SportCar3{

    // Attributes
    private int horsePower;

    // default constructor
    public RaceCar3() {
        System.out.println("Creating a race Car3 object using default constructor ....");
        horsePower = 400;
    }

    public RaceCar3(int nd, double pr, int ns, double gc, int hp) {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race Car3 object using parameterized constructor ....");
        horsePower = hp;
    }

    public RaceCar3(RaceCar3 rc) {
        System.out.println("Creating a race Car3 object using copy constructor ....");

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
        return "This Race Car3 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car3 is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car3 is: " + horsePower + ".";
    }

    // 这个equal是重写，两个对象类中只要有一个对象是重写了equals这个方法且带上以下条件 就无法满足不同类型对象equal
    // 两个不同类型的对象调用equals方法，如果equals方法没有被重写 永远不会相等；如果equals方法被重写，且含有instanceof逻辑，那么有可能相等。而getClass（）仍然永远不会相等
    public boolean equals(Object x) {
        System.out.println("Executing equals() from the RaceCar3 Class");
        if (x == null || this == null || this.getClass() != x.getClass())
            return false;
        else {
            // cast the passed object to a RaceCar3 object
            RaceCar3 rc = (RaceCar3)x;

            return (this.getNumOfDoors() == rc.getNumOfDoors() &&
                    this.getPrice() == rc.getPrice() &&
                    this.getNumOfSeats() == rc.getNumOfSeats() &&
                    this.getGasConsumption() == rc.getGasConsumption() &&
                    this.horsePower == rc.horsePower);
        }
    }
}   // end of Race Car3 class

public class object3 {
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

        SportCar3 sc1 = new SportCar3(4, 12000, 5, 3), sc2 = new SportCar3(3, 12000, 5, 3);

        System.out.println();
        System.out.println("Will create two Race Car3 objects");

        RaceCar3 rc1 = new RaceCar3(4, 67000, 2, 4, 400), rc2 = new RaceCar3(3, 85000, 4, 4, 450);

        System.out.println("\nComparing some of the Vehicle3s");
        System.out.println("==============================");

        if(b1.equals(b2))
            System.out.println("The two Bus3 objects (b1 & b2) are equal");
        else
            System.out.println("The two Bus3 objects (b1 & b2) are not equal");

        if(b1.equals(b3))
            System.out.println("The two Bus3 objects (b1 & b3) are equal");
        else
            System.out.println("The two Bus3 objects (b1 & b3) are not equal");

        if(sc1.equals(sc2))
            System.out.println("The two sport Car3 objects (sc1 & sc2) are equal");
        else
            System.out.println("The two sport Car3 objects (sc1 & sc2) are not equal");

        if(rc1.equals(rc2))
            System.out.println("The two race Car3 objects (rc1 & rc2) are equal");
        else
            System.out.println("The two race Car3 objects (rc1 & rc2) are not equal");

        System.out.println("\nComparing some Vehicle3s from different classes");
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

        // 两个不同的对象调用默认的equals方法也是返回不相等的

        if(rc1.equals(sc1))
            System.out.println("Race Car3 rc1 & sport Car3 sc1 are equal");
        else
            System.out.println("Race Car3 rc1 & sport Car3 sc1 are not equal");

        if(sc1.equals(rc1))
            System.out.println("Race Car3 rc1 & sport Car3 sc1 are equal");
        else
            System.out.println("Race Car3 rc1 & sport Car3 sc1 are not equal");

        Bus3 b4 = null;		// Is that really a Bus3 object? is that object initialized!

        if(b1.equals(b4))
            System.out.println("The two Bus3 objects (b1 & b4) are equal");
        else
            System.out.println("The two Bus3 objects (b1 & b4) are not equal");
    }
}

	
