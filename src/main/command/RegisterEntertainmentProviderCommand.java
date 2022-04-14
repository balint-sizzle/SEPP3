package main.command;
import main.controller.Context;
import main.command.ICommand;
import main.model.EntertainmentProvider;

import java.util.List;

public class RegisterEntertainmentProviderCommand implements ICommand {
    private final String orgName;
    private final String orgAddress;
    private final String paymentAccountEmail;
    private final String mainRepName;
    private final String mainRepEmail;
    private final String password;
    private final List<String> otherRepNames;
    private final List<String> otherRepEmails;
    private EntertainmentProvider newEntertainmentProviderResult;
    private EntertainmentProvider attribute;

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
    public void execute(Context context) {
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

        boolean isValid = noneNull && uniqueEmail && (uniqueOrgName || uniqueOrgAddress);

        if (!isValid) {
            newEntertainmentProviderResult = null;
            throw new RuntimeException("Invalid request");
        }
        else {
            newEntertainmentProviderResult = new EntertainmentProvider(orgName,
                                                                       orgAddress,
                                                                       paymentAccountEmail,
                                                                       mainRepName,
                                                                       mainRepEmail,
                                                                       password,
                                                                       otherRepNames,
                                                                       otherRepEmails);
        }
    }

    @Override
    public EntertainmentProvider getResult() {
        return newEntertainmentProviderResult;
    }
}
