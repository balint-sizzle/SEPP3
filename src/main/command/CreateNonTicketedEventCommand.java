package main.command;

import main.controller.Context;
import main.model.EntertainmentProvider;
import main.model.EventType;
import main.model.NonTicketedEvent;
import main.state.EventState;
import main.state.IEventState;
import main.state.UserState;


public class CreateNonTicketedEventCommand extends CreateEventCommand {

    public CreateNonTicketedEventCommand(String title, EventType type) {
        super(title, type);
    }

    public void execute(Context context) {
        if (isUserAllowedToCreateEvent(context)) {
            EventState eventState = (EventState) context.getEventState();
            UserState userState = (UserState) context.getUserState();

            NonTicketedEvent event = eventState.createNonTicketedEvent((EntertainmentProvider) userState.getCurrentUser(),title, type);
            eventIdResult = event.getEventNumber();
        }
    }
}

