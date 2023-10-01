/**
 Timeslot.java defines an enum class called Timeslot, which represents
 different event booking times to the hour and minute along with methods
 and constructors to change or access those times.
 @author Khushi Ranpura
 */
package p1;
public enum Timeslot
{
    MORNING(10, 30), //10:30 am
    AFTERNOON(14, 00), //2:00 pm
    EVENING(18,30); //6:30 pm
    private int hour;
    private int minute;

    private static final int NOON = 12;

    /**
     Constructor for the Timeslot enum class that initializes the
     hour and minute of each timeslot to the passed in parameters. .
     @param hour exact hour of timeslot
     @param minute exact minute of timeslot
     */
    private Timeslot(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
    }

    /**
     Getter method that returns the hour of the
     Timeslot constant it is called on.
     @return hour
     */
    public int getHour()
    {
        return this.hour;
    }

    /**
     Getter method that returns the minute of the
     Timeslot constant it is called on.
     @return minute
     */
    public int getMinute()
    {
        return this.minute;
    }

    /**
     * String method that returns a Timeslot formatted as a string.
     * @return String timeslot
     */
    public String getTimeSlotString()
    {
        if (this.equals(Timeslot.MORNING))
        {
            return ("10:30am");
        }
        else if (this.equals(Timeslot.AFTERNOON))
        {
            return ("2:00pm");
        }
        else if (this.equals(Timeslot.EVENING))
        {
            return ("6:30pm");
        }
        else
        {
            return null;
        }
    }



}
