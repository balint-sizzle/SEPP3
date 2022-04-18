package main.command;

import main.controller.Context;
import main.model.EntertainmentProvider;
import main.model.Event;
import main.model.EventPerformance;

import java.time.LocalDateTime;
import java.util.List;

public class AddEventPerformanceCommand extends Object implements ICommand{
    private final long eventNumber;
    private final String venueAddress;
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;
    private final List<String> performerNames;
    private final boolean hasSocialDistancing;
    private final boolean hasAirFiltration;
    private final boolean isOutdoors;
    private final int capacityLimit;
    private final int venueSize;
    private EventPerformance eventPerformanceResult;

    public AddEventPerformanceCommand(long eventNumber,
                                      String venueAddress,
                                      LocalDateTime startDateTime,
                                      LocalDateTime endDateTime,
                                      List<String> performerNames,
                                      boolean hasSocialDistancing,
                                      boolean hasAirFiltration,
                                      boolean isOutdoors,
                                      int capacityLimit,
                                      int venueSize) {
        this.eventNumber = eventNumber;
        this.venueAddress = venueAddress;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.performerNames = performerNames;
        this.hasSocialDistancing = hasSocialDistancing;
        this.hasAirFiltration = hasAirFiltration;
        this.isOutdoors = isOutdoors;
        this.capacityLimit = capacityLimit;
        this.venueSize = venueSize;
    }

    public void execute(Context context) {
        boolean validEventId = false;
        boolean duplicates = false;
        Event thisEvent = null;

        for (Event event : context.getEventState().getAllEvents()) {
            if (event.getEventNumber() == eventNumber) {
                validEventId = true;
                thisEvent = event;
                break;
            }
        }

        for (Event event : context.getEventState().getAllEvents()) {
            for (EventPerformance performance : event.getPerformances()) {
                if (event.getEventNumber() == eventNumber &&
                        performance.getStartDateTime() == startDateTime &&
                        performance.getEndDateTime() == endDateTime) {
                    duplicates = true;
                    break;
                }
            }
        }

        boolean isValid = startDateTime.isBefore(endDateTime) &&
                capacityLimit > 0 &&
                context.getUserState().getCurrentUser() instanceof EntertainmentProvider &&
                validEventId &&
                thisEvent.getOrganiser() == context.getUserState().getCurrentUser() &&
                !duplicates;

        if (isValid) {
            eventPerformanceResult = new EventPerformance(thisEvent.getPerformances().size(),
                    thisEvent,
                    venueAddress,
                    startDateTime,
                    endDateTime,
                    performerNames,
                    hasSocialDistancing,
                    hasAirFiltration,
                    isOutdoors,
                    capacityLimit,
                    venueSize);
            thisEvent.addPerformance(eventPerformanceResult);
        }
        else {
            eventPerformanceResult = null;
        }
    }

    public EventPerformance getResult() {
        return eventPerformanceResult;
    }
}
