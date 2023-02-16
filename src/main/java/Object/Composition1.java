package Object;

// *******************************************************************
// Compositioin1.java By: Aiman Hanna (C) 1993 - 2021
// This program illustrates the subject of class composition. 
// Composition is when objects of some classes are used to create bigger 
// objects of other classes. 
// While inheritance leads to an "is-a" relationship between classes, 
// composition leads to a "has-a" relationship. 
//
// Key Points:
// 1) Class composition
// *******************************************************************


// Engine Class
class Engine {

    // Attributes
    private int horsePower;
    private double price;

    // Constructors
    public Engine()	// default constructor 
    {
        System.out.println("Creating an Engine object using default constructor ....");

        horsePower = 200;
        price = 14000;
    }

    public Engine(int hp, double pr)
    {
        System.out.println("Creating an Engine object using parameterized constructor ....");

        horsePower = hp;
        price = pr;
    }

    public int getHorsePower()
    {
        return horsePower;
    }

    public void setHorsePower(int hp)
    {
        horsePower = hp;
    }


    public double getPrice()
    {
        return price;
    }

    public void setPrice(double pr)
    {
        price = pr;
    }


    public boolean equals(Object x)
    {
        if (x == null || this.getClass() != x.getClass())
            return false;
        else
        {
            // cast the passed object to an Engine object
            Engine e = (Engine)x;
            return (this.price == e.price && this.horsePower == e.horsePower);
        }
    }


    public String toString()
    {
        return "This Engine has " + horsePower +
                " HP and it price is " + price + "$.";
    }

} // End of Engine class


// Body Class
class Body
{
    public static enum availableColors {White, Red, Yellow, Blue};

    // Attributes
    private availableColors color;
    private double price;

    // Constructors
    public Body()	// default constructor 
    {
        System.out.println("Creating a Body object using default constructor ....");

        color = availableColors.White;
        price = 8000;
    }

    public Body(availableColors cl, double pr)
    {
        System.out.println("Creating a Body object using parameterized constructor ....");

        color = cl;
        price = pr;
    }

    public availableColors getColor()
    {
        return color;
    }

    public void setColor(availableColors cl)
    {
        color = cl;
    }


    public double getPrice()
    {
        return price;
    }

    public void setPrice(double pr)
    {
        price = pr;
    }


    public boolean equals(Object x)
    {
        if (x == null || this.getClass() != x.getClass())
            return false;
        else
        {
            // cast the passed object to a body object
            Body b = (Body)x;
            return (this.price == b.price && this.color ==  b.color);
        }
    }


    public String toString()
    {
        return "The color of this Body is " + color +
                ", and its price is " + price + "$.";
    }

} // End of Engine class



//Car8 Class 
// A Car8 is composed of Engine & Body. It also has a price & manufacturing year
class Car8{

    // Attributes
    private Engine eng;
    private Body bdy;
    private double price;
    private int year;

    private final static double profitRate = 2.5;

    // Constructors
    public Car8()	// default constructor 
    {
        System.out.println("\nCreating a Car8 object using default constructor ....");

        eng = new Engine();
        bdy = new Body();
        price = (eng.getPrice() + bdy.getPrice()) * profitRate;
        year = 2010;
    }

    public Car8(int hp, Body.availableColors cl, double epr, double bpr, int yr)
    {
        System.out.println("\nCreating a Car8 object using parameterized constructor ....");

        eng = new Engine(hp, epr);
        bdy = new Body(cl, bpr);

        price = (epr + bpr) * profitRate;

        year = yr;
    }


    public int getHorsePower()
    {
        return eng.getHorsePower();
    }

    public void setHorsePower(int hp)
    {
        eng.setHorsePower(hp);
    }


    public Body.availableColors getColor()
    {
        return bdy.getColor();
    }


    public void setColor(Body.availableColors cl)
    {

        bdy.setColor(cl);
    }


    public double getPrice()
    {
        return price;
    }

    public void setPrice(double pr)
    {
        if(pr < (eng.getPrice() + bdy.getPrice()) )
        {
            System.out.println("Sorry, price does not cover cost. No change will be made.");
        }
        else
        {
            price = pr;
        }
    }

    public int getYear()
    {
        return year;
    }

    public void setyear(int yr)
    {
        year = yr;
    }

    public String toString()
    {
        return "This Car8 has " + eng.getHorsePower() + " HP, and its color is " +
                bdy.getColor() + ". The manufacturing year of the Car8 is " + year +
                ", and its price is " + price + "$.";

    }

    public boolean equals(Object x)
    {
        if (x == null || this.getClass() != x.getClass())
            return false;
        else
        {
            // cast the passed object to a Car8 object
            Car8 c = (Car8)x;

            return (this.getHorsePower() == c.getHorsePower() &&
                    this.getColor() == c.getColor() &&
                    this.getPrice() == c.getPrice() &&
                    this.year == c.year);
        }
    }
}   // end of Car8 class





public class Composition1 {
    public static void main(String[] args) {
        System.out.println("Will create three Car8 objects");

        Car8 c1 = new Car8(), c2 = new Car8(120, Body.availableColors.Blue, 22000, 4000, 2008),
                c3 = new Car8(250, Body.availableColors.Yellow, 19000, 1000, 2010);


        System.out.println("\nDisplaying information of the Car8s");
        System.out.println("==================================");



        System.out.println(c1);
        System.out.println();

        System.out.println(c2);
        System.out.println();

        System.out.println(c3);
        System.out.println();



    }

}

/* The Output 
Will create three Car8 objects

Creating a Car8 object using default constructor ....
Creating an Engine object using default constructor ....
Creating a Body object using default constructor ....

Creating a Car8 object using parameterized constructor ....
Creating an Engine object using parameterized constructor ....
Creating a Body object using parameterized constructor ....

Creating a Car8 object using parameterized constructor ....
Creating an Engine object using parameterized constructor ....
Creating a Body object using parameterized constructor ....

Displaying information of the Car8s
==================================
This Car8 has 200 HP, and its color is White. The manufacturing year of the Car8 is 2010, and its price is 55000.0$.

This Car8 has 120 HP, and its color is Blue. The manufacturing year of the Car8 is 2008, and its price is 65000.0$.

This Car8 has 250 HP, and its color is Yellow. The manufacturing year of the Car8 is 2010, and its price is 50000.0$.
*/
	
