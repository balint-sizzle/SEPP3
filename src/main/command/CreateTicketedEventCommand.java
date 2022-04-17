package main.command;

import main.controller.Context;
import main.model.EntertainmentProvider;
import main.model.EventType;
import main.model.TicketedEvent;
import main.state.EventState;
import main.state.SponsorshipState;
import main.state.UserState;

public class CreateTicketedEventCommand extends CreateEventCommand {

    private final int numTickets;
    private final double ticketPrice;
    private final boolean requestSponsorship;

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
