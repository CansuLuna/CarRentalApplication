import CarRentalApplication.LargeCar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargeCarTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTankCapacity()
    {
        LargeCar test = new LargeCar();
        assertEquals(60,test.getTankCapacity());

        LargeCar test1 = new LargeCar();
        assertNotEquals(49,test1.getTankCapacity());


        LargeCar test2 = new LargeCar();
        assertNotEquals(25,test2.getTankCapacity());

    }

    @Test
    public void getLargeType()
    {
        LargeCar test = new LargeCar();
        assertEquals("large",test.getLargeType());

        LargeCar test1 = new LargeCar();
        assertNotEquals("small",test1.getLargeType());
    }

    @Test
    public void isTankFull()
    {
        LargeCar test = new LargeCar();
        test.setCurrentFuel(60);
        assertEquals(true,test.isTankFull());

        LargeCar test1 = new LargeCar();
        test.setCurrentFuel(20);
        assertEquals(false,test1.isTankFull());
    }

    @Test
    public void addFuel()
    {
        LargeCar test1 = new LargeCar();
        test1.setCurrentFuel(0);
        assertEquals(60,test1.addFuel(70));

        LargeCar test = new LargeCar();
        test.setCurrentFuel(20);
        assertEquals(40,test.addFuel(70));
    }

    @Test
    public void testIllegalArgumentAddFuel() throws Exception
    {
        try
        {
            LargeCar test1 = new LargeCar();
            test1.setCurrentFuel(60);
            test1.addFuel(5);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("The tank is full",e.getMessage());
        }
    }

    @Test
    public void drive()
    {
        LargeCar test = new LargeCar();
        test.setRented(true);
        test.setCurrentFuel(50);
        assertEquals(4, test.drive(40));
    }

    @Test
    public void getRegNumber()
    {
        LargeCar test = new LargeCar();
        assertEquals(test.getRegNumber(),test.getRegNumber());
    }

    @Test
    public void setCurrentFuel()
    {
        LargeCar test = new LargeCar();
        test.setCurrentFuel(20);
        assertEquals(20,test.getCurrentFuel());
    }

    @Test
    public void getCurrentFuel()
    {
        LargeCar test = new LargeCar();
        test.setCurrentFuel(20);
        assertEquals(20,test.getCurrentFuel());
    }

    @Test
    public void setRented()
    {
        LargeCar test = new LargeCar();
        test.setRented(true);
        assertEquals(true,test.isCarRented());

        LargeCar test1 = new LargeCar();
        test1.setRented(false);
        assertEquals(false,test1.isCarRented());
    }

    @Test
    public void isCarRented()
    {
        LargeCar test = new LargeCar();
        assertEquals(false,test.isCarRented());

        LargeCar test1 = new LargeCar();
        test1.setRented(true);
        assertEquals(true, test1.isCarRented());
    }

}