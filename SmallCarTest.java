import CarRentalApplication.SmallCar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallCarTest {


    @Test
    public void getTankCapacity()
    {
        SmallCar test = new SmallCar();
        assertEquals(49,test.getTankCapacity());

        SmallCar test1 = new SmallCar();
        assertNotEquals(60,test1.getTankCapacity());

        SmallCar test2 = new SmallCar();
        assertNotEquals(25,test2.getTankCapacity());
    }

    @Test
    public void getSmallType()
    {
        SmallCar test = new SmallCar();
        assertEquals("small",test.getSmallType());

        SmallCar test1 = new SmallCar();
        assertNotEquals("large",test1.getSmallType());
    }

    @Test
    public void isTankFull()
    {
        SmallCar test = new SmallCar();
        test.setCurrentFuel(49);
        assertEquals(true,test.isTankFull());

        SmallCar test1 = new SmallCar();
        test.setCurrentFuel(40);
        assertEquals(false,test1.isTankFull());
    }

    @Test
    public void drive()
    {
        SmallCar test = new SmallCar();
        test.setRented(true);
        test.setCurrentFuel(20);
        assertEquals(18, test.drive(10));

    }

    @Test
    public void getRegNumber()
    {
        SmallCar test = new SmallCar();
        assertEquals(test.getRegNumber(),test.getRegNumber());
    }

    @Test
    public void setCurrentFuel()
    {
        SmallCar test = new SmallCar();
        test.setCurrentFuel(20);
        assertEquals(20,test.getCurrentFuel());
    }

    @Test
    public void getCurrentFuel()
    {
        SmallCar test = new SmallCar();
        test.setCurrentFuel(20);
        assertEquals(20,test.getCurrentFuel());
    }

    @Test
    public void setRented()
    {
        SmallCar test = new SmallCar();
        test.setRented(true);
        assertEquals(true,test.isCarRented());

        SmallCar test1 = new SmallCar();
        test1.setRented(false);
        assertEquals(false,test1.isCarRented());
    }

    @Test
    public void isTankFull1()
    {
        SmallCar test = new SmallCar();
        test.setCurrentFuel(49);
        assertEquals(true,test.isTankFull());

        SmallCar test1 = new SmallCar();
        test1.setCurrentFuel(20);
        assertEquals(false,test1.isTankFull());
    }

    @Test
    public void isCarRented()
    {
        SmallCar test = new SmallCar();
        assertEquals(false,test.isCarRented());

        SmallCar test1 = new SmallCar();
        test1.setRented(true);
        assertEquals(true, test1.isCarRented());
    }

    @Test
    public void addFuel()
    {

        SmallCar test1 = new SmallCar();
        test1.setCurrentFuel(0);
        assertEquals(49,test1.addFuel(70));

        SmallCar test = new SmallCar();
        test.setCurrentFuel(20);
        assertEquals(29,test.addFuel(70));

    }
    @Test
    public void testIllegalArgumentAddFuel() throws Exception
    {
        try
        {
            SmallCar test1 = new SmallCar();
            test1.setCurrentFuel(49);
            test1.addFuel(70);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("The tank is full",e.getMessage());
        }
    }

}