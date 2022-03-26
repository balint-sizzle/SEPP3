package src.main.controller;

import main.external.MockEntertainmentProviderSystem;
import main.external.MockPaymentSystem;

import main.state.IUserState;
import main.state.IBookingState;
import main.state.IEventState;
import main.state.ISponsorshipState;

import main.state.UserState;
import main.state.BookingState;
import main.state.EventState;
import main.state.SponsorshipState;

public class Context{
    private MockEntertainmentProviderSystem entertainmentProviderSystem;
    private MockPaymentSystem paymentSystem;

    private IUserState userState;
    private IBookingState bookingState;
    private IEventState eventState;
    private ISponsorshipState sponsorshipState;

    private ISponsorshipState attribute; // TODO FIGURE OUT WHAT THIS IS
    
    public Context(){
        this.entertainmentProviderSystem = new MockEntertainmentProviderSystem();
        this.paymentSystem = new MockPaymentSystem();
        this.userState = new UserState();
        this.bookingState = new BookingState();
        this.eventState = new EventState();
        this.sponsorshipState = new SponsorshipState();
    }

    public Context(Context other){
        //TODO FIGURE OUT HOW TO DO THIS
        // this.entertainmentProviderSystem = other.entertainmentProviderSystem;
        // this.paymentSystem = other.paymentSystem;
        // this.userState = other.userState;
        // this.bookingState = other.bookingState;
        // this.eventState = other.eventState;
        // this.sponsorshipState = other.sponsorshipState;
    }

    public MockPaymentSystem getPaymentSystem(){ return this.paymentSystem;}

    public IBookingState getBookingState(){return this.bookingState;}

    public IEventState getEventState() {return this.eventState;}

    public IUserState getUserState() {return this.userState;}

    public ISponsorshipState getSponsorshipState() {return this.sponsorshipState;}


}