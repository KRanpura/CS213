/**
 Department.java defines an enum class called Department, which represents
 acronyms for different university departments along with their full names.
 @author Khushi Ranpura
 */
package p1;
public enum Department
{
    CS("computer science"),
    EE("electrical engineering"),
    ITI("information technology and informatics"),
    MATH("mathematics"),
    BAIT("business analytics and information technology");

    private String departmentName;

    /**
     Constructor for the Department enum class that initializes the
     departmentName field of each enum constant to the String value
     passed into the method .
     @param departmentName hosting department
     */
    private Department (String departmentName)
    {
        this.departmentName = departmentName;
    }

    /**
     Getter method that returns the full department name of the
     Department acronym constant it is called on.
     @return departmentName
     */
    public String getDepartmentName()
    {
        return departmentName;
    }
}

