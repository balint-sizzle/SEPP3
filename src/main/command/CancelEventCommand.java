package main.command;

import main.controller.Context;
import main.model.*;
import main.state.EventState;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

public class CancelEventCommand {

    private long eventId;
    private String organiserMessage;
    private Boolean successResult;

    public CancelEventCommand(long eventNumber, String organiserMessage) {
        eventId = eventNumber;
        this.organiserMessage = organiserMessage;
    }

    public void execute(Context context) {
        // get values of current user, event to cancel, and its performances
        User currentUser = context.getUserState().getCurrentUser();
        Event event = context.getEventState().findEventByNumber(eventId);
        Collection<EventPerformance> performances = event.getPerformances();

        // check if any performances have already started or ended
        LocalDateTime now = LocalDateTime.now();
        boolean performancesNotStarted = true;

        for (EventPerformance performance : performances) {
            if (performance.getStartDateTime().isAfter(now)) {
                performancesNotStarted = false;
            }
        }

        // check all conditions before cancelling event and refunding sponsorship amount
        if ((organiserMessage.length() != 0) && (currentUser instanceof EntertainmentProvider) &&
                (event != null) && (event.getStatus() == EventStatus.ACTIVE) &&
                (event.getOrganiser() == currentUser) && (performancesNotStarted)){
            event.cancel();
            // figure out how to refund all tickets

        }
    }

    public Boolean getResult() {
        return successResult;
    }

    
}
