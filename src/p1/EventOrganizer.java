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
    public void run()
    {
        System.out.println("Event Organizer running....");
        Scanner scanner = new Scanner(System.in);
        EventCalendar calendar = new EventCalendar(); // Instantiate an EventCalendar

        //need to create new event and call Event Calendar with date, starttime, location, contact duration
        // A 2/29/2024 afternoon HLL114 CS cs@rutgers.edu 60
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine().trim(); // Read the entire line

            if(line.length() >= 1)
            {
                String[] commandAndArgs = line.split(" ", 2); // Split the line into command and arguments
                String command = commandAndArgs[0].toUpperCase();
                String eventString = (commandAndArgs.length > 1) ? commandAndArgs[1] : "";

                switch(command)
                {
                    case "A":
                        String [] eventParts = eventString.split(" ");
                        if (eventParts.length == 6 )
                        {
                            String dateStr = eventParts[0];
                            int month =Integer.parseInt(dateStr.split("/")[0]);
                            int day = Integer.parseInt(dateStr.split("/")[1]);
                            int year = Integer.parseInt(dateStr.split("/")[2]);
                            Date eventDate = new Date(month, day, year);

                            String timeslotStr = eventParts[1].toUpperCase();

                                Timeslot timeslot = Timeslot.valueOf(timeslotStr);




                            String locationString = eventParts[2].toUpperCase();
                            Location location = Location.valueOf(locationString);

                            String departmentString = eventParts[3].toUpperCase();
                            Department department = Department.valueOf(departmentString);

                            String contactString = eventParts[4];
                            String[] contactSplit = contactString.split("@");
                            Department depc = Department.valueOf(contactSplit[0].toUpperCase());
                            Contact contact = new Contact(depc, contactString);


                            String durationString = eventParts[5];
                            int duration = Integer.parseInt(durationString);

                            Event newEvent = new Event(eventDate, timeslot, location, contact, duration);
                            calendar.add(newEvent);

                            break;
                        }
                        //R 12/22/2023 MORNING HLL114
                    case "R":
                        String [] eventPartsR = eventString.split(" ");
                        if (eventPartsR.length == 3)
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
                            calendar.remove(newEvent);
                            break;
                        }
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
                        break;
                }

            }
        }
    }
}
