package CarRentalApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * The purpose of this class is to store and retrieve
 * information on driving licence such as name, date of birth,
 * date of issue, licence number and whether the licence is full or not.
 * The class also contains two methods that calculates the year difference
 * between now and the date of birth and date of issue.
 *
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 */

public class DrivingLicence
{
    private final Name name;
    private final Date dateOfBirth;
    private final LicenceNumber licenceNumber;
    private final Date dateOfIssue;
    private boolean isFull;

    /**
     * constructor for CarRentalApplication.DrivingLicence class
     */
    public DrivingLicence(Name name, Date dateOfBirth, LicenceNumber licenceNumber, Date dateOfIssue, boolean isFull)
    {
        this.dateOfBirth = new Date(dateOfBirth.getTime());
        this.name = new Name(name.getFirstName(),name.getLastName());
        this.licenceNumber = LicenceNumber.generateLicenceNum(name, dateOfIssue);
        this.isFull = isFull;
        this.dateOfIssue = new Date(dateOfIssue.getTime());
    }

    /**
     * returns name
     */
    public Name getName()
    {
        return new Name(name.getFirstName(),name.getLastName());

    }

    /**
     * returns date of birth
     */
    public Date getDateOfBirth()
    {
        return new Date(dateOfBirth.getTime());
    }

    /**
     * returns date of issue
     */
    public Date getDateOfIssue()
    {
        return new Date(dateOfIssue.getTime());
    }


    /**
     * returns true if is a full license
     */
    public boolean isFull()
    {
        return isFull;
    }

    /**
     *returns licence number
     */
    public LicenceNumber getLicenceNumber()
    {
        return licenceNumber;
    }
}
