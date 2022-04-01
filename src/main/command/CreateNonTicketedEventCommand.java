package main.command;
import org.junit.Test;
import main.controller.Context;
import main.model.Event;
import main.model.EventType;

import static org.junit.Assert.assertTrue;

public class CreateNonTicketedEventCommand extends CreateEventCommand {

    public CreateNonTicketedEventCommand(String title, EventType type) {
        super(title, type);
    }

    @Test
    public void execute(Context context) {
        assertTrue(isUserAllowedToCreateEvent(context));
    }

}

