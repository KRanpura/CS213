package p1;

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
        System.out.println("Even Organizer running....");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine())
        {

        }
    }
}
