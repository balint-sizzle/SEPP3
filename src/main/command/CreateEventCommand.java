package src.main.command;
import src.main.controller.Context;
import src.main.model.*;

public abstract class CreateEventCommand implements ICommand {

    private final String title;
    private final EventType type;

    CreateEventCommand(String title, EventType type) {
        this.title = title;
        this.type = type;
    }

    protected boolean isUserAllowedToCreateEvent(Context context) {
        User currentUser = context.getUserState().getCurrentUser();
        return (currentUser instanceof EntertainmentProvider);
    }
}