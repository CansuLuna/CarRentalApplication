package CarRentalApplication;

/**
 * @author Cansu Karaboga
 * @version 1.0 12 Mar 2018
 *
 */
public final class Name
{
    private final String firstName;
    private final String lastName;
    private final String fullName;

    /**
     * Constructor for CarRentalApplication.Name class.
     * It does not let String objects to be formed as null.
     */
    public Name(String firstName, String lastName)
    {
        if (firstName.trim().isEmpty() || firstName == null)
            throw new IllegalArgumentException("First name cannot be empty");

        if (lastName.trim().isEmpty() || firstName == null)
            throw new IllegalArgumentException("Last name cannot be empty");

        this.firstName =firstName;
        this.lastName = lastName;
        this.fullName = firstName +" "+ lastName;
    }

    /**
     * method to get first name
     */
    public final String getFirstName()
    {
        return firstName;
    }

    /**
     * method to get last name
     */
    public final String getLastName()
    {
        return lastName;
    }

    /**
     * method to get full name: fist name + last name
     */
    public final String getFullName()
    {
        return fullName;
    }

    public final String toString()
    {
        return fullName;
    }

}
