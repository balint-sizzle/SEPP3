package main.state;
import main.model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventState implements IEventState {

    private long nextEventId;
    private long nextPerformanceId;
    private List<Event> events;

    public EventState() {
        this.events = new ArrayList<>();
        nextEventId = 1;
        nextPerformanceId = 1;
    }

    public List<Event> getAllEvents() {
        return this.events;
    }

    public Event findEventByNumber(long eventNumber) {
        for (Event event: this.events) {
            if (event.getEventNumber() == eventNumber) {
                return event;
            }
        }
        return null;
    }

    public NonTicketedEvent createNonTicketedEvent(EntertainmentProvider organiser,
                                                   String title,
                                                   EventType type) {
        NonTicketedEvent event = new NonTicketedEvent(nextEventId, organiser, title, type);
        nextEventId++;
        this.events.add(event);
        return event;
    }

    public TicketedEvent createTicketedEvent(EntertainmentProvider organiser,
                                             String title,
                                             EventType type,
                                             double ticketPrice,
                                             int numTickets) {
        TicketedEvent event =  new TicketedEvent(nextEventId, organiser, title, type, ticketPrice, numTickets);
        nextEventId++;
        this.events.add(event);
        return event;
    }

    public EventPerformance createEventPerformance(Event event,
                                                   String venueAddress,
                                                   LocalDateTime startDateTime,
                                                   LocalDateTime endDateTime,
                                                   List<String> performerNames,
                                                   boolean hasSocialDistancing,
                                                   boolean hasAirFiltration,
                                                   boolean isOutdoors,
                                                   int capacityLimit,
                                                   int venueSize) {
        EventPerformance performance = new EventPerformance(nextPerformanceId, event, venueAddress, startDateTime,
                                        endDateTime, performerNames, hasSocialDistancing, hasAirFiltration,
                                        isOutdoors, capacityLimit, venueSize);
        nextPerformanceId++;
        event.addPerformance(performance);
        return performance;
    }
    
}

