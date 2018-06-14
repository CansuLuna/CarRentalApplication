package CarRentalApplication;

/**
 * An Abstract class that implements the CarRentalApplication.Fleet interface
 *
 * The purpose of this class is to store and retrieve
 * information about the car.
 *
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 */
public abstract class AbstractFleet implements Fleet
{
    private boolean isFull;
    private boolean isRented;
    private RegistrationNumber regNumber;
    final static String LARGETYPE = "large";
    final static String SMALLTYPE = "small";
    private int currentFuel;


    AbstractFleet()
    {
        this.isFull = true;
        this.isRented = false;
        this.regNumber = RegistrationNumber.generateRegNumber();

    }
    public static Fleet getInstance(String type) {

        if (type.equalsIgnoreCase(LARGETYPE)) {
            return new LargeCar();

        } else if (type.equalsIgnoreCase(SMALLTYPE)) {
            return new SmallCar();
        } else
        {
            throw new IllegalArgumentException("Type doesn't exist");
        }
    }

    /**
     * To get the registration number of the car
     */
    public final String getRegNumber()
    {
        return this.regNumber.toString();
    }


    /**
     * To set the current fuel amount of the car's tank
     */
    public final void setCurrentFuel (int amount)
    {
        this.currentFuel = amount;
    }

    /**
     * To get the current fuel amount of the car's tank
     */
    public final int getCurrentFuel()
    {
        return currentFuel;
    }

    /**
     * To change the status of the car from rented to available or vice versa
     * true = rented
     * false= available for rent
     * @param status
     */
    public final void setRented(boolean status)
    {
        this.isRented=status;
    }

    /**
     * Method to see if the car is rented or available
     * true = rented
     * false= available for rent
     * @return boolean
     */
    public final boolean isCarRented()
    {
        boolean carRented;

        if (isRented==true)
        {
            carRented=true;
        }
        else
        {
            carRented=false;
        }
        return carRented;
    }

    public String toString()
    {
        String car = this.regNumber.toString();

        return car;
    }

    //public abstract void setCapacity(int newCapacity);

    public abstract int addFuel(int fuel);

    public abstract int drive(int distance);

    public abstract int getTankCapacity();

}
