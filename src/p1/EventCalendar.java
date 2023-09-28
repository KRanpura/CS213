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
        for (int i = 0; i < events.length; i++)
        {
            newArray[i] = events[i];

        }
        events = newArray;
    }
    public boolean add(Event event)
    {
        if (events.length == 0) //array has initial capacity 0
        {
            grow();
        }
        for (int i = 0; i < events.length; i++)
        {
            if (events[i] == null)
            {
                events[i] = event;
                if (i == events.length - 1)
                {
                    grow();
                }
                return true;
            }
        }
        return false;
    }

    public boolean remove(Event event)
    {
        for (int i = 0; i < events.length; i++)
        {
            if (events[i].equals(event))
            {
                events[i] = null;
                return true; //successfully found and removed
            }
        }
        return false; //event does not exist / cannot be removed
    }

    public boolean contains(Event event)
    {
        if (find(event) != NOT_FOUND)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void print() //print the array as is
    {
        for (int i = 0; i < events.length; i++)
        {
            events[i].toString();
        }
    }
    public void printByDate() //ordered by date and timeslot
    {
        //implement in place sorting and then run print()

    }
    public void printByCampus() //ordered by campus and building/room
    {

    }
    public void printByDepartment() //ordered by department
    {

    }
}
