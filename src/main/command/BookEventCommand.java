package main.command;

import main.controller.Context;
import main.external.MockEntertainmentProviderSystem;
import main.model.Consumer;
import main.model.EntertainmentProvider;
import main.model.User;

public class BookEventCommand extends Object implements ICommand{
//    BookEventCommand allows Consumers to book tickets for a specific EventPerformance.
//    The command applies for the currently logged-in user.
    long eventNumber;
    long performanceNumber;
    int numTicketsRequested;

    BookEventCommand(long eventNumber, long performanceNumber, int numTicketsRequested){
        this.eventNumber = eventNumber;
        this.performanceNumber = performanceNumber;
        this.numTicketsRequested = numTicketsRequested;

    }

    @Override
    public boolean execute(Context context) {
//        currently logged-in user is a Consumer
        User currentUser = context.getUserState().getCurrentUser();
        return (currentUser instanceof Consumer);
//        event number corresponds to an existing event
//        event is a ticketed event
//        boolean isTicked =
//        number of requested tickets is not less than 1
        boolean notLessThan1 = eventNumber >= 0;
//        performance number corresponds to an existing performance of the event
        boolean correspondsToExistingPOE = performanceNumber != 0;
//        the selected performance has not ended yet
        //todo
//        the requested number of tickets is still available according to the organiser's EntertainmentProviderSystem
        boolean isAviliable = MockEntertainmentProviderSystem.getNumTicketsLeft();
//        booking payment via the PaymentSystem succeeds
        //todo

    }

    @Override
    public Object getResult() {
//        A unique booking number corresponding to a Booking if successful and null otherwise
        if(true){
            return  eventNumber;
        }
        else{
            return null;
        }

    }
}
