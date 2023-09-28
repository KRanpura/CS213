/**
 Timeslot.java defines an enum class called Timeslot, which represents
 different event booking times to the hour and minute along with methods
 and constructors to change or access those times.
 @author Khushi Ranpura
 */
package p1;

import javax.lang.model.type.NullType;

public enum Timeslot
{
    MORNING(10, 30), //10:30 am
    AFTERNOON(14, 00), //2:00 pm
    EVENING(18,30), //6:30 pm
    NULL(0,0); //return this if none of the above constants

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

    public Timeslot checkTimeSlot(String timeslot)
    {
        for (Timeslot slot : Timeslot.values())
        {
            if (slot.toString().equals(timeslot))
            {
                return slot;
            }
        }
        return NULL;
    }

    public String getTimeSlotString()
    {
        if (this.hour > NOON)
        {
            return ((this.hour - NOON) + ":" + this.minute + "pm");
        }
        else
        {
            return (this.hour + ":" + this.minute + "am");
        }
    }

}
