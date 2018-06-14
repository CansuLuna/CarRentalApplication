package CarRentalApplication;

/**
 * A Java interface class
 * The interface includes methods: to get the car's registration number,
 * to get the capacity of the fuel tank, to get the current fuel amount in the
 * tank, to indicate whether the car's tank is full or not, to indicate
 * whether the car is rented or not, to add fuel and a drive method which returns
 * fuel consumption.
 *
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 */
public interface Fleet
{
    String getRegNumber();
    int getTankCapacity();
    int getCurrentFuel();
    boolean isTankFull();
    boolean isCarRented();
    int addFuel(int fuel);
    int drive(int distance);
    void setCurrentFuel (int amount);
    void setRented(boolean status);


}
