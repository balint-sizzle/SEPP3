package main.command;

import main.command.ICommand;
import main.controller.Context;
import main.external.MockEntertainmentProviderSystem;
import main.external.MockPaymentSystem;
import main.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class BookEventCommand implements ICommand {
    //    BookEventCommand allows Consumers to book tickets for a specific EventPerformance.
//    The command applies for the currently logged-in user.
    long eventNumber;
    Booking booking;
    long performanceNumber;
    int numTicketsRequested;

    public BookEventCommand(long eventNumber, long performanceNumber, int numTicketsRequested) {
        this.eventNumber = eventNumber;
        this.performanceNumber = performanceNumber;
        this.numTicketsRequested = numTicketsRequested;
    }

    @Override
    public void execute(Context context) {
//currently logged-in user is a Consumer
//event number corresponds to an existing event
        if (context.getUserState().getCurrentUser() instanceof Consumer) {
            List<Event> events = context.getEventState().getAllEvents();
            if (!(events == null || events.isEmpty())) {
                for (Event event : events) {
                    if (this.eventNumber == event.getEventNumber() &&
                        event instanceof TicketedEvent &&
                        this.numTicketsRequested > 0 &&
                        event.getPerformanceByNumber(this.performanceNumber) != null){
                        if (LocalDateTime.now().isBefore(event.getPerformanceByNumber(this.performanceNumber).getEndDateTime()) &&
                                MockEntertainmentProviderSystem.getNumTicketsLeft(this.eventNumber, this.performanceNumber) >= this.numTicketsRequested &&
                                context.getPaymentSystem().processPayment(context.getUserState().getCurrentUser().getEmail(), event.getOrganiser().getOrgAddress(), this.numTicketsRequested*((TicketedEvent) event).getDiscountedTicketPrice())){
                            this.booking = context.getBookingState().createBooking(((Consumer) context.getUserState().getCurrentUser()), event.getPerformanceByNumber(this.performanceNumber), this.numTicketsRequested, this.numTicketsRequested*((TicketedEvent) event).getDiscountedTicketPrice());
                        }
                    }
                }
            }
        }
    }

    public Long getResult() {
        return this.booking.getBookingNumber();
    }
}