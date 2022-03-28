package main.state;

import main.model.Booking;

import java.util.List;
import java.util.function.Consumer;

public class BookingState extends Object implements IBookingState{

    @Override
    public Booking createBooking(Consumer booker, Object o, int numTickets, double amountPaid) {
        return null;
    }

    @Override
    public Booking findBookingByNumber(long bookingNumber) {
        return null;
    }

    @Override
    public List<Booking> findBookingsByEventNumber(long eventNumber) {
        return null;
    }
}