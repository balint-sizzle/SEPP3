package main.command;

import main.controller.Context;
import main.model.Event;
import main.model.EventPerformance;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class ListEventsOnGivenDateCommand extends ListEventsCommand{

    private LocalDateTime searchDateTime;
    private List<Event> eventListResult;

    public ListEventsOnGivenDateCommand(boolean userEventsOnly,
                                        boolean activeEventsOnly,
                                        LocalDateTime searchDateTime) {
        super(userEventsOnly, activeEventsOnly);
        this.searchDateTime = searchDateTime;
    }

    public void execute(Context context) {
        // get events based on preferences
        super.execute(context);

        // define window for search (+/- 1 day from search)
        LocalDateTime earliestDateTime = searchDateTime.minusDays(1);
        LocalDateTime latestDateTime = searchDateTime.plusDays(1);

        // find which events satisfy time constraints
        for (Event event : eventListResult) {
            Collection<EventPerformance> performances = event.getPerformances();
            boolean withinSearchWindow = false;

            // if any performances occur within the search window, the event should be returned
            for (EventPerformance performance : performances) {
                if (performance.getStartDateTime().isAfter(earliestDateTime) || performance.getEndDateTime().isBefore(latestDateTime)) {
                    withinSearchWindow = true;
                }
            }

            // remove all events that are not within the search window
            if (!withinSearchWindow) {
                eventListResult.remove(event);
            }
        }
    }
    
}
