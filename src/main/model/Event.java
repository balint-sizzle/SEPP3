package src.main.model;

import java.util.Map;

public abstract class Event {

    private long eventId;
    private EntertainmentProvider organiser;
    private String title;
    private EventType type;
    private Map<Long, EventPerformance> performances;

    protected Event(long eventNumber, EntertainmentProvider organiser,
                    String title, EventType type) {
        eventId = eventNumber;
        this.organiser = organiser;
        this.title = title;
        this.type = type;
    }
    
}
