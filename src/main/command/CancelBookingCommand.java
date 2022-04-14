package main.command;

import main.controller.Context;

public class CancelBookingCommand extends Object implements ICommand{
    long bookingNumber;
    CancelBookingCommand(long bookingNumber){
        this.bookingNumber = bookingNumber;

    }

    @Override
    public boolean execute(Context context) {
        return false;
    }

    @Override
    public Boolean getResult() {
        return null;
    }
}
