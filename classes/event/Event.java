package event;

public class Event {
    private String name;
    private String venue;
    private String dateTime;
    private double ticketPrice;
    private int numAvailableTickets;
    private double cancellationFee;
    private String status;
    private boolean visible;

    public Event(String name, String venue, String dateTime, double ticketPrice, int numAvailableTickets, double cancellationFee, String status, boolean visible) {
        this.name = name;
        this.venue = venue;
        this.dateTime = dateTime;
        this.ticketPrice = ticketPrice;
        this.numAvailableTickets = numAvailableTickets;
        this.cancellationFee = cancellationFee;
        this.status = status;
        this.visible = visible;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getVenue() {
        return this.venue;
    }

    public void setDateTime(String datetime) {
        this.dateTime = datetime;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public void setNumAvailableTickets(int numAvailableTickets) {
        this.numAvailableTickets = numAvailableTickets;
    }

    public int getNumAvailableTickets() {
        return this.numAvailableTickets;
    }

    public void setCancellationFee(double cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public double getCancellationFee() {
        return this.cancellationFee;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getVisible() {
        return this.visible;
    }
}
