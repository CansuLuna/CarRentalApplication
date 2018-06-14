package CarRentalApplication;
/**
 * The purpose of this class is to store and retrieve
 * information about large cars. It is a child class of
 * CarRentalApplication.AbstractFleet class. It overrides the isThankFull method,
 * it also implements addFuel and drive methods
 *
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 */

import CarRentalApplication.AbstractFleet;

public final class LargeCar extends AbstractFleet
{
    private final static int LARGECAPACITY = 60;
    private final static int FUELCONSUMPTION = 10;
    private final static int FUELCONSUMPTION_2 = 15;

    /**
     * constructor for CarRentalApplication.LargeCar class
     */
   public LargeCar()
    {
        super();
    }

    /**
     * returns the tank capacity of the large car
     */
    public final int getTankCapacity ()
    {
        return LARGECAPACITY;
    }

    /**
     * returns the type of car:large
     */
    public final String getLargeType()
    {
    return LARGETYPE;
    }


    /**
     * To see if the tank is full or not
     * true = full
     * false= not full
     * @return boolean
     */
    public final boolean isTankFull()
    {
        boolean fuel = false;

        if(getCurrentFuel() == LARGECAPACITY )
        {
            fuel = true;
        }
        return fuel;

    }


    /**
     * Method to add fuel up to the tanks capacity
     * it returns how much fuel was added to thr tank
     * it returns 0 if the car is not rented or tank is already full
     * @param fuel
     * @return integer
     */
    public final int addFuel (int fuel)
    {
        int newFuel = 0;

        if (getCurrentFuel()+fuel <= LARGECAPACITY)
        {
            newFuel = fuel;
            setCurrentFuel(fuel+getCurrentFuel());

        }
        else if(fuel+getCurrentFuel() > LARGECAPACITY )
        {
            newFuel = LARGECAPACITY - getCurrentFuel();
            setCurrentFuel(newFuel+getCurrentFuel());
        }else
        {
            throw new IllegalArgumentException("The tank is full");
        }

        return newFuel;
    }

    /**
     * Method that returns the fuel consumption when given the distance that
     * the journey took.The car cannot be driven if it has 0 or less fuel or/and
     * it is not currently rented.
     * @param distance
     * @return integer
     */
    public final int drive (int distance)
    {
        int fuelConsumed = 0;
        int newFuelLevel;
        if(isCarRented()==true && getCurrentFuel() >= 0)
        {
            if(distance <= 50  && distance % 10 == 0)
            {
                fuelConsumed = distance/FUELCONSUMPTION;
                newFuelLevel=getCurrentFuel()-fuelConsumed;
                setCurrentFuel(newFuelLevel);

            }
            else if (distance <= 50  && distance % 10 != 0)
            {
                fuelConsumed = distance/FUELCONSUMPTION + 1;
                newFuelLevel=getCurrentFuel()-fuelConsumed;
                setCurrentFuel(newFuelLevel);

            }
            else if (distance > 50)
            {
                int higherSpeed = distance - 50;

                fuelConsumed= (higherSpeed/FUELCONSUMPTION_2) + (distance/FUELCONSUMPTION);
                if (higherSpeed % 15 != 0)
                {
                    fuelConsumed =+ 1;
                }
                newFuelLevel=getCurrentFuel()-fuelConsumed;
                setCurrentFuel(newFuelLevel);
            }

        }
        else
        {
            throw new IllegalArgumentException("This car has not been driven");
        }
        return fuelConsumed;
    }

}
