package inheritence;

// 该程序说明了派生类的对象如何也被视为其基（祖先）类的对象的概念。 请注意，事实并非如此。

// 1. 大部分时候，普通方法访问其他方法、成员变量时无须使用 this 前缀，但如果方法里有个局部变量和成员变量同名，但程序又需要在该方法里访问这个被覆盖的成员变量，则必须使用 this 前缀。
// 2. this 关键字最大的作用就是让类中一个方法，访问该类里的另一个方法或实例变量。
// 3. 用 this( ) 来访问本类的其他构造函数

// Key Points:
// 1) The is-a relationship between derived and base classes.

// Vehicle9 Class
class Vehicle9 {

    // Attributes
    private int numOfDoors;
    private double price;

    // default constructor
    public Vehicle9() {
        System.out.println("\nCreating a Vehicle9 object using default constructor ....");
        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle9(int nd, double pr) {
        System.out.println("\nCreating a Vehicle9 object using parameterized constructor ....");
        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle9(Vehicle9 vec) {
        System.out.println("\nCreating a Vehicle9 object using copy constructor ....");
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
        return "This Vehicle9 has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }
}

class Bus9 extends Vehicle9{

    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus9() {
        System.out.println("Creating a Bus9 object using default constructor ....");
        passengerCapacity = 10;
    }

    public Bus9(int pc) {
        System.out.println("Creating a Bus9 object using parameterized constructor ....");
        passengerCapacity = pc;
    }

    public Bus9(Bus9 b) {
        System.out.println("Creating a Bus9 object using copy constructor ....");
        setNumOfDoors(b.getNumOfDoors());   //省略了super
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
    }

    // 允许设置价格、门数和载客量的构造函数
    public Bus9(int nd, double pr, int pc) {
        this(pc); 	// Call the constructor that sets the passenger capacity
        System.out.println("Creating a Bus9 object using parameterized constructor for full settings....\n");

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
        return "This Bus9 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus9 is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr) {
        if(pr < getPrice())
            System.out.println("The price of this Bus9 will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this Bus9 will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the Bus9.");

        super.setPrice(pr);
        // Notice that you cannot access "price" directly  since it is private to the base class
        // i.e. price = pr; would be illegal
    }
}   // end of Bus9 class


//Car Class - This is a derived class from the Vehicle9 Class.
//For a Car object, we are interested in its number of seats
class Car extends Vehicle9{

    // Attributes
    private int numOfSeats;

    // default constructor
    public Car() {
        System.out.println("Creating a car object using default constructor ....");
        numOfSeats = 5;
    }

    public Car(int nd, double pr, int ns) {
        super(nd, pr);
        System.out.println("Creating a car object using parameterized constructor ....");
        numOfSeats = ns;
    }

    public Car(Car c) {
        System.out.println("Creating a car object using copy constructor ....");
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
        return "This Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this car is " + numOfSeats + ".";
    }
}

//对于 SportCar 对象，我们感兴趣的是它每 100 英里的汽油消耗量（加仑）
class SportCar extends Car{

    // Attributes
    private double gasConsumption;

    // default constructor
    public SportCar() {
        System.out.println("Creating a sport car object using default constructor ....");
        gasConsumption = 4;
    }

    public SportCar(int nd, double pr, int ns, double gc) {
        super(nd, pr, ns);
        System.out.println("Creating a sport car object using parameterized constructor ....");
        gasConsumption = gc;
    }

    public SportCar(SportCar sc) {
        System.out.println("Creating a sport car object using copy constructor ....");

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
        return "This Sport Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }
}

class RaceCar extends SportCar{

    // Attributes
    private int horsePower;

    // default constructor
    public RaceCar() {
        System.out.println("Creating a race car object using default constructor ....");
        horsePower = 400;
    }

    public RaceCar(int nd, double pr, int ns, double gc, int hp) {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race car object using parameterized constructor ....");
        horsePower = hp;
    }

    public RaceCar(RaceCar rc) {
        System.out.println("Creating a race car object using copy constructor ....");

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
        return "This Race Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car is: " + horsePower + ".";
    }
}

public class inheritence9 {
    // 一种接受任何 Vehicle9 对象并显示其信息的方法
    public static void showVehicle9Info(Vehicle9 v) {
        System.out.println("Here is the information of this Vehicle9");
        System.out.println(v);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Will create two Vehicle9 objects");

        Vehicle9 v1 = new Vehicle9(), v2 = new Vehicle9(4, 5000);
        v1.setPrice(22000);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus9 objects");

        Bus9 b1 = new Bus9(2, 55000, 37), b2 = new Bus9(3, 62000, 55), b3 = new Bus9(b1);

        System.out.println();
        System.out.println("Will create two Car objects");

        Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 26000, 2);

        System.out.println();
        System.out.println("Will create two Sport Car objects");

        SportCar sc1 = new SportCar(4, 12000, 5, 3), sc2 = new SportCar(3, 18500, 4, 4);

        System.out.println();
        System.out.println("Will create two Race Car objects");

        RaceCar rc1 = new RaceCar(4, 67000, 2, 4, 400), rc2 = new RaceCar(3, 85000, 4, 4, 450);

        System.out.println("\nDisplaying Information of the different Vehicle9s");
        System.out.println("================================================\n");

        // 现在，由于所有创建的对象实际上都是 Vehicle9 对象，因此以下调用都是可能的、合法的，并且可以正常运行。
        showVehicle9Info(v1);
        showVehicle9Info(v2);
        showVehicle9Info(b1);
        showVehicle9Info(b2);
        showVehicle9Info(b3);
        showVehicle9Info(sc1);
        showVehicle9Info(sc2);
        showVehicle9Info(rc1);
        showVehicle9Info(rc2);
    }

}
