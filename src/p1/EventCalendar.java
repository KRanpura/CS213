/**
 * EventCalendar.java defines the EventCalendar object with its attributes: an array of events,
 * and an int representing number of events. It additionally implements methods to add, remove, find,
 * and print events in the calendar.
 *  @author Kusum Gandham, Khushi Ranpura
 */

package p1;

public class EventCalendar
{
    private static final int NOT_FOUND = -1;
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    /**
     * Default constructor to create new instance of EventCalendar object,
     * with numEvents set to 0.
     */
    public EventCalendar()
    {
        this.numEvents = 0;
    }

    /**
     * Private method to find the index of an event in the events array,
     * returns index if event is found, -1.
     * @param event, event to be found
     * @return index of found event or -1
     */
    private int find(Event event)
    {
        for (int i = 0; i < this.events.length; i++)
        {
            if (this.events[i].equals(event))
            {
                return i;
            }
        }
        return NOT_FOUND;
    }


    /**
     * Private method to grow the size of the events array
     * when full.
     */
    private void grow()
    {
        Event[] newArray = new Event[this.events.length+4];
        for (int i = 0; i < this.events.length; i++)
        {
            newArray[i] = this.events[i];
        }
        this.events = newArray;
    }


    /**
     * Private method to add a new event to the events array.
     * @param event, event to be added.
     * @return true if successfully added, otherwise false
     */
    public boolean add(Event event)
    {
        if (this.events.length == 0) //array has initial capacity 0
        {
            grow();
        }
        for (int i = 0; i < this.events.length; i++)
        {
            if (this.events[i] == null)
            {
                this.events[i] = event;
                this.numEvents++;
                if (i == this.events.length - 1)
                {
                    grow();
                }
                return true;
            }
        }
        return false;
    }


    /**
     * Private method to remove an event from the events array,
     * and then shift all events up to preserve order.
     * @param event, event to be removed
     * @return true if event successfully removed, otherwise false.
     */
    public boolean remove(Event event)
    {
        int index = find(event);
        if (index == NOT_FOUND)
        {
            return false;
        }
        else
        {
            this.events[index] = null; //remove event
            this.numEvents--;
            for (int i = index; i < this.events.length; i++) //shift each event up 1 position
            {
                if (this.events[index+1] != null)
                {
                    Event temp = this.events[index+1].clone();
                    this.events[index] = temp;
                }
            }
            this.events[this.events.length-1] = null; //set last spot to null
            return true;
        }
    }


    /**
     * Private method to check if the events array contains an event.
     * @param event, event to check for.
     * @return true if found, otherwise false.
     */
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


    /**
     * Private method to print each event in the array as is.
     */
    public void print() //print the array as is
    {
        for (int i = 0; i < this.events.length; i++)
        {
            System.out.println(this.events[i].toString());
        }
    }
    public void printByDate() //ordered by date and timeslot
    {
        //implement in place sorting and then run print()

    }
    public void printByCampus() //ordered by campus and building/room
    {
        //implement in place sorting and then run print()
    }
    public void printByDepartment() //ordered by department
    {
        //implement in place sorting and then run print()
    }
}
