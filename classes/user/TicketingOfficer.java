package user;

import event.*;

public class TicketingOfficer extends User{
    private String[] venue;
    private Event[] events;

    public TicketingOfficer(String username, String password, String accountType, String[] venue, Event[] events) {
        super(username, password, accountType);
        this.venue = venue;
        this.events = events;
    }

    public void setVenue(String[] venue) {
        this.venue = venue;
    }

    public String[] getVenue() {
        return this.venue;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Event[] getEvents() {
        return this.events;
    }
}