package Object;

//该程序说明了“Object”类。 所有的 Java 类都继承自这个类。 因此，所有 Java 对象实际上也是来自该 Object 类的对象。
// 使用“instanceof”运算符，可以知道对象是否是特定类的实例。

// See the showVehicleInfo() method below.

// Key Points:
// 1) The "Object" class
// 2) The "instanceof" operator

// 一些classes； 注意这些类的实现还没有给出
class Book {}
class Painting{}
class Phones{}

// Vehicle Class
class Vehicle {
    // Attributes
    private int numOfDoors;
    private double price;
    protected static int i = 12;

    // default constructor
    public Vehicle() {
        System.out.println("\nCreating a vehicle object using default constructor ....");
        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle(int nd, double pr) {
        System.out.println("\nCreating a vehicle object using parameterized constructor ....");
        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle(Vehicle vec) {
        System.out.println("\nCreating a vehicle object using copy constructor ....");
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
        return "This Vehicle has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }
}

// Bus 类——这是 Vehicle 类的派生类； 那就是它继承了Vehicle类
class Bus extends Vehicle{
    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus() {
        System.out.println("Creating a bus object using default constructor ....");
        passengerCapacity = 10;
    }

    public Bus(int pc) {
        System.out.println("Creating a bus object using parameterized constructor ....");
        passengerCapacity = pc;
    }

    public Bus(Bus b) {
        System.out.println("Creating a bus object using copy constructor ....");
        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
    }

    // 允许设置价格、门数和载客量的构造函数
    public Bus(int nd, double pr, int pc) {
        this(pc); 	// 调用设置载客量的构造函数
        System.out.println("Creating a bus object using parameterized constructor for full settings....\n");
        // 请注意，我们现在不能调用 super 来设置其他两个属性（即 super(nd, pr);），
        // 因为“this”或“super”必须是第一个语句，并且不可能同时拥有它们 ！
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
        return "This Bus has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this bus is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr) {
        if(pr < getPrice())
            System.out.println("The price of this bus will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this bus will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the bus.");

        super.setPrice(pr);
        // Notice that you cannot access "price" directly  since it is private to the base class
        // i.e. price = pr; would be illegal
    }
}

//Car 类 - 这是 Vehicle 类的派生类。
//对于汽车对象，我们感兴趣的是它的座位数
class Car extends Vehicle{
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

//跑车类 - 这是汽车类的派生类
//对于跑车对象，我们感兴趣的是它的汽油消耗量（以每 100 英里加仑为单位）
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

//RaceCar 类 - 这是 SportCar 类的派生类
//对于 RaceCar 对象，我们感兴趣的是它的马力
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

public class object1 {
    // 一种接受任何车辆对象并显示其信息的方法
    public static void showVehicleInfo(Object x) {
        // 知道所有 Vehicle 类都覆盖了 toString() 方法，如果传递的对象是这些类之一，那么使用 toString() 方法显示其信息是安全的
        // instanceof 判断其左边对象是否为其右边类的实例，返回boolean类型的数据
        if(x instanceof Vehicle) {
            System.out.println("Here is the information of this vehicle");
            System.out.println(x);
            System.out.println();
        }
        else
            System.out.println("The type of the passed object is unknown; will not display any information ");
    }

    public static void main(String[] args) {
        System.out.println("Will create two Vehicle objects");

        Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000);
        v1.setPrice(22000);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus objects");

        Bus b1 = new Bus(2, 55000, 37), b2 = new Bus(3, 62000, 55), b3 = new Bus(b1);

        System.out.println();
        System.out.println("Will create two Car objects");

        Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 26000, 2);

        System.out.println();
        System.out.println("Will create two Sport Car objects");

        SportCar sc1 = new SportCar(4, 12000, 5, 3), sc2 = new SportCar(3, 18500, 4, 4);

        System.out.println();
        System.out.println("Will create two Race Car objects");

        RaceCar rc1 = new RaceCar(4, 67000, 2, 4, 400), rc2 = new RaceCar(3, 85000, 4, 4, 450);

        System.out.println("\nDisplaying Information of the different vehicles");
        System.out.println("================================================\n");

        Book bk1 = new Book();
        Painting p1 = new Painting();
        Phones ph1 = new Phones();

        // 现在，由于所有创建的对象实际上都是 Object 对象，因此以下调用都是可能且合法的，并且将按照我们的计划运行。
        showVehicleInfo(v1);
        showVehicleInfo(v2);
        showVehicleInfo(b1);

        showVehicleInfo(bk1);

        showVehicleInfo(b2);
        showVehicleInfo(b3);
        showVehicleInfo(sc1);

        showVehicleInfo(p1);
        showVehicleInfo(ph1);

        showVehicleInfo(sc2);
        showVehicleInfo(rc1);
        showVehicleInfo(rc2);
    }
}


