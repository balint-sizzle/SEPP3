package main.command;

import main.controller.Context;
import main.model.GovernmentRepresentative;
import main.model.SponsorshipRequest;
import main.model.SponsorshipStatus;
import main.model.User;
import main.state.SponsorshipState;
import org.junit.Assert;
import org.junit.Test;

public class RespondSponsorshipCommand {

    private long requestId;
    private int percentToSponsor;
    private Boolean successResult;

    public RespondSponsorshipCommand(long requestNumber, int percentToSponsor) {
        requestId = requestNumber;
        this.percentToSponsor = percentToSponsor;
    }

    public void execute(Context context) {
        User currentUser = context.getUserState().getCurrentUser();
        SponsorshipRequest request = context.getSponsorshipState().findRequestByNumber(requestId);

        Assert.assertTrue((currentUser instanceof GovernmentRepresentative) && (0 <= percentToSponsor)
        && (percentToSponsor <= 100) && (request != null) && (request.getStatus() == SponsorshipStatus.PENDING));
    }

    public Boolean getResult(Context context) {
        User currentUser = context.getUserState().getCurrentUser();
        SponsorshipRequest request = context.getSponsorshipState().findRequestByNumber(requestId);

        return ((currentUser instanceof GovernmentRepresentative) && (0 <= percentToSponsor)
                && (percentToSponsor <= 100) && (request != null) && (request.getStatus() == SponsorshipStatus.PENDING));
    }
    
}
