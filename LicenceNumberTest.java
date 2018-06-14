import CarRentalApplication.LicenceNumber;
import CarRentalApplication.Name;
import java.util.Date;
import java.util.regex.Pattern;

import CarRentalApplication.RegistrationNumber;
import org.junit.Test;

import static org.junit.Assert.*;

public class LicenceNumberTest
{
    Name name = new Name("Allday","Breakfast");
    Name name1 = new Name("Tuna","Cucumber");
    Name name2 = new Name("Prawn","Salad");
    Date date = new Date();
    Date date1 = new Date();
    Date date2 = new Date();

    LicenceNumber test = LicenceNumber.generateLicenceNum(name, date);
    LicenceNumber test1 = LicenceNumber.generateLicenceNum(name1,date1);
    LicenceNumber test2 = LicenceNumber.generateLicenceNum(name2,date2);

    @Test
    public void generateLicenceNum()
    {
        assertNotEquals(test, test2);
        assertNotEquals(test1, test2);
        assertNotEquals(test2, test);
        assertNotEquals(test, test1);

    }

    @Test
    public void getInitials()
    {
        assertTrue(Pattern.matches("[A-Z]{2}", (test.getInitials())));
        assertTrue(Pattern.matches("[A-Z]{2}", (test1.getInitials())));
        assertTrue(Pattern.matches("[A-Z]{2}", (test2.getInitials())));
    }
//Serial number hasn't been padded at this point
    @Test
    public void getSerialNumber()
    {
        assertTrue(Pattern.matches("[0-9]{1,2}",Integer.toString(test.getSerialNumber())));
        assertTrue(Pattern.matches("[0-9]{1,2}",Integer.toString(test1.getSerialNumber())));
        assertTrue(Pattern.matches("[0-9]{1,2}",Integer.toString(test2.getSerialNumber())));

    }

    @Test
    public void getLicenceNumber()
    {
        assertTrue(Pattern.matches("[A-Z]{2}-[0-9]{4}-[0-9]{1,2}",(test.getLicenceNumber())));
        assertTrue(Pattern.matches("[A-Z]{2}-[0-9]{4}-[0-9]{1,2}",(test1.getLicenceNumber())));
        assertTrue(Pattern.matches("[A-Z]{2}-[0-9]{4}-[0-9]{1,2}",(test2.getLicenceNumber())));

    }

}