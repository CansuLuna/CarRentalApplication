import CarRentalApplication.DrivingLicence;
import CarRentalApplication.LicenceNumber;
import CarRentalApplication.Name;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class DrivingLicenceTest {

    Name newName = new Name("Salmon","Creamcheese");
    Date date = new Date();
    Date dob = new Date();
    DrivingLicence test = new DrivingLicence(newName, dob, LicenceNumber.generateLicenceNum(newName, date), date, true);

    @Test
    public void getName()
    {


      assertEquals(newName.getFullName().toString(),test.getName().toString());

    }

    @Test
    public void getDateOfBirth()
    {
        assertEquals(dob,test.getDateOfBirth());
    }

    @Test
    public void getDateOfIssue()
    {
        assertEquals(date,test.getDateOfIssue());
    }

    @Test
    public void getYearDifference()
    {

    }

    @Test
    public void getIssueDifference()
    {

    }

    @Test
    public void isFull()
    {
        assertEquals(true, test.isFull());
    }

    @Test
    public void getLicenceNumber()
    {

    }
}