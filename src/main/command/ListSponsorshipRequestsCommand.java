package main.command;

import main.controller.Context;
import main.model.GovernmentRepresentative;
import main.model.SponsorshipRequest;
import main.model.User;
import main.state.SponsorshipState;

import java.util.ArrayList;
import java.util.List;

public class ListSponsorshipRequestsCommand implements ICommand{

    private boolean pendingRequestsOnly;
    private List<SponsorshipRequest> requestListResult;

    public ListSponsorshipRequestsCommand(boolean pendingRequestsOnly) {
        this.pendingRequestsOnly = pendingRequestsOnly;
        requestListResult = new ArrayList<>();
    }

    public void execute(Context context) {
        User currentUser = context.getUserState().getCurrentUser();
        SponsorshipState sponsorshipState = (SponsorshipState) context.getSponsorshipState();

        if (currentUser instanceof GovernmentRepresentative) {
            if (pendingRequestsOnly) {
                requestListResult = sponsorshipState.getPendingSponsorshipRequests();
            }
            else {
                requestListResult = sponsorshipState.getAllSponsorshipRequests();
            }
        }
    }

   public List<SponsorshipRequest> getResult() {
        return requestListResult;
   }
    
}
