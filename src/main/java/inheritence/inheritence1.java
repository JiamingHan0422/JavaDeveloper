package inheritence;

// 这个程序说明了继承的主题。 特别是，该程序说明了在使用继承时如何创建对象。
// Key Points:
// 	1) Inheritance
// 	2) Base & derived classes
//  3) The keyword "extends"
//  4) Default constructors

// Vehicle Class
class Vehicle {

    // Attributes
     int numOfDoors; // protected 可以让其子类访问该属性 即使该子类在不同的包下
     double price;  // 而default 可以让其同一个包下的子类访问该属性

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


// Bus 类 - 这是 Vehicle 类的派生类； 那就是它继承了Vehicle类
class Bus extends Vehicle{
    // Attributes
    private int passengerCapacity;
    // Constructors
    public Bus(){
        System.out.println("Creating a bus object using default constructor ....\n");
        passengerCapacity = 10;
    }
    public Bus(int pc) {
        System.out.println("Creating a bus object using parameterized constructor ....\n");
        passengerCapacity = pc;
    }

    public Bus(Bus b) {
        System.out.println("Creating a bus object using copy constructor ....\n");
        passengerCapacity = b.passengerCapacity;
    }

    @Override
    public void setNumOfDoors(int nd) {
        super.setNumOfDoors(nd);
    }

    @Override
    public void setPrice(double pr) {
        super.setPrice(pr); //子类方法重写父类，由于重名 要加上super
    }

    public int getPassangerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int pc) {
        passengerCapacity = pc;;
    }
    // 这里可以看出 door 和 price是继承了默认的 Vehicle 的属性
    public String toString() {
        return "This Bus has a passenger capacity of " + getPassangerCapacity() + "." + "and door " + getNumOfDoors() + "and price " + getPrice();
    }
}

public class inheritence1 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle objects");

        Vehicle v1 = new Vehicle(), v2 = new Vehicle(2, 5000);

        System.out.println();
        System.out.println("Will create three Bus objects");

        Bus b1 = new Bus(), b2 = new Bus(55), b3 = new Bus(b1);

        // 向上转型好处 如果以子类对象为参数，则有多少个子类就需要重写写多少个子类函数 使代码变得简洁，但向上转 父类引用虽然的确拿的是子类对象，但子类的扩展方法也随之丢失
        Vehicle v5 = new Bus(60);  //这个向上转型是父类引用子类对象
        Bus b4 = (Bus) v2;

        // 向下转型(子 = (父) 父， 父()对象（其实是子引用）变成子类了)前必须先向上转型(父 = new子()， 子()对象变成父类了)

        //因为 子类引用不能指向父类对象
        // 向下转型好处是可以将向上转型时子类丢失的扩展方法找回
        Bus b5 = new Bus(70);
        b5.setNumOfDoors(v2.getNumOfDoors());
        b5.setPrice(v2.getPrice());

        System.out.println("Here is the information of the first bus:\n" + b1 + "\n");
        System.out.println("Here is the information of the second bus:\n" + b2 + "\n");
        System.out.println("Here is the information of the third bus:\n" + b3 + "\n");

        System.out.println("Here is the information of the first Vehicle:\n" + v1 + "\n");
        System.out.println("Here is the information of the second Vehicle:\n" + v2 + "\n");
        System.out.println("Here is the information of the third Vehicle:\n" + b5 + "\n");
    }

}

