package CarRentalApplication;

import java.util.*;

/**
 * This class functions as a factory to produce unique registration numbers.
 * A registration number consists of a capital letter fallowed by 4 random digits
 *
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 */

public final class RegistrationNumber
{
    private static final Map<String, RegistrationNumber> REGNUM = new HashMap<>();

    private final char letter; // One letter
    private final int numbers; // Four numbers
    private final String finalFormat; // letter + number, e.g. A1234

    /**
     * constructor for the CarRentalApplication.RegistrationNumber class
     */
    private RegistrationNumber(char letter, int numbers)
    {
        this.letter = letter;
        this.numbers = numbers;
        this.finalFormat =String.format("%c%04d",letter,numbers);
    }

    /**
     * Method to generate unique registration numbers.
     * it randomly generates a character and 4 digit numbers
     * It then checks the see if this combination already exists in the map.
     * If not, the combination gets added to the map. If yes, the method is run
     * again till we get a unique combination
     */
    public final static RegistrationNumber generateRegNumber()
    {
        Random random = new Random();

        final char letter = (char) (random.nextInt(26) + 'a');
        final int numbers = random.nextInt(10000);//bound?


        System.out.println("Before formatting number = " + " " + numbers);
        final String finalFormat = String.format("%c%04d",letter,numbers);
        System.out.println("After formatting number = " + " " + finalFormat);
        if (!REGNUM.containsKey(finalFormat))
        {
            REGNUM.put(finalFormat, new RegistrationNumber(letter, numbers));
        }
        else if (REGNUM.containsKey(finalFormat))
        {
            return generateRegNumber();

        }

        return REGNUM.get(finalFormat);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationNumber that = (RegistrationNumber) o;
        return letter == that.letter &&
                numbers == that.numbers &&
                Objects.equals(finalFormat, that.finalFormat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(letter, numbers, finalFormat);
    }

    /**
     * Method to get the letter
     */
    public final char getLetter()
    {
        return letter;
    }

    /**
     * Method to get numbers
     */
    public final int getNumbers()
    {
        return numbers;
    }

    /**
     * Method to get the combination of letter and numbers.
     */
    public final String getFinalFormat()
    {
        return finalFormat;
    }

    public final  String toString()
    {
        String finalFormat = this.finalFormat;
        //System.out.print("This is Final Format to String " + "   "+ finalFormat);
        return finalFormat;
    }

    public static Map<String, RegistrationNumber> getREGNUM() {
        return REGNUM;
    }

}

