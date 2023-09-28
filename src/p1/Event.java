/**
 Event.java defines the Event object with its attributes: date, startTime, location,
 contact, and duration of event. It additionally implements methods to access these
 attributes, print out an event, and compare events to each other.
 @author Khushi Ranpura
 */
package p1;
public class Event implements Comparable<Event>
{
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes

    private static final int MIN_PER_HOUR = 60;

    /**
     Event constructor that creates a new Event object when parameters are passed in.
     @param date date of the event booking
     @param startTime start time of the event booking
     @param location location of event
     @param contact contact information of department hosting event / room booking
     @param duration duration in minutes of how long a location is booked for
     */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration)
    {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration; //in minutes
    }

    /**
     Overloaded Event constructor that creates a new Event object when parameters are passed in.
     @param date date of the event booking
     @param startTime start time of the event booking
     @param location location of event
     */
    public Event(Date date, Timeslot startTime, Location location)
    {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
    }

    /**
     Getter method that returns the date attribute of the
     Event object it is called on.
     * @return date
     */
    public Date getDate() {return this.date;}

    /**
     Getter method that returns the location attribute of the
     Event object it is called on.
     * @return location
     */
    public Location getLocation()
    {
        return this.location;
    }

    /**
     Getter method that returns the startTime or Timeslot attribute
     of the Event object it is called on.
     * @return startTime
     */
    public Timeslot getStartTime() {return this.startTime;}

    /**
     Getter method that returns the contact attribute of the
     Event object it is called on.
     * @return contact
     */
    public Contact getContact() {return this.contact;}

    /**
     Getter method that returns the duration attribute of the
     Event object it is called on.
     * @return duration
     */
    public int getDuration() {return this.duration;}

    /**
     Setter method that changes the date attribute of the
     Event object it is called on to the passed in date parameter.
     * @param date new date
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     Setter method that changes the location attribute of the
     Event object it is called on to the passed in location parameter.
     * @param location new location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }

    /**
     Setter method that changes the startTime attribute of the
     Event object it is called on to the passed in parameter.
     * @param startTime new startTime
     */
    public void setStartTime(Timeslot startTime)
    {
        this.startTime = startTime;
    }

    /**
     Setter method that changes the contact attribute of the
     Event object it is called on to the passed in contact parameter.
     * @param contact new contact
     */
    public void setContact(Contact contact)
    {
        this.contact = contact;
    }

    /**
     Setter method that changes the duration attribute of the
     Event object it is called on to the passed in parameter.
     * @param duration new duration
     */
    public void setDuration(int duration)
    {
        this.duration = duration;
    }


    /**
     Checks if two events are equal, meaning they are on the same date, at the
     same time, at the same location.
     @param object the object to compare the Event to.
     @return true if the events are equal, else false if they are unequal or
     if the object is not an Event object.
     */
    @Override
    public boolean equals(Object object)
    {
        if (object instanceof Event)
        {
            Event otherEvent = (Event) object;
            if (this.compareTo(otherEvent) == 0)
            {
                return(this.getLocation().equals(otherEvent.getLocation()));
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     Compares two events based on dates first, and then startTime if
     the dates are the same.
     @param otherEvent the Event object to compare the initial Event to.
     @return 0 if the events are equal, otherwise -1 if they are not equal
     */
    @Override
    public int compareTo(Event otherEvent)
    {
        if (this.getDate().compareTo(otherEvent.getDate()) != 0)
        {
            return -1;
        }
        else
        {
            if (this.getStartTime() == otherEvent.getStartTime())
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
    }

    /**
     Prints an event, including the date, start and end time, location,
     department, contact, etc.
     @return a string of the event information to print.
     */
    @Override
    public String toString()
    {
        return "[Event Date:" + this.getDate().getMonth() + "/" + this.getDate().getDay() + "/" +
                this.getDate().getYear() + "] [Start: " + this.getStartTime().getTimeSlotString() + "] [End: " +
                this.getEndTimeString() + " ] @" + this.getLocation() + " (" +
                this.getLocation().getBuildingName() + ", " + this.getLocation().getCampusName() +
                ") [Contact: " + this.getContact().getDepartment() + ", " + this.getContact().getEmail() + "]";
    }

    /**
     Helper method that calculates the end time of the event by adding
     the duration in minutes to the startTime of the event.
     @return a string, the properly formatted end time of the event
     */
    private String getEndTimeString()
    {
        int totalMinutes = this.getStartTime().getHour() * MIN_PER_HOUR + this.getStartTime().getMinute();
        totalMinutes+= this.duration;

        int newHours = totalMinutes / MIN_PER_HOUR;
        int newMinutes = totalMinutes % MIN_PER_HOUR;

        if (newHours > 12)
        {
            return (newHours - 12) + ":" + newMinutes + "pm";
        }
        else
        {
            return (newHours + ":" + newMinutes + "am");
        }
    }
}

