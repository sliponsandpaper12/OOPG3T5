package user;

import event.*;
import ticket.*;

public class Customer extends User{
    private Event[] upcomingEvents;
    private Event[] pastEvents;
    private double credits;
    private Ticket[] tickets;

    public Customer(String username, String password, String accountType, Event[] upcomingEvents, Event[] pastEvents, double credits, Ticket[] tickets) {
        super(username, password, accountType);
        this.upcomingEvents = upcomingEvents;
        this.pastEvents = pastEvents;
        this.credits = credits;
        this.tickets = tickets;
    }

    public void setUpcomingEvents(Event[] upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public Event[] getUpcomingEvents() {
        return this.upcomingEvents;
    }

    public void setPastEvents(Event[] pastEvents) {
        this.pastEvents = pastEvents;
    }

    public Event[] getPastEvents() {
        return this.pastEvents;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public double getCredits() {
        return this.credits;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public Ticket[] getTickets() {
        return this.tickets;
    }
}
