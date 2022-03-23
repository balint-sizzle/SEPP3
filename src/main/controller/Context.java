package src.main.controller;
import src.main.external.*;
import src.main.model.EventType;
import src.main.state.*;

public class Context {

    MockPaymentSystem paymentSystem;
    UserState userState;
    EventState eventState;
    BookingState bookingState;
    SponsorshipState sponsorshipState;


    Context() {
        paymentSystem = new MockPaymentSystem();
        userState = new UserState();
        eventState = new EventState();
        bookingState = new BookingState();
        sponsorshipState = new SponsorshipState();
    }

    Context(Context other) {
        paymentSystem = other.getPaymentSystem();
        userState = other.getUserState();
        eventState = other.getEventState();
        bookingState = other.getBookingState();
        sponsorshipState = other.getSponsorshipState();
    }

    public IUserState getUserState() { return userState; }

    public IEventState getEventState() { return eventState; }

    public IBookingState getBookingState() { return bookingState; }

    public ISponsorshipState getSponsorshipState() { return sponsorshipState; }

    public PaymentSystem getPaymentSystem() { return paymentSystem; }

}
