package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// represents a log of game system events using Singleton Design Pattern
public class EventLog implements Iterable<Event> {
	/** the only EventLog in the system (Singleton Design Pattern) */
    private static EventLog theLog;
    private Collection<Event> events;

    // prevent external construction
    private EventLog() {
        events = new ArrayList<Event>();
    }

    // EFFECTS: get instance of EventLog creates it if it doesn't already exist
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    // EFFECTS: add an event to the event log
    public void logEvent(Event e) {
        events.add(e);
    }

    // EFFECTS: clears the event log and logs the event
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    // EFFECTS: return Iterator<Event>
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
