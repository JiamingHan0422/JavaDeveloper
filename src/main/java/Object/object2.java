package Object;

// 这个程序说明了更多的“对象”类。 该类定义了 equals() 方法，但是，该方法应始终被“覆盖”（不仅是重载）。 本节目着重于这一点。
// 注意 equals() 方法添加到不同的类。 虽然这些类中的每一个都定义了 equals() 方法，但它们都没有覆盖它。
// 现在这个程序可以正常工作了吗？ 它会一直正常工作吗？ 为什么？ 或者为什么不呢？

// Key Points:
// 1) The "Object" class
// 2) The equals() method - overriding vs. overloading

// Vehicle2 Class
class Vehicle2 {

    // Attributes
    private int numOfDoors;
    private double price;
    protected static int i = 12;

    // default constructor
    public Vehicle2() {
        System.out.println("\nCreating a Vehicle2 object using default constructor ....");
        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle2(int nd, double pr) {
        System.out.println("\nCreating a Vehicle2 object using parameterized constructor ....");
        numOfDoors = nd;
        price = pr;
    }

    // copy constructor 
    public Vehicle2(Vehicle2 vec) {
        System.out.println("\nCreating a Vehicle2 object using copy constructor ....");
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
        return "This Vehicle2 has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }

    public boolean equals(Vehicle2 v) {
        return (this.numOfDoors == v.numOfDoors && this.price == v.price);
    }
} 

// Bus2 Class - This is a derived class from the Vehicle2 Class; that is it 
// inherits the Vehicle2 class 
class Bus2 extends Vehicle2{

    // Attributes
    private int passengerCapacity;

    // default constructor 
    public Bus2() {
        System.out.println("Creating a Bus2 object using default constructor ....");
        passengerCapacity = 10;
    }

    public Bus2(int pc) {
        System.out.println("Creating a Bus2 object using parameterized constructor ....");
        passengerCapacity = pc;
    }

    public Bus2(Bus2 b) {
        System.out.println("Creating a Bus2 object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
    }

    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public Bus2(int nd, double pr, int pc) {
        this(pc); 	// Call the constructor that sets the passenger capacity
        System.out.println("Creating a Bus2 object using parameterized constructor for full settings....\n");
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
        return "This Bus2 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus2 is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr) {
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
    
    public boolean equals(Bus2 b) {
        return (this.getNumOfDoors() == b.getNumOfDoors() &&
                this.getPrice() == b.getPrice() &&
                this.passengerCapacity == b.passengerCapacity);
    }
}   

class Car2 extends Vehicle2{

    // Attributes
    private int numOfSeats;

    // default constructor
    public Car2() {
        System.out.println("Creating a Car2 object using default constructor ....");

        numOfSeats = 5;
    }

    public Car2(int nd, double pr, int ns) {
        super(nd, pr);
        System.out.println("Creating a Car2 object using parameterized constructor ....");

        numOfSeats = ns;
    }

    public Car2(Car2 c) {
        System.out.println("Creating a Car2 object using copy constructor ....");
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
        return "This Car2 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Car2 is " + numOfSeats + ".";
    }

    public boolean equals(Car2 c) {
        return (this.getNumOfDoors() == c.getNumOfDoors() &&
                this.getPrice() == c.getPrice() &&
                this.numOfSeats == c.numOfSeats);
    }
}


class SportCar2 extends Car2{

    // Attributes
    private double gasConsumption;

    // default constructor 
    public SportCar2() {
        System.out.println("Creating a sport Car2 object using default constructor ....");
        gasConsumption = 4;
    }

    public SportCar2(int nd, double pr, int ns, double gc) {
        super(nd, pr, ns);
        System.out.println("Creating a sport Car2 object using parameterized constructor ....");
        gasConsumption = gc;
    }

    public SportCar2(SportCar2 sc) {
        System.out.println("Creating a sport Car2 object using copy constructor ....");

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
        return "This Sport Car2 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car2 is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }

    public boolean equals(SportCar2 sc) {
        System.out.println("Executing equals() from the SportCar2 Class");
        return (this.getNumOfDoors() == sc.getNumOfDoors() &&
                this.getPrice() == sc.getPrice() &&
                this.getNumOfSeats() == sc.getNumOfSeats() &&
                this.gasConsumption == sc.gasConsumption);
    }
}

class RaceCar2 extends SportCar2{

    // Attributes
    private int horsePower;

    // default constructor 
    public RaceCar2() {
        System.out.println("Creating a race Car2 object using default constructor ....");
        horsePower = 400;
    }

    public RaceCar2(int nd, double pr, int ns, double gc, int hp) {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race Car2 object using parameterized constructor ....");
        horsePower = hp;
    }

    public RaceCar2(RaceCar2 rc) {
        System.out.println("Creating a race Car2 object using copy constructor ....");

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
        return "This Race Car2 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car2 is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car2 is: " + horsePower + ".";
    }

    // 这个equal是重载所以没有问题
    public boolean equals(RaceCar2 rc) {
        System.out.println("Executing equals() from the RaceCar2 Class");
        return (this.getNumOfDoors() == rc.getNumOfDoors() &&
                this.getPrice() == rc.getPrice() &&
                this.getNumOfSeats() == rc.getNumOfSeats() &&
                this.getGasConsumption() == rc.getGasConsumption() &&
                this.horsePower == rc.horsePower);
    }
}

public class object2 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle2 objects");

        Vehicle2 v1 = new Vehicle2(), v2 = new Vehicle2(4, 5000);
        v1.setPrice(22000);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus2 objects");

        Bus2 b1 = new Bus2(2, 55000, 37), b2 = new Bus2(3, 62000, 55), b3 = new Bus2(b1);

        System.out.println();
        System.out.println("Will create two Car2 objects");

        Car2 c1 = new Car2(4, 12000, 5), c2 = new Car2(2, 26000, 2);

        System.out.println();
        System.out.println("Will create two Sport Car2 objects");

        SportCar2 sc1 = new SportCar2(4, 12000, 5, 3), sc2 = new SportCar2(3, 12000, 5, 3);

        System.out.println();
        System.out.println("Will create two Race Car2 objects");

        RaceCar2 rc1 = new RaceCar2(4, 67000, 2, 4, 400), rc2 = new RaceCar2(3, 85000, 4, 4, 450);

        System.out.println("\nComparing some of the Vehicle2s");
        System.out.println("==============================");

        if(b1.equals(b2))
            System.out.println("The two Bus2 objects (b1 & b2) are equal");
        else
            System.out.println("The two Bus2 objects (b1 & b2) are not equal");

        if(b1.equals(b3))
            System.out.println("The two Bus2 objects (b1 & b3) are equal");
        else
            System.out.println("The two Bus2 objects (b1 & b3) are not equal");

        if(sc1.equals(sc2))
            System.out.println("The two sport Car2 objects (sc1 & sc2) are equal");
        else
            System.out.println("The two sport Car2 objects (sc1 & sc2) are not equal");

        if(rc1.equals(rc2))
            System.out.println("The two race Car2 objects (rc1 & rc2) are equal");
        else
            System.out.println("The two race Car2 objects (rc1 & rc2) are not equal");

        System.out.println("\nComparing some Vehicle2s from different classes");
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

        if(rc1.equals(sc1))
            System.out.println("Race Car2 rc1 & sport Car2 sc1 are equal");
        else
            System.out.println("Race Car2 rc1 & sport Car2 sc1 are not equal");

        if(sc1.equals(rc1))
            System.out.println("Race Car2 rc1 & sport Car2 sc1 are equal");
        else
            System.out.println("Race Car2 rc1 & sport Car2 sc1 are not equal");

        // 最糟糕的是，下面的语句只会让那个程序崩溃
        // 创建另一个 Bus2
        Bus2 b4 = new Bus2();		// 那真的是 Bus2 对象吗？ 该对象是否已初始化！ 将null改成Bus（）后问题解决

        if(b1.equals(b4))   //对比对象若为null的话则会报空指针错误
            System.out.println("The two Bus2 objects (b1 & b4) are equal");
        else
            System.out.println("The two Bus2 objects (b1 & b4) are not equal");
    }
}

