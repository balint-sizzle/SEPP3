package main.model;

public class SponsorshipRequest {

    private long requestId;
    private TicketedEvent event;
    private SponsorshipStatus status;
    private Integer sponsoredPricePercent;
    private String sponsorAccountEmail;

    public SponsorshipRequest(long requestNumber, TicketedEvent event) {
        status = SponsorshipStatus.PENDING;
        requestId = requestNumber;
        this.event = event;
    }

    public long getRequestNumber() {
        return requestId;
    }

    public TicketedEvent getEvent() {
        return event;
    }

    public SponsorshipStatus getStatus() {
        return status;
    }

    public Integer getSponsoredPricePercent() {
        return sponsoredPricePercent;
    }

    public String getSponsorAccountEmail() {
        return sponsorAccountEmail;
    }

    public void accept(int percent, String sponsorAccountEmail) {
        status = SponsorshipStatus.ACCEPTED;
        sponsoredPricePercent = percent;
        this.sponsorAccountEmail = sponsorAccountEmail;
    }

    public void reject() {
        status = SponsorshipStatus.REJECTED;
    }
}
