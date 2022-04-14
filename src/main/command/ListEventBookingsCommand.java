package main.command;


import main.controller.Context;
import main.model.*;

import java.util.List;

public class ListEventBookingsCommand extends Object implements ICommand{

    private long eventNumber;
    private List<Booking> bookingListResult;

    public ListEventBookingsCommand(long eventNumber) {
        this.eventNumber = eventNumber;
    }

    public void execute(Context context) {
        // get logged in user and chosen event
        User currentUser = context.getUserState().getCurrentUser();
        Event event = context.getEventState().findEventByNumber(eventNumber);

        // verify user is logged in and event is ticketed
        if (currentUser != null && event instanceof TicketedEvent &&
                // verify user is either government representative or event organiser
                (currentUser instanceof GovernmentRepresentative || currentUser == event.getOrganiser())) {
            bookingListResult = context.getBookingState().findBookingsByEventNumber(eventNumber);
        }
    }

    public List<Booking> getResult() {
        return bookingListResult;
    }

}
