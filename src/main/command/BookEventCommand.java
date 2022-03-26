package src.main.command;

public class BookEventCommand extends Object implements ICommand{

    public long eventNumber;
    public long performanceNumber;
    int numTicketsRequested;

    public BookEventCommand(long eventNumber, long performanceNumber, int numTicketsRequested){
        this.eventNumber = eventNumber;
        this.performanceNumber = performanceNumber;
        this.numTicketsRequested = numTicketsRequested;


    }

    @Override
    public void execute(Context context) {

    }

    @Override
    public Object getResult() {
        return null;
    }
}
