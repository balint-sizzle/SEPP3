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
        List<Booking> bookingList = null;
        User user = context.getUserState().getCurrentUser();

        if (user instanceof Consumer) {
            Consumer consumer = (Consumer) user;
            bookingList = consumer.getBookings();
        }

        if (!(bookingList == null || bookingList.isEmpty())){
          for (Booking booking : bookingList) {
              if (booking.getBookingNumber() == this.bookingNumber) {
                  this.successResult = (booking.getStatus() == BookingStatus.Active &&
                  Duration.between(LocalDateTime.now(), booking.getEventPerformance().getStartDateTime()).toHours() > 24 && // not exactly sure this is correct
                  context.getPaymentSystem().processPayment(user.getEmail(),
                  booking.getEventPerformance().getEvent().getOrganiser().getEmail(),
                  booking.getAmountPaid()));
                  break;
              }
          }
        }
    }

    public Boolean getResult() {
        return this.successResult;
    }
}
