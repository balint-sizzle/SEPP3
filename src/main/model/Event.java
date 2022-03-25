package src.main.model;

import java.util.*;

public abstract class Event {

    private long eventId;
    private EntertainmentProvider organiser;
    private String title;
    private EventType type;
    private Collection<EventPerformance> performances;
    private EventStatus status;

    protected Event(long eventNumber, EntertainmentProvider organiser,
                    String title, EventType type) {
        eventId = eventNumber;
        this.organiser = organiser;
        this.title = title;
        this.type = type;
        status = EventStatus.ACTIVE;
        performances = new ArrayList<>();
    }

    public long getEventNumber() {
        return eventId;
    }

    public EntertainmentProvider getOrganiser() {
        return organiser;
    }

    public String getTitle() {
        return title;
    }

    public EventType getType() {
        return type;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void cancel() {
        status = EventStatus.CANCELLED;
    }

    public void addPerformance(EventPerformance performance) {
        performances.add(performance);
    }

    public EventPerformance getPerformanceByNumber(long performanceNumber) {
        for (EventPerformance performance : performances) {
            if (performance.getPerformanceNumber() == performanceNumber) {
                return performance;
            }
        }
        return null;
    }

    public Collection<EventPerformance> getPerformances() {
        return performances;
    }
}
