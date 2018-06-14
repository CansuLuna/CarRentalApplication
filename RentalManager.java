package CarRentalApplication;

import java.util.*;

/**
 * The purpose of this class is to maintain a record of who has rented a given car.
 * The class also includes methods to issue cars for rent and terminate existing
 * rental contracts.It also provides information on car availability and type.
 *
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 */
public class RentalManager {
    static final RentalManager INSTANCE = new RentalManager();
    static ArrayList<Fleet> fleetArrayList;
    static Map<DrivingLicence, Fleet> RECORD;
    private static final int LRGAGE = 25;
    private static final int SMLAGE = 21;
    private static final int SMLLICENCE = 1;
    private static final int LRGLICENCE = 5;
    private final static int NUMBEROFLARGECARS = 20;
    private final static int NUMBEROFSMALLCARS = 30;

    /**
     * Constructor that populates fleetArrayList.
     */
    private RentalManager() {
        fleetArrayList = new ArrayList<>();
        RECORD = new HashMap<>();

        for (int i = 0; i < NUMBEROFSMALLCARS; i++)
            fleetArrayList.add(new SmallCar());

        for (int i = 0; i < NUMBEROFLARGECARS; i++)
            fleetArrayList.add(new LargeCar());
    }

    public static RentalManager getINSTANCE()
    {
        return INSTANCE;
    }


    /**
     * Method that returns available cars
     * @return  list of cars
     */
    public static ArrayList<Fleet> getFleetArrayList()
    {
        return fleetArrayList;
    }

    /**
     * returns the keys and values of the Map
     * @return key and values of the map
     */
    public final static Map<DrivingLicence, Fleet> getRECORD() {
        return RECORD;
    }

    /**
     * method that returns number of available cars of a given type
     * @param typeOfCar
     * @return integer value
     */
    public final int availableCars(String typeOfCar) {
        int availableCars = 0;

        if (typeOfCar.equalsIgnoreCase("large"))
        {

            for (Fleet l : fleetArrayList) {
                if (l instanceof LargeCar && l.isCarRented() == false) {
                    System.out.println("in large car");
                    availableCars ++;
                }

            }

        }
        else if( typeOfCar.equalsIgnoreCase("small"))
        {
            for (Fleet s : fleetArrayList)
            {
                if (s instanceof SmallCar && s.isCarRented() == false)
                {
                    System.out.println("in small car ");
                    availableCars ++;
                }
            }
        }
        else
            {
            throw new IllegalArgumentException("the company only owns large or small cars");
            }

        return availableCars;

    }

    /**
     * method that returns collection of all the cars currently rented out, if any
     * @return ArrayList
     */
    public final ArrayList<Fleet> getRentedCars()
    {

        return new ArrayList<>(RECORD.values());
    }

    /**
     * Given a person's driving licence, the method return the car they are currently
     * renting, if any
     * @param licence
     * @return Fleet type object
     */
    public final Fleet getCar(DrivingLicence licence) {
        Fleet car = null;
        if (RECORD.containsKey(licence)) {
            car = RECORD.get(licence);

        }
        Fleet tempCar = car;
        return tempCar;
    }

    public Date getDate(int year) {
        Calendar cal = Calendar.getInstance();

        int yearDifference = cal.getWeekYear() - year;
        cal.set(cal.YEAR, yearDifference);
        Date date = cal.getTime();
        return date;

    }

    /**
     * Given a person's driving licence and desired car type, the method determines
     * whether the person is eligible to rent a car. If the person and the car passes
     * all the qualification, they are put in to the map.
     * @param licence
     * @param typeOfCar
     */
    public final void issueCar(DrivingLicence licence, String typeOfCar)
    {
        Fleet car = null;

        if (licence.isFull()) {
            if (typeOfCar.equalsIgnoreCase("large"))
            {
                while (car == null) {
                    for (Fleet s : fleetArrayList) {
                        if (s instanceof LargeCar) {
                            car = s;

                        }
                    }
                }
                if (car != null) {
                    car.setCurrentFuel(60);

                    if (car.getCurrentFuel() == car.getTankCapacity()) {
                        Date largeAge = getDate(LRGAGE);
                        Date largeIssue = getDate(LRGLICENCE);

                        if ((licence.getDateOfBirth().before(largeAge) || licence.getDateOfBirth().equals(largeAge)) && ( licence.getDateOfIssue().before(largeIssue) || licence.getDateOfIssue().equals(largeIssue) ))
                        {
                            car.setRented(true);
                            RECORD.put(licence, car);
                            fleetArrayList.remove(car);

                        }

                    }
                }
            }

            else if (typeOfCar.equalsIgnoreCase("small")) {

                    while (car == null)
                    {
                        for (Fleet s : fleetArrayList) {
                            if (s instanceof SmallCar) {
                                car = s;

                            }
                        }
                    }

                    if (car != null)
                    {
                        //all cars must be full before given out for rent, since this is not a real-life project. I am setting it up manually below.
                        car.setCurrentFuel(49);

                        if (car.getCurrentFuel() == car.getTankCapacity())
                        {
                            Date smallAge = getDate(SMLAGE);

                            Date issue = getDate(SMLLICENCE);


                            if ((licence.getDateOfBirth().before(smallAge)||licence.getDateOfBirth().equals(smallAge)) &&( licence.getDateOfIssue().before(issue)||licence.getDateOfBirth().equals(issue)))
                            {
                                car.setRented(true);
                                RECORD.put(licence, car);
                                fleetArrayList.remove(car);

                            }
                        }
                    }

                }
            else {
                throw new IllegalArgumentException("A car cannot be issued");
            }

        }
    }

        /**
         * method terminates the rental contract associated with the given driving licence
         * A car only be returned with a full tank. If tank is not full, the method returns
         * the amount of fuel that needs to be added.
         * @param licence
         * @return integar value
         */
    public final int terminateRental(DrivingLicence licence)
    {
        int addFuel=0;

        if(RECORD.containsKey(licence))
        {
            Fleet car = RECORD.get(licence);
            if(car.getTankCapacity()-car.getCurrentFuel() == 0)
            {
               Fleet f = RECORD.get(licence);
               fleetArrayList.add(f);
               car.setRented(false);
               RECORD.remove(licence);


           }else
                {

                  addFuel = car.getTankCapacity() - car.getCurrentFuel();

                }
        }
        else
            {
               throw new IllegalArgumentException("This license is not registered in the system");
           }

           return addFuel;
    }

    }

