package main.command;

import main.controller.Context;
import main.model.EntertainmentProvider;
import main.model.User;

import java.util.Collection;
import java.util.List;

public class UpdateEntertainmentProviderProfileCommand extends UpdateProfileCommand {

    private String oldPassword;
    private String newOrgName;
    private String newOrgAddress;
    private String newPaymentAccountEmail;
    private String newMainRepName;
    private String newMainRepEmail;
    private String newPassword;
    private List<String> newOtherRepNames;
    private List<String> newOtherRepEmails;

    public UpdateEntertainmentProviderProfileCommand(String oldPassword,
                                                     String newOrgName,
                                                     String newOrgAddress,
                                                     String newPaymentAccountEmail,
                                                     String newMainRepName,
                                                     String newMainRepEmail,
                                                     String newPassword,
                                                     List<String> newOtherRepNames,
                                                     List<String> newOtherRepEmails) {
        this.oldPassword = oldPassword;
        this.newOrgName = newOrgName;
        this.newOrgAddress = newOrgAddress;
        this.newPaymentAccountEmail = newPaymentAccountEmail;
        this.newMainRepName = newMainRepName;
        this.newMainRepEmail = newMainRepEmail;
        this.newPassword = newPassword;
        this.newOtherRepNames = newOtherRepNames;
        this.newOtherRepEmails = newOtherRepEmails;
    }

    public void execute(Context context) {
        User currentUser = context.getUserState().getCurrentUser();

        // check if there is another entertainment provider with same name and address
        Collection<User> users = context.getUserState().getAllUsers().values();
        boolean nameAndAddressNotTaken = true;

        // iterate over all users
        for(User user : users) {
            // if user is EntertainmentProvider, check name and address and flag if they are the same as new ones
            if (user instanceof EntertainmentProvider){
                EntertainmentProvider provider = (EntertainmentProvider) user;
                if (provider.getOrgName().equals(newOrgName) && provider.getOrgAddress().equals(newOrgAddress)) {
                    nameAndAddressNotTaken = false;
                }
            }
        }

        // if values not null, user is entertainment provider, and name and address not taken, change values
        if (isProfileUpdateInvalid(context, oldPassword, newMainRepEmail) && oldPassword != null &&
                newOrgName != null && newOrgAddress != null && newPaymentAccountEmail != null &&
                newMainRepName != null && newMainRepEmail != null  && newPassword != null &&
                newOtherRepNames != null && newOtherRepEmails != null &&
                currentUser instanceof EntertainmentProvider && nameAndAddressNotTaken){

            EntertainmentProvider provider = (EntertainmentProvider) currentUser;
            provider.setOrgName(newOrgName);
            provider.setOrgAddress(newOrgAddress);
            provider.setPaymentAccountEmail(newPaymentAccountEmail);
            provider.setMainRepName(newMainRepName);
            provider.setEmail(newMainRepEmail);
            provider.updatePassword(newPassword);
            provider.setOtherRepNames(newOtherRepNames);
            provider.setOtherRepEmails(newOtherRepEmails);

        }
    }
    
}
