package Vehicle;

public class Vehicle {

    // Attributes
    protected int numOfDoors; // protected 可以让其子类访问该属性 即使该子类在不同的包下
    protected double price;  // 而default 可以让其同一个包下的子类访问该属性

    // Constructors
    public Vehicle() {
        System.out.println("Creating a vehicle object using default constructor ....");
        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle(int nd, double pr) {
        System.out.println("Creating a vehicle object using parameterized constructor ....");
        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle(Vehicle vec) {
        System.out.println("Creating a vehicle object using copy constructor ....");
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
                "doors and it price is " + price + "$.";
    }
}