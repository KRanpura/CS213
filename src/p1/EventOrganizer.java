package p1;
import java.util.Scanner;
import java.util.StringTokenizer;
public class EventOrganizer
{
    private static final int SIX_MONTHS_IN_DAYS = 182;
    private void addHelper(String [] eventParts, EventCalendar calendar)
    {
           // boolean makeEvent = true;
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
                System.out.println("Invalid timeslot!");
                return;
            }
            //Timeslot timeslot = Timeslot.valueOf(eventParts[1].toUpperCase());

            Location location = getLocation(eventParts[2].toUpperCase());
            if (location == null)
            {
                System.out.println("Invalid location!");
                return;
            }
            //Location location = Location.valueOf(eventParts[2].toUpperCase());
            //Department department = Department.valueOf(eventParts[3].toUpperCase());

            String contactString = eventParts[4];
            String[] contactSplit = contactString.split("@");

            Department depc = getDepartment(contactSplit[0].toUpperCase());
           // Department depc = Department.valueOf(contactSplit[0].toUpperCase());

            if (depc == null)
            {
                System.out.println("Invalid contact information!");
                return;
            }
            Contact contact = new Contact(depc, contactString);
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
            boolean result = calendar.add(newEvent);
            if (result)
            {
                System.out.println("Event added to calender.");
            }
            else
            {
                System.out.println("The event is already on the calender.");
            }
    }

    private void removeHelper(String [] eventPartsR, EventCalendar calendar)
    {
        String dateStr = eventPartsR[0];
        int month =Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date eventDate = new Date(month, day, year);
        if (!validEventDate(eventDate))
        {
            return;
        }

        String timeslotStr = eventPartsR[1].toUpperCase();
        Timeslot timeslot = getTimeSlot(timeslotStr);
        if (timeslot == null)
        {
            System.out.println("Invalid timeslot!");
            return;
        }
        //Timeslot timeslot = Timeslot.valueOf(timeslotStr);

        String locationString = eventPartsR[2].toUpperCase();
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
    public void run()
    {
        System.out.println("Event Organizer running....");
        Scanner scanner = new Scanner(System.in);
        EventCalendar calendar = new EventCalendar(); // Instantiate an EventCalendar
        boolean isRunning = true;
        // A 2/29/2024 afternoon HLL114 CS cs@rutgers.edu 60
        while(scanner.hasNextLine() && isRunning)
        {
            String line = scanner.nextLine().trim(); // Read the entire line

            if(!line.isEmpty())
            {
                String[] commandAndArgs = line.split(" ", 2); // Split the line into command and arguments
                String command = commandAndArgs[0];
                String eventString = (commandAndArgs.length > 1) ? commandAndArgs[1] : "";
                switch(command)
                {
                    case "A":
                        String [] eventParts = eventString.split("\\s+");
                        addHelper(eventParts, calendar);
                        break;
                        //R 12/22/2023 MORNING HLL114
                    case "R":
                        String [] eventPartsR = eventString.split("\\s+");
                        removeHelper(eventPartsR, calendar);
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
            System.out.println(eventDate.toString() + " " + eventDate.compareTo(today) + " : Event date must be a future date!");
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
