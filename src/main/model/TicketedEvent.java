package main.model;

public class TicketedEvent extends Event {

    private double ticketPrice;
    private int numTickets;
    private SponsorshipRequest sponsorshipRequest;

    public TicketedEvent(long eventNumber,
                         EntertainmentProvider organiser,
                         String title,
                         EventType type,
                         double ticketPrice,
                         int numTickets) {
        super(eventNumber, organiser, title, type);
        this.ticketPrice = ticketPrice;
        this.numTickets = numTickets;
    }

    public double getOriginalTicketPrice() {
        return ticketPrice;
    }

    public double getDiscountedTicketPrice() {
        if (isSponsored()) {
            // not clear how discounts work
            return 0;
        }
        else {
            return ticketPrice;
        }
    }

    public int getNumTickets() {
        return numTickets;
    }

    public String getSponsorAccountEmail() {
        if (isSponsored()) {
            return sponsorshipRequest.getSponsorAccountEmail();
        }
        else {
            return null;
        }
    }

    public boolean isSponsored() {
        return (sponsorshipRequest != null);
    }

    public void setSponsorshipRequest(SponsorshipRequest sponsorshipRequest) {
        this.sponsorshipRequest = sponsorshipRequest;
    }
    
}
