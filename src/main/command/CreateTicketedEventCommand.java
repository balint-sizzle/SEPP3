package main.command;

import org.junit.Test;
import main.controller.Context;
import main.model.EventType;
import main.model.TicketedEvent;

import static org.junit.Assert.assertTrue;

public class CreateTicketedEventCommand extends CreateEventCommand {

    private int numTickets;
    private double ticketPrice;
    private boolean requestSponsorship;

    public CreateTicketedEventCommand(String title, EventType type,
                                      int numTickets, double ticketPrice,
                                      boolean requestSponsorship) {
        super(title,type);
        this.numTickets = numTickets;
        this.ticketPrice = ticketPrice;
        this.requestSponsorship = requestSponsorship;
    }

    @Test
    public void execute(Context context) {
        assertTrue(isUserAllowedToCreateEvent(context));
    }
    
}
