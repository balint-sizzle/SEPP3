package main.command;

import main.controller.Context;
import main.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class GovernmentReport1Command implements ICommand{
    private final LocalDateTime intervalStartInclusive;
    private final LocalDateTime intervalEndInclusive;
    private List<Booking> bookingListResult;

    public GovernmentReport1Command(LocalDateTime intervalStartInclusive, LocalDateTime intervalEndInclusive) {
        this.intervalStartInclusive = intervalStartInclusive;
        this.intervalEndInclusive = intervalEndInclusive;
    }

    public void execute(Context context) {
        List<Event> allEvents = context.getEventState().getAllEvents();
        for (Event event : allEvents) {
            boolean isSponsored = ((TicketedEvent) event).isSponsored();
            if (isSponsored && (event.getStatus() == EventStatus.ACTIVE)) {
                List<Booking> eventBookings = context.getBookingState().findBookingsByEventNumber(event.getEventNumber());
                for (Booking booking : eventBookings) {
                    EventPerformance performance = booking.getEventPerformance();
                    boolean timeInclusive = (performance.getStartDateTime().isBefore(intervalStartInclusive) &&
                                             performance.getEndDateTime().isAfter(intervalEndInclusive)) ||

                                            (performance.getStartDateTime().isBefore(intervalStartInclusive) &&
                                             performance.getEndDateTime().isAfter(intervalStartInclusive) &&
                                             performance.getEndDateTime().isBefore(intervalEndInclusive)) ||

                                            (performance.getStartDateTime().isAfter(intervalStartInclusive) &&
                                             performance.getStartDateTime().isBefore(intervalEndInclusive) &&
                                             performance.getEndDateTime().isBefore(intervalEndInclusive)) ||

                                            (performance.getStartDateTime().isAfter(intervalStartInclusive) &&
                                             performance.getEndDateTime().isBefore(intervalEndInclusive));

                    if (timeInclusive) {
                        bookingListResult.add(booking);
                    }
                }
            }
        }
    }

    public List<Booking> getResult() {
        return bookingListResult;
    }
}
