package main.state;

import main.model.SponsorshipRequest;
import main.model.SponsorshipStatus;
import main.model.TicketedEvent;
import java.util.ArrayList;
import java.util.List;

public class SponsorshipState implements ISponsorshipState {

    private long nextSponsorshipId;
    private List<SponsorshipRequest> sponsorshipRequests;

    public SponsorshipState() {
        sponsorshipRequests = new ArrayList<>();
        nextSponsorshipId = 1;
    }

    public SponsorshipState(ISponsorshipState other) {
        sponsorshipRequests = new ArrayList<>(other.getAllSponsorshipRequests());
        nextSponsorshipId = other.get
    }

    @Override
    public SponsorshipRequest addSponsorshipRequest(TicketedEvent event) {
        SponsorshipRequest request = new SponsorshipRequest(nextSponsorshipId, event);
        nextSponsorshipId++;
        event.setSponsorshipRequest(request);

        return request;
    }

    @Override
    public List<SponsorshipRequest> getAllSponsorshipRequests() {
        return sponsorshipRequests;
    }

    @Override
    public List<SponsorshipRequest> getPendingSponsorshipRequests() {
        List<SponsorshipRequest>pendingSponsorshipRequests = new ArrayList<>();

        for (SponsorshipRequest request : sponsorshipRequests) {
            if (request.getStatus() == SponsorshipStatus.PENDING) {
                pendingSponsorshipRequests.add(request);
            }
        }

        return pendingSponsorshipRequests;
    }

    public SponsorshipRequest findRequestByNumber(long requestNumber) {
        for (SponsorshipRequest request : sponsorshipRequests) {
            if (request.getRequestNumber() == requestNumber) {
                return request;
            }
        }
        return null;
    }
}
