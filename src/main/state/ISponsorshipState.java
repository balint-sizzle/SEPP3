package main.state;

import main.model.SponsorshipRequest;
import main.model.TicketedEvent;

import java.util.List;

public interface ISponsorshipState {

    SponsorshipRequest addSponsorshipRequest(TicketedEvent event);
    SponsorshipRequest findRequestByNumber(long requestNumber);
    List<SponsorshipRequest> getAllSponsorshipRequests();
    List<SponsorshipRequest> getPendingSponsorshipRequests();

}
