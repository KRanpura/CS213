package p1;

public class Event implements Comparable<Event>
{
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes

    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration)
    {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Event)
        {
            Event event = (Event) obj;
            if (this.date.compareTo(event.date) && this.timeslot.compareTo(event.timeslot) &&
                    this.location == event.location)
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public int compareTo(Event event)
    {

    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}


//    Define necessary constants, constructors and methods. However, you CANNOT change or add instance
//        variables. -2 points for each violation.
//        • Must override equals() and toString() methods, and implement the compareTo() methods to compare
//        the event date and timeslot. You must add the @Override tags. -2 points for each violation.
//        • The toString() method returns a textual representation of an event in the following format.
//        [p1.Event p1.Date: 10/21/2023] [Start: 2:00pm] [End: 3:00pm] @HLL114 (Hill Center, Busch) [Contact: Computer Science, cs@rutgers.edu]
//        • The equals() method returns true if two dates, timeslots and locations are equal.
//        • The compareTo() method compares the dates first, then the timeslots if the dates are the same.