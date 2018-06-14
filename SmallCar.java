package CarRentalApplication;
/**
 * The purpose of this class is to store and retrieve
 * information about small cars. It is a child class of
 * CarRentalApplication.AbstractFleet class. It overrides the isThankFull method,
 * it also implements addFuel and drive methods
 *
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 */


public final class SmallCar extends AbstractFleet
{
    private final static int SMALLCAPACITY = 49;
    private final static int FUELCONSUMPTION = 20;

    /**
     * constructor for CarRentalApplication.SmallCar class
     */
   public SmallCar()
    {
        super();
    }

    /**
     * returns the tank capacity of the small car
     */
    public final int getTankCapacity ()
    {
        return SMALLCAPACITY;
    }

    /**
     * returns the type of car:small
     */
    public final String getSmallType()
    {
        return SMALLTYPE;
    }


    /**
     * To see if the tank is full or not
     * true = full
     * false= not full
     */
    public final boolean isTankFull()
    {
        boolean fuel = false;

        if(super.getCurrentFuel() == SMALLCAPACITY)
        {
            fuel = true;
        }
        return fuel;
    }


    /**
     * Method to add fuel up to the tanks capacity
     * it returns how much fuel was added to the tank
     * it returns 0 if the car is not rented or tank is already full
     * @param fuel
     * @return integer
     */
    public final int addFuel (int fuel)
    {
        int newFuel = 0;

        if (getCurrentFuel()+fuel <= SMALLCAPACITY)
        {
            newFuel = fuel;
            setCurrentFuel(fuel+getCurrentFuel());

        }
        else if(fuel+getCurrentFuel() > SMALLCAPACITY )
        {
            newFuel = SMALLCAPACITY - getCurrentFuel();
            setCurrentFuel(newFuel+getCurrentFuel());
        }else
        {
            throw new IllegalArgumentException("The tank is full");
        }

        return newFuel;
    }

    /**
     * Method that return the fuel consumption when given the distance that
     * the journey took.The car cannot be driven if it has 0 or less fuel or/and
     * it is not currently rented.
     * @param distance
     * @return integer
     */
    public final int drive (int distance)
    {
        int fuelConsumed;
        int newFuelLevel = 0;
        if(isCarRented()==true && getCurrentFuel() >= 0)
        {
            if(distance <= 50 && distance % 10 == 0 )
            {
                fuelConsumed = FUELCONSUMPTION/distance;
                newFuelLevel=getCurrentFuel()-fuelConsumed;
                setCurrentFuel(newFuelLevel);
            }
            else if (distance <= 50  && distance % 10 != 0)
            {
                fuelConsumed = FUELCONSUMPTION/distance + 1;
                newFuelLevel=getCurrentFuel()-fuelConsumed;
                setCurrentFuel(newFuelLevel);
            }
        }
        else
        {
            throw new IllegalArgumentException("This car has not been driven");
        }
        return newFuelLevel;
    }

}
