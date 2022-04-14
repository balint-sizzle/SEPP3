package main.model;

import java.time.LocalDateTime;

public class Booking {
    long bookingNumber;
    Consumer booker;
    EventPerformance performance;
    int numTickets;
    double amountPaid;
    LocalDateTime bookingDateTime;


    public Booking(long bookingNumber, Consumer booker, EventPerformance performance,
            int numTickets, double amountPaid, LocalDateTime bookingDateTime){
        this.bookingNumber = bookingNumber;
        this.booker = booker;
        this.performance = performance;
        this.numTickets = numTickets;
        this.amountPaid = amountPaid;
        this.bookingDateTime = bookingDateTime;

    }
    public long getBookingNumber(){
        return bookingNumber;
    }
    public BookingStatus getStatus(){
        return null;
    }
    public Consumer getBooker(){
        return booker;
    }
    public EventPerformance getEventPerformance(){
        return performance;
    }
    public double getAmountPaid(){
        return amountPaid;
    }
    public void cancelByConsumer(){
        //todo
//        Sets the status to BookingStatus.CancelledByConsumer.
        BookingStatus status = BookingStatus.CancelledByConsumer;
    }
    public void cancelPaymentFailed(){
        //todo
//        Sets the status to BookingStatus.PaymentFailed.
        BookingStatus status = BookingStatus.PaymentFailed;
    }
    public void cancelByProvider(){
        //todo
//        Sets the status to BookingStatus.CancelledByProvider.
        BookingStatus status = BookingStatus.CancelledByProvider;
    }
    public String toString(){
        return null;
    }


}
