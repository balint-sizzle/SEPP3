package main.command;
import main.controller.Context;
import main.model.*;


public abstract class CreateEventCommand implements ICommand {

    protected long eventNumberResult;
    protected String title;
    protected EventType type;

    public CreateEventCommand(String title, EventType type) {
        this.title = title;
        this.type = type;
    }

    protected boolean isUserAllowedToCreateEvent(Context context) {
        User currentUser = context.getUserState().getCurrentUser();
        return (currentUser instanceof EntertainmentProvider);
    }

    public Long getResult() {
        return eventNumberResult;
    }

}