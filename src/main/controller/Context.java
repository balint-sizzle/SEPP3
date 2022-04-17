package main.controller;
import main.external.*;
import main.state.*;

public class Context {

    private MockEntertainmentProviderSystem entertainmentProviderSystem;
    private MockPaymentSystem paymentSystem;

    private IUserState userState;
    private IBookingState bookingState;
    private IEventState eventState;
    private ISponsorshipState sponsorshipState;

    private ISponsorshipState attribute; // TODO FIGURE OUT WHAT THIS IS

    public Context(){
        this.entertainmentProviderSystem = new MockEntertainmentProviderSystem("Amazon", "Bezos@jeff.com");
        this.paymentSystem = new MockPaymentSystem();
        this.userState = new UserState();
        this.bookingState = new BookingState();
        this.eventState = new EventState();
        this.sponsorshipState = new SponsorshipState();
    }

    public Context(Context other){
        paymentSystem = (MockPaymentSystem) other.getPaymentSystem();
        userState = (UserState) other.getUserState();
        eventState = (EventState) other.getEventState();
        bookingState = (BookingState) other.getBookingState();
        sponsorshipState = (SponsorshipState) other.getSponsorshipState();

    }

    public IUserState getUserState() {
        return userState;
    }

    public IEventState getEventState() {
        return eventState;
    }

    public IBookingState getBookingState() {
        return bookingState;
    }

    public ISponsorshipState getSponsorshipState() {
        return sponsorshipState;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

}
