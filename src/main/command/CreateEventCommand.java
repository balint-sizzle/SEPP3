package src.main.command;
import src.main.controller.Context;
import src.main.model.EntertainmentProvider;
import src.main.model.EventType;

public abstract class CreateEventCommand extends Object implements ICommand {

    private final String title;
    private final EventType type;

    CreateEventCommand(String title, EventType type) {
        this.title = title;
        this.type = type;
    }

    protected boolean isUserAllowedToCreateEvent(Context context) {
        currentUser = context.getUserState().getCurrentUser();

        return (currentUser != null) && (typeof currentUser != EntertainmentProvider)

    }
}