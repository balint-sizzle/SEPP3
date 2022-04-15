import main.command.ICommand;
import main.controller.Context;
import main.model.Consumer;

public class BookEventCommand extends Object implements ICommand {
    //    BookEventCommand allows Consumers to book tickets for a specific EventPerformance.
//    The command applies for the currently logged-in user.
    long eventNumber;
    long performanceNumber;
    int numTicketsRequested;

    BookEventCommand(long eventNumber, long performanceNumber, int numTicketsRequested) {
        this.eventNumber = eventNumber;
        this.performanceNumber = performanceNumber;
        this.numTicketsRequested = numTicketsRequested;

    }

    @Override
    public void execute(Context context) {
//currently logged-in user is a Consumer
        boolean isConsumer = context.getUserState().getCurrentUser() instanceof Consumer;
//event number corresponds to an existing event
        //todo
// event is a ticketed event
        //todo
//number of requested tickets is not less than 1
        //todo
//performance number corresponds to an existing performance of the event
        //todo
        boolean correspondsToExistingPOE = performanceNumber != 0;
//the selected performance has not ended yet
        //todo
//the requested number of tickets is still available according to the organiser's EntertainmentProviderSystem
        //todo
//booking payment via the PaymentSystem succeeds
        //todo

    }

    @Override
    public Long getResult() {
//A unique booking number corresponding to a Booking if successful and null otherwise


        return null;
    }
}