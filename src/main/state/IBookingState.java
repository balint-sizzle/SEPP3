package main.state;

import main.model.Booking;
import main.model.Consumer;
import main.model.EventPerformance;

import java.util.List;

public interface IBookingState {
    Booking findBookingByNumber(long bookingNumber);
    List<Booking> findBookingsByEventNumber(long eventNumber);
    Booking createBooking(Consumer booker,
                          EventPerformance performance,
                          int numTickets,
                          double amountPaid);


}
