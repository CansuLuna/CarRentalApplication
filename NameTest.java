import CarRentalApplication.Name;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {



    @Test
    public void getFirstName()
    {
        Name name = new Name("Roast", "Dinner");
        assertEquals("Roast", name.getFirstName());
    }

    @Test
    public void testIllegalArgumentFirstName() throws Exception
    {
        try
        {
         Name fail = new Name ("", "Avocado");
         fail("First name cannot be null");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("First name cannot be empty",e.getMessage());
        }

        try
        {
            Name fail = new Name (" ", "Chocolate");
            fail("Last name cannot be null");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("First name cannot be empty",e.getMessage());
        }
    }

    @Test
    public void getLastName()
    {
        Name name = new Name("Meal", "Deal");
        assertEquals("Deal", name.getLastName());

    }

    @Test
    public void testIllegalArgumentLastName() throws Exception
    {
        try
        {
            Name fail = new Name ("Cake", "");
            fail("Last name cannot be null");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Last name cannot be empty",e.getMessage());
        }

        try
        {
            Name fail = new Name ("Coffee", " ");
            fail("Last name cannot be null");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Last name cannot be empty",e.getMessage());
        }
    }

    @Test
    public void getFullName()
    {
        Name name = new Name("Strawberry", "Pie");
        assertEquals("Strawberry Pie",name.getFullName());
    }

}