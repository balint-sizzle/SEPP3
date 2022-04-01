package src.main.command;
import org.junit.Test;
import src.main.controller.Context;
import src.main.model.Event;
import src.main.model.EventType;

import static org.junit.Assert.assertTrue;

public class CreateNonTicketedEventCommand extends CreateEventCommand {

    public CreateNonTicketedEventCommand(String title, EventType type) {
        super(title, type);
    }

    @Test
    public void execute(Context context) {
        assertTrue(isUserAllowedToCreateEvent(context));
    }

