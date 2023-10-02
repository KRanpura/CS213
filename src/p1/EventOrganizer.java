/**
 * EventOrganizer.java creates a new instance of the Event Organizer
 * class. It defines methods to parse user input for event information
 * in addition to making and removing events.
 * @author Kusum Gandham, Khushi Ranpura
 */
package p1;
import java.util.Scanner;
public class EventOrganizer
{
    private static final int SIX_MONTHS_IN_DAYS = 182;

    /**
        Private helper method to parse user input for event information,
        check if information is valid, and then add the event.
        @param eventParts array of String inputs to parse
        @param calendar calendar to add new event to 
     */
    private void addHelper(String [] eventParts, EventCalendar calendar)
    {
            String dateStr = eventParts[0];
            int month = Integer.parseInt(dateStr.split("/")[0]);
            int day = Integer.parseInt(dateStr.split("/")[1]);
            int year = Integer.parseInt(dateStr.split("/")[2]);
            Date eventDate = new Date(month, day, year);
            if (!validEventDate(eventDate))
            {
                return;
            }
            Timeslot timeslot = getTimeSlot(eventParts[1].toUpperCase());
            if (timeslot == null)
            {
                System.out.println("Invalid time slot!");
                return;
            }
            Location location = getLocation(eventParts[2].toUpperCase());
            if (location == null)
            {
                System.out.println("Invalid location!");
                return;
            }
            String contactString = eventParts[4];
            String[] contactSplit = contactString.split("@");
            Department dept = getDepartment(contactSplit[0].toUpperCase());
            if (dept == null)
            {
                System.out.println("Invalid contact information!");
                return;
            }
            Contact contact = new Contact(dept, contactString);
            if (!contact.isValid())
            {
                System.out.println("Invalid contact information!");
                return;
            }
            int duration = Integer.parseInt(eventParts[5]); //fix this to catch NumberFormatException
            if (duration < 30 || duration > 120)
            {
                System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
                return;
            }
            Event newEvent = new Event(eventDate, timeslot, location, contact, duration);
            if (calendar.add(newEvent))
            {
                System.out.println("Event added to calender.");
            }
            else
            {
                System.out.println("The event is already on the calender.");
            }
    }

    /**
     Private helper method to parse user input for event information,
     check if event is valid and exists, and then remove the event.
     @param removeEventParts array of String inputs to parse for event info
     @param calendar calendar to add remove event from
     */
    private void removeHelper(String [] removeEventParts, EventCalendar calendar)
    {
        String dateStr = removeEventParts[0];
        int month =Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date eventDate = new Date(month, day, year);
        if (!validEventDate(eventDate))
        {
            return;
        }
        String timeslotStr = removeEventParts[1].toUpperCase();
        Timeslot timeslot = getTimeSlot(timeslotStr);
        if (timeslot == null)
        {
            System.out.println("Invalid timeslot!");
            return;
        }
        String locationString = removeEventParts[2].toUpperCase();
        Location location = Location.valueOf(locationString);
        if (location == null)
        {
            System.out.println("Invalid location!");
            return;
        }
        Event newEvent = new Event(eventDate, timeslot, location);
        boolean result = calendar.remove(newEvent);
        if (result)
        {
            System.out.println("Event has been removed from the calendar!");
        }
        else
        {
            System.out.println("Cannot remove; event is not in the calendar!");
        }
    }

    /**
     Main method to parse user input for event information and
     to call helpers to validate, add, remove, and print events.
     */
    public void run()
    {
        System.out.println("Event Organizer running....");
        //Scanner scanner = new Scanner(System.in);
        EventCalendar calendar = new EventCalendar(); // Instantiate an EventCalendar
        boolean isRunning = true;
        while(new Scanner(System.in).hasNextLine() && isRunning)
        {
            String line = new Scanner(System.in).nextLine().trim(); // Read the entire line
            if(!line.isEmpty())
            {
                String[] commandAndArgs = line.split(" ", 2); // Split the line into command and arguments
                String command = commandAndArgs[0];
                String eventString = (commandAndArgs.length > 1) ? commandAndArgs[1] : "";
                switch(command)
                {
                    case "A":
                        //String [] eventParts = eventString.split("\\s+");
                        addHelper(eventString.split("\\s+"), calendar);
                        break;
                    case "R":
                        //String [] removeEventParts = eventString.split("\\s+");
                        removeHelper(eventString.split("\\s+"), calendar);
                        break;
                    case "P":
                        calendar.print();
                        break;
                    case "PE":
                        calendar.printByDate();
                        break;
                    case "PC":
                        calendar.printByCampus();
                        break;
                    case "PD":
                        calendar.printByDepartment();
                        break;
                    case "Q":
                        System.out.println("Event Organizer Terminated");
                        isRunning = false;
                        break;
                    default:
                        System.out.println(command + " is an invalid command!");
                        break;
                }
            }
        }
    }

    /**
     * Private helper method to make sure an event date is a
     * valid date, is a future date, and is not more than 6 months
     * in the future.
     * @param eventDate date to be validated
     * @return true is valid event date, else false
     */
    private boolean validEventDate(Date eventDate)
    {
        Date today = new Date();
        if (!eventDate.isValid())
        {
            System.out.println(eventDate.toString() + ": Invalid calendar date!");
            return false;
        }
        else if (eventDate.compareTo(today) > 0)
        {
            System.out.println(eventDate.toString() + " : Event date must be a future date!");
            return false;
        }
        else if (Math.abs(eventDate.compareTo(today)) > SIX_MONTHS_IN_DAYS)
        {
            System.out.println(eventDate.toString() + ": Event date must be within 6 months!");
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     Private helper method to get the timeslot enum constant that is represented
     by the passed in string.
     @param timeslotString string to find a timeslot enum constant for
     @return timeslot if string is a valid enum constant, else null
     */
    private Timeslot getTimeSlot(String timeslotString)
    {
        for (Timeslot slot : Timeslot.values())
        {
            if (slot.toString().equals(timeslotString))
            {
                return slot;
            }
        }
        return null;
    }

    /**
     Private helper method to get the location enum constant
     that is represented by the passed in string.
     @param locationString string to find a location enum constant for
     @return location enum constant, or null if string does not represent
     valid location
     */
    private Location getLocation(String locationString)
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

    /**
     Private helper method to get the department enum constant
     that is represented by the passed in string.
     @param deptString string to find a department enum constant for
     @return department enum constant, or null if string does not represent
     valid department
     */
    private Department getDepartment(String deptString)
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
