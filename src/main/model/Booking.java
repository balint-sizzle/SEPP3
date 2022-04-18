package main.model;

import java.time.LocalDateTime;

public class Booking {
    long bookingNumber;
    Consumer booker;
    EventPerformance performance;
    BookingStatus status;
    int numTickets;
    double amountPaid;
    LocalDateTime bookingDateTime;


    public Booking(long bookingNumber, Consumer booker, EventPerformance performance,
            int numTickets, double amountPaid, LocalDateTime bookingDateTime){
        this.bookingNumber = bookingNumber;
        this.booker = booker;
        this.status = BookingStatus.Active;
        this.performance = performance;
        this.numTickets = numTickets;
        this.amountPaid = amountPaid;
        this.bookingDateTime = bookingDateTime;

    }
    public long getBookingNumber(){
        return bookingNumber;
    }
    public BookingStatus getStatus(){
        return status;
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
        status = BookingStatus.CancelledByConsumer;
    }
    public void cancelPaymentFailed(){
        status = BookingStatus.PaymentFailed;
    }
    public void cancelByProvider(){
        status = BookingStatus.CancelledByProvider;
    }
}
