package main.command;
import main.controller.Context;
import src.main.command.ICommand;
import main.model.EntertainmentProvider;

import java.util.List;

public class RegisterEntertainmentProviderCommand extends Object implements ICommand {
    private String orgName;
    private String orgAddress;
    private String paymentAccountEmail;
    private String mainRepName;
    private String mainRepEmail;
    private String password;
    private List<String> otherRepNames;
    private List<String> otherRepEmails;
    private boolean isValid;

    public RegisterEntertainmentProviderCommand(String orgName,
                                                String orgAddress,
                                                String paymentAccountEmail,
                                                String mainRepName,
                                                String mainRepEmail,
                                                String password,
                                                List<String> otherRepNames,
                                                List<String> otherRepEmails) {
        this.orgName = orgName;
        this.orgAddress = orgAddress;
        this.paymentAccountEmail = paymentAccountEmail;
        this.mainRepName = mainRepName;
        this.mainRepEmail = mainRepEmail;
        this.password = password;
        this.otherRepNames = otherRepNames;
        this.otherRepEmails = otherRepEmails;
     }

    @Override
    public boolean execute(Context context) {
        boolean noneNull = !(orgName == null ||
                             orgAddress == null ||
                             paymentAccountEmail == null ||
                             mainRepName == null ||
                             mainRepEmail == null ||
                             password == null ||
                             otherRepNames == null ||
                             otherRepEmails == null);
        
        boolean uniqueEmail = !context.getUserState().getAllUsers().containsKey(mainRepEmail);
        boolean uniqueOrgName = !context.getUserState().getAllUsers().containsKey(orgName);
        boolean uniqueOrgAddress = !context.getUserState().getAllUsers().containsKey(orgAddress);

        isValid = noneNull && uniqueEmail && (uniqueOrgName || uniqueOrgAddress);
        return noneNull;
    }

    @Override
    public EntertainmentProvider getResult() {
        if (isValid) {
            return new EntertainmentProvider(orgName,
                                             orgAddress,
                                             paymentAccountEmail,
                                             mainRepName,
                                             mainRepEmail,
                                             password,
                                             otherRepNames,
                                             otherRepEmails);
        }
        else {
            return null;
        }
    }
}
