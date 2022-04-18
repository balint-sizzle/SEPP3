package main.state;

import main.model.Booking;
import main.model.Consumer;
import main.model.EventPerformance;

import java.time.LocalDateTime;
import java.util.List;

public class BookingState implements IBookingState {
    private List<Booking> bookings;
    private long nextBookingNumber;

    public BookingState() {
        this.nextBookingNumber = 0;
    }
    public BookingState(IBookingState other) {
        BookingState otherState = (BookingState) other;
        this.bookings = otherState.bookings;
        this.nextBookingNumber = otherState.nextBookingNumber;
    }

    public Booking findBookingByNumber(long bookingNumber) {
        for (Booking booking : bookings) {
            if (booking.getBookingNumber() == bookingNumber) {
                return booking;
            }
        }
        return null;
    }

    public List<Booking> findBookingsByEventNumber(long eventNumber) {
        System.out.println(bookings);
        List<Booking> eventBookings = null;
        if (!(bookings==null || bookings.isEmpty())) {
            for (Booking booking : bookings) {
                if (booking.getEventPerformance().getEvent().getEventNumber() == eventNumber) {
                    eventBookings.add(booking);
                }
            }
        }
        return eventBookings;
    }

    public Booking createBooking(Consumer booker, EventPerformance performance, int numTickets, double amountPaid) {
        Booking booking = new Booking(nextBookingNumber, booker, performance, numTickets, amountPaid, LocalDateTime.now());
        bookings.add(booking);
        nextBookingNumber++;
        System.out.println(nextBookingNumber);
        return booking;
    }
}

