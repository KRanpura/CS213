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
        this.events = new Event[0];
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
            if (this.events[i] != null)
            {
                if (this.events[i].equals(event))
                {
                    return i;
                }
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
        if (!contains(event)) {
            if (this.events.length == 0) //array has initial capacity 0
            {
                grow();
            }
            for (int i = 0; i < this.events.length; i++) {
                if (this.events[i] == null) {
                    this.events[i] = event;
                    this.numEvents++;
                    if (i == this.events.length - 1) {
                        grow();
                    }
                    return true;
                }
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
            this.events[index] = null; // Remove event
            this.numEvents--;

            // Shift events to fill the gap
            for (int i = index; i < this.events.length - 1; i++) {
                this.events[i] = this.events[i + 1];
            }
            // Set the last spot to null
            this.events[this.events.length - 1] = null;

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
        if (this.events.length == 0)
        {
            System.out.println("Event calendar is empty!");
            return;
        }
        System.out.println("\n* Event calendar *");
        for (int i = 0; i < this.events.length; i++)
        {
            if (this.events[i] != null) {
                System.out.println(this.events[i].toString());
            }
        }
        System.out.println("* end of event calendar *");
    }

    /**
     * Private method to print each event in the array
     * in order of date.
     */
    public void printByDate() //ordered by date and timeslot
    {
        if (this.events.length == 0)
        {
            System.out.println("Event calendar is empty!");
            return;
        }
        Event[] nonNullEvents = new Event[numEvents];
        int nonNullCount = 0;
        for (int i = 0; i < events.length; i++) {
            if (events[i] != null) {
                nonNullEvents[nonNullCount++] = events[i];
            }
        }
        for (int i = 0; i < nonNullCount - 1; i++) {
            for (int j = 0; j < nonNullCount - i - 1; j++) {
                if (nonNullEvents[j].compareTo(nonNullEvents[j + 1]) < 0) {
                    Event temp = nonNullEvents[j];
                    nonNullEvents[j] = nonNullEvents[j + 1];
                    nonNullEvents[j + 1] = temp;
                }
            }
        }

        System.out.println("\n* Event calendar by event date and start time *");
        for (int i = 0; i < nonNullCount; i++) {
            System.out.println(nonNullEvents[i].toString());
        }
        System.out.println("* end of event calendar *");
    }

    /**
     * Private method to print each event in the array
     * grouped by campus.
     */
    public void printByCampus() //ordered by campus and building/room
    {
        if (this.events.length == 0)
        {
            System.out.println("Event calendar is empty!");
            return;
        }
        Event[] nonNullEvents = new Event[numEvents];
        int nonNullCount = 0;
        for (int i = 0; i < events.length; i++) {
            if (events[i] != null) {
                nonNullEvents[nonNullCount++] = events[i];
            }
        }
        for (int i = 0; i < nonNullCount - 1; i++) {
            for (int j = 0; j < nonNullCount - i - 1; j++) {
                String campus1 = nonNullEvents[j].getLocation().getCampusName().toLowerCase();
                String campus2 = nonNullEvents[j + 1].getLocation().getCampusName().toLowerCase();
                if (campus1.equals(campus2)) {
                    String building1 = nonNullEvents[j].getLocation().getBuildingName().toLowerCase();
                    String building2 = nonNullEvents[j + 1].getLocation().getBuildingName().toLowerCase();

                    if (building1.compareTo(building2) > 0) {
                        Event temp = nonNullEvents[j];
                        nonNullEvents[j] = nonNullEvents[j + 1];
                        nonNullEvents[j + 1] = temp;
                    }
                } else if (campus1.compareTo(campus2) > 0) {
                    Event temp = nonNullEvents[j];
                    nonNullEvents[j] = nonNullEvents[j + 1];
                    nonNullEvents[j + 1] = temp;
                }
            }
        }
        System.out.println("\n* Event calendar by campus and building *");
        for (int i = 0; i < nonNullCount; i++)
        {
            System.out.println(nonNullEvents[i].toString());
        }
        System.out.println("* end of event calendar *");
    }

    /**
     * Private method to print each event in the array
     * grouped by department.
     */
    public void printByDepartment() //ordered by department
    {
        if (this.events.length == 0)
        {
            System.out.println("Event calendar is empty!");
            return;
        }
        Event[] nonNullEvents = new Event[numEvents];
        int nonNullCount = 0;
        for (Event event : events) {
            if (event != null) {
                nonNullEvents[nonNullCount++] = event;
            }
        }
        for (int i = 0; i < nonNullCount - 1; i++) {
            for (int j = 0; j < nonNullCount - i - 1; j++) {
                String department1 = nonNullEvents[j].getContact().getDepartment().getDepartmentName().toLowerCase();
                String department2 = nonNullEvents[j + 1].getContact().getDepartment().getDepartmentName().toLowerCase();
                if (department1.compareTo(department2) > 0) {
                    Event temp = nonNullEvents[j];
                    nonNullEvents[j] = nonNullEvents[j + 1];
                    nonNullEvents[j + 1] = temp;
                }
            }
        }
        System.out.println("\n* Event calendar by department *");
        for (int i = 0; i < nonNullCount; i++) {
            System.out.println(nonNullEvents[i].toString());
        }
        System.out.println("* end of event calendar *");
    }
}
