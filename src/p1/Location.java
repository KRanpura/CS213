/**
 Location.java defines an enum class called Location, which represents
 acronyms for different locations along with methods and constructors
 to set and access attributes of the location, like building name and campus name.
 @author Khushi Ranpura
 */

package p1;
public enum Location
{
    HLL114("Hill Center", "Busch"),
    ARC103("Allison Road Classroom", "Busch"),
    BE_AUD("Beck Hall", "Livingston"),
    TIL232("Tillett Hall", "Livingston"),
    AB2225("Academic Building", "College Avenue"),
    MU302("Murray Hall", "College Avenue");

    private String buildingName;
    private String campusName;

    /**
     Constructor for the Department enum class that initializes the
     departmentName field of each enum constant to the String value
     passed into the method.
     @param buildingName building room is booked in
     @param campusName campus that the building is on
     */
    private Location(String buildingName, String campusName)
    {
        this.buildingName = buildingName;
        this.campusName = campusName;
    }

    /**
     Getter method that returns the building name of the
     Location acronym constant it is called on.
     @return buildingName
     */
    public String getBuildingName()
    {
        return buildingName;
    }

    /**
     Getter method that returns the name of the campus that
     one of the buildings is located on for the Location
     acronym constant it is called on.
     @return campusName
     */
    public String getCampusName()
    {
        return campusName;
    }

    public Location getLocation(String locationString)
    {
        for (Location location : Location.values())
        {
            if (location.toString().equals(locationString))
            {
                return location;
            }
        }
        return null;
    }

}


