package p1;

public class EventCalendar
{
    private static final int NOT_FOUND = -1;
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array
    private int find(Event event) //search an event in the list
    {
        for (int i = 0; i < events.length; i++)
        {
            if (events[i].equals(event))
            {
                return i;
            }
        }
        return NOT_FOUND;
    }
    private void grow() //increase capacity of list by 4 whenever full
    {
        Event[] newArray = new Event[events.length+4];
        for (int i=0; i<events.length;i++)
        {
            newArray[i] = events[i];

        }
        events = newArray;
    }
    public boolean add(Event event)
    {
        if (events.length == 0)
        {
            grow();
        }

        return false; //placeholder
    }
    public boolean remove(Event event)
    {
        return false; //placeholder
    }
    public boolean contains(Event event)
    {
        return false; //placeholder
    }
    public void print() //print the array as is
    {

    }
    public void printByDate() //ordered by date and timeslot
    {

    }
    public void printByCampus() //ordered by campus and building/room
    {

    }
    public void printByDepartment() //ordered by department
    {

    }
}
