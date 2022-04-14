package main.command;

import main.controller.Context;

import java.time.LocalDateTime;
import java.util.List;

public class AddEventPerformanceCommand extends Object implements ICommand{
    long eventNumber;
    String venueAddress;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    List<String> performerNames;
    boolean hasSocialDistancing;
    boolean hasAirFiltration;
    boolean isOutdoors;
    int capacityLimit;
    int venueSize;

    AddEventPerformanceCommand(long eventNumber, String venueAddress,
                               LocalDateTime startDateTime, LocalDateTime endDateTime,
                               List<String> performerNames, boolean hasSocialDistancing,
                               boolean hasAirFiltration, boolean isOutdoors,
                               int capacityLimit, int venueSize){
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

    @Override
    public void execute(Context context) {

    }

    @Override
    public Object getResult() {
        return null;
    }
}
