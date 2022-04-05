package main.command;

import main.model.*;
import main.state.EventState;
import main.state.IEventState;
import main.state.SponsorshipState;
import main.state.UserState;
import org.junit.Test;
import main.controller.Context;

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

    public void execute(Context context) {
        if (isUserAllowedToCreateEvent(context)) {
            EventState eventState = (EventState) context.getEventState();
            UserState userState = (UserState) context.getUserState();
            SponsorshipState sponsorshipState = (SponsorshipState) context.getSponsorshipState();

            TicketedEvent event = eventState.createTicketedEvent((EntertainmentProvider) userState.getCurrentUser(),
                    title, type, ticketPrice, numTickets);
            sponsorshipState.addSponsorshipRequest(event);
            eventIdResult = event.getEventNumber();
        }

    }
  
}
