
/**
 Contact.java defines the Contact object with its attributes: department and email,
 and implements methods to check the validity of the department and email .
 @author Khushi Ranpura, Kusum Gandham
 */
package p1;
public class Contact
{
    private Department department;
    private String email;

    /**
     Date constructor that creates a new Date object when parameters are passed in.
     @param department the department the contact represents
     @param email the contact's email
     */
    public Contact(Department department, String email)
    {
        this.department = department;
        this.email = email;
    }

    /**
     Checks validity of a Contact object, by calling methods isValidDepartment()
     and isValidEmail() to check individual attribute validity.
     @return true if the contact information is valid, false otherwise.
     */
    public boolean isValid()
    {
        return (isValidDepartment(this.department) && isValidEmail(this.email));
    }

    /**
     Helper method to check if passed in department name
     is a valid existing department
     @param department department hosting event
     @return true if the department name exists, false otherwise.
     */
    private boolean isValidDepartment(Department department)
    {
        for (Department dep : Department.values())
        {
            if (dep.equals(department))
            {
                return true;
            }
        }
        //error message print statement needs to be added here
        return false;
    }


    /**
     Helper method to check if passed in email is valid.
     @param email contact email
     @return true if the email is valid and in correct format
     */
    private boolean isValidEmail(String email)
    {
        return(email.endsWith("@rutgers.edu"));
    }
}