import main.command.*;
import main.controller.Controller;
import main.model.*;
import main.state.BookingState;
import main.state.UserState;
import org.junit.jupiter.api.Test;

import javax.naming.ldap.Control;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBookingState {
    BookingState bookingState;
    Controller controller;

    public TestBookingState(){
        this.bookingState = new BookingState();

    }
    private static void consumerBookNthTicketedEvent(Controller controller, int n) {
        ListEventsCommand cmd = new ListEventsCommand(false, true);
        controller.runCommand(cmd);
        List<Event> events = cmd.getResult();

        for (Event event : events) {
            if (event instanceof TicketedEvent) {
                n--;
            }

            if (n <= 0) {
                Collection<EventPerformance> performances = event.getPerformances();
                controller.runCommand(new BookEventCommand(
                        event.getEventNumber(),
                        performances.iterator().next().getPerformanceNumber(),
                        1
                ));
                return;
            }
        }
    }
    private static void makePerformances(Controller controller){
        controller.runCommand(new RegisterEntertainmentProviderCommand(
                "No org",
                "Leith Walk",
                "a hat on the ground",
                "the best musicican ever",
                "busk@every.day",
                "When they say 'you can't do this': Ding Dong! You are wrong!",
                Collections.emptyList(),
                Collections.emptyList()
        ));

        CreateNonTicketedEventCommand eventCmd = new CreateNonTicketedEventCommand(
                "Music for everyone!",
                EventType.Music
        );
        controller.runCommand(eventCmd);
        long eventNumber = eventCmd.getResult();

        controller.runCommand(new AddEventPerformanceCommand(
                eventNumber,
                "Leith as usual",
                LocalDateTime.of(2030, 3, 20, 4, 20),
                LocalDateTime.of(2030, 3, 20, 6, 45),
                List.of("The same musician"),
                true,
                true,
                true,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE
        ));
    }

    @Test
    void create2Bookings(){
        controller = new Controller();
        makePerformances(controller);
        consumerBookNthTicketedEvent(controller, 2);
        ListEventsCommand cmd = new ListEventsCommand(false, false);
        controller.runCommand(cmd);
        List<Event> events = cmd.getResult();
        ListEventBookingsCommand cmd2 =  new ListEventBookingsCommand(events.get(0).getEventNumber());
        controller.runCommand(cmd2);
        List<Booking> bookings = cmd2.getResult();
        assertEquals(2, bookings.size());
    }
}
