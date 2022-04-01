package src.main.state;
import src.main.model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventState implements IEventState {

    private long nextEventId;
    private long nextPerformanceId;
    private List<Event> events;

    public EventState() {
        events = new ArrayList<>();
        nextEventId = 1;
        nextPerformanceId = 1;
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public Event findEventByNumber(long eventNumber) {
        for (Event event: events) {
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
        return event;
    }

    public TicketedEvent createTicketedEvent(EntertainmentProvider organiser,
                                             String title,
                                             EventType type,
                                             double ticketPrice,
                                             int numTickets) {
        TicketedEvent event =  new TicketedEvent(nextEventId, organiser, title, type, ticketPrice, numTickets);
        nextEventId++;
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
        return performance;
    }
    
}

