package main.external;

import java.time.LocalDateTime;
import java.util.Map;

public class MockEntertainmentProviderSystem extends Object implements EntertainmentProviderSystem{
    private String orgName;
    private String orgAddress;
    //Todo: not sure about this.
    private Map<Long,String[]> recordedEvents;

    public MockEntertainmentProviderSystem(String orgName, String orgAddress) {
        this.orgName = orgName;
        this.orgAddress = orgAddress;
    }

    public void recordNewEvent(long eventNumber, String title, int numTickets) {
        recordedEvents.put(eventNumber, new String[]{title, Integer.toString(numTickets)});
    }

    public void cancelEvent(long eventNumber, String message) {
        recordedEvents.remove(eventNumber);
    }

    public void recordNewPerformance(long eventNumber,
                                     long performanceNumber,
                                     LocalDateTime startDateTime,
                                     LocalDateTime endDateTime) {

    }

    public int getNumTicketsLeft(long eventNumber, long performanceNumber) {
        //Todo
        return 0;
    }

    public void recordNewBooking(long eventNumber,
                                 long performanceNumber,
                                 long bookingNumber,
                                 String consumerName,
                                 String consumerEmail,
                                 int bookedTickets) {
        //Todo: for booking
    }

    public void cancelBooking(long bookingNumber) {

    }

    public void recordSponsorshipAcceptance(long eventNumber, int sponsoredPricePercent) {

    }

    public void recordSponsorshipRejection(long eventNumber) {

    }
}