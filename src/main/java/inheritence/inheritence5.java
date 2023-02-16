package inheritence;

// 该程序详细说明了默认构造函数和其他构造函数。 该程序显示了如何调用基类的其他构造函数。
// 请注意，到目前为止，在所有前面的示例中，派生类构造函数只导致调用基类的默认构造函数。
//
// Key Points: 
// 1) The "super" constructor  


// Vehicle5 Class
class Vehicle5 {
    // Attributes
    private int numOfDoors;
    private double price;

    // default constructor
    public Vehicle5() {
        System.out.println("Creating a Vehicle5 object using default constructor ....");
        numOfDoors = 4;
        price = 10000;
    }

    public Vehicle5(int nd, double pr) {
        System.out.println("Creating a Vehicle5 object using parameterized constructor ....");
        numOfDoors = nd;
        price = pr;
    }

    // copy constructor
    public Vehicle5(Vehicle5 vec) {
        System.out.println("Creating a Vehicle5 object using copy constructor ....");

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
        return "This Vehicle5 has " + numOfDoors +
                "doors and it price is " + price + "$.";
    }
} // end of Vehicle5 class

// Bus5 类——这是 Vehicle5 类的派生类； 那就是它继承了Vehicle5类
class Bus5 extends Vehicle5{

    // Attributes
    private int passengerCapacity;

    // default constructor
    public Bus5() {
        System.out.println("Creating a Bus5 object using default constructor ....\n");
        passengerCapacity = 10;
    }

    public Bus5(int pc) {
        System.out.println("Creating a Bus5 object using parameterized constructor ....\n");
        passengerCapacity = pc;
    }

    public Bus5(Bus5 b) {
        System.out.println("Creating a Bus5 object using copy constructor ....\n");

        passengerCapacity = b.passengerCapacity;
    }

    // 允许设置价格和门数的构造函数 这样以来 子类就彻底可以定义父类所具有的属性了
    public Bus5(int nd, double pr, int pc) {
        super(nd, pr); 	// 只需将给定的参数传递给基类的构造函数即可进行设置
        System.out.println("Creating a Bus5 object using parameterized constructor for full settings....\n");
        passengerCapacity = pc;
    }

    public int getPassangerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int pc) {
        passengerCapacity = pc;;
    }

    public String toString() {
        return "This Bus5 has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this Bus5 is " + passengerCapacity + ".";
    }

    // Override the setPrice() method
    public void setPrice(double pr) {
        if(pr < getPrice())
            System.out.println("The price of this Bus5 will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this Bus5 will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the Bus5.");

        // 请注意，您不能直接访问“price”，因为它是基类私有的，即 price = pr; 将是非法的
        // 因为你复写了父类的方法 所以需要通过关键词super来调用父类的属性或方法
        super.setPrice(pr);
    }
}

public class inheritence5 {
    public static void main(String[] args) {
        System.out.println("Will create two Vehicle5 objects");

        Vehicle5 v1 = new Vehicle5(), v2 = new Vehicle5(4, 5000);
        v1.setPrice(22000);
        v2.setPrice(16700);

        System.out.println();
        System.out.println("Will create three Bus5 objects");

        Bus5 b1 = new Bus5(2, 55000, 37), b2 = new Bus5(3, 62000, 55), b3 = new Bus5(b1);

        //更改其中一些 Bus5 对象的信息

        b3.setPrice(9900);

        System.out.println();
        System.out.println("Here is the information of the first Bus5:\n" + b1 + "\n");
        System.out.println("Here is the information of the second Bus5:\n" + b2 + "\n");
        System.out.println("Here is the information of the third Bus5:\n" + b3 + "\n");
    }
}

	
