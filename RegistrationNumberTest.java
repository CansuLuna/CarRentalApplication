import CarRentalApplication.RegistrationNumber;
import org.junit.Test;
import java.util.regex.*;
import static org.junit.Assert.*;
import java.util.*;



public class RegistrationNumberTest {

    RegistrationNumber test = RegistrationNumber.generateRegNumber();
    RegistrationNumber test1 = RegistrationNumber.generateRegNumber();
    RegistrationNumber test2 = RegistrationNumber.generateRegNumber();
    RegistrationNumber test3 = RegistrationNumber.generateRegNumber();
    RegistrationNumber test4 = RegistrationNumber.generateRegNumber();
    RegistrationNumber test5 = RegistrationNumber.generateRegNumber();
    RegistrationNumber test6 = RegistrationNumber.generateRegNumber();
    RegistrationNumber test7 = RegistrationNumber.generateRegNumber();
    RegistrationNumber test8 = RegistrationNumber.generateRegNumber();
    RegistrationNumber test9 = RegistrationNumber.generateRegNumber();

    @Test
    public void generateRegNumber()
    {
        assertNotEquals(test, test5);
        assertNotEquals(test1, test4);
        assertNotEquals(test2, test3);
        assertNotEquals(test3, test2);
        assertNotEquals(test4, test1);
        assertNotEquals(test5, test);
        assertNotEquals(test6, test9);
        assertNotEquals(test7, test8);
        assertNotEquals(test8, test7);
        assertNotEquals(test9, test6);
        assertNotEquals(test, test5);
        assertNotEquals(test1, test4);
        assertNotEquals(test2, test3);
        assertNotEquals(test3, test2);
        assertNotEquals(test4, test1);
        assertNotEquals(test5, test);
    }

    @Test
    public void getLetter()
    {
        assertTrue(Pattern.matches("[a-z]", Character.toString(test.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test1.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test2.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test3.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test4.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test5.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test6.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test7.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test8.getLetter())));
        assertTrue(Pattern.matches("[a-z]", Character.toString(test9.getLetter())));

    }

    //number hasnt been padded at this point, so it may be less then 4 digits
    @Test
    public void getNumbers()
    {
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test1.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test2.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test3.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test4.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test5.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test6.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test7.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test8.getNumbers())));
        assertTrue(Pattern.matches("[0-9]{1,4}", Integer.toString(test9.getNumbers())));

    }

    @Test
    public void getFinalFormat()
    {
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test1.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test2.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test3.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test4.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test5.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test6.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test7.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test8.getFinalFormat()));
        assertTrue(Pattern.matches("[a-z][0-9]{4}", test9.getFinalFormat()));

    }

    @Test
    public void testing() throws Exception {
        ArrayList<RegistrationNumber> regs = new ArrayList<>();
        for(int i = 0; i < 9000; i++){
            RegistrationNumber regNum = RegistrationNumber.generateRegNumber();
            regs.add(regNum);
        }
        int count = 0;
        for(RegistrationNumber regNum1 : regs) {
            for(int i = 0; i < regs.size(); i++){
                if(count != i)
                    assertNotEquals(regNum1, regs.get(i));
            }
            count ++;
        }
    }

}