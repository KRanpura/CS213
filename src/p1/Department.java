/**
 Department.java defines an enum class called Department, which represents
 acronyms for different university departments along with their full names.
 @author Khushi Ranpura
 */
package p1;
public enum Department
{
    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI("Information Technology and Informatics"),
    MATH("Mathematics"),
    BAIT("Business Analytics and Information Technology");

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

    public Department getDepartment(String deptString)
    {
        for (Department dep : Department.values())
        {
            if (dep.toString().equals(deptString))
            {
                return dep;
            }
        }
        return null;
    }
}

