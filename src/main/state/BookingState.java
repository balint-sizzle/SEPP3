package main.state;

import main.model.Booking;
import main.model.Consumer;
import main.model.EventPerformance;

import java.util.List;

public class BookingState implements IBookingState {
    BookingState(){

    }
    BookingState(IBookingState other){

    }

    @Override
    public Booking findBookingByNumber(long bookingNumber) {
        Booking Booking = null;
        return Booking;
    }

    @Override
    public List<Booking> findBookingsByEventNumber(long eventNumber) {
        return null;
    }

    @Override
    public Booking createBooking(Consumer booker, EventPerformance performance, int numTickets, double amountPaid) {
        return null;
    }
}

