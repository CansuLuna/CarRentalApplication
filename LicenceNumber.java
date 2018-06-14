package CarRentalApplication;

import java.util.*;

/**
 * This is class functions as a factory to produce unique licence numbers.
 * A licence number consists of a persons initials, fallowed by the persons
 * date of birth and ends with a two digit random serial number.
 *
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 */
public class LicenceNumber
{
    private static final Set<LicenceNumber> LICENCENUM = new HashSet< LicenceNumber>();
    private final String initials;
    private final int issueYear;
    private final int serialNumber;
    private final String licenceNumber;

    /**
     * Constructor for the CarRentalApplication.LicenceNumber class
     */
    private LicenceNumber(String initials, int issueYear, int serialNumber)
    {
        this.initials = initials;
        this.issueYear = issueYear;
        this.serialNumber = serialNumber;
        licenceNumber = initials + "-" + issueYear + "-" + serialNumber;
    }

    /**
     * Method to generate unique licence numbers.
     * It gets the initials, issue year and generates random two digit number.
     * it finally checks to see if the generated licence number is already
     * in the set. If yes, the method is run again to assure uniqueness.
     */
    public final static LicenceNumber generateLicenceNum (Name fullName, Date dateOfIssue)
    {

        final String initials = fullName.getFirstName().substring(0, 1).toUpperCase() + fullName.getLastName().substring(0, 1).toUpperCase();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOfIssue);
        final int issueYear = cal.get(Calendar.YEAR);

        Random random = new Random();

        final int serialNumber = random.nextInt(100);//bound?

        final String licenceNumber = initials + "-" + issueYear + "-" + serialNumber;

        LicenceNumber ThisLicenceNumber = new LicenceNumber(initials, issueYear, serialNumber);

        if (!LICENCENUM.contains(licenceNumber))
        {
            LICENCENUM.add(ThisLicenceNumber);
        }
        else if (LICENCENUM.contains(licenceNumber))
        {
            return generateLicenceNum(fullName, dateOfIssue);
        }

        return ThisLicenceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenceNumber that = (LicenceNumber) o;
        return issueYear == that.issueYear &&
                serialNumber == that.serialNumber &&
                Objects.equals(initials, that.initials) &&
                Objects.equals(licenceNumber, that.licenceNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(initials, issueYear, serialNumber, licenceNumber);
    }

    /**
     * return the issue year
     */
    public final int getIssueYear()
    {
        return issueYear;
    }

    /**
     * returns initials
     */
    public final String getInitials()
    {
        return initials;
    }

    /**
     * returns serial number
     */
    public final int getSerialNumber()
    {
        return serialNumber;
    }

    /**
     * returns licence number
     */
    public final String getLicenceNumber()
    {
        return licenceNumber;
    }

    public final String toString()
    {
        String finalFormat = this.initials + "-"+ this.issueYear + "-"+this.serialNumber;

        return finalFormat;
    }
}