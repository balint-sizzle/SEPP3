package main.command;

import main.controller.Context;
import main.model.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class CancelEventCommand {

    private final long eventId;
    private final String organiserMessage;
    private Boolean successResult;

    public CancelEventCommand(long eventNumber, String organiserMessage) {
        eventId = eventNumber;
        this.organiserMessage = organiserMessage;
    }

    public void execute(Context context) {
        // get values of current user, event to cancel, and its performances
        User currentUser = context.getUserState().getCurrentUser();
        Event event = context.getEventState().findEventByNumber(eventId);
        Collection<EventPerformance> performances = event.getPerformances();

        // check if any performances have already started or ended
        LocalDateTime now = LocalDateTime.now();
        boolean performancesNotStarted = true;

        for (EventPerformance performance : performances) {
            if (performance.getStartDateTime().isAfter(now)) {
                performancesNotStarted = false;
            }
        }

        // check all conditions before cancelling event and refunding sponsorship amount
        if ((organiserMessage.length() != 0) && (currentUser instanceof EntertainmentProvider) &&
                (event.getStatus() == EventStatus.ACTIVE) &&
                (event.getOrganiser() == currentUser) && (performancesNotStarted)){
            event.cancel();

            // if event is ticketed, initiate refunds
            if (event instanceof TicketedEvent) {
                // get all tickets for event
                List<Booking> bookings = context.getBookingState().findBookingsByEventNumber(eventId);
                String providerEmail = currentUser.getPaymentAccountEmail();

                for (Booking booking : bookings) {
                    // cancel the booking, and get the email of the consumer in order to perform refund
                    booking.cancelByProvider();
                    String bookerEmail = booking.getBooker().getPaymentAccountEmail();
                    context.getPaymentSystem().processRefund(bookerEmail, providerEmail, booking.getAmountPaid());
                }
            }

            successResult = true;
        }

        else {
            successResult = false;
        }
    }

    public Boolean getResult() {
        return successResult;
    }

    
}
