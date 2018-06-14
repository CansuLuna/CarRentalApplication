import CarRentalApplication.DrivingLicence;
import CarRentalApplication.LicenceNumber;
import CarRentalApplication.RentalManager;
import CarRentalApplication.Name;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class RentalManagerTest {


    @Test
    public void issueCar()
    {
        try
        {
            Name name = new Name("Cansu", "Karaboga");

            Calendar today = Calendar.getInstance();
            int yearDifference = today.getWeekYear();
            today.set(today.YEAR, yearDifference);
            Date dob = today.getTime();

            Calendar today2 = Calendar.getInstance();
            int yearDifference2 = today2.getWeekYear() - 6;
            today2.set(today2.YEAR, yearDifference2);
            Date doi = today2.getTime();

            LicenceNumber licenceNumber = LicenceNumber.generateLicenceNum(name, doi);
            DrivingLicence drivingLicence = new DrivingLicence(name, dob, licenceNumber, doi, true);

            RentalManager rm = RentalManager.getINSTANCE();

        }
        catch (IllegalArgumentException e)
        {
            assertEquals("A car cannot be issued",e.getMessage());
        }

        try
        {
            Name name = new Name("Cansu", "Karaboga");

            Calendar today = Calendar.getInstance();
            int yearDifference = today.getWeekYear() + 20;
            today.set(today.YEAR, yearDifference);
            Date dob = today.getTime();

            Calendar today2 = Calendar.getInstance();
            int yearDifference2 = today2.getWeekYear() - 6;
            today2.set(today2.YEAR, yearDifference2);
            Date doi = today2.getTime();

            LicenceNumber licenceNumber = LicenceNumber.generateLicenceNum(name, doi);
            DrivingLicence drivingLicence = new DrivingLicence(name, dob, licenceNumber, doi, true);

            RentalManager rm = RentalManager.getINSTANCE();

        }
        catch (IllegalArgumentException e)
        {
            assertEquals("A car cannot be issued",e.getMessage());
        }

        try
        {
            Name name = new Name("Cansu", "Karaboga");

            Calendar today = Calendar.getInstance();
            int yearDifference = today.getWeekYear() - 70;
            today.set(today.YEAR, yearDifference);
            Date dob = today.getTime();

            Calendar today2 = Calendar.getInstance();
            int yearDifference2 = today2.getWeekYear() - 6;
            today2.set(today2.YEAR, yearDifference2);
            Date doi = today2.getTime();

            LicenceNumber licenceNumber = LicenceNumber.generateLicenceNum(name, doi);
            DrivingLicence drivingLicence = new DrivingLicence(name, dob, licenceNumber, doi, true);

            RentalManager rm = RentalManager.getINSTANCE();

        }
        catch (IllegalArgumentException e)
        {
            assertNotEquals("A car cannot be issued",e.getMessage());
        }

    }

    @Test
    public void terminateRental()
    {
        Name name = new Name("Cansu", "Karaboga");

        Calendar today = Calendar.getInstance();
        int yearDifference = today.getWeekYear() - 70;
        today.set(today.YEAR, yearDifference);
        Date dob = today.getTime();

        Calendar today2 = Calendar.getInstance();
        int yearDifference2 = today2.getWeekYear() - 6;
        today2.set(today2.YEAR, yearDifference2);
        Date doi = today2.getTime();


        LicenceNumber licenceNumber = LicenceNumber.generateLicenceNum(name, doi);
        DrivingLicence drivingLicence = new DrivingLicence(name, dob, licenceNumber, doi, true);

        RentalManager rm = RentalManager.getINSTANCE();

        rm.issueCar(drivingLicence,"small");
        assertEquals(0, rm.terminateRental(drivingLicence));

    }

}