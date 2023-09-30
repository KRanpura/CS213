package p1;
import java.util.Scanner;
import java.util.StringTokenizer;
public class EventOrganizer
{
//(c) EventOrganizer class
//• This class is the user interface class to process the command lines. An instance of this class can process a
//        single command line or multiple command lines at a time. If it cannot process multiple command lines at
//    a time, you will lose 10 points.
//• Your software starts running by instantiating an object of this class. It shall display " Event Organizer
//    running....”. Next, it will read and process the command lines continuously until the “Q” command
//    is entered. Before the software stops running, display " Event Organizer terminated".
//        • You must define a public void run() method that includes a while loop to continuously read the
//    command lines from the console until a “Q” command is entered. You will lose 5 points if the run()
//    method is missing. You MUST keep this method under 40 lines for readability, or you will lose 3 points.
//    You can define necessary instance variables and private helper methods for handling the commands.

    private void addHelper(String [] eventParts, EventCalendar calendar) {
            String dateStr = eventParts[0];
            int month = Integer.parseInt(dateStr.split("/")[0]);
            int day = Integer.parseInt(dateStr.split("/")[1]);
            int year = Integer.parseInt(dateStr.split("/")[2]);
            Date eventDate = new Date(month, day, year);

            Timeslot timeslot = Timeslot.valueOf(eventParts[1].toUpperCase());

            Location location = Location.valueOf(eventParts[2].toUpperCase());
            //Department department = Department.valueOf(eventParts[3].toUpperCase());

            String contactString = eventParts[4];
            String[] contactSplit = contactString.split("@");
            Department depc = Department.valueOf(contactSplit[0].toUpperCase());
            Contact contact = new Contact(depc, contactString);

            int duration = Integer.parseInt(eventParts[5]);

            Event newEvent = new Event(eventDate, timeslot, location, contact, duration);
            boolean result = calendar.add(newEvent);
            if (result) {
                System.out.println("Event added to calender.");
            } else {
                System.out.println("Event is already on calender.");
            }
    }

    private void removeHelper(String [] eventPartsR, EventCalendar calendar)
    {
        String dateStr = eventPartsR[0];
        int month =Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date eventDate = new Date(month, day, year);

        String timeslotStr = eventPartsR[1].toUpperCase();
        Timeslot timeslot = Timeslot.valueOf(timeslotStr);

        String locationString = eventPartsR[2].toUpperCase();
        Location location = Location.valueOf(locationString);

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
                String command = commandAndArgs[0].toUpperCase();
                String eventString = (commandAndArgs.length > 1) ? commandAndArgs[1] : "";
                switch(command)
                {
                    case "A":
                        String [] eventParts = eventString.split(" ");
                        addHelper(eventParts, calendar);
                        break;
                        //R 12/22/2023 MORNING HLL114
                    case "R":
                        String [] eventPartsR = eventString.split(" ");
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
                        System.out.println(command + " is an invalid command");
                        break;
                }

            }
        }
    }
}
