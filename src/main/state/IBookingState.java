package main.state;

import main.model.Booking;

import java.util.List;
import java.util.function.Consumer;

public interface IBookingState<EventPerformance> {
    Booking createBooking(Consumer booker, EventPerformance performance, int numTickets, double amountPaid);
    Booking findBookingByNumber(long bookingNumber);
    List<Booking> findBookingsByEventNumber(long eventNumber);
}
