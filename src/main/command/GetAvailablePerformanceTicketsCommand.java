package main.command;

import main.controller.Context;
import main.model.Event;
import main.model.EventPerformance;
import main.model.TicketedEvent;

public class GetAvailablePerformanceTicketsCommand implements ICommand {
    private final long eventNumber;
    private final long performanceNumber;
    private int numberOfTickets;
    public GetAvailablePerformanceTicketsCommand(long eventNumber, long performanceNumber) {
        this.eventNumber = eventNumber;
        this.performanceNumber = performanceNumber;
    }

    public void execute(Context context) {
        Event thisEvent = null;
        EventPerformance thisPerformance = null;
        int eventTickets;
        int usedTickets = 0;

        for (Event event : context.getEventState().getAllEvents()) {
            if (event.getEventNumber() == eventNumber) {
                thisEvent = event;
                break;
            }
        }

        if (thisEvent instanceof TicketedEvent) {
            eventTickets = ((TicketedEvent) thisEvent).getNumTickets();
            for (EventPerformance performance : thisEvent.getPerformances()) {
                eventTickets = eventTickets - performance.getCapacityLimit();
                if (performance.getPerformanceNumber() == performanceNumber) {
                    usedTickets = Math.max(eventTickets, 0);
                    thisPerformance = performance;
                }
            }
        }

        boolean isValid = thisEvent instanceof TicketedEvent &&
                thisPerformance != null;

        if (isValid) {
            numberOfTickets = thisPerformance.getCapacityLimit() - usedTickets;
        }
    }

    public Integer getResult() {
        return numberOfTickets;
    }
}
