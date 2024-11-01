package model;

import java.util.Calendar;
import java.util.Date;

// represents a game system event
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;

    // creates on event with the given description and the current date/time stamp
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }

    // EFFECTS: gets the date of this event
    public Date getDate() {
        return dateLogged;
    }

    // EFFECTS: gets the description of the event
    public String getDescription() {
        return description;
    }

    // MODIFIES: this
    // EFFECTS: return true if two objects are the same
    @Override
	public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other.getClass() != this.getClass()) {
            return false;
        }


        Event otherEvent = (Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged)
                && this.description.equals(otherEvent.description));
    }

    // EFFECTS: return the hashcode
    @Override
	public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    // EFFECTS: change to string
    @Override
	public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}
