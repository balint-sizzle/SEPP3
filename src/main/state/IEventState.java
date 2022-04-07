package main.state;

import main.model.*;

import java.util.List;

public interface IEventState {

    TicketedEvent createTicketedEvent(EntertainmentProvider organiser,
                                       String title,
                                       EventType type,
                                       double ticketPrice,
                                       int numTickets);

    NonTicketedEvent createNonTicketedEvent(EntertainmentProvider organiser,
                                            String title,
                                            EventType type);

    Event findEventByNumber(long eventNumber);

    List<Event> getAllEvents();
}

