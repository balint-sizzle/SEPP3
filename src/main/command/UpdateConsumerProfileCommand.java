package main.command;

import main.controller.Context;
import main.model.Consumer;
import main.model.ConsumerPreferences;
import main.model.User;

public class UpdateConsumerProfileCommand extends UpdateProfileCommand {

    private String oldPassword;
    private String newName;
    private String newEmail;
    private String newPhoneNumber;
    private String newPassword;
    private String newPaymentAccountEmail;
    private ConsumerPreferences newPreferences;

    public UpdateConsumerProfileCommand(String oldPassword,
                                        String newName,
                                        String newEmail,
                                        String newPhoneNumber,
                                        String newPassword,
                                        String newPaymentAccountEmail,
                                        ConsumerPreferences newPreferences) {
        this.oldPassword = oldPassword;
        this.newName = newName;
        this.newEmail = newEmail;
        this.newPhoneNumber = newPhoneNumber;
        this.newPassword = newPassword;
        this.newPaymentAccountEmail = newPaymentAccountEmail;
        this.newPreferences = newPreferences;
    }

    public void execute(Context context) {
        User currentUser = context.getUserState().getCurrentUser();

        if (isProfileUpdateInvalid(context, oldPassword, newEmail) && newName != null &&
        newEmail != null && newPhoneNumber != null && newPassword != null &&
        newPaymentAccountEmail != null && newPreferences != null && currentUser != null &&
        currentUser instanceof Consumer){
            Consumer consumer = (Consumer) currentUser;
            consumer.setName(newName);
            consumer.setEmail(newEmail);
            consumer.setPhoneNumber(newPhoneNumber);
            consumer.updatePassword(newPassword);
            consumer.setPaymentAccountEmail(newPaymentAccountEmail);
            consumer.setPreferences(newPreferences);
        }
    }
    
}
