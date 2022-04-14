package main.command;

import main.controller.Context;
import main.model.Booking;
import main.model.Consumer;
import main.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListConsumerBookingsCommand implements ICommand {

    private List<Booking> bookingListResult;

    public void execute(Context context) {
        // get current user
        User currentUser = context.getUserState().getCurrentUser();

        // verify logged in user is consumer
        if (currentUser != null && currentUser instanceof Consumer) {
            // set result to consumer's bookings
            bookingListResult = ((Consumer) currentUser).getBookings();
        }
    }

    public List<Booking> getResult() {
        return bookingListResult;
    }
    
}
