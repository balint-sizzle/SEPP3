package main.command;

import main.controller.Context;
import main.model.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class CancelBookingCommand implements ICommand {
    private final long bookingNumber;
    private boolean successResult;
    public CancelBookingCommand(long bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public void execute(Context context) {
        boolean validBookingNumber = false;
        boolean bookingIDContained = false;
        List<Booking> bookingList = null;
        Booking theBooking = null;
        User user = context.getUserState().getCurrentUser();

        if (user instanceof Consumer) {
            Consumer consumer = (Consumer) user;
            bookingList = consumer.getBookings();
        }

        for (Booking booking : bookingList) {
            if (booking.getBookingNumber() == bookingNumber) {
                validBookingNumber = true;
                theBooking = booking;
                break;
            }
        }

        boolean isValid = user instanceof Consumer &&
                validBookingNumber &&
                theBooking.getStatus() == BookingStatus.Active &&
                Duration.between(LocalDateTime.now(),
                        theBooking.getEventPerformance().getStartDateTime()).toHours() > 24 &&
                context.getPaymentSystem().processPayment(user.getEmail(),
                        theBooking.getEventPerformance().getEvent().getOrganiser().getEmail(),
                        theBooking.getAmountPaid());

        if (isValid) {
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
