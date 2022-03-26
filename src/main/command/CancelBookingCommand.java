package src.main.command;

public class CancelBookingCommand extends Object implements ICommand{
    public long bookingNumber;


    public CancelBookingCommand​(long bookingNumber){
        this.bookingNumber = bookingNumber;
    }

    @Override
    public void execute(Context context) {
        //todo
//        This method should not be called directly outside of testing.
//        Normal usage is to create a command object
//        and execute it by passing to Controller.runCommand(ICommand) instead
    }

    @Override
    public Object getResult() {
        return null;
    }
}
