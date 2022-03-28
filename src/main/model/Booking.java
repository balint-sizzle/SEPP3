package main.model;

import java.time.LocalDateTime;

public class Booking extends Object{



    long bookingNumber;
    Consumer booker;
    EventPerformance performance;
    int numTickets;
    double amountPaid;
    LocalDateTime bookingDateTime;
    public Booking(long bookingNumber,
                    Consumer booker,
                    EventPerformance performance,
                    int numTickets,
                    double amountPaid,
                    LocalDateTime bookingDateTime){
        this.bookingNumber = bookingNumber;
        this.booker = booker;
        this.performance = performance;
        this.numTickets = numTickets;
        this.amountPaid = amountPaid;
        this.bookingNumber = bookingNumber;
        this.bookingDateTime = bookingDateTime;


    }
    public long getBookingNumber() {
        return bookingNumber;
    }
    public BookingStatus getStatus(){
        return null;
    }
    public Consumer getBooker() {
        return booker;
    }
    public EventPerformance getPerformance() {
        return performance;
    }
    public double getAmountPaid() {
        return amountPaid;
    }
    public void cancelByConsumer(){
//        Sets the status to BookingStatus.CancelledByConsumer.
    }
    public void cancelPaymentFailed(){
//        Sets the status to BookingStatus.PaymentFailed.
    }
    public void cancelByProvider(){
//        Sets the status to BookingStatus.CancelledByProvider.
    }
    public String toString(){

        return null;
    }
    
}
