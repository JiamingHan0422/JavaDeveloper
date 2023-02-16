package Polymorphism;

//该程序说明了“多态性”和动态/后期绑定的主题。

//
// Key Points:
// 1) Late binding.


// Vehicle Class
class Vehicle {

    // Attributes
    protected int numOfDoors;
    protected double price;

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
        // 获取类名只是为了显示目的
        String s = this.getClass().toString();
        s = s.substring(6); // 删除单词“class”以仅获取类名
        System.out.println("Executing getPrice() from the " + s + " class. The price is " + price + "$.");
        return price;
    }

    public void setPrice(double pr) {
        price = pr;
    }

    public String toString() {
        return "This Vehicle has " + numOfDoors + " doors and it price is " + price + "$.";
    }

    // Find out if that vehicle has a cheaper price than the passed vehicle
    //两个后期绑定，只有在执行的时候才知道 this.getClass 是什么 类型 v是什么类型
    public boolean isCheaper(Vehicle v) {
        // Obtain the class names just for display purposes
        String s1 = this.getClass().toString(), s2 = v.getClass().toString();
        s1 = s1.substring(6); // Remove the word "class" to get only the class name
        s2 = s2.substring(6);


        if(getPrice() < v.getPrice()) {
            System.out.println("The price of this " + s1 +
                    " object is cheaper than the price of the passed " +
                    s2 + " object.");
            return true;
        }
        else {
            System.out.println("The price of this " + s1 +
                    " object is NOT cheaper than the price of the passed " +
                    s2 + " object.");
            return false;
        }
    }
}

class Bus extends Vehicle{

    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus() {
        System.out.println("Creating a bus object using default constructor ....");
        passengerCapacity = 10;
    }

    public Bus(int pc)
    {
        System.out.println("Creating a bus object using parameterized constructor ....");

        passengerCapacity = pc;
    }

    public Bus(Bus b)
    {
        System.out.println("Creating a bus object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
    }


    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public Bus(int nd, double pr, int pc)
    {

        this(pc); 	// Call the constructor that sets the passenger capacity

        System.out.println("Creating a bus object using parameterized constructor for full settings....\n");

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
        return "This Bus has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this bus is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr)
    {
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

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "Bus";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }
}   // end of Bus class



//Car Class - This is a derived class from the Vehicle Class.
//For a Car object, we are interested in its number of seats
class Car extends Vehicle{

    // Attributes
    private int numOfSeats;

    // Constructors
    public Car()	// default constructor
    {
        System.out.println("Creating a car object using default constructor ....");

        numOfSeats = 5;
    }

    public Car(int nd, double pr, int ns)
    {
        super(nd, pr);
        System.out.println("Creating a car object using parameterized constructor ....");

        numOfSeats = ns;
    }

    public Car(Car c)
    {
        System.out.println("Creating a car object using copy constructor ....");
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
        return "This Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this car is " + numOfSeats + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "Car";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }
}   // end of Car class



//SportCar Class - This is a derived class from the Car Class
//For a SportCar object, we are interested in its gas consumption
// as gallon per 100 miles
class SportCar extends Car{

    // Attributes
    private double gasConsumption;

    // Constructors
    public SportCar()	// default constructor
    {
        System.out.println("Creating a sport car object using default constructor ....");

        gasConsumption = 4;
    }

    public SportCar(int nd, double pr, int ns, double gc)
    {
        super(nd, pr, ns);
        System.out.println("Creating a sport car object using parameterized constructor ....");
        gasConsumption = gc;
    }

    public SportCar(SportCar sc)
    {
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


    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "SportCar";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }
}   // end of Sport Car class



//RaceCar Class - This is a derived class from the SportCar Class
//For a RaceCar object, we are interested in its horse power
class RaceCar extends SportCar{

    // Attributes
    private int horsePower;

    // Constructors
    public RaceCar()	// default constructor
    {
        System.out.println("Creating a race car object using default constructor ....");

        horsePower = 400;
    }

    public RaceCar(int nd, double pr, int ns, double gc, int hp)
    {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race car object using parameterized constructor ....");
        horsePower = hp;
    }

    public RaceCar(RaceCar rc)
    {
        System.out.println("Creating a race car object using copy constructor ....");

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
        return "This Race Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car is: " + horsePower + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "RaceCar";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }
}   // end of Race Car class

public class Polymorphism1{

    // A method that would accept any vehicle object and displays its information
    public static void showVehicleInfo(Vehicle v)
    {
        System.out.println("Here is the information of this vehicle");
        System.out.println(v);
        System.out.println();
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

        System.out.println("\nComparing the prices of different vehicles");
        System.out.println("==========================================\n");

        v1.isCheaper(v2);

        System.out.println();
        v2.isCheaper(rc1);

        System.out.println();
        sc1.isCheaper(b2);

        System.out.println();
        b3.isCheaper(c1);

        System.out.println();
        c2.isCheaper(sc2);

        System.out.println();
        sc2.isCheaper(v2);

        System.out.println();
        rc2.isCheaper(rc1);
    }

}

/* The Output
Will create two Vehicle objects

Creating a vehicle object using default constructor ....

Creating a vehicle object using parameterized constructor ....

Will create three Bus objects

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....
Creating a bus object using parameterized constructor for full settings....

Executing getPrice() from the Bus class. The price is 10000.0$.
Executing getPrice() from the Bus class. The price is 10000.0$.
Executing getPrice() from the Bus class. The price is 10000.0$.
The price of this bus will be increased from 10000.0$ to 55000.0$.

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....
Creating a bus object using parameterized constructor for full settings....

Executing getPrice() from the Bus class. The price is 10000.0$.
Executing getPrice() from the Bus class. The price is 10000.0$.
Executing getPrice() from the Bus class. The price is 10000.0$.
The price of this bus will be increased from 10000.0$ to 62000.0$.

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....
Executing getPrice() from the Bus class. The price is 55000.0$.
Executing getPrice() from the Bus class. The price is 10000.0$.
Executing getPrice() from the Bus class. The price is 10000.0$.
Executing getPrice() from the Bus class. The price is 10000.0$.
The price of this bus will be increased from 10000.0$ to 55000.0$.

Will create two Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....

Will create two Sport Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....

Will create two Race Car objects

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....
Creating a race car object using parameterized constructor ....

Creating a vehicle object using parameterized constructor ....
Creating a car object using parameterized constructor ....
Creating a sport car object using parameterized constructor ....
Creating a race car object using parameterized constructor ....

Comparing the prices of different vehicles
==========================================

Executing getPrice() from the Vehicle class. The price is 22000.0$.
Executing getPrice() from the Vehicle class. The price is 16700.0$.
The price of this Vehicle object is NOT cheaper than the price of the passed Vehicle object.

Executing getPrice() from the Vehicle class. The price is 16700.0$.
Executing getPrice() from the RaceCar class. The price is 67000.0$.
The price of this Vehicle object is cheaper than the price of the passed RaceCar object.

Executing getPrice() from the SportCar class. The price is 12000.0$.
Executing getPrice() from the Bus class. The price is 62000.0$.
The price of this SportCar object is cheaper than the price of the passed Bus object.

Executing getPrice() from the Bus class. The price is 55000.0$.
Executing getPrice() from the Car class. The price is 12000.0$.
The price of this Bus object is NOT cheaper than the price of the passed Car object.

Executing getPrice() from the Car class. The price is 26000.0$.
Executing getPrice() from the SportCar class. The price is 18500.0$.
The price of this Car object is NOT cheaper than the price of the passed SportCar object.

Executing getPrice() from the SportCar class. The price is 18500.0$.
Executing getPrice() from the Vehicle class. The price is 16700.0$.
The price of this SportCar object is NOT cheaper than the price of the passed Vehicle object.

Executing getPrice() from the RaceCar class. The price is 85000.0$.
Executing getPrice() from the RaceCar class. The price is 67000.0$.
The price of this RaceCar object is NOT cheaper than the price of the passed RaceCar object.

*/


