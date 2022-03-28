package main.command;

public class BookEventCommand extends Object implements ICommand{
    long eventNumber;
    long performanceNumber;
    int numTicketsRequested;
    public BookEventCommand(long eventNumber,
                             long performanceNumber,
                             int numTicketsRequested){
        this.eventNumber = eventNumber;
        this.performanceNumber = performanceNumber;
        this.numTicketsRequested = numTicketsRequested;

    }

    @Override
    public void execute(main.controller.Context context) {

    }

    @Override
    public Object getResult() {
        return null;
    }
}