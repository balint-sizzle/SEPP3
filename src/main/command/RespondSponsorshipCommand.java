package main.command;

import main.controller.Context;
import main.model.GovernmentRepresentative;
import main.model.SponsorshipRequest;
import main.model.SponsorshipStatus;
import main.model.User;
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

        successResult = ((currentUser instanceof GovernmentRepresentative) && (0 <= percentToSponsor)
        && (percentToSponsor <= 100) && (request != null) && (request.getStatus() == SponsorshipStatus.PENDING));

        if (successResult) {
            request.accept(percentToSponsor, currentUser.getPaymentAccountEmail());
        }
    }

    public Boolean getResult(Context context) {
        return successResult;
    }
    
}
